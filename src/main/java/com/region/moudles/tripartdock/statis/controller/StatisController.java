package com.region.moudles.tripartdock.statis.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.region.moudles.common.controller.BaseController;
import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.stats.dto.StatsPlatResultModel;
import com.region.moudles.tripartdock.statis.service.StatisService;

/**
 * @ClassName: StatsController
 * @Description: 大屏统计图表数据获取入口
 * @author Administrator
 * @date 2019年6月20日
 */
@RestController
@RequestMapping("/his/statis")
public class StatisController  extends BaseController {

	@Inject
	private StatisService statisService;
	
	/**
	 * @Description: 获取机构工作量charts数据
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getOrgWorkCharts")
    public JsonResult getOrgWorkCharts(){
    	try {
    		String startTime = request.getParameter("startTime");
    		String endTime = request.getParameter("endTime");
    		String orgId = request.getParameter("orgId");
    		String itemGroupName = request.getParameter("itemGroupName");
    		StatsPlatResultModel info = new StatsPlatResultModel(startTime, endTime, orgId, itemGroupName);
    		
			return jsonResult(statisService.getOrgWorkCharts(info));
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 获取机构工作量的列表
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getOrgWorkList")
    public JsonResult getOrgWorkList(){
    	try {
    		String startTime = request.getParameter("startTime");
    		String endTime = request.getParameter("endTime");
    		String orgId = request.getParameter("orgId");
    		String itemGroupName = request.getParameter("itemGroupName");
    		String pageNo = request.getParameter("pageNo");
    		String pageSize = request.getParameter("pageSize");
    		StatsPlatResultModel info = new StatsPlatResultModel(startTime, endTime, orgId, itemGroupName);
    		info.setPageNo(Integer.parseInt(pageNo));
    		info.setPageSize(Integer.parseInt(pageSize));
    		PageModel page = new PageModel(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
    		
    		statisService.getOrgWorkList(info, page);
			return jsonResult(page);
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 获取项目组别charts数据
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getItemGroupCharts")
    public JsonResult getItemGroupCharts(){
    	try {
    		String startTime = request.getParameter("startTime");
    		String endTime = request.getParameter("endTime");
    		String orgId = request.getParameter("orgId");
    		StatsPlatResultModel info = new StatsPlatResultModel(startTime, endTime, orgId);
    		
			return jsonResult(statisService.getItemGroupCharts(info));
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 获取项目组别的列表
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getItemGroupList")
    public JsonResult getItemGroupList(){
    	try {
    		String startTime = request.getParameter("startTime");
    		String endTime = request.getParameter("endTime");
    		String orgId = request.getParameter("orgId");
    		String pageNo = request.getParameter("pageNo");
    		String pageSize = request.getParameter("pageSize");
    		StatsPlatResultModel info = new StatsPlatResultModel(startTime, endTime, orgId);
    		info.setPageNo(Integer.parseInt(pageNo));
    		info.setPageSize(Integer.parseInt(pageSize));
    		PageModel page = new PageModel(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
    		
    		statisService.getItemGroupList(info, page);
			return jsonResult(page);
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description:  获取检验申请charts柱状图数据
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getExamApplyBarCharts")
    public JsonResult getExamApplyBarCharts(){
    	try {
    		String startTime = request.getParameter("year");
    		String endTime = request.getParameter("month");
    		String orgId = request.getParameter("orgId");
    		StatsPlatResultModel info = new StatsPlatResultModel(startTime, endTime, orgId);
    		
			return jsonResult(statisService.getExamApplyBarCharts(info));
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description:  获取检验申请charts饼状图数据
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getExamApplyPieCharts")
    public JsonResult getExamApplyPieCharts(){
    	try {
    		String startTime = request.getParameter("year");
    		String endTime = request.getParameter("month");
    		String orgId = request.getParameter("orgId");
    		StatsPlatResultModel info = new StatsPlatResultModel(startTime, endTime, orgId);
    		
			return jsonResult(statisService.getExamApplyPieCharts(info));
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 获取检验申请的列表
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getExamApplyList")
    public JsonResult getExamApplyList(){
    	try {
    		String startTime = request.getParameter("year");
    		String endTime = request.getParameter("month");
    		String orgId = request.getParameter("orgId");
    		String pageNo = request.getParameter("pageNo");
    		String pageSize = request.getParameter("pageSize");
    		StatsPlatResultModel info = new StatsPlatResultModel(startTime, endTime, orgId);
    		info.setPageNo(Integer.parseInt(pageNo));
    		info.setPageSize(Integer.parseInt(pageSize));
    		PageModel page = new PageModel(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
    		
    		statisService.getExamApplyList(info, page);
			return jsonResult(page);
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description:  获取标本量charts柱状图数据
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getSampleBarCharts")
    public JsonResult getSampleBarCharts(){
    	try {
    		String startTime = request.getParameter("year");
    		String endTime = request.getParameter("month");
    		String orgId = request.getParameter("orgId");
    		StatsPlatResultModel info = new StatsPlatResultModel(startTime, endTime, orgId);
    		
			return jsonResult(statisService.getSampleBarCharts(info));
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description:  获取标本量charts饼状图数据
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getSamplePieCharts")
    public JsonResult getSamplePieCharts(){
    	try {
    		String startTime = request.getParameter("year");
    		String endTime = request.getParameter("month");
    		String orgId = request.getParameter("orgId");
    		StatsPlatResultModel info = new StatsPlatResultModel(startTime, endTime, orgId);
    		
			return jsonResult(statisService.getSamplePieCharts(info));
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description:  获取检验申请charts折线图数据
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getSampleLineCharts")
    public JsonResult getSampleLineCharts(){
    	try {
    		String startTime = request.getParameter("year");
    		String endTime = request.getParameter("month");
    		String orgId = request.getParameter("orgId");
    		StatsPlatResultModel info = new StatsPlatResultModel(startTime, endTime, orgId);
    		
			return jsonResult(statisService.getSampleLineCharts(info));
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 获取检验数据charts数据
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getExamDataLineCharts")
    public JsonResult getExamDataLineCharts(){
    	try {
    		String startTime = request.getParameter("startTime");
    		String endTime = request.getParameter("endTime");
    		String orgId = request.getParameter("orgId");
    		String itemGroupName = request.getParameter("itemGroupName");
    		StatsPlatResultModel info = new StatsPlatResultModel(startTime, endTime, orgId, itemGroupName);
    		
			return jsonResult(statisService.getExamDataLineCharts(info));
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 获取检验数据的列表
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getExamDataList")
    public JsonResult getExamDataList(){
    	try {
    		String startTime = request.getParameter("startTime");
    		String endTime = request.getParameter("endTime");
    		String orgId = request.getParameter("orgId");
    		String itemGroupName = request.getParameter("itemGroupName");
    		String pageNo = request.getParameter("pageNo");
    		String pageSize = request.getParameter("pageSize");
    		StatsPlatResultModel info = new StatsPlatResultModel(startTime, endTime, orgId, itemGroupName);
    		info.setPageNo(Integer.parseInt(pageNo));
    		info.setPageSize(Integer.parseInt(pageSize));
    		PageModel page = new PageModel(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
    		
    		statisService.getExamDataList(info, page);
			return jsonResult(page);
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 获取检验组别统计（大屏）
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getItemGroupStatis")
	public JsonResult getItemGroupStatis() {
		try {
			String orgId = request.getParameter("orgId");
			return jsonResult(statisService.getItemGroupStatis(orgId));
		}catch(Exception e) {
			e.printStackTrace();
			return jsonResult(null, -1, "系统错误");
		}
	}
	
	/**
	 * @Description: 获取年度检验组别统计（大屏）
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getCurYearItemGroupStatis")
	public JsonResult getCurYearItemGroupStatis() {
		try {
			String orgId = request.getParameter("orgId");
			return jsonResult(statisService.getCurYearItemGroupStatis(orgId));
		}catch(Exception e) {
			e.printStackTrace();
			return jsonResult(null, -1, "系统错误");
		}
	}
	
	/**
	 * @Description: 获取往年同期年度检验组别统计（大屏）
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getBefYearItemGroupStatis")
	public JsonResult getBefYearItemGroupStatis() {
		try {
			String orgId = request.getParameter("orgId");
			return jsonResult(statisService.getBefYearItemGroupStatis(orgId));
		}catch(Exception e) {
			e.printStackTrace();
			return jsonResult(null, -1, "系统错误");
		}
	}
	
	/**
	 * @Description: 获取各医院本月标本量统计（大屏）
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getMonthSampleNumStatis")
	public JsonResult getMonthSampleNumStatis() {
		try {
			String orgId = request.getParameter("orgId");
			return jsonResult(statisService.getMonthSampleNumStatis(orgId));
		}catch(Exception e) {
			e.printStackTrace();
			return jsonResult(null, -1, "系统错误");
		}
	}
	
	/**
	 * @Description: 获取检验结果数据分析（大屏）
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getExamResultStatis")
	public JsonResult getExamResultStatis() {
		try {
			String orgId = request.getParameter("orgId");
			return jsonResult(statisService.getExamResultStatis(orgId));
		}catch(Exception e) {
			e.printStackTrace();
			return jsonResult(null, -1, "系统错误");
		}
	}
	
	/**
	 * @Description: 获取就诊类型统计（大屏）
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getVisitTypeStatis")
	public JsonResult getVisitTypeStatis() {
		try {
			String orgId = request.getParameter("orgId");
			return jsonResult(statisService.getVisitTypeStatis(orgId));
		}catch(Exception e) {
			e.printStackTrace();
			return jsonResult(null, -1, "系统错误");
		}
	}
	/**
	 * @Description: 获取服务动态数据（大屏）
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getActionServiceData")
    public JsonResult getActionServiceData(){
    	try {
    		String orgId = request.getParameter("orgId");
			return jsonResult(statisService.getActionServiceData(orgId));
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, -1, "系统错误");
    	}
    }
	
	/**
	 * @Description: 判断项目是否已经有检验数据
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("isExamDataExist")
    public Integer isExamDataExist(){
    	try {
    		String itemCode = request.getParameter("itemCode");
    		String itemName = request.getParameter("itemName");
			return statisService.isExamDataExist(itemCode, itemName);
    	}catch(Exception e) {
    		e.printStackTrace();
    		return -1;
    	}
    }
}
