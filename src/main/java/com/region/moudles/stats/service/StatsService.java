package com.region.moudles.stats.service;

import java.util.List;
import java.util.Map;

import com.region.moudles.stats.dto.StatsPlatResultModel;
import com.region.moudles.stats.dto.StatsResultModel;

public interface StatsService {

	
	//获取家庭医生签约人次
	StatsResultModel getDoctorConNum(String orgCode)throws Exception;
	
	//获取人群类型占比
	StatsResultModel getPopTypeProp(String orgCode)throws Exception;
	
	//获取履约人数
	StatsResultModel getCompliantPersonsNum(String orgCode)throws Exception;
	
	//获取建档、签约、体检的人数(各区县)
	StatsResultModel getPopTypesSpread(String orgCode)throws Exception;
	
	//获取年度就诊人次统计
	StatsResultModel getAnnualVisits(String orgCode)throws Exception;
	
	//获取年度入/出院人次统计
	StatsResultModel getInOrOutHospitalVisits(String orgCode)throws Exception;
	
	//获取县区医院就诊统计
	StatsResultModel getHospitalVisits(String orgCode, String type)throws Exception;
	
	//统计某地区的各类人数
	Map<String, Object> peopNumStats(String orgCode, String typeFlg)throws Exception;
	
	//获取人群类型占比
	Map<String, Object> getWSYPopTypeProp(String orgCode)throws Exception;
	
	//获取卫生院的随访人次
	Map<String, Object> getWSYFollowPropNum(String orgCode, String typeFlg)throws Exception;
	
	//获取卫生院的家医签约
	Map<String, Object> getWSYDoctorSign(String orgCode)throws Exception;
	
	//获取卫生院的就诊人次
	Map<String, Object> getWSYHospitalNum(String orgCode)throws Exception;
	
	//获取卫生院的年度总收入、医保收入、收入对比、本月收入数据
	Map<String, Object> getWSYOtherData(String orgCode)throws Exception;
	
	//获取个别医院的药品收入、门诊次均费用和住院次均费用（人民医院、中医院和妇幼保健院）
	StatsResultModel getYYChargeStatsData(StatsPlatResultModel info)throws Exception;
	
	//获取服务动态数据
	List<String> getServiceData(String orgCode)throws Exception;
}
