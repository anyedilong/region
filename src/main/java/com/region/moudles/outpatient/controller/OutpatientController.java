package com.region.moudles.outpatient.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.outpatient.dto.JcDto;
import com.region.until.up.UpUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.utils.DateUtils;
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
import com.region.moudles.outpatient.domain.Medicalrecord;
import com.region.moudles.outpatient.domain.OutpatientCost;
import com.region.moudles.outpatient.domain.OutpatientImage;
import com.region.moudles.outpatient.domain.OutpatientJc;
import com.region.moudles.outpatient.domain.OutpatientRecipe;
import com.region.moudles.outpatient.domain.OutpatientZd;
import com.region.moudles.outpatient.service.OutpatientService;
import com.region.moudles.system.service.SysOrgService;
import com.region.until.StringUntil;
import com.region.until.UUIDUtil;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;


@RestController
@RequestMapping("/his/outpatient")
public class OutpatientController extends BaseController {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Inject
    private OutpatientService outpatientService;
    @Inject
    private SysOrgService sysOrgService;

    //保存门诊病历
    @RequestMapping("save")
    public JsonHisResult getOutpatient() {
        ArrayList<String> faillist = new ArrayList<>();
        String param = getParam(request);
        logger.info("保存门诊病历请求参数：" + param);
        //获取上传数据的orgcode
        String auth_code = request.getHeader("auth_code");
        String orgCode = sysOrgService.queryOrgCodeByAuthCode(auth_code);
        //if(StringUntil.isNull(orgCode)) 
        //return JsonHisResult(new ArrayList<String>(), 0, "授权码对应的机构已删除！！！");

        List<Medicalrecord> list = JSONObject.parseArray(param, Medicalrecord.class);
        if (list != null && list.size() > 0) {
            faillist = outpatientService.saveOutpatient(list, orgCode);
        }
        if (faillist != null && faillist.size() > 0 || StringUntil.isNull(param)) {
            logger.info("保存失败！");
            return JsonHisResult(faillist, 1, "保存失败");
        } else {
            logger.info("保存成功！");
            return JsonHisResult(faillist, 0, "保存成功");
        }
    }

    //保存门诊诊断
    @RequestMapping("savediagnosis")
    public JsonHisResult saveDiagnosis() {
        ArrayList<String> faillist = new ArrayList<>();
        String param = getParam(request);
        logger.info("保存门诊诊断：" + param);
        //获取上传数据的orgcode
        String auth_code = request.getHeader("auth_code");
        String orgCode = sysOrgService.queryOrgCodeByAuthCode(auth_code);
        //if(StringUntil.isNull(orgCode)) return JsonHisResult(new ArrayList<String>(), 0, "授权码对应的机构已删除！！！");
        List<OutpatientZd> list = JSONObject.parseArray(param, OutpatientZd.class);
        if (list != null && list.size() > 0) {
            faillist = outpatientService.saveOutpatientZd(list, orgCode);
        }
        if (faillist != null && faillist.size() > 0 || StringUntil.isNull(param)) {
            return JsonHisResult(faillist, 1, "保存失败");
        } else {
            return JsonHisResult(faillist, 0, "保存成功");
        }
    }

    //保存门诊检验信息
    @RequestMapping("saveinspect")
    public JsonHisResult saveInspect() {
        ArrayList<String> faillist = new ArrayList<>();
        String param = getParam(request);
        logger.info("保存门诊检验信息：" + param);
        //获取上传数据的orgcode
        String auth_code = request.getHeader("auth_code");
        String orgCode = sysOrgService.queryOrgCodeByAuthCode(auth_code);
        //if(StringUntil.isNull(orgCode)) return JsonHisResult(new ArrayList<String>(), 0, "授权码对应的机构已删除！！！");
        List<OutpatientJc> list = JSONObject.parseArray(param, OutpatientJc.class);
        if (list != null && list.size() > 0) {
            faillist = outpatientService.saveinspect(list, orgCode);
        }
        if (faillist != null && faillist.size() > 0 || StringUntil.isNull(param)) {
            return JsonHisResult(faillist, 1, "保存失败");
        } else {
            return JsonHisResult(faillist, 0, "保存成功");
        }
    }

    //保存门诊处方
    @RequestMapping("saverecipe")
    public JsonHisResult saveRecipe() {
        ArrayList<String> faillist = new ArrayList<>();
        String param = getParam(request);
        logger.info("保存门诊处方：" + param);
        //获取上传数据的orgcode
        String auth_code = request.getHeader("auth_code");
        String orgCode = sysOrgService.queryOrgCodeByAuthCode(auth_code);
        List<OutpatientRecipe> list = JSONObject.parseArray(param, OutpatientRecipe.class);
        if (list != null && list.size() > 0) {
            faillist = outpatientService.saverecipe(list, orgCode);
        }
        if (faillist != null && faillist.size() > 0 || StringUntil.isNull(param)) {
            return JsonHisResult(faillist, 1, "保存失败");
        } else {
            return JsonHisResult(faillist, 0, "保存成功");
        }
    }

    //保存门诊结算
    @RequestMapping("outcost")
    public JsonHisResult saveoutcost() {
        ArrayList<String> faillist = new ArrayList<>();
        String param = getParam(request);
        logger.info("保存门诊结算：" + param);
        //获取上传数据的orgcode
        String auth_code = request.getHeader("auth_code");
        String orgCode = sysOrgService.queryOrgCodeByAuthCode(auth_code);
        //if(StringUntil.isNull(orgCode)) return JsonHisResult(new ArrayList<String>(), 0, "授权码对应的机构已删除！！！");
        List<OutpatientCost> list = JSONObject.parseArray(param, OutpatientCost.class);
        if (list != null && list.size() > 0) {
            faillist = outpatientService.savecost(list, orgCode);
        }
        if (faillist != null && faillist.size() > 0 || StringUntil.isNull(param)) {
            return JsonHisResult(faillist, 1, "保存失败");
        } else {
            return JsonHisResult(faillist, 0, "保存成功");
        }
    }

    /**
     * 　　* @Title  门诊影像
     * 　　* @param
     * 　　* @return
     * 　　* @throws
     * 　　* @author lenovo
     * 　　* @date 2019/8/3 2019/8/3
     */
    @RequestMapping("saveimage")
    public JsonHisResult saveImage(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> faillist = new ArrayList<>();
        String param = getParam(request);
        logger.info("保存门诊影像：" + param);
        String auth_code = request.getHeader("auth_code");
        String orgCode = sysOrgService.queryOrgCodeByAuthCode(auth_code);
        List<OutpatientImage> list = JSONArray.parseArray(param, OutpatientImage.class);
        if (list != null && list.size() > 0) {
            faillist = outpatientService.saveimage(list, orgCode);
        }
        if (faillist != null && faillist.size() > 0) {
            return JsonHisResult(faillist, 1, "保存失败");
        } else {
            return JsonHisResult(faillist, 0, "保存成功");
        }
    }

    //查询门诊
    @RequestMapping("getOutpatientZDInfo")
    public PageModel getOutpatientZDInfo() {
        try {
            String sfzh = request.getParameter("sfzh");
            String pageNo = request.getParameter("pageNo");
            String pageSize = request.getParameter("pageSize");
            PageModel page = new PageModel(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
            outpatientService.getOutpatientZDInfo(sfzh, page);
            return page;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Title : getOutpatientBLList
     * @Description : 查询单个居民门诊病历列表（公卫）
     * @author: 黄飞翰
     * @date: 2019年7月31日 下午3:58:45
     */
    @RequestMapping("getOutpatientBLList")
    public PageModel getOutpatientBLList() {
        try {
            String sfzh = request.getParameter("sfzh");
            String pageNo = request.getParameter("pageNo");
            String pageSize = request.getParameter("pageSize");
            PageModel page = new PageModel(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
            outpatientService.getOutpatientBLList(sfzh, page);
            return page;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询门诊病例详情（公卫）
     *
     * @author : 皮雪平
     * @date : 2019/8/7 13:47
     */
    @RequestMapping("getOutpatientBLDetail")
    public Medicalrecord getOutpatientBLDetail() {
        try {
            String medicalRecordId = request.getParameter("medicalRecordId");
            Medicalrecord mz = outpatientService.getOutpatientBLDetail(medicalRecordId);
            return mz;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param @return
     * @return PageModel
     * @throws
     * @Description: 查询单个居民门诊病历列表（健康浏览器）
     */
    @RequestMapping("getOutpatientPage")
    public PageModel getOutpatientPage() {
        try {
            String sfzh = request.getParameter("sfzh");
            String pageNo = request.getParameter("pageNo");
            String pageSize = request.getParameter("pageSize");
            PageModel page = new PageModel(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
            outpatientService.getOutpatientPage(sfzh, page);
            return page;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param @return
     * @return Medicalrecord
     * @throws
     * @Description: 查询门诊处方详情（健康浏览器）
     */
    @RequestMapping("getOutpatientCfList")
    public List<OutpatientRecipe> getOutpatientCfList() {
        try {
            String mzId = request.getParameter("mzId");
            List<OutpatientRecipe> list = outpatientService.getOutpatientCfList(mzId);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param @return
     * @return Medicalrecord
     * @throws
     * @Description: 查询门诊诊断详情（健康浏览器）
     */
    @RequestMapping("getOutpatientZDList")
    public List<OutpatientZd> getOutpatientZDList() {
        try {
            String mzId = request.getParameter("mzId");
            List<OutpatientZd> list = outpatientService.getOutpatientZDList(mzId);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param @return
     * @return Medicalrecord
     * @throws
     * @Description: 查询门诊影像详情（健康浏览器）
     */
    @RequestMapping("getOutpatientImageList")
    public List<OutpatientImage> getOutpatientImageList() {
        try {
            String mzId = request.getParameter("mzId");
            List<OutpatientImage> list = outpatientService.getOutpatientImageList(mzId);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param @return
     * @return Medicalrecord
     * @throws
     * @Description: 门诊影像dcm文件转换为图片（健康浏览器）
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

            //InputStream is = UpUtils.getFTPFile("/人民医院/", imageName);
            BufferedImage myJpegImage = null;
            String basePath = "/home/hpe/dcm/";
            String filePath = StringUntil.getFilePath(basePath, imagePath);
            if (StringUtils.isBlank(filePath))
                filePath = "other" + File.separator;
            System.out.println("文件路径：" + basePath + filePath + imagePath);
            File file = new File(basePath + filePath + imagePath);
            System.out.println("文件是否存在：" + file.exists());
            if (!file.exists()) {
                file = new File("/u01/1001001001090/dcm/人民医院/" + imagePath);
                System.out.println("文件是否存在：" + file.exists());
                if (!file.exists()) {
                    logger.info("文件不存在：" + imagePath);
                    return null;
                }
            }

            Iterator<ImageReader> iterator = ImageIO.getImageReadersByFormatName("DICOM");
            System.out.println("iterator：" + iterator.hasNext());
            while (iterator.hasNext()) {
                ImageReader imageReader = (ImageReader) iterator.next();
                System.out.println("1");
                DicomImageReadParam dicomImageReadParam = (DicomImageReadParam) imageReader.getDefaultReadParam();
                System.out.println("2");
                try {
                    ImageInputStream iis = ImageIO.createImageInputStream(file);
                    System.out.println("3");
                    imageReader.setInput(iis, false);
                    System.out.println("4");
                    myJpegImage = imageReader.read(0, dicomImageReadParam);
                    System.out.println("5");
                    iis.close();
                    System.out.println("6");
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
                    OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file2));
                    JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(outputStream);
                    encoder.encode(myJpegImage);
                    outputStream.close();
                    //imageJpgPath = "http://10.179.81.6:8083" +"//jpg//"+ jpgName;
                    //imageJpgPath = "http://220.164.62.189:8093/jpg/" + jpgName;
                    imageJpgPath = "/jpg/" + jpgName;
                    //imageJpgPath = ftpPath +"//renminyyjpg//"+ jpgName;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            outpatientService.updateImageJpgPath(imageId, imageJpgPath);
            return imageJpgPath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param @return
     * @return Medicalrecord
     * @throws
     * @Description: 查询门诊检查详情（健康浏览器）
     */
    @RequestMapping("getOutpatientJcList")
    public List<OutpatientJc> getOutpatientJcList() {
        try {
            String mzId = request.getParameter("mzId");
            String itemType = request.getParameter("itemType");
            List<OutpatientJc> list = outpatientService.getOutpatientJcList(mzId, itemType);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询门诊和住院检查分页
     *
     * @return
     * @throws Exception 聂亚威
     */
    @RequestMapping("getJcPage")
    public PageModel getJcPage() throws Exception {
        String param = getParam(request);
        logger.info("查询门诊和住院检查分页请求参数：" + param);
        JcDto req = JSON.toJavaObject(JSONObject.parseObject(param), JcDto.class);
        if (StringUtils.isBlank(req.getInspectType()))
            req.setInspectType("1");
        req.setPage(new PageModel(req.getPageNo() == null ? 1 : req.getPageNo(), req.getPageSize() == null ? 10 : req.getPageSize()));
        PageModel resp = outpatientService.getJcPage(req);
        logger.info("查询门诊和住院检查分页返回：" + JSON.toJSONString(resp));
        return resp;
    }

    /**
     * 查询门诊或住院检查详情
     *
     * @return
     * @throws Exception 聂亚威
     */
    @RequestMapping("getJcInfo")
    public JcDto getJcInfo() throws Exception {
        String param = getParam(request);
        logger.info("查询门诊或住院检查详情请求参数：" + param);
        JcDto req = JSON.toJavaObject(JSONObject.parseObject(param), JcDto.class);
        if (StringUtils.isBlank(req.getId()))
            return new JcDto();
        JcDto resp = outpatientService.getJcInfo(req);
        logger.info("查询门诊或住院检查详情返回：" + JSON.toJSONString(resp));
        return resp;
    }

}
