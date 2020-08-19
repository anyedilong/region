package com.region.moudles.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.region.moudles.common.controller.BaseController;
import com.region.moudles.common.domain.BaseDomain;
import com.region.moudles.system.domain.Department;
import com.region.moudles.system.service.SystemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;


@RestController
@RequestMapping("/his/system")
public class SystemController extends BaseController{

    @Inject
    private SystemService systemService;
    /**
     * 保存科室
     * @param param
     */
    public void  getDep(String param){
        List<Department> list=JSONObject.parseArray(param, Department.class);
        if(list!=null&&list.size()>0){
           systemService.getDep(list);
        }

    }
}
