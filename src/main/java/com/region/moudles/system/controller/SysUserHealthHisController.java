package com.region.moudles.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.region.moudles.common.controller.BaseController;
import com.region.moudles.common.domain.JsonHisResult;
import com.region.moudles.system.domain.SysUserHealth;
import com.region.moudles.system.service.SysUserHealthService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;


@RestController
@RequestMapping("/his/sys")
public class SysUserHealthHisController extends BaseController {

    @Inject
    private SysUserHealthService sysUserHealthService;

    @RequestMapping("user")
     public JsonHisResult saveuser(){
         String param=getParam(request);
         List<SysUserHealth> list= JSONObject.parseArray(param,SysUserHealth.class);
               sysUserHealthService.saveuser(list);
        return JsonHisResult(null,0,"保存成功");
    }

}
