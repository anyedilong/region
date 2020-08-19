package com.region.moudles.tripartdock.statis.service;

import java.util.List;
import java.util.Map;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.stats.dto.ResultModel;
import com.region.moudles.stats.dto.StatsPlatResultModel;
import com.region.moudles.tripartdock.statis.dto.StatisJcDto;

public interface StatisService {

	//获取机构工作量charts数据
	Map<String, Object> getOrgWorkCharts(StatsPlatResultModel info) throws Exception;
	//获取机构工作量的列表
	void getOrgWorkList(StatsPlatResultModel info, PageModel page) throws Exception;
	
	//获取项目组别charts数据
	Map<String, Object> getItemGroupCharts(StatsPlatResultModel info) throws Exception;
	//获取项目组别的列表
	void getItemGroupList(StatsPlatResultModel info, PageModel page) throws Exception;
	
	// 获取检验申请charts柱状图数据
	Map<String, Object> getExamApplyBarCharts(StatsPlatResultModel info) throws Exception;
	//获取检验申请charts饼状图数据
	List<StatisJcDto> getExamApplyPieCharts(StatsPlatResultModel info) throws Exception;
	//获取检验申请的列表
	void getExamApplyList(StatsPlatResultModel info, PageModel page) throws Exception;
	
	// 获取标本量charts柱状图数据
	Map<String, Object> getSampleBarCharts(StatsPlatResultModel info) throws Exception;
	// 获取标本量charts饼状图数据
	List<StatisJcDto> getSamplePieCharts(StatsPlatResultModel info) throws Exception;
	// 获取检验申请charts折线图数据
	Map<String, Object> getSampleLineCharts(StatsPlatResultModel info) throws Exception;
	
	//获取检验数据charts数据
	Map<String, Object> getExamDataLineCharts(StatsPlatResultModel info) throws Exception;
	//获取检验数据的列表
	void getExamDataList(StatsPlatResultModel info, PageModel page) throws Exception;
	
	//获取检验组别统计（大屏）
	Map<String, Object> getItemGroupStatis(String orgId) throws Exception;
	//获取年度检验组别统计（大屏）
	Map<String, Object> getCurYearItemGroupStatis(String orgId) throws Exception;
	//获取往年同期年度检验组别统计（大屏）
	Map<String, Object> getBefYearItemGroupStatis(String orgId) throws Exception;
	//获取各医院本月标本量统计（大屏）
	List<ResultModel> getMonthSampleNumStatis(String orgId) throws Exception;
	//获取检验结果数据分析（大屏）
	Map<String, Object> getExamResultStatis(String orgId) throws Exception;
	//获取就诊类型统计（大屏）
	Map<String, Object> getVisitTypeStatis(String orgId) throws Exception;
	//获取服务动态数据（大屏）
	List<String> getActionServiceData(String orgId) throws Exception;
	
	//判断项目是否已经有检验数据
	Integer isExamDataExist(String itemCode, String itemName) throws Exception;
}
