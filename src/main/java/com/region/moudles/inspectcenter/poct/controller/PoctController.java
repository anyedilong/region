package com.region.moudles.inspectcenter.poct.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.region.moudles.common.controller.BaseController;
import com.region.moudles.inspectcenter.poct.domain.Poct;
import com.region.moudles.inspectcenter.poct.service.PoctService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/poct")
public class PoctController extends BaseController {

    @Inject
    private PoctService poctService;

    /**
     * 查询检验列表
     * 聂亚威
     * @return
     */
    @RequestMapping("getPoctList")
    public List<Poct> getPoctList() {
        String param = getParam(request);
        logger.info("查询检验列表请求参数：" + param);
        Poct req = JSON.toJavaObject(JSONObject.parseObject(param), Poct.class);
        List<Poct> list = poctService.getPoctList(req);
        logger.info("查询检验列表返回：" + list);
        return list;
    }

    /**
     * 查询检验详情
     * 聂亚威
     * @return
     */
    @RequestMapping("getPoct")
    public Poct getPoct() {
        String param = getParam(request);
        logger.info("查询检验详情请求参数：" + param);
        Poct req = JSON.toJavaObject(JSONObject.parseObject(param), Poct.class);
        Poct resp = poctService.getPoct(req.getId());
        logger.info("查询检验详情返回：" + resp);
        return resp;
    }

}
