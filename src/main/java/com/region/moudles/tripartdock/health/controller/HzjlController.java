package com.region.moudles.tripartdock.health.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.region.moudles.common.controller.BaseController;
import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.tripartdock.health.bean.Hzjl;
import com.region.moudles.tripartdock.health.service.HzjlService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

//会诊记录
@RestController
@RequestMapping("${hispath}/hzjl")
public class HzjlController extends BaseController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    private HzjlService hzjlService;

    /**
     * 获取会诊记录详情
     */
    @RequestMapping("/getInfo")
    public JsonResult getInfo() {
        String param = getParam(request);
        logger.info("查询会诊记录详情请求参数：" + param);
        JSONObject paramObj = JSONObject.parseObject(param);
        String id = paramObj.getString("id");
        if (StringUtils.isBlank(id)) {
            return jsonResult(null, 90001, "ID不能为空！");
        }
        Hzjl info = hzjlService.getInfo(id);
        logger.info("查询会诊记录详情返回：" + JSON.toJSONString(info));
        return jsonResult(info);
    }
}
