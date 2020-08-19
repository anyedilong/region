package com.region.moudles.inspectcenter.qualitydata.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.region.moudles.common.controller.BaseController;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.inspectcenter.qualitydata.domain.QualityData;
import com.region.moudles.inspectcenter.qualitydata.service.QualityService;
import com.region.moudles.outpatient.dto.JcDto;
import com.region.until.DateUntil;
import org.apache.commons.lang3.StringUtils;
import org.dcm4che2.util.DateUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/quality")
public class QualityController extends BaseController {

    @Inject
    private QualityService qualityService;

    /**
     * 查询质控数据列表（分页）
     * 聂亚威
     *
     * @return
     */
    @RequestMapping("getQualityPage")
    public PageModel getQualityPage() {
        String param = getParam(request);
        logger.info("查询质控数据列表（分页）请求参数：" + param);
        JSONObject json = JSONObject.parseObject(param);
        String controlDate = json.getString("controlDate");
        if (StringUtils.isNotBlank(controlDate) && controlDate.length() == 7) {
            controlDate = controlDate + "-01";
            json.put("controlDate", controlDate);
        }
        JcDto req = JSON.toJavaObject(json, JcDto.class);
        //设置查询结束时间
        if (req.getControlDate() != null)
            req.setNextControlDate(DateUntil.getMonthAfter(DateUntil.parseDate(controlDate), 1));
        req.setPage(new PageModel(req.getPageNo() == null ? 1 : req.getPageNo(), req.getPageSize() == null ? 10 : req.getPageSize()));
        qualityService.getQualityPage(req);
        logger.info("查询质控数据列表（分页）返回：" + JSON.toJSONString(req.getPage()));
        return req.getPage();
    }

    /**
     * 查询质控数据结果
     * 聂亚威
     *
     * @return
     */
    @RequestMapping("getResultList")
    public List<QualityData> getResultList() {
        String param = getParam(request);
        logger.info("查询质控数据结果请求参数：" + param);
        JSONObject json = JSONObject.parseObject(param);
        String controlDate = json.getString("month");
        if (StringUtils.isNotBlank(controlDate) && controlDate.length() == 7) {
            controlDate = controlDate + "-01";
            json.put("controlDate", controlDate);
        }
        JcDto req = JSON.toJavaObject(json, JcDto.class);
        //设置查询结束时间
        if (req.getControlDate() != null)
            req.setNextControlDate(DateUntil.getMonthAfter(DateUntil.parseDate(controlDate), 1));
        req.setPage(new PageModel(req.getPageNo() == null ? 1 : req.getPageNo(), req.getPageSize() == null ? 10 : req.getPageSize()));
        List<QualityData> list = qualityService.getResultList(req);
        logger.info("查询质控数据结果返回：" + JSON.toJSONString(list));
        return list;
    }

}
