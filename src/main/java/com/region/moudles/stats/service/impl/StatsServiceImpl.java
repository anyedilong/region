package com.region.moudles.stats.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.region.moudles.stats.dao.StatsDao;
import com.region.moudles.stats.dto.ResultModel;
import com.region.moudles.stats.dto.ResultMoneyModel;
import com.region.moudles.stats.dto.StatsPlatResultModel;
import com.region.moudles.stats.dto.StatsResultModel;
import com.region.moudles.stats.service.StatsService;
import com.region.until.StringUntil;

@Service("statsService")
public class StatsServiceImpl implements StatsService {

	@Inject
	private StatsDao statsDao;
	
	/**
	 * 	获取家庭医生签约人次
	 */
	@Override
	public StatsResultModel getDoctorConNum(String orgCode) throws Exception {
		
		StatsPlatResultModel param = new StatsPlatResultModel();
		converDateInfo(param);
		//type: 市区大屏 1.签约解约 2.门诊急诊 3.入院出院        卫生院大屏：4.医生签约(柱状) 5.就诊人次(柱状) 6.收入对比
		param.setIncomeType("1");
		param.setOrgCode(orgCode);
		List<ResultModel> list = statsDao.getStatsCommon(param);
		
		return this.converStatsData(list);
	}
	
	/**
	 * 	获取人群类型占比
	 */
	@Override
	public StatsResultModel getPopTypeProp(String orgCode) throws Exception {
		
		//图例
		List<String> xList = new ArrayList<>();
		//外圈
		List<Object> y1List = new ArrayList<>();
		//内圈
		List<Object> y2List = new ArrayList<>();
		
		xList =  Arrays.asList("儿童,孕产妇,老年人,慢病管理,精神病,高血压,糖尿病,冠心病,脑卒中,肺结核,新冠,残疾人".split(","));
		//获取人群类别和数量
		List<ResultModel> rqlxList = statsDao.getPopTypeProp(orgCode);
		
		//记录慢病管理的数量
		int num = 0;
		for(int i = 3; i < rqlxList.size(); i++) {
			if(rqlxList.get(i).getValue() > 0) {
				y2List.add(rqlxList.get(i));
				num += rqlxList.get(i).getValue();
			}
		}
		for(int i = 0; i < 3; i++) {
			if(rqlxList.get(i).getValue() > 0) {
				y1List.add(rqlxList.get(i));
			}
		}
		ResultModel info = new ResultModel("慢病管理", num);
		y1List.add(info);
		
		StatsResultModel resultModel = new StatsResultModel();
		resultModel.setxList(xList);
		resultModel.setY1List(y1List);
		resultModel.setY2List(y2List);
		return resultModel;
	}
	
	/**
	 * 	获取履约人数
	 */
	@Override
	public StatsResultModel getCompliantPersonsNum(String orgCode) throws Exception {
		
		//图例
		List<String> xList = new ArrayList<>();
		//外圈
		List<Object> y1List = new ArrayList<>();
		//内圈
		List<Object> y2List = new ArrayList<>();
		
		xList =  Arrays.asList("履约人数,签约人数".split(","));
		//获取履约的人数
		ResultModel record = statsDao.getRecordData(orgCode);
		//获取签约的人数
		ResultModel sign = statsDao.getSignData(orgCode);
		if(record.getValue() > 0) {
			y1List.add(record);
		}
		if(sign.getValue() > 0) {
			y1List.add(sign);
		}
		
		StatsResultModel resultModel = new StatsResultModel();
		resultModel.setxList(xList);
		resultModel.setY1List(y1List);
		resultModel.setY2List(y2List);
		return resultModel;
	}
	
	/**
	 * 	获取建档、签约、体检的人数(各区县)
	 */
	@Override
	public StatsResultModel getPopTypesSpread(String orgCode) throws Exception {
		//图例
		List<String> xList = new ArrayList<>();
		//建档
		List<Object> y1List = new ArrayList<>();
		//签约
		List<Object> y2List = new ArrayList<>();
		//体检
		List<Object> y3List = new ArrayList<>();
		//核酸检验人次
		List<Object> y4List = new ArrayList<>();
		//脱贫
		//List<Object> y5List = new ArrayList<>();
		StatsResultModel resultModel = new StatsResultModel();		
		//参数为地方的orgCode
		List<ResultModel> list = statsDao.getPopTypesSpread(orgCode);
		
		for(int i = 0; i < list.size(); i++) {
			ResultModel info = list.get(i);
			//list最后一条存储为建档、签约、体检的总人次
			if((i + 1) == list.size()) {
				resultModel.setArchiveNum(info.getValue()+"");
				resultModel.setSignNum(info.getValue1()+"");
				resultModel.setTjNum(info.getValue2()+"");
				//resultModel.setPkNum(info.getValue3()+"");
				resultModel.setNucleinNum(info.getValue4()+"");
			}else {
				String name = info.getName().replaceAll("卫健局", "").replaceAll("云南省曲靖市马龙区", "").replaceAll("街道办事处", "");
				y1List.add(new ResultModel(name, info.getValue(), info.getOrgCode()));
				y2List.add(new ResultModel(name, info.getValue1(), info.getOrgCode()));
				y3List.add(new ResultModel(name, info.getValue2(), info.getOrgCode()));
				y4List.add(new ResultModel(name, info.getValue3(), info.getOrgCode()));
				//y5List.add(new ResultModel(name, info.getValue4(), info.getOrgCode()));
			}
		}
		resultModel.setxList(xList);
		resultModel.setY1List(y1List);
		resultModel.setY2List(y2List);
		resultModel.setY3List(y3List);
		resultModel.setY4List(y4List);
		//resultModel.setY5List(y5List);
		return resultModel;
	}
	
	/**
	 * 	获取年度就诊人次统计
	 */
	@Override
	public StatsResultModel getAnnualVisits(String orgCode) throws Exception {
		
		StatsPlatResultModel param = new StatsPlatResultModel();
		converDateInfo(param);
		//type: 市区大屏 1.签约解约 2.门诊住院 3.入院出院        卫生院大屏：4.医生签约(柱状) 5.就诊人次(柱状) 6.收入对比
		param.setIncomeType("2");
		param.setOrgCode(orgCode);
		List<ResultModel> list = statsDao.getStatsCommon(param);
		
		return this.converStatsData(list);
	}
	
	/**
	 * 	获取年度入/出院人次统计
	 */
	@Override
	public StatsResultModel getInOrOutHospitalVisits(String orgCode) throws Exception {
		
		StatsPlatResultModel param = new StatsPlatResultModel();
		converDateInfo(param);
		//type: 市区大屏 1.签约解约 2.门诊急诊 3.入院出院        卫生院大屏：4.医生签约(柱状) 5.就诊人次(柱状) 6.收入对比
		param.setIncomeType("3");
		param.setOrgCode(orgCode);
		List<ResultModel> list = statsDao.getStatsCommon(param);
		
		return this.converStatsData(list);
	}
	
	/**
	 * 	获取县区医院就诊统计
	 */
	@Override
	public StatsResultModel getHospitalVisits(String orgCode, String type) throws Exception {
		
		//x轴各县区
		List<String> xList = new ArrayList<>();
		//y1轴
		List<Object> y1List = new ArrayList<>();
		//y2轴
		List<Object> y2List = new ArrayList<>();
		List<ResultModel> visits = statsDao.getHospitalVisits(orgCode, type);
		
		if(visits != null) {
			for(int i = 0; i < visits.size(); i++) {
				String name = visits.get(i).getName().replaceAll("卫健局", "").replaceAll("云南省曲靖市马龙区", "").replaceAll("街道办事处", "").replaceAll("卫生院", "");
				xList.add(name);
				y1List.add(visits.get(i).getValue());
				y2List.add(visits.get(i).getValue1());
			}
		}
		StatsResultModel resultModel = new StatsResultModel();
		resultModel.setxList(xList);
		resultModel.setY1List(y1List);
		resultModel.setY2List(y2List);
		return resultModel;
	}
	
	/**
	 * 	统计某地区的各类人数
	 */
	@Override
	public Map<String, Object> peopNumStats(String orgCode, String typeFlg) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<>();
		//卫生院大屏type 1.各类人数统计 2.随访人次 3.医生签约(饼状) 4.就诊人次(饼状) 5.年度总收入 6.医保收入 7.本月收入  8.中医院、人民医院和妇幼保健院的各类人统计
		List<ResultModel> propNums = statsDao.getWSYStatsCommon(orgCode, typeFlg);
		if("8".equals(typeFlg)) {
			resultMap.put("outpatNum", propNums.get(0).getValue());
			resultMap.put("hosptNum", propNums.get(1).getValue());
			resultMap.put("jcjyNum", propNums.get(2).getValue());
			resultMap.put("sumNum", propNums.get(3).getValue());
			resultMap.put("xyNum", propNums.get(4).getValue());
			resultMap.put("zchengyNum", propNums.get(5).getValue());
			resultMap.put("zcaoyNum", propNums.get(6).getValue());
			resultMap.put("currOwnNum", propNums.get(7).getValue());
			resultMap.put("currYbNum", propNums.get(8).getValue());
			resultMap.put("currTcNum", propNums.get(9).getValue());
			resultMap.put("nucleinNum", propNums.get(10).getValue());
		}else {
			resultMap.put("archiveNum", propNums.get(0).getValue());
			resultMap.put("signNum", propNums.get(1).getValue());
			resultMap.put("checkNum", propNums.get(2).getValue());
			resultMap.put("poorNum", propNums.get(3).getValue());
			resultMap.put("unsignNum", propNums.get(4).getValue());
			resultMap.put("outsignNum", propNums.get(5).getValue());
			resultMap.put("nucleinNum", propNums.get(6).getValue());
		}
		return resultMap;
	}
	
	/**
	 * 	获取卫生院的人群类型占比
	 */
	@Override
	public Map<String, Object> getWSYPopTypeProp(String orgCode) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<>();
		//饼状图图例
		List<String> x1List = new ArrayList<>();
		//饼状图数据
		List<Object> y1List = new ArrayList<>();
		//柱状图x轴
		List<String> x2List = new ArrayList<>();
		//柱状图y轴
		List<Object> y2List = new ArrayList<>();
		
		x1List =  Arrays.asList("儿童,孕产妇,老年人,慢病管理".split(","));
		x2List =  Arrays.asList("精神病,高血压,糖尿病,冠心病,脑卒中,肺结核,新冠,残疾人".split(","));
		//获取人群类别和数量
		List<ResultModel> rqlxList = statsDao.getPopTypeProp(orgCode);
		
		//记录慢病管理的数量
		int num = 0;
		for(int i = 3; i < rqlxList.size(); i++) {
			y2List.add(rqlxList.get(i).getValue());
			num += rqlxList.get(i).getValue();
		}
		for(int i = 0; i < 3; i++) {
			y1List.add(rqlxList.get(i));
		}
		ResultModel info = new ResultModel("慢病管理", num);
		y1List.add(info);
		
		StatsResultModel resultModel1 = new StatsResultModel();
		resultModel1.setxList(x1List);
		resultModel1.setY1List(y1List);
		StatsResultModel resultModel2 = new StatsResultModel();
		resultModel2.setxList(x2List);
		resultModel2.setY1List(y2List);
		resultMap.put("pie", resultModel1);
		resultMap.put("bar", resultModel2);
		return resultMap;
	}
	
	/**
	 * 	获取卫生院的随访人次
	 */
	@Override
	public Map<String, Object> getWSYFollowPropNum(String orgCode, String typeFlg) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<>();
		//柱状图x轴
		List<String> x1List = new ArrayList<>();
		//柱状图y轴
		List<Object> y1List = new ArrayList<>();
		//饼状图图例
		List<String> x2List = new ArrayList<>();
		//饼状图数据
		List<Object> y2List = new ArrayList<>();
		
		x1List =  Arrays.asList("儿童,孕产妇,老年人,精神病,高血压,糖尿病,冠心病,脑卒中,肺结核,残疾人".split(","));
		x2List =  Arrays.asList("失访人次,随访人次".split(","));
		//卫生院大屏type 1.各类人数统计 2.随访人次 3.医生签约(饼状) 4.就诊人次(饼状) 5.年度总收入 6.医保收入 7.本月收入
		List<ResultModel> propNums = new ArrayList<>();
		if("8".equals(typeFlg)) {
			propNums = statsDao.getWSYStatsCommon(orgCode, "201");
		}else {
			propNums = statsDao.getWSYStatsCommon(orgCode, "2");
		}
		for(int i = 0; i < propNums.size(); i++) {
			if((i+2) >= propNums.size()) {
				//if(propNums.get(i).getValue() > 0)
				y2List.add(propNums.get(i));
			}else {
				y1List.add(propNums.get(i).getValue());
			}
		}
		
		StatsResultModel resultModel1 = new StatsResultModel();
		resultModel1.setxList(x1List);
		resultModel1.setY1List(y1List);
		StatsResultModel resultModel2 = new StatsResultModel();
		resultModel2.setxList(x2List);
		resultModel2.setY1List(y2List);
		resultMap.put("bar", resultModel1);
		resultMap.put("pie", resultModel2);
		return resultMap;
	}
	
	/**
	 * 	获取卫生院的家医签约
	 */
	@Override
	public Map<String, Object> getWSYDoctorSign(String orgCode) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<>();
		List<ResultModel> pie = new ArrayList<>();
		//卫生院大屏type 1.各类人数统计 2.随访人次 3.医生签约(饼状) 4.就诊人次(饼状) 5.年度总收入 6.医保收入 7.本月收入
		List<ResultModel> signPies = statsDao.getWSYStatsCommon(orgCode, "3");
		for(ResultModel info : signPies) {
			//if(info.getValue() > 0) {
				pie.add(info);
			//}
		}
		
		StatsPlatResultModel param = new StatsPlatResultModel();
		converDateInfo(param);
		//type: 市区大屏 1.签约解约 2.门诊急诊 3.入院出院        卫生院大屏：4.医生签约(柱状) 5.就诊人次(柱状) 6.收入对比
		param.setIncomeType("4");
		param.setOrgCode(orgCode);
		List<ResultModel> signBars = statsDao.getStatsCommon(param);
		StatsResultModel bar = converStatsData(signBars);
		List<Object> y1List = new ArrayList<>();
		List<Object> y2List = new ArrayList<>();
		List<Object> y3List = new ArrayList<>();
		for(int i = 0; i < signBars.size(); i++) {
			y1List.add(signBars.get(i).getValue());
			y2List.add(signBars.get(i).getValue1());
			y3List.add(signBars.get(i).getValue2());
		}
		bar.setY1List(y1List);
		bar.setY2List(y2List);
		bar.setY3List(y3List);
		resultMap.put("pie", pie);
		resultMap.put("bar", bar);
		return resultMap;
	}
	
	/**
	 * 	获取卫生院的就诊人次
	 */
	@Override
	public Map<String, Object> getWSYHospitalNum(String orgCode) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<>();
		//卫生院大屏type 1.各类人数统计 2.随访人次 3.医生签约(饼状) 4.就诊人次(饼状) 5.年度总收入 6.医保收入 7.本月收入
		List<ResultModel> hosptialPies = statsDao.getWSYStatsCommon(orgCode, "4");
		List<ResultModel> hosptialPies1 = new ArrayList<>();
		for(ResultModel info : hosptialPies) {
			//if(info.getValue() > 0) {
				hosptialPies1.add(info);
			//}
		}
		
		StatsPlatResultModel param = new StatsPlatResultModel();
		converDateInfo(param);
		//type: 市区大屏 1.签约解约 2.门诊急诊 3.入院出院        卫生院大屏：4.医生签约(柱状) 5.就诊人次(柱状) 6.收入对比
		param.setIncomeType("5");
		param.setOrgCode(orgCode);
		List<ResultModel> hosptialBars = statsDao.getStatsCommon(param);
		StatsResultModel line = converStatsData(hosptialBars);
		
		resultMap.put("pie", hosptialPies1);
		resultMap.put("line", line);
		return resultMap;
	}
	
	/**
	 * 	获取卫生院的年度总收入、医保收入、收入对比、本月收入数据
	 */
	@Override
	public Map<String, Object> getWSYOtherData(String orgCode) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<>();
		//年度总收入x轴
		List<String> x1List = new ArrayList<>();
		//年度总收入y轴
		List<Object> y1List = new ArrayList<>();
		//收入对比x轴
		List<String> x2List = new ArrayList<>();
		//收入对比y轴
		List<Object> y2List = new ArrayList<>();
				
		//卫生院大屏type 1.各类人数统计 2.随访人次 3.医生签约(饼状) 4.就诊人次(饼状) 5.年度总收入 6.科室收入排名 7.本月收入
		//年度总收入
		List<ResultMoneyModel> sumIncomes = statsDao.getWSYStatsIncomeCommon(orgCode, "5");
		for(int i = 0; i < sumIncomes.size(); i++) {
			x1List.add(sumIncomes.get(i).getName());
			y1List.add(sumIncomes.get(i).getValue());
		}
		//科室收入排名
		List<ResultMoneyModel> medicatIncomes = statsDao.getWSYStatsIncomeCommon(orgCode, "6");
		if(medicatIncomes != null && medicatIncomes.size() > 5) {
			medicatIncomes.sort(new Comparator<ResultMoneyModel>() {
				@Override
				public int compare(ResultMoneyModel o1, ResultMoneyModel o2) {
					return (int) (o2.getValue() - o1.getValue());
				}
			});
			//默认显示前五个科室
			if(medicatIncomes.size() > 5){
				medicatIncomes = medicatIncomes.subList(0, 5);
			}
			for(int i = 0; i < medicatIncomes.size(); i++) {
				x2List.add(medicatIncomes.get(i).getName());
				y2List.add(medicatIncomes.get(i).getValue());
			}
		}
		//收入对比
		StatsPlatResultModel param = new StatsPlatResultModel();
		converDateInfo(param);
		//type: 市区大屏 1.签约解约 2.门诊急诊 3.入院出院        卫生院大屏：4.医生签约(柱状) 5.就诊人次(柱状) 6.收入对比
		param.setIncomeType("6");
		param.setOrgCode(orgCode);
		List<ResultMoneyModel> incomes = statsDao.getStatsIncomeCommon(param);
		//本月收入
		List<ResultMoneyModel> curIncome = statsDao.getWSYStatsIncomeCommon(orgCode, "7");
		List<ResultMoneyModel> curIncome1 = new ArrayList<>();
		for(ResultMoneyModel info : curIncome) {
			//if(info.getValue() > 0) {
				curIncome1.add(info);
			//}
		}
		
		StatsResultModel resultModel1 = new StatsResultModel();
		resultModel1.setxList(x1List);
		resultModel1.setY1List(y1List);
		StatsResultModel resultModel2 = new StatsResultModel();
		resultModel2.setxList(x2List);
		resultModel2.setY1List(y2List);
		resultMap.put("sumIncome", resultModel1);
		resultMap.put("medicatIncome", resultModel2);
		resultMap.put("income", converStatsIncomeData(incomes));
		resultMap.put("curIncome", curIncome1);
		return resultMap;
	}
	
	/**
	 * 	获取个别医院的药品收入、门诊次均费用和住院次均费用（人民医院、中医院和妇幼保健院）
	 */
	@Override
	public StatsResultModel getYYChargeStatsData(StatsPlatResultModel info) throws Exception {
		//TODO
		converDateInfo(info);
		List<ResultMoneyModel> incomes = statsDao.getStatsIncomeCommon(info);
		StatsResultModel statsIncomeData = converStatsIncomeData(incomes);
		return statsIncomeData;
	}
	
	
	/**
	 * 	获取服务动态数据
	 */
	@Override
	public List<String> getServiceData(String orgCode) throws Exception {
		return statsDao.getServiceData(orgCode);
	}
	
	/**
	 * 	把统计数据封装成charts数据格式
	 */
	private StatsResultModel converStatsData(List<ResultModel> list)throws Exception {
		//x轴月份
		List<String> xList = new ArrayList<>();
		//y1轴
		List<Object> y1List = new ArrayList<>();
		//y2轴
		List<Object> y2List = new ArrayList<>();
		//y3轴
		List<Object> y3List = new ArrayList<>();
		
		if(list.size() > 0) {
			for(int i = 0; i < list.size(); i++) {
				xList.add(Integer.parseInt(list.get(i).getName())+"月");
				y1List.add(list.get(i).getValue());
				y2List.add(list.get(i).getValue1());
				y3List.add(list.get(i).getValue2());
			}
		}
		StatsResultModel resultModel = new StatsResultModel();
		resultModel.setxList(xList);
		resultModel.setY1List(y1List);
		resultModel.setY2List(y2List);
		resultModel.setY3List(y3List);
		return resultModel;
	}
	
	/**
	 * 	把统计数据封装成charts数据格式
	 */
	private StatsResultModel converStatsIncomeData(List<ResultMoneyModel> list)throws Exception {
		//x轴月份
		List<String> xList = new ArrayList<>();
		//y1轴
		List<Object> y1List = new ArrayList<>();
		//y2轴
		List<Object> y2List = new ArrayList<>();
		//y3轴
		List<Object> y3List = new ArrayList<>();
		
		if(list.size() > 0) {
			for(int i = 0; i < list.size(); i++) {
				xList.add(Integer.parseInt(list.get(i).getName())+"月");
				y1List.add(list.get(i).getValue());
				y2List.add(list.get(i).getValue1());
				y3List.add(list.get(i).getValue2());
			}
		}
		StatsResultModel resultModel = new StatsResultModel();
		resultModel.setxList(xList);
		resultModel.setY1List(y1List);
		resultModel.setY2List(y2List);
		resultModel.setY3List(y3List);
		return resultModel;
	}
	
	/**
	 * 起始时间填写
	 */
	private void converDateInfo(StatsPlatResultModel info) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy");
		String dateStr = sdf.format(new Date());
		String year = dateStr.substring(0, 4);
		if(StringUntil.isNull(info.getEndTime())) {
			//起末时间都没有的，默认今年
			if(!StringUntil.isNull(info.getStartTime()) && sdf1.parse(info.getStartTime()).before(sdf1.parse(year))) {
				String temp = info.getStartTime();
				info.setStartTime(temp + "-01");
				info.setEndTime(temp+"-12");
			}else {
				info.setStartTime(year+"-01");
				info.setEndTime(dateStr);
			}
		}else {
			//当截止时间有的话，查询当前月的数据
			String endTime = info.getEndTime().substring(0, 4) + "-" + info.getEndTime().substring(4);
			info.setStartTime(endTime);
			info.setEndTime(endTime);
		}
	}

}
