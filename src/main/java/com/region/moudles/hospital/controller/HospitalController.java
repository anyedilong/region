package com.region.moudles.hospital.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.region.until.up.UpUtils;
import org.apache.commons.lang3.StringUtils;
import org.dcm4che2.imageio.plugins.dcm.DicomImageReadParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.region.moudles.common.controller.BaseController;
import com.region.moudles.common.domain.JsonHisResult;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.hospital.domain.HospitalEmr;
import com.region.moudles.hospital.domain.HospitalImage;
import com.region.moudles.hospital.domain.HospitalInfto;
import com.region.moudles.hospital.domain.HospitalJc;
import com.region.moudles.hospital.domain.HospitalOrder;
import com.region.moudles.hospital.domain.HospitalOrderItem;
import com.region.moudles.hospital.domain.HospitalOutCost;
import com.region.moudles.hospital.domain.HospitalOutMingXi;
import com.region.moudles.hospital.domain.HospitalZd;
import com.region.moudles.hospital.service.HospitalService;
import com.region.moudles.system.service.SysOrgService;
import com.region.until.StringUntil;
import com.region.until.UUIDUtil;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

@RestController
@RequestMapping("/his/hospital")
public class HospitalController extends BaseController {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Inject
    private HospitalService hospitalService;
    @Inject
    private SysOrgService sysOrgService;

    //保存入院登记
    @RequestMapping("save")
    public JsonHisResult getHospital() {
        ArrayList<String> faillist = new ArrayList<>();
        String param = getParam(request);
        logger.info("保存入院登记：" + param);
        //获取上传数据的orgcode
        String auth_code = request.getHeader("auth_code");
        String orgCode = sysOrgService.queryOrgCodeByAuthCode(auth_code);
        //if(StringUntil.isNull(orgCode)) return JsonHisResult(new ArrayList<String>(), 0, "授权码对应的机构已删除！！！");

        List<HospitalInfto> list = JSONObject.parseArray(param, HospitalInfto.class);
        if (list != null && list.size() > 0) {
            faillist = hospitalService.saveHospital(list, orgCode);
        }
        if (faillist != null && faillist.size() > 0) {
            return JsonHisResult(faillist, 1, "保存失败");
        } else {
            return JsonHisResult(faillist, 0, "保存成功");
        }

    }

    //保存入院诊断
    @RequestMapping("savediagnosis")
    public JsonHisResult getdiagnosis() {
        ArrayList<String> faillist = new ArrayList<>();
        String param = getParam(request);
        logger.info("保存入院诊断：" + param);
        //获取上传数据的orgcode
        String auth_code = request.getHeader("auth_code");
        String orgCode = sysOrgService.queryOrgCodeByAuthCode(auth_code);
        //if(StringUntil.isNull(orgCode)) return JsonHisResult(new ArrayList<String>(), 0, "授权码对应的机构已删除！！！");

        List<HospitalZd> list = JSONObject.parseArray(param, HospitalZd.class);
        if (list != null && list.size() > 0) {
            faillist = hospitalService.saveDiagnosis(list, orgCode);
        }
        if (faillist != null && faillist.size() > 0) {
            return JsonHisResult(faillist, 1, "保存失败");
        } else {
            return JsonHisResult(faillist, 0, "保存成功");
        }
    }

    //保存住院检验
    @RequestMapping("saveinspect")
    public JsonHisResult saveInspect() {
        ArrayList<String> faillist = new ArrayList<>();
        String param = getParam(request);
        logger.info("保存住院检验：" + param);
        //获取上传数据的orgcode
        String auth_code = request.getHeader("auth_code");
        String orgCode = sysOrgService.queryOrgCodeByAuthCode(auth_code);
        //if(StringUntil.isNull(orgCode)) return JsonHisResult(new ArrayList<String>(), 0, "授权码对应的机构已删除！！！");

        if (StringUntil.isNull(param)) {
            return JsonHisResult(faillist, 1, "保存失败");
        }
        List<HospitalJc> list = JSONObject.parseArray(param, HospitalJc.class);
        if (list != null && list.size() > 0) {
            faillist = hospitalService.saveInspect(list, orgCode);
        }
        if (faillist != null && faillist.size() > 0) {
            return JsonHisResult(faillist, 1, "保存失败");
        } else {
            return JsonHisResult(faillist, 0, "保存成功");
        }
    }

    //保存住院影像
    @RequestMapping("saveimage")
    public JsonHisResult saveImage(HttpServletRequest request, HttpServletResponse response) {
        //MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        String param = request.getParameter("param");
        if (StringUntil.isNull(param)) {
            param = getParam(request);
            try {
                // 参数
                //MultipartFile paramMultipartFile = multipartRequest.getFile("param");
                //
                //InputStream paramInputStream = paramMultipartFile.getInputStream();
                //byte[] buffer = new byte[request.getContentLength()];
                //paramInputStream.read(buffer);
                //param = new String(buffer, "UTF-8");
            } catch (Exception e) {
                param = "";
            }
        }
        logger.info("保存住院影像：" + param);
        List<HospitalImage> list = JSONArray.parseArray(param, HospitalImage.class);
        //List<HospitalImage> list = new ArrayList<>();
        //list.add(hospitalImage);
        ArrayList<String> faillist = hospitalService.saveImage(list);
		/*Map<String, MultipartFile> MultipartFileMap = multipartRequest.getFileMap();
		String fileNames = "";
		for (Map.Entry<String, MultipartFile> entry : MultipartFileMap.entrySet()) {
			String key = entry.getKey();
			if (key.indexOf("file") == 0) {
				MultipartFile fileMultipartFile = entry.getValue();
				if (fileMultipartFile != null) {
					try {
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String fileName = fileMultipartFile.getOriginalFilename();// 文件名
						InputStream inputStream = fileMultipartFile.getInputStream();
						// String authCode=SysUtil.getAuthCode(request,response);
						// String orgCode=sysAuthService.getOrgCode(authCode);
						String imageTime = simpleDateFormat.format(hospitalImage.getImageTime());
						// String filePath=orgCode+"\\"+imageTime;
						// UpUtils.upload(inputStream,filePath,fileName);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}*/
        if (faillist != null && faillist.size() > 0) {
            return JsonHisResult(faillist, 1, "保存失败");
        } else {
            return JsonHisResult(faillist, 0, "保存成功");
        }
    }

    //保存出院结算
    @RequestMapping("outcost")
    public JsonHisResult saveoutcost() {
        ArrayList<String> faillist = new ArrayList<>();
        String param = getParam(request);
        logger.info("保存出院结算：" + param);
        //获取上传数据的orgcode
        String auth_code = request.getHeader("auth_code");
        String orgCode = sysOrgService.queryOrgCodeByAuthCode(auth_code);
        //if(StringUntil.isNull(orgCode)) return JsonHisResult(new ArrayList<String>(), 0, "授权码对应的机构已删除！！！");

        List<HospitalOutCost> list = JSONObject.parseArray(param, HospitalOutCost.class);
        if (list != null && list.size() > 0) {
            faillist = hospitalService.saveoutcost(list, orgCode);
        }
        if (faillist != null && faillist.size() > 0) {
            return JsonHisResult(faillist, 1, "保存失败");
        } else {
            return JsonHisResult(faillist, 0, "保存成功");
        }
    }

    //保存住院费用明细
    @RequestMapping("hospitalcost")
    public JsonHisResult savehospitalcost() {
        ArrayList<String> faillist = new ArrayList<>();
        String param = getParam(request);
        logger.info("保存住院费用明细：" + param);
        JSONArray array = JSONArray.parseArray(param);
        for (int i = 0; i < array.size(); i++) {
            JSONObject json = array.getJSONObject(i);
            String outId = json.getString("out_id");
            List<HospitalOutMingXi> list = JSONArray.parseArray(json.getString("feelist"), HospitalOutMingXi.class);
            if (list != null && list.size() > 0) {
                ArrayList<String> tempList = hospitalService.savehospitalcost(outId, list);
                faillist.addAll(tempList);
            }

        }
        //List<HospitalOutMingXi> list = JSONObject.parseArray(json.getString("feelist"), HospitalOutMingXi.class);
        if (faillist.size() > 0) {
            return JsonHisResult(faillist, 1, "保存失败");
        } else {
            return JsonHisResult(faillist, 0, "保存成功");
        }
    }

    // 查询住院列表(公卫)
    @RequestMapping("getHospitalZYInfoPage")
    public PageModel getHospitalZYInfoPage() {
        try {
            String sfzh = request.getParameter("sfzh");
            String pageNo = request.getParameter("pageNo");
            String pageSize = request.getParameter("pageSize");
            PageModel page = new PageModel(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
            hospitalService.getHospitalZYInfoPage(sfzh, page);
            return page;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 查询住院详情(公卫)
    @RequestMapping("getZYDJDetail")
    public HospitalInfto getZYDJDetail() {
        try {
            String zyId = request.getParameter("zyId");
            return hospitalService.getZYDJDetail(zyId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 查询出院结算列表(公卫)
    @RequestMapping("getCYJSInfoPage")
    public PageModel getCYJSInfoPage() {
        try {
            String sfzh = request.getParameter("sfzh");
            String pageNo = request.getParameter("pageNo");
            String pageSize = request.getParameter("pageSize");
            PageModel page = new PageModel(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
            hospitalService.getCYJSInfoPage(sfzh, page);
            return page;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 查询出院结算详情(公卫)
    @RequestMapping("getCYJSDetail")
    public HospitalOutCost getCYJSDetail() {
        try {
            String cyId = request.getParameter("cyId");
            return hospitalService.getCYJSDetail(cyId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 查询住院病案列表(公卫)
    @RequestMapping("getZYBAList")
    public PageModel getZYBAList() {
        try {
            String sfzh = request.getParameter("sfzh");
            String pageNo = request.getParameter("pageNo");
            String pageSize = request.getParameter("pageSize");
            PageModel page = new PageModel(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
            hospitalService.getZYBAList(sfzh, page);
            return page;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 查询住院病案详情(公卫)
    @RequestMapping("getZYBADetail")
    public HospitalEmr getZYBADetail() {
        try {
            String emrId = request.getParameter("emrId");
            String admissionId = request.getParameter("id");
            String orgCode = request.getParameter("orgCode");
            return hospitalService.getZYBADetail(emrId, admissionId, orgCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 查询住院列表(健康浏览器和惠民平台)
    @RequestMapping("getHospitalPage")
    public PageModel getHospitalPage() {
        try {
            String sfzh = request.getParameter("sfzh");
            String pageNo = request.getParameter("pageNo");
            String pageSize = request.getParameter("pageSize");
            PageModel page = new PageModel(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
            hospitalService.getHospitalPage(sfzh, page);
            return page;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 查询住院详情(健康浏览器和惠民平台)
    @RequestMapping("getHospitalDetail")
    public HospitalInfto getHospitalDetail() {
        try {
            String id = request.getParameter("id");
            return hospitalService.getHospitalDetail(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 查询住院详情(惠民平台app)
    @RequestMapping("getAppHospitalDetail")
    public HospitalInfto getAppHospitalDetail() {
        try {
            String id = request.getParameter("id");
            return hospitalService.getAppHospitalDetail(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 查询住院明细详情(健康浏览器和惠民平台)
    @RequestMapping("getHospitalCostList")
    public List<HospitalOutCost> getHospitalCostList() {
        try {
            String zyId = request.getParameter("zyId");
            String startTime = request.getParameter("startTime");
            String endTime = request.getParameter("endTime");
            String name = request.getParameter("name");
            return hospitalService.getHospitalCostList(zyId, startTime, endTime, name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 查询住院诊断的详情(健康浏览器和惠民平台)
    @RequestMapping("getHospitalZDList")
    public List<HospitalZd> getHospitalZDList() {
        try {
            String zyId = request.getParameter("zyId");
            return hospitalService.getHospitalZDList(zyId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 查询住院影像的详情(健康浏览器和惠民平台)
    @RequestMapping("getHospitalImageList")
    public List<HospitalImage> getHospitalImageList() {
        try {
            String zyId = request.getParameter("zyId");
            return hospitalService.getHospitalImageList(zyId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param @return
     * @return Medicalrecord
     * @throws
     * @Description: 门诊影像dcm文件转换为图片（健康浏览器和惠民平台）
     */
    @RequestMapping("getCoverImageFormat")
    public String getCoverImageFormat() {
        try {
            //影像的id
            String imageId = request.getParameter("imageId");
            //影像的dcm全路径+名称(现在是名称)
            String imagePath = request.getParameter("imagePath");
            //影像的路径
            //String ftpPath = imagePath.substring(0, imagePath.indexOf("/dcm"));
            //String ftpPath = imagePath.substring(0, imagePath.indexOf("/人"));
            //影像的名称
            //String imageName = imagePath.substring(imagePath.lastIndexOf("/")+1);
            String jpgName = UUIDUtil.getUUID() + ".jpg";
            String imageJpgPath = "";

            BufferedImage myJpegImage = null;
            //InputStream is = UpUtils.getFTPFile("/人民医院/", imageName);
            //File file = new File("D://ftp//人民医院//"+imageName);
            //File file = new File("D:\\ftpHome\\renminyyjpg\\" + imagePath);
            String basePath = "/home/hpe/dcm/";
            String filePath = StringUntil.getFilePath(basePath, imagePath);
            if (StringUtils.isBlank(filePath))
                filePath = "other" + File.separator;
            System.out.println("文件路径：" + basePath + filePath + imagePath);
            File file = new File(basePath + filePath + imagePath);
            if (!file.exists()) {
                file = new File("/u01/1001001001090/dcm/人民医院/" + imagePath);
                if (!file.exists()) {
                    logger.info("文件不存在：" + imagePath);
                    return null;
                }
            }

            Iterator<ImageReader> iterator = ImageIO.getImageReadersByFormatName("DICOM");
            while (iterator.hasNext()) {
                ImageReader imageReader = (ImageReader) iterator.next();
                DicomImageReadParam dicomImageReadParam = (DicomImageReadParam) imageReader.getDefaultReadParam();
                try {
                    ImageInputStream iis = ImageIO.createImageInputStream(file);
                    imageReader.setInput(iis, false);
                    myJpegImage = imageReader.read(0, dicomImageReadParam);
                    iis.close();
                    if (myJpegImage == null) {
                        System.out.println("Could not read image!!");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //ftp文件上传
                //UpUtils.upload(is, "/renminyyjpg/", jpgName);
                File file2 = new File("/u01/1001001001090/jpg/" + jpgName);
                try {
                    //File file2 = new File("D://ftp//renminyyjpg//"+jpgName);
                    OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file2));
                    JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(outputStream);
                    encoder.encode(myJpegImage);
                    outputStream.close();
                    //imageJpgPath = "http://10.179.81.6:8083" +"//jpg//"+ jpgName;
                    //imageJpgPath = "http://220.164.62.189:8093/jpg/" + jpgName;
                    //imageJpgPath = ftpPath +"//renminyyjpg//"+ jpgName;
                    imageJpgPath = "/jpg/" + jpgName;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            hospitalService.updateImageJpgPath(imageId, imageJpgPath);
            return imageJpgPath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 查询住院检查的详情(健康浏览器和惠民平台)
    @RequestMapping("getHospitalJcList")
    public List<HospitalJc> getHospitalJcList() {
        try {
            String zyId = request.getParameter("zyId");
            String itemType = request.getParameter("itemType");
            return hospitalService.getHospitalJcList(zyId, itemType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 查询住院医嘱的列表(健康浏览器和惠民平台)
    @RequestMapping("getHospitalOrderList")
    public List<HospitalOrder> getHospitalOrderList() {
        try {
            String zyId = request.getParameter("zyId");
            return hospitalService.getHospitalOrderList(zyId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 查询住院医嘱的详情(健康浏览器和惠民平台)
    @RequestMapping("getHospitalOrderDetail")
    public HospitalOrder getHospitalOrderDetail() {
        try {
            String id = request.getParameter("id");
            return hospitalService.getHospitalOrderDetail(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 查询住院医嘱明细的列表(惠民平台公众号)
    @RequestMapping("getHospitalOrderItemList")
    public List<HospitalOrderItem> getHospitalOrderItemList() {
        try {
            String zyId = request.getParameter("zyId");
            return hospitalService.getHospitalOrderItemList(zyId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
