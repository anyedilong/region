package com.region.moudles.stats.service;

import java.util.Map;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.stats.dto.StatsPlatResultModel;
import com.region.moudles.stats.dto.StatsResultModel;

public interface StatsSPMSService {

	
	//同期折线统计
	StatsResultModel getTQLineData(StatsPlatResultModel info) throws Exception ;
	
	//运营（科室和医疗）分类各种情况的占比
	Map<String,Object> getMedicantChartsData(StatsPlatResultModel mode) throws Exception ;
	
	//获取运营（科室和医疗）各类型的统计(列表)
	void getMedicantTypePage(StatsPlatResultModel mode, PageModel page) throws Exception ;
	
	//获取各月份的运营（科室和医疗）各类型的统计(柱状)
	Map<String, Object> getMedicantTypeByMonth(StatsPlatResultModel info) throws Exception ;
	
	//获取各运营（科室和医疗）类型的占比（饼状）
	Object getMedicantTypeProp(StatsPlatResultModel info) throws Exception ;
}
