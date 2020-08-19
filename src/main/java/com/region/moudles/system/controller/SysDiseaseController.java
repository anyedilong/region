package com.region.moudles.system.controller;


import com.alibaba.fastjson.JSONObject;
import com.region.moudles.common.controller.BaseController;
import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.system.domain.SysDiseaseDomain;
import com.region.moudles.system.domain.SysDiseaseTypeDomain;
import com.region.moudles.system.dto.DepartmentDto;
import com.region.moudles.system.dto.SysDiseaseDto;
import com.region.moudles.system.dto.SysDiseaseTypeDto;
import com.region.moudles.system.dto.SysDrugDto;
import com.region.moudles.system.service.BltMedicantTypeService;
import com.region.moudles.system.service.SysDepartmentService;
import com.region.moudles.system.service.SysDiseaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/his/system")
public class SysDiseaseController extends BaseController {

    @Inject
    private SysDiseaseService sysDiseaseService;
    @Inject
    private SysDepartmentService sysDepartmentService;
    @Inject
    private BltMedicantTypeService bltMedicantTypeService;
    
    /**
    　　* @Title  疾病下载
    　　* @param 
    　　* @return 
    　　* @throws
    　　* @author lenovo
    　　* @date 2019/8/10 2019/8/10 
    　　*/
    @RequestMapping("disease")
    public JsonResult getdisease(){
              String param=getParam(request);
              JSONObject paramObj= JSONObject.parseObject(param);
              String type=paramObj.getString("disease_type_code");
              List<SysDiseaseDto>  list=sysDiseaseService.getDisease(type);
            return  jsonResult(list);
   }
   /**
   　　* @Title  疾病类型下载
   　　* @param 
   　　* @return 
   　　* @throws
   　　* @author lenovo
   　　* @date 2019/8/10 2019/8/10
   　　*/
    @RequestMapping("diseasetype")
    public JsonResult getdiseasetype(){
        List<SysDiseaseTypeDto>  list=sysDiseaseService.getType();
        return  jsonResult(list);
    }
    /**
    　　* @Title  科室下载
    　　* @param 
    　　* @return 
    　　* @throws
    　　* @author lenovo
    　　* @date 2019/8/10 2019/8/10 
    　　*/
    @RequestMapping("getdep")
    public  JsonResult getdep(){
           List<DepartmentDto> list=sysDepartmentService.getdep();
           return  jsonResult(list);
    }
    /**
    　　* @Title  药品下载
    　　* @param 
    　　* @return 
    　　* @throws
    　　* @author lenovo
    　　* @date 2019/8/10 2019/8/10 
    　　*/
    @RequestMapping("drug")
    public JsonResult  getdrug(){
         List<SysDrugDto> list=bltMedicantTypeService.getdrug();
         return  jsonResult(list);
    }
}
