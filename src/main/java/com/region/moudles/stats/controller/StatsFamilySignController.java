package com.region.moudles.stats.controller;


import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.region.moudles.common.controller.BaseController;
import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.stats.dto.StatsPlatResultModel;
import com.region.moudles.stats.service.StatsFamilySignService;
import com.region.until.StringUntil;
import com.region.until.SysUtil;

/**
 * @ClassName: StatsFamilySignController
 * @Description: 家医签约数据获取入口
 * @author Administrator
 * @date 2019年6月20日
 */

@RestController
@RequestMapping("${familypath}/statssign")
public class StatsFamilySignController extends BaseController {

	@Inject
	private StatsFamilySignService familySignService;
	
	
	/**
	 * @Description: 获取家医菜单中家庭签约统计签约、履约人次、履约人数、解约（echarts）
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getJYTimesStats")
    public JsonResult getJYTimesStats(){
    	try {
    		String param = getParam(request);
    		
            StatsPlatResultModel info = JSON.parseObject(param, StatsPlatResultModel.class);
            if (info == null) {
                info = new StatsPlatResultModel();
            }
            if(StringUntil.isNull(info.getOrgCode())) {
            	//获取当前登录人的机构code 
                String orgCode = SysUtil.sysUser(request, response).getOrg().getOrgCode();
                info.setOrgCode(orgCode);
            }
            return jsonResult(familySignService.getJYTimesStats(info));
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 获取家庭签约菜单中县区排行
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getQXJYTimesStats")
    public JsonResult getQXJYTimesStats(){
    	try {
    		String param = getParam(request);
    		String orgCode = JSON.parseObject(param).getString("orgCode");
    		//01:医疗 15.家医
    		String incomeType = JSON.parseObject(param).getString("incomeType");
            if(StringUntil.isNull(orgCode)) {
            	//获取当前登录人的机构code 
            	orgCode = SysUtil.sysUser(request, response).getOrgCode();
            }
    		return jsonResult(familySignService.getQXJYTimesStats(incomeType, orgCode));
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 获取家庭签约的类别的统计（列表）
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getJGLBTimesPage")
    public JsonResult getJGLBTimesPage(){
    	try {
    		String param = getParam(request);
            StatsPlatResultModel info = JSON.parseObject(param, StatsPlatResultModel.class);
            if (info == null) {
                info = new StatsPlatResultModel();
            }
            if(StringUntil.isNull(info.getOrgCode())) {
            	//获取当前登录人的机构code 
            	String orgCode = SysUtil.sysUser(request, response).getOrg().getOrgCode();
                info.setOrgCode(orgCode);
            }
            JSONObject obj = JSON.parseObject(param);
			PageModel page = new PageModel(obj.getInteger("pageNum"), obj.getInteger("pageSize"));
			familySignService.getJGLBTimesPage(info, page);
            return jsonResult(page);
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 获取家庭签约菜单中各类别的收入（echarts）
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getJYItemTimesStats")
    public JsonResult getJYItemTimesStats(){
    	try {
    		String param = getParam(request);
            StatsPlatResultModel info = JSON.parseObject(param, StatsPlatResultModel.class);
            if (info == null) {
                info = new StatsPlatResultModel();
            }
            if(StringUntil.isNull(info.getOrgCode())) {
            	//获取当前登录人的机构code 
            	String orgCode = SysUtil.sysUser(request, response).getOrg().getOrgCode();
                info.setOrgCode(orgCode);
            }
    		return jsonResult(familySignService.getJYItemTimesStats(info));
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 获取某个地方各类别的收入占比（echarts）
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getJYItemPropStats")
    public JsonResult getJYItemPropStats(){
    	try {
    		String param = getParam(request);
            StatsPlatResultModel info = JSON.parseObject(param, StatsPlatResultModel.class);
            if (info == null) {
                info = new StatsPlatResultModel();
            }
            if(StringUntil.isNull(info.getOrgCode())) {
            	//获取当前登录人的机构code 
            	String orgCode = SysUtil.sysUser(request, response).getOrg().getOrgCode();
                info.setOrgCode(orgCode);
            }
    		return jsonResult(familySignService.getJYItemPropStats(info));
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
}