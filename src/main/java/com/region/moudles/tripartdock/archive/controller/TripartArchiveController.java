package com.region.moudles.tripartdock.archive.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import com.region.moudles.tripartdock.health.bean.BaseCustomerDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.region.moudles.common.controller.BaseController;
import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.tripartdock.archive.domain.Bsxx;
import com.region.moudles.tripartdock.archive.domain.Jbxxjlb;
import com.region.moudles.tripartdock.archive.domain.Jzsxxb;
import com.region.moudles.tripartdock.archive.domain.Shhjb;
import com.region.moudles.tripartdock.archive.dto.ArchiveQueryCon;
import com.region.moudles.tripartdock.archive.service.TripartArchiveService;

/**
 * @author Administrator
 * @ClassName: TripartArchiveController
 * @Description: 三方对接 保存档案信息
 * @date 2019年7月25日
 */
@RestController
@RequestMapping("${hispath}/archive")
public class TripartArchiveController extends BaseController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    private TripartArchiveService archiveService;

    //保存档案相关信息
    @RequestMapping("archiveSave")
    public JsonResult archiveSave() {
        String param = "";
        try {
            param = request.getParameter("param");
            List<Jbxxjlb> list = JSONObject.parseArray(param, Jbxxjlb.class);

            if (list != null && list.size() > 0) {
                Map<String, Object> map = archiveService.saveArchiveInfo(list);
                if (map != null && map.size() > 0) {
                    logger.error("档案信息保存失败; 失败数据》》》》" + JSON.toJSONString(map) + "; ");
                    return jsonResult(JSON.toJSONString(map), 10001, "保存失败");
                }
            }
            return jsonResult();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("档案信息保存失败; 失败数据》》》》" + param + "; 失败原因》》》》" + e.getMessage());
            return jsonResult(param, 10001, "系统错误" + e.getMessage());
        }
    }

    //档案列表(健康浏览器)
    @RequestMapping("getArchivePage")
    public PageModel getArchivePage() {
        try {
            String hzmc = request.getParameter("hzmc");
            String zjlx = request.getParameter("zjlx");
            String sfzh = request.getParameter("sfzh");
            String startTime = request.getParameter("startTime");
            String endTime = request.getParameter("endTime");
            String pageSize = request.getParameter("pageSize");
            String pageNo = request.getParameter("pageNo");

            PageModel page = new PageModel(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
            Jbxxjlb jbxxjlb = new Jbxxjlb();
            jbxxjlb.setHzmc(hzmc);
            jbxxjlb.setZjlx(zjlx);
            jbxxjlb.setSfzh(sfzh);
            jbxxjlb.setStartTime(startTime);
            jbxxjlb.setEndTime(endTime);

            archiveService.getArchivePage(jbxxjlb, page);
            return page;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //根据门诊住院条件获取档案的列表(健康浏览器)
    @RequestMapping("getArchivePageByCon")
    public PageModel getArchivePageByCon() {
        try {
            // 获取参数
            String startTime = request.getParameter("startTime");
            String endTime = request.getParameter("endTime");
            String isMedical = request.getParameter("isMedical");
            String isOutCost = request.getParameter("isOutCost");
            String isOutRx = request.getParameter("isOutRx");
            String isOutImage = request.getParameter("isOutImage");
            String isOutJcz = request.getParameter("isOutJcz");
            String isOutZd = request.getParameter("isOutZd");
            String isHospital = request.getParameter("isHospital");
            String isHosImage = request.getParameter("isHosImage");
            String isHosJcz = request.getParameter("isHosJcz");
            String isHosOutCost = request.getParameter("isHosOutCost");
            String isHosZd = request.getParameter("isHosZd");
            String isHosEmr = request.getParameter("isHosEmr");
            String pageSize = request.getParameter("pageSize");
            String pageNo = request.getParameter("pageNo");
            PageModel page = new PageModel(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
            ArchiveQueryCon info = new ArchiveQueryCon();
            info.setStartTime(startTime);
            info.setEndTime(endTime);
            info.setIsMedical(isMedical);
            info.setIsOutCost(isOutCost);
            info.setIsOutRx(isOutRx);
            info.setIsOutImage(isOutImage);
            info.setIsOutJcz(isOutJcz);
            info.setIsOutZd(isOutZd);
            info.setIsHospital(isHospital);
            info.setIsHosImage(isHosImage);
            info.setIsHosJcz(isHosJcz);
            info.setIsHosOutCost(isHosOutCost);
            info.setIsHosZd(isHosZd);
            info.setIsHosEmr(isHosEmr);
            archiveService.getArchivePageByCon(info, page);
            return page;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //档案详情(健康浏览器-管理员登录)
    @RequestMapping("queryArchiveDetail")
    public Jbxxjlb queryArchiveDetail() {
        try {
            String archiveId = request.getParameter("archiveId");
            return archiveService.queryArchiveDetail(archiveId, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //档案详情(健康浏览器-管理员登录)
    @RequestMapping("getArchiveDetailBySfzh")
    public Jbxxjlb getArchiveDetailBySfzh() {
        try {
            String sfzh = request.getParameter("sfzh");
            return archiveService.queryArchiveDetail("", sfzh);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //档案详情(健康浏览器-his嵌入)
    @RequestMapping("queryArchiveDetailByCon")
    public Jbxxjlb queryArchiveDetailByCon() {
        try {
            String hzmc = request.getParameter("hzmc");
            String zjlx = request.getParameter("zjlx");
            String sfzh = request.getParameter("sfzh");
            return archiveService.queryArchiveDetailByCon(hzmc, zjlx, sfzh);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //病史信息详情(健康浏览器)
    @RequestMapping("queryBSxxDetail")
    public List<Bsxx> queryBSxxDetail() {
        try {
            String jmId = request.getParameter("jmId");
            return archiveService.queryBSxxDetail(jmId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //家族史信息详情(健康浏览器)
    @RequestMapping("queryJZSxxDetail")
    public Jzsxxb queryJZSxxDetail() {
        try {
            String jmId = request.getParameter("jmId");
            return archiveService.queryJZSxxDetail(jmId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //生活环境详情(健康浏览器)
    @RequestMapping("querySHhjDetail")
    public Shhjb querySHhjDetail() {
        try {
            String jmId = request.getParameter("jmId");
            return archiveService.querySHhjDetail(jmId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //通过身份证号获取人群类型
    @RequestMapping("queryRqlxBySfzh")
    public String queryRqlxBySfzh() {
        try {
            String sfzh = request.getParameter("sfzh");
            Jbxxjlb info = archiveService.queryArchiveDetail("", sfzh);
            return info.getRqlx();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("getInfoBySfzh")
    public BaseCustomerDomain getInfoBySfzh() {
        String param = getParam(request);
        String sfzh = JSONObject.parseObject(param).getString("sfzh");
        return archiveService.getInfoBySfzh(sfzh);

    }
}
