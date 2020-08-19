package com.region.moudles.system.controller;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.region.moudles.common.controller.BaseController;
import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.system.dto.SysDepartmentDto;
import com.region.moudles.system.service.SysDepartmentService;



@RestController
@RequestMapping("${familypath}/department")
public class SysDepartmentController extends BaseController{

    @Inject
    private SysDepartmentService departmentService;
    
    /**
     *	  查询科室目录
     * @param param
     */
    @RequestMapping("getDepartPage")
    public JsonResult getDepartPage(){
    	try {
    		String param = getParam(request);
    		if(StringUtils.isNoneBlank(param)){
    			SysDepartmentDto department = JSON.parseObject(param, SysDepartmentDto.class);
	    		if (department == null) {
	    			department = new SysDepartmentDto();
	    		}
	    		JSONObject obj = JSON.parseObject(param).getJSONObject("page");
				PageModel page = new PageModel(obj.getInteger("page_no"), obj.getInteger("page_size"));
	            departmentService.getDepPage(department, page);
	            return jsonResult(page);
            }
            return jsonResult();
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
}
