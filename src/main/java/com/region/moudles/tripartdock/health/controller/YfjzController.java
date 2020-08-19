package com.region.moudles.tripartdock.health.controller;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.region.moudles.common.controller.BaseController;
import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.tripartdock.follow.dto.RequestDto;
import com.region.moudles.tripartdock.health.dto.YfjzDto;
import com.region.moudles.tripartdock.health.service.YfjzService;

//预防接种
@RestController
@RequestMapping("${hispath}/yfjz")
public class YfjzController extends BaseController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    private YfjzService yfjzService;

    /**
     * 获取预防接种详情
     */
    @RequestMapping("getInfo")
    public JsonResult getInfo() {
        String param = getParam(request);
        logger.info("查询预防接种详情请求参数：" + param);
        JSONObject paramObj = JSONObject.parseObject(param);
        String id = paramObj.getString("id");
        if (StringUtils.isBlank(id)) {
            return jsonResult(null, 90001, "ID不能为空！");
        }
        YfjzDto yfjz = yfjzService.getInfo(JSONObject.parseObject(param, RequestDto.class));
        logger.info("查询预防接种详情返回：" + JSON.toJSONString(yfjz));
        return jsonResult(yfjz);
    }

    //获取预防接种列表
    @RequestMapping("getList")
    public JsonResult getList() throws Exception {
        String param = getParam(request);
        RequestDto request = JSONObject.parseObject(param, RequestDto.class);
        return yfjzService.getList(request);
    }
}
