package com.region.moudles.tripartdock.statis.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.stats.dto.ResultModel;
import com.region.moudles.stats.dto.StatsPlatResultModel;
import com.region.moudles.tripartdock.statis.dao.StatisDao;
import com.region.moudles.tripartdock.statis.dto.StatisJcDto;
import com.region.moudles.tripartdock.statis.service.StatisService;
import com.region.until.StringUntil;

@Service("statisService")
public class StatisServiceImpl implements StatisService {

	@Inject
	private StatisDao statisDao;

	@Override
	public Map<String, Object> getOrgWorkCharts(StatsPlatResultModel info) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		fillStatsResultModel(info, "1");
		List<StatisJcDto> list = statisDao.getOrgWorkCharts(info);
		//存储饼状图数据
		List<StatisJcDto> pie = new ArrayList<>();
		//存储柱状图数据
		Map<String, Object> barMap = new HashMap<>();
		if(list != null && list.size() > 0) {
			pie.addAll(list);
			List<String> barX = new ArrayList<>();
			List<String> barY = new ArrayList<>();
			for(StatisJcDto rm : list) {
				String name = rm.getName();
				name = name.replace("云南省", "").replace("曲靖市", "").replace("马龙区", "").replace("街道办事处", "");
				barX.add(name);
				barY.add(rm.getValue());
			}
			barMap.put("barX", barX);
			barMap.put("barY", barY);
		}
		resultMap.put("pie", pie);
		resultMap.put("bar", barMap);
		return resultMap;
	}

	@Override
	public void getOrgWorkList(StatsPlatResultModel info, PageModel page) throws Exception {
		fillStatsResultModel(info, "1");
		statisDao.getOrgWorkList(info, page);
	}

	@Override
	public Map<String, Object> getItemGroupCharts(StatsPlatResultModel info) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		fillStatsResultModel(info, "1");
		List<StatisJcDto> list = statisDao.getItemGroupCharts(info);
		//存储饼状图数据
		List<StatisJcDto> pie = new ArrayList<>();
		//存储柱状图数据
		Map<String, Object> barMap = new HashMap<>();
		if(list != null && list.size() > 0) {
			pie.addAll(list);
			List<String> barX = new ArrayList<>();
			List<String> barY = new ArrayList<>();
			for(StatisJcDto rm : list) {
				barX.add(rm.getName());
				barY.add(rm.getValue());
			}
			barMap.put("barX", barX);
			barMap.put("barY", barY);
		}
		resultMap.put("pie", pie);
		resultMap.put("bar", barMap);
		return resultMap;
	}

	@Override
	public void getItemGroupList(StatsPlatResultModel info, PageModel page) throws Exception {
		fillStatsResultModel(info, "1");
		statisDao.getItemGroupList(info, page);
	}
	
	@Override
	public Map<String, Object> getExamApplyBarCharts(StatsPlatResultModel info) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		//处理日期类型
		fillStatsResultModel(info, "2");
		//说明要查询的日期大于当前日期
		if(StringUntil.isNull(info.getStartTime())) {
			return resultMap;
		}
		List<String> barX = new ArrayList<>();
		List<String> barY = new ArrayList<>();
		//查询数据
		List<StatisJcDto> list = statisDao.getExamApplyBarCharts(info);
		if(list != null && list.size() > 0) {
			for(StatisJcDto rm : list) {
				if("0".equals(info.getMonth())) {
					//x轴为月份
					barX.add(Integer.parseInt(rm.getName())+"月");
				}else {
					//x轴为天
					barX.add(rm.getName());
				}
				barY.add(rm.getValue());
			}
		}
		resultMap.put("barX", barX);
		resultMap.put("barY", barY);
		return resultMap;
	}

	@Override
	public List<StatisJcDto> getExamApplyPieCharts(StatsPlatResultModel info) throws Exception {
		//处理日期类型
		fillStatsResultModel(info, "2");
		//说明要查询的日期大于当前日期
		if(StringUntil.isNull(info.getStartTime())) {
			return new ArrayList<>();
		}
		//为使日期格式为yyyy-MM-dd统一
		if("0".equals(info.getMonth())) {
			info.setStartTime(info.getStartTime()+"-01");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			info.setEndTime(info.getEndTime()+"-"+getDaysOfMonth(sdf.parse(info.getEndTime())));
		}
		List<StatisJcDto> pie = statisDao.getExamApplyPieCharts(info);
		if(pie == null || pie.size() == 0) {
			pie = new ArrayList<>();
		}
		return pie;
	}

	@Override
	public void getExamApplyList(StatsPlatResultModel info, PageModel page) throws Exception {
		//处理日期类型
		fillStatsResultModel(info, "2");
		//为使日期格式为yyyy-MM-dd统一
		if("0".equals(info.getMonth())) {
			info.setStartTime(info.getStartTime()+"-01");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			info.setEndTime(info.getEndTime()+"-"+getDaysOfMonth(sdf.parse(info.getEndTime())));
		}
		//说明要查询的日期小于当前日期
		if(!StringUntil.isNull(info.getStartTime())) {
			statisDao.getOrgWorkList(info, page);
		}
	}
	
	@Override
	public Map<String, Object> getSampleBarCharts(StatsPlatResultModel info) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		//处理日期类型
		fillStatsResultModel(info, "2");
		//说明要查询的日期大于当前日期
		if(StringUntil.isNull(info.getStartTime())) {
			return resultMap;
		}
		List<String> barX = new ArrayList<>();
		List<String> barY = new ArrayList<>();
		//查询数据
		List<StatisJcDto> list = statisDao.getSampleBarCharts(info);
		if(list != null && list.size() > 0) {
			for(StatisJcDto rm : list) {
				if("0".equals(info.getMonth())) {
					//x轴为月份
					barX.add(Integer.parseInt(rm.getName())+"月");
				}else {
					//x轴为天
					barX.add(rm.getName());
				}
				barY.add(rm.getValue());
			}
		}
		resultMap.put("barX", barX);
		resultMap.put("barY", barY);
		return resultMap;
	}

	@Override
	public List<StatisJcDto> getSamplePieCharts(StatsPlatResultModel info) throws Exception {
		//处理日期类型
		fillStatsResultModel(info, "2");
		//说明要查询的日期大于当前日期
		if(StringUntil.isNull(info.getStartTime())) {
			return new ArrayList<>();
		}
		//为使日期格式为yyyy-MM-dd统一
		if("0".equals(info.getMonth())) {
			info.setStartTime(info.getStartTime()+"-01");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			info.setEndTime(info.getEndTime()+"-"+getDaysOfMonth(sdf.parse(info.getEndTime())));
		}
		List<StatisJcDto> pie = statisDao.getSamplePieCharts(info);
		if(pie == null || pie.size() == 0) {
			pie = new ArrayList<>();
		}
		return pie;
	}
	
	@Override
	public Map<String, Object> getSampleLineCharts(StatsPlatResultModel info) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		//处理日期类型
		fillStatsResultModel(info, "2");
		//说明要查询的日期大于当前日期
		if(StringUntil.isNull(info.getStartTime())) {
			return resultMap;
		}
		List<String> lineX = new ArrayList<>();
		List<String> jzY = new ArrayList<>();
		List<String> mzY = new ArrayList<>();
		List<String> zyY = new ArrayList<>();
		//查询数据
		List<StatisJcDto> list = statisDao.getSampleLineCharts(info);
		if(list != null && list.size() > 0) {
			for(StatisJcDto rm : list) {
				if("0".equals(info.getMonth())) {
					//x轴为月份
					lineX.add(Integer.parseInt(rm.getName())+"月");
				}else {
					//x轴为天
					lineX.add(rm.getName());
				}
				jzY.add(rm.getValue());
				mzY.add(rm.getValue1());
				zyY.add(rm.getValue2());
			}
		}
		resultMap.put("lineX", lineX);
		resultMap.put("jzY", jzY);
		resultMap.put("mzY", mzY);
		resultMap.put("zyY", zyY);
		return resultMap;
	}
	
	@Override
	public Map<String, Object> getExamDataLineCharts(StatsPlatResultModel info) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		fillStatsResultModel(info, "1");
		List<StatisJcDto> list = statisDao.getExamDataLineCharts(info);
		List<String> lineX = new ArrayList<>();
		List<String> lineY1 = new ArrayList<>();
		List<String> lineY2 = new ArrayList<>();
		if(list != null && list.size() > 0) {
			for(StatisJcDto rm : list) {
				String name = rm.getName();
				name = name.replace("云南省", "").replace("曲靖市", "").replace("马龙区", "").replace("街道办事处", "");
				lineX.add(name);
				lineY1.add(rm.getValue());
				lineY2.add(rm.getValue1());
			}
		}
		resultMap.put("lineX", lineX);
		resultMap.put("lineY1", lineY1);
		resultMap.put("lineY2", lineY2);
		return resultMap;
	}

	@Override
	public void getExamDataList(StatsPlatResultModel info, PageModel page) throws Exception {
		fillStatsResultModel(info, "1");
		statisDao.getExamDataList(info, page);
	}
	
	private void fillStatsResultModel(StatsPlatResultModel info, String type) throws Exception {
		if("1".equals(type)) {
			//机构工作量和项目组别类型统计的日期为空时自动设置
			if(StringUntil.isNull(info.getStartTime()) && "1".equals(type)) {
				info.setStartTime("1970-01-01");
			}
			if(StringUntil.isNull(info.getEndTime()) && "1".equals(type)) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				info.setEndTime(sdf.format(new Date()));
			}
		}else if("2".equals(type)) {
			//检验申请统计的日期为空时自动设置
			String year = info.getStartTime();
			String month = info.getEndTime();
			info.setMonth(month);
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM");
			SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
			if(StringUntil.isNull(year) && StringUntil.isNull(month)) {
				//默认为本年的
				info.setStartTime(sdf1.format(new Date())+"-01");
				info.setEndTime(sdf2.format(new Date()));
				info.setMonth("0");
			}else {
				String currYear = sdf1.format(new Date());
				String currDate = sdf2.format(new Date());
				if("0".equals(month)) {
					//0：表示为全年，x轴为月份
					if(currYear.equals(year)) {
						//表示本年的
						info.setStartTime(sdf1.format(new Date())+"-01");
						info.setEndTime(sdf2.format(new Date()));
					}else if(Integer.parseInt(currYear) >= Integer.parseInt(year)){
						//表示以前的
						info.setStartTime(year+"-01");
						info.setEndTime(year+"-12");
					}else {
						//表示大于当前日期
						info.setStartTime(null);
						info.setEndTime(sdf2.format(null));
					}
				}else {
					//表示为整月，x轴为天
					if(currDate.equals(year+"-"+month)) {
						//表示本年的
						info.setStartTime(sdf2.format(new Date())+"-01");
						info.setEndTime(sdf3.format(new Date()));
					}else if(Integer.parseInt(currYear) >= Integer.parseInt(year)){
						//表示以前的
						info.setStartTime(year+"-"+month+"-01");
						info.setEndTime(year+"-"+month+"-"+getDaysOfMonth(sdf2.parse(year+"-"+month)));
					}else {
						//表示大于当前日期
						info.setStartTime(null);
						info.setEndTime(null);
					}
				}
			}
		}
	}
	
	@Override
	public Map<String, Object> getItemGroupStatis(String orgId) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		List<ResultModel> list = statisDao.getCommonExamStatis("", "", orgId, "01");
		int sumNum = 0;
		if(list != null && list.size() > 0) {
			for(ResultModel info : list) {
				sumNum += info.getValue();
			}
			//根据总数求各组别的占比
			for(ResultModel info : list) {
				info.setProp((info.getValue()*100/sumNum)+"%");
			}
		}else {
			list = new ArrayList<>();
		}
		//显示总数量
		resultMap.put("sumNum", sumNum);
		resultMap.put("list", list);
		return resultMap;
	}

	@Override
	public Map<String, Object> getCurYearItemGroupStatis(String orgId) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		List<String> xList = new ArrayList<>();
		List<Integer> y1List = new ArrayList<>();
		List<Integer> y2List = new ArrayList<>();
		List<Integer> y3List = new ArrayList<>();
		List<Integer> y4List = new ArrayList<>();
		List<Integer> y5List = new ArrayList<>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM");
		//获取当年的一月到当前月份
		String startDate = sdf.format(new Date())+"-01";
		String endDate = sdf1.format(new Date());
		
		List<ResultModel> list = statisDao.getCommonExamStatis(startDate, endDate, orgId, "02");
		if(list != null && list.size() > 0) {
			for(ResultModel info : list) {
				xList.add(info.getName());
				y1List.add(info.getValue());
				y2List.add(info.getValue1());
				y3List.add(info.getValue2());
				y4List.add(info.getValue3());
				y5List.add(info.getValue4());
			}
		}else {
			list = new ArrayList<>();
		}
		resultMap.put("xList", xList);
		resultMap.put("y1List", y1List);
		resultMap.put("y2List", y2List);
		resultMap.put("y3List", y3List);
		resultMap.put("y4List", y4List);
		resultMap.put("y5List", y5List);
		return resultMap;
	}

	@Override
	public Map<String, Object> getBefYearItemGroupStatis(String orgId) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		List<String> xList = new ArrayList<>();
		List<Integer> y1List = new ArrayList<>();
		List<Integer> y2List = new ArrayList<>();
		List<Integer> y3List = new ArrayList<>();
		List<Integer> y4List = new ArrayList<>();
		List<Integer> y5List = new ArrayList<>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		//获取以前年份的统计数据， 最多为五年前的
		String startDate = sdf.format(new Date());
		List<ResultModel> list = statisDao.getCommonExamStatis(startDate, startDate, orgId, "03");
		if(list != null && list.size() > 0) {
			for(ResultModel info : list) {
				if(info.getValue() != 0 || info.getValue1() != 0 || info.getValue2() != 0 
						|| info.getValue3() != 0 || info.getValue4() != 0 || !xList.isEmpty())
					xList.add(info.getName());
				if(xList.size() > 0) {
					y1List.add(info.getValue());
					y2List.add(info.getValue1());
					y3List.add(info.getValue2());
					y4List.add(info.getValue3());
					y5List.add(info.getValue4());
				}
			}
		}else {
			list = new ArrayList<>();
		}
		resultMap.put("xList", xList);
		resultMap.put("y1List", y1List);
		resultMap.put("y2List", y2List);
		resultMap.put("y3List", y3List);
		resultMap.put("y4List", y4List);
		resultMap.put("y5List", y5List);
		return resultMap;
	}

	@Override
	public List<ResultModel> getMonthSampleNumStatis(String orgId) throws Exception {
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM");
		//获取当前月份
		String startDate = sdf1.format(new Date());
		List<ResultModel> list = statisDao.getCommonExamStatis(startDate, startDate, orgId, "04");
		if(list == null || list.size() == 0) {
			list = new ArrayList<>();
		}else {
			for(ResultModel rm : list) {
				String name = rm.getName();
				name = name.replace("云南省曲靖市马龙区", "").replace("云南省", "").replace("曲靖市", "").replace("街道办事处", "");
				rm.setName(name);
			}
		}
		return list;
	}

	@Override
	public Map<String, Object> getExamResultStatis(String orgCode) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		List<String> xList = new ArrayList<>();
		List<Integer> y1List = new ArrayList<>();
		List<Integer> y2List = new ArrayList<>();
		
		List<ResultModel> list = statisDao.getCommonExamStatis("", "", orgCode, "05");
		if(list != null && list.size() > 0) {
			for(ResultModel info : list) {
				xList.add(info.getName());
				y1List.add(info.getValue());
				y2List.add(info.getValue1());
			}
		}else {
			list = new ArrayList<>();
		}
		resultMap.put("xList", xList);
		resultMap.put("y1List", y1List);
		resultMap.put("y2List", y2List);
		return resultMap;
	}

	@Override
	public Map<String, Object> getVisitTypeStatis(String orgId) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		List<String> xList = new ArrayList<>();
		List<ResultModel> y1List = new ArrayList<>();
		List<ResultModel> y2List = new ArrayList<>();
		List<ResultModel> y3List = new ArrayList<>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM");
		String startDate = sdf.format(new Date())+"-01";
		String endDate = sdf1.format(new Date());
		List<ResultModel> list = statisDao.getCommonExamStatis(startDate, endDate, orgId, "06");
		int outNum = 0;
		int hospNum = 0;
		int jzNum = 0;
		if(list != null && list.size() > 0) {
			for(ResultModel info : list) {
				String name = info.getName();
				name = name.replace("云南省", "").replace("曲靖市", "").replace("云南省曲靖市马龙区", "").replace("街道办事处", "");
				xList.add(name);
				ResultModel model1 = new ResultModel(name, info.getValue(), info.getOrgCode(), info.getOrgId(), info.getOrgLevel());
				y1List.add(model1);
				ResultModel model2 = new ResultModel(name, info.getValue1(), info.getOrgCode(), info.getOrgId(), info.getOrgLevel());
				y2List.add(model2);
				ResultModel model3 = new ResultModel(name, info.getValue2(), info.getOrgCode(), info.getOrgId(), info.getOrgLevel());
				y3List.add(model3);
				outNum += info.getValue();
				hospNum += info.getValue1();
				jzNum += info.getValue2();
			}
		}else {
			list = new ArrayList<>();
		}
		//地图数据
		Map<String, Object> mapMap = new HashMap<>();
		mapMap.put("xList", xList);
		mapMap.put("y1List", y1List);
		mapMap.put("y2List", y2List);
		mapMap.put("y3List", y3List);
		//饼状图数据
		List<ResultModel> pieList = new ArrayList<>();
		ResultModel rm1 = new ResultModel("门诊检验", outNum);
		ResultModel rm2 = new ResultModel("住院检验", hospNum);
		ResultModel rm3 = new ResultModel("急诊检验", jzNum);
		pieList.add(rm1);
		pieList.add(rm2);
		pieList.add(rm3);
		//柱状图数据
		Map<String, Object> barMap = new HashMap<>();
		List<String> xBarList = Arrays.asList("门诊,住院,急诊".split(","));
		List<Integer> yBarList = new ArrayList<>();
		yBarList.add(outNum);
		yBarList.add(hospNum);
		yBarList.add(jzNum);
		barMap.put("xBarList", xBarList);
		barMap.put("yBarList", yBarList);
		
		resultMap.put("mapMap", mapMap);
		resultMap.put("pieMap", pieList);
		resultMap.put("barMap", barMap);
		return resultMap;
	}

	@Override
	public List<String> getActionServiceData(String orgId) throws Exception {
		List<String> list = new ArrayList<>();
		List<ResultModel> queryList = statisDao.getCommonExamStatis("", "", orgId, "07");
		for(ResultModel info : queryList) {
			list.add(info.getName());
		}
		return list;
	}
	
	//求当前月份有多少天
	public static int getDaysOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

	@Override
	public Integer isExamDataExist(String itemCode, String itemName) throws Exception {
		return statisDao.isExamDataExist(itemCode, itemName);
	}

}
