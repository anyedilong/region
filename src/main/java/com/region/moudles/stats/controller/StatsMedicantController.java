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
import com.region.moudles.stats.service.StatsMedicantService;
import com.region.until.StringUntil;
import com.region.until.SysUtil;

/**
 * @ClassName: StatsMedicantController
 * @Description: 医疗收入数据获取入口
 * @author Administrator
 * @date 2019年6月20日
 */

@RestController
@RequestMapping("${familypath}/statsmedicant")
public class StatsMedicantController extends BaseController {

	@Inject
	private StatsMedicantService medicantService;
	
	
	/**
	 * @Description: 获取医疗菜单中医疗收入统计住院、门诊、检查（echarts）
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getYLChargeStats")
    public JsonResult getYLChargeStats(){
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
            return jsonResult(medicantService.getYLChargeStats(info));
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 获取机构的处方项类别的收入统计
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getJGLBSRCharges")
    public JsonResult getJGLBSRCharges(){
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
			medicantService.getJGLBSRCharges(info, page);
            return jsonResult(page);
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 获取医疗菜单中区域总收入统计（echarts）
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getQXYLChargeStats")
    public JsonResult getQXYLChargeStats(){
    	try {
    		String param = getParam(request);
    		String orgCode = JSON.parseObject(param).getString("orgCode");
    		//01:医疗 15.家医
    		String incomeType = JSON.parseObject(param).getString("incomeType");
            if(StringUntil.isNull(orgCode)) {
            	//获取当前登录人的机构code 
            	orgCode = SysUtil.sysUser(request, response).getOrgCode();
            }
    		return jsonResult(medicantService.getQXYLChargeStats(incomeType, orgCode));
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 获取医疗菜单中各处方项类别的收入（echarts）
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getYLItemChargeStats")
    public JsonResult getYLItemChargeStats(){
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
    		return jsonResult(medicantService.getYLItemChargeStats(info));
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 获取某个地方各处方项类别的收入占比（echarts）
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getYLItemTypeStats")
    public JsonResult getYLItemTypeStats(){
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
    		return jsonResult(medicantService.getYLItemTypeStats(info));
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 获取机构的处方项类别的收入统计
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getJGITSRCharges")
    public JsonResult getJGITSRCharges(){
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
			medicantService.getJGITSRCharges(info, page);
            return jsonResult(page);
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 获取机构的处方项类别的各月份收入统计（echarts）
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getYLMonthItemChargeStats")
    public JsonResult getYLMonthItemChargeStats(){
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
    		return jsonResult(medicantService.getYLMonthItemChargeStats(info));
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 获取各处方项类别的收入占比（echarts）
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getYLMonthItemPropStats")
    public JsonResult getYLMonthItemPropStats(){
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
    		return jsonResult(medicantService.getYLMonthItemPropStats(info));
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
}