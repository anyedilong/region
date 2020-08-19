package com.region.moudles.stats.service;

import java.util.List;
import java.util.Map;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.stats.dto.ResultModel;
import com.region.moudles.stats.dto.StatsPlatResultModel;

public interface StatsFamilySignService {

	//获取家医菜单中家庭签约统计签约、履约人次、履约人数、解约（echarts）
	Map<String, Object> getJYTimesStats(StatsPlatResultModel info)throws Exception;
	
	//获取家庭签约菜单中县区排行
	List<ResultModel> getQXJYTimesStats(String incomeType, String orgCode)throws Exception;
	
	//获取家庭签约的类别的统计（列表）
	void getJGLBTimesPage(StatsPlatResultModel info, PageModel page)throws Exception;
	
	//获取家庭签约菜单中各类别的收入（echarts）
	Map<String, Object> getJYItemTimesStats(StatsPlatResultModel info)throws Exception;
	
	//获取某个地方各类别的收入占比（echarts）
	List<ResultModel> getJYItemPropStats(StatsPlatResultModel info)throws Exception;
	
}
