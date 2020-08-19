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
import com.region.moudles.system.domain.SysOrg;
import com.region.moudles.system.dto.SysUserHealthDto;
import com.region.moudles.system.service.SysOrgService;
import com.region.moudles.system.service.SysUserHealthService;
import com.region.until.SysUtil;


@RestController
@RequestMapping("${familypath}/userHealth")
public class SysUserHealthController extends BaseController{

    @Inject
    private SysUserHealthService userHealthService;
    @Inject
    private SysOrgService sysOrgService;
    
    /**
     *	  查询卫生人员列表
     * @param param
     */
    @RequestMapping("getUserHealthPage")
    public JsonResult getUserHealthPage(){
    	try {
    		String param = getParam(request);
    		if(StringUtils.isNoneBlank(param)){
    			SysUserHealthDto userHealth = JSON.parseObject(param, SysUserHealthDto.class);
	            if(userHealth == null) {
	            	userHealth = new SysUserHealthDto();
	            }
	            String orgId = SysUtil.sysUser(request, response).getOrgId();
	            SysOrg org = sysOrgService.get(orgId);
	            userHealth.setOrgCode(org.getOrgCode());
	            JSONObject obj = JSON.parseObject(param).getJSONObject("page");
				PageModel page = new PageModel(obj.getInteger("pageNum"), obj.getInteger("pageSize"));
	    		userHealthService.getUserHealthPage(userHealth, page);
	            return jsonResult(page);
            }
            return jsonResult();
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
}
