package com.region.moudles.stats.controller;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.region.moudles.common.controller.BaseController;
import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.stats.dto.StatsPlatResultModel;
import com.region.moudles.stats.service.StatsService;

/**
 * @ClassName: StatsController
 * @Description: 大屏统计图表数据获取入口
 * @author Administrator
 * @date 2019年6月20日
 */
@RestController
@RequestMapping("${familypath}/stats")
public class StatsController  extends BaseController {

	@Inject
	private StatsService statsService;
	
	/**
	 * @Description: 获取家庭医生签约人次
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getDoctorConNum")
    public JsonResult getDoctorConNum(){
    	try {
    		String param = getParam(request);
    		if (StringUtils.isNotBlank(param)) {
				JSONObject jsonObject = JSONObject.parseObject(param);
				String orgCode = jsonObject.getString("orgCode");
				return jsonResult(statsService.getDoctorConNum(orgCode));
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 获取人群类型占比
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getPopTypeProp")
    public JsonResult getPopTypeProp(){
    	try {
    		String param = getParam(request);
    		if (StringUtils.isNotBlank(param)) {
				JSONObject jsonObject = JSONObject.parseObject(param);
				String orgCode = jsonObject.getString("orgCode");
				return jsonResult(statsService.getPopTypeProp(orgCode));
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 获取履约人数
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getCompliantPersonsNum")
    public JsonResult getCompliantPersonsNum(){
    	try {
    		String param = getParam(request);
    		if (StringUtils.isNotBlank(param)) {
				JSONObject jsonObject = JSONObject.parseObject(param);
				String orgCode = jsonObject.getString("orgCode");
				return jsonResult(statsService.getCompliantPersonsNum(orgCode));
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 获取建档、签约、体检的人数(各区县)
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getPopTypesSpread")
    public JsonResult getPopTypesSpread(){
    	try {
    		String param = getParam(request);
    		if (StringUtils.isNotBlank(param)) {
				JSONObject jsonObject = JSONObject.parseObject(param);
				String orgCode = jsonObject.getString("orgCode");
				return jsonResult(statsService.getPopTypesSpread(orgCode));
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 获取年度就诊人次统计
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getAnnualVisits")
    public JsonResult getAnnualVisits(){
    	try {
    		String param = getParam(request);
    		if (StringUtils.isNotBlank(param)) {
				JSONObject jsonObject = JSONObject.parseObject(param);
				String orgCode = jsonObject.getString("orgCode");
				return jsonResult(statsService.getAnnualVisits(orgCode));
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 获取年度入/出院人次统计
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getInOrOutHospitalVisits")
    public JsonResult getInOrOutHospitalVisits(){
    	try {
    		String param = getParam(request);
    		if (StringUtils.isNotBlank(param)) {
				JSONObject jsonObject = JSONObject.parseObject(param);
				String orgCode = jsonObject.getString("orgCode");
				return jsonResult(statsService.getInOrOutHospitalVisits(orgCode));
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 获取县区医院就诊统计
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getHospitalVisits")
    public JsonResult getHospitalVisits(){
    	try {
    		String param = getParam(request);
    		if (StringUtils.isNotBlank(param)) {
				JSONObject jsonObject = JSONObject.parseObject(param);
				String orgCode = jsonObject.getString("orgCode");
				String type = jsonObject.getString("type");
				return jsonResult(statsService.getHospitalVisits(orgCode, type));
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 统计某地区的各类人数
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("peopNumStats")
    public JsonResult peopNumStats(){
    	try {
    		String param = getParam(request);
    		if (StringUtils.isNotBlank(param)) {
				JSONObject jsonObject = JSONObject.parseObject(param);
				String orgCode = jsonObject.getString("orgCode");
				String typeFlg = jsonObject.getString("typeFlg");
				return jsonResult(statsService.peopNumStats(orgCode, typeFlg));
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 获取卫生院的人群类型占比
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getWSYPopTypeProp")
    public JsonResult getWSYPopTypeProp(){
    	try {
    		String param = getParam(request);
    		if (StringUtils.isNotBlank(param)) {
				JSONObject jsonObject = JSONObject.parseObject(param);
				String orgCode = jsonObject.getString("orgCode");
				return jsonResult(statsService.getWSYPopTypeProp(orgCode));
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 获取卫生院的随访人次
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getWSYFollowPropNum")
    public JsonResult getWSYFollowPropNum(){
    	try {
    		String param = getParam(request);
    		if (StringUtils.isNotBlank(param)) {
				JSONObject jsonObject = JSONObject.parseObject(param);
				String orgCode = jsonObject.getString("orgCode");
				String typeFlg = jsonObject.getString("typeFlg");
				return jsonResult(statsService.getWSYFollowPropNum(orgCode, typeFlg));
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 获取卫生院的家医签约
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getWSYDoctorSign")
    public JsonResult getWSYDoctorSign(){
    	try {
    		String param = getParam(request);
    		if (StringUtils.isNotBlank(param)) {
				JSONObject jsonObject = JSONObject.parseObject(param);
				String orgCode = jsonObject.getString("orgCode");
				return jsonResult(statsService.getWSYDoctorSign(orgCode));
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 获取卫生院的就诊人次
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getWSYHospitalNum")
    public JsonResult getWSYHospitalNum(){
    	try {
    		String param = getParam(request);
    		if (StringUtils.isNotBlank(param)) {
				JSONObject jsonObject = JSONObject.parseObject(param);
				String orgCode = jsonObject.getString("orgCode");
				return jsonResult(statsService.getWSYHospitalNum(orgCode));
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 获取个别医院的药品收入、门诊次均费用和住院次均费用（人民医院、中医院和妇幼保健院）
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getYYChargeStatsData")
    public JsonResult getYYChargeStatsData(){
    	try {
    		String param = getParam(request);
    		if (StringUtils.isNotBlank(param)) {
    			StatsPlatResultModel info = JSON.parseObject(param, StatsPlatResultModel.class);
				return jsonResult(statsService.getYYChargeStatsData(info));
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 获取卫生院的年度总收入、医保收入、收入对比、本月收入数据
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getWSYOtherData")
    public JsonResult getWSYOtherData(){
    	try {
    		String param = getParam(request);
    		if (StringUtils.isNotBlank(param)) {
				JSONObject jsonObject = JSONObject.parseObject(param);
				String orgCode = jsonObject.getString("orgCode");
				return jsonResult(statsService.getWSYOtherData(orgCode));
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 获取服务动态数据
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getServiceData")
    public JsonResult getServiceData(){
    	try {
    		String param = getParam(request);
    		if (StringUtils.isNotBlank(param)) {
				JSONObject jsonObject = JSONObject.parseObject(param);
				String orgCode = jsonObject.getString("orgCode");
				return jsonResult(statsService.getServiceData(orgCode));
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
}
