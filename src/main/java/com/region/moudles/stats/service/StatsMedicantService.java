package com.region.moudles.stats.service;

import java.util.Map;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.stats.dto.StatsPlatResultModel;
import com.region.moudles.stats.dto.StatsResultModel;

public interface StatsMedicantService {

	//获取医疗菜单中医疗收入统计住院、门诊、检查（echarts）
	Map<String, Object> getYLChargeStats(StatsPlatResultModel info)throws Exception;
	
	//获取机构的处方项类别的收入统计
	void getJGLBSRCharges(StatsPlatResultModel info, PageModel page)throws Exception;
	
	// 获取医疗菜单中区域总收入统计（echarts）
	Object getQXYLChargeStats(String incomeType, String orgCode)throws Exception;
	
	// 获取医疗菜单中各处方项类别的收入（echarts）
	Map<String, Object> getYLItemChargeStats(StatsPlatResultModel info)throws Exception;
	
	//获取某个地方各处方项类别的收入占比
	Object getYLItemTypeStats(StatsPlatResultModel info)throws Exception;
	
	//获取机构的处方项类别的收入统计
	void getJGITSRCharges(StatsPlatResultModel info, PageModel page)throws Exception;
	
	// 获取机构的处方项类别的各月份收入统计
	StatsResultModel getYLMonthItemChargeStats(StatsPlatResultModel info)throws Exception;
	
	//获取各处方项类别的收入占比（echarts）
	Object getYLMonthItemPropStats(StatsPlatResultModel info)throws Exception;
}
