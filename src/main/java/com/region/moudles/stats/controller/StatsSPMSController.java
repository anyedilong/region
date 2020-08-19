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
import com.region.moudles.stats.service.StatsSPMSService;
import com.region.until.StringUntil;
import com.region.until.SysUtil;

/**
 * @ClassName: StatsController
 * @Description: 平台统计获取数据入口（公用）
 * @author Administrator
 * @date 2019年6月20日
 */

@RestController
@RequestMapping("${familypath}/commonstats")
public class StatsSPMSController extends BaseController {

	@Inject
	private StatsSPMSService statsSPMSService;
	
	/**
	 * 	同期折线统计
	 * @return
	 */
	@RequestMapping("/getTQLineCharts")
	public JsonResult getTQLineCharts() {
		
		try {
			String param =getParam(request);
			StatsPlatResultModel info = JSON.parseObject(param, StatsPlatResultModel.class);
			if(info ==null) {
				info =new StatsPlatResultModel();
			}
			if(StringUntil.isNull(info.getOrgCode())){
				info.setOrgCode(SysUtil.sysUser(request, response).getOrgCode());
			}
			
			return jsonResult(statsSPMSService.getTQLineData(info));
		}catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null,9001,"获取失败");
		}
	}
		
	/**
	 * 	运营（科室和医疗）分类各种情况的占比
	 * @return
	 */
	@RequestMapping("getOperManageChartsData")
	public JsonResult getManageChartsData() {
		try {
			String param = getParam(request);
			StatsPlatResultModel mode = JSON.parseObject(param, StatsPlatResultModel.class);
			if(mode ==null) {
			   mode = new StatsPlatResultModel();
			}
			if(StringUntil.isNull(mode.getOrgCode())) {
				mode.setOrgCode(SysUtil.sysUser(request, response).getOrgCode());
			}
			return jsonResult(statsSPMSService.getMedicantChartsData(mode));
		}catch(Exception e) {
			e.printStackTrace();
			return jsonResult(null,9001,"获取失败");
		}
	}
	
	/**
	 * @Description: 获取运营（科室和医疗）各类型的统计(列表)
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getOperTypePage")
    public JsonResult getOperTypePage(){
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
			statsSPMSService.getMedicantTypePage(info, page);
            return jsonResult(page);
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 获取各月份的运营（科室和医疗）各类型的统计(柱状)
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getOperTypeByMonth")
    public JsonResult getOperTypeByMonth(){
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
    		return jsonResult(statsSPMSService.getMedicantTypeByMonth(info));
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 获取各运营（科室和医疗）类型的占比（饼状）
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getOperTypeProp")
    public JsonResult getOperTypeProp(){
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
    		return jsonResult(statsSPMSService.getMedicantTypeProp(info));
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
}