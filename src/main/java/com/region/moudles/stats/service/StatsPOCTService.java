package com.region.moudles.stats.service;

import java.util.List;
import java.util.Map;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.stats.dto.ResultModel;
import com.region.moudles.stats.dto.StatsPlatResultModel;

public interface StatsPOCTService {

	// 获取核酸检验统计菜单中检验人次、结果呈阳性、结果呈阴性（echarts）
	Map<String, Object> getNucleinCheckStats(StatsPlatResultModel info)throws Exception;
	
	//获取家庭签约的类别的统计（列表）
	void getJGLBTimesPage(StatsPlatResultModel info, PageModel page)throws Exception;
	
	//获取家庭签约菜单中各类别的收入（echarts）
	Map<String, Object> getJYItemTimesStats(StatsPlatResultModel info)throws Exception;
	
	//获取某个地方各类别的收入占比（echarts）
	List<ResultModel> getJYItemPropStats(StatsPlatResultModel info)throws Exception;
	
}
