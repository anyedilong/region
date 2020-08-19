package com.region.moudles.stats.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.stats.dao.StatsMedicantDao;
import com.region.moudles.stats.dto.ResultMoneyModel;
import com.region.moudles.stats.dto.StatsPlatResultModel;
import com.region.moudles.stats.dto.StatsResultModel;
import com.region.moudles.stats.service.StatsMedicantService;
import com.region.until.StringUntil;

@Service("statsMedicantService")
public class StatsMedicantServiceImpl implements StatsMedicantService {

	@Inject
	private StatsMedicantDao medicantDao;
	
	/**
	 * 	获取医疗菜单中医疗收入统计住院、门诊、检查（echarts）
	 */
	@Override
	public Map<String, Object> getYLChargeStats(StatsPlatResultModel info)throws Exception {
		
		Map<String, Object> resultMap = new HashMap<>();
		//记录总收入
		List<ResultMoneyModel> sumList = new ArrayList<>();
		//x轴
		List<String> xList = new ArrayList<>();
		//住院
		List<Object> y1List = new ArrayList<>();
		//门诊
		List<Object> y2List = new ArrayList<>();
		//检验检查
		List<Object> y3List = new ArrayList<>();
		//手术
		List<Object> y4List = new ArrayList<>();
		//医疗总收入
		List<Object> y5List = new ArrayList<>();
		
		this.converDateInfo(info);
		//医疗收入
		List<ResultMoneyModel> ylList = medicantDao.getYLCharges(info);
		
		for(int i = 0; i < ylList.size(); i++) {
			if(ylList.size() == (i+2)) {
				//总计
				ResultMoneyModel zy = new ResultMoneyModel();
				zy.setName("年度住院总收入");
				zy.setValue(ylList.get(i).getValue());
				zy.setValue1(ylList.get(i+1).getValue());
				sumList.add(zy);
				ResultMoneyModel mz = new ResultMoneyModel();
				mz.setName("年度门诊总收入");
				mz.setValue(ylList.get(i).getValue1());
				mz.setValue1(ylList.get(i+1).getValue1());
				sumList.add(mz);
				ResultMoneyModel jc = new ResultMoneyModel();
				jc.setName("年度检验检查总收入");
				jc.setValue(ylList.get(i).getValue2());
				jc.setValue1(ylList.get(i+1).getValue2());
				sumList.add(jc);
				ResultMoneyModel ss = new ResultMoneyModel();
				ss.setName("手术总收入");
				ss.setValue(ylList.get(i).getValue3());
				ss.setValue1(ylList.get(i+1).getValue3());
				sumList.add(ss);
				break;
			}else {
				xList.add(Integer.parseInt(ylList.get(i).getName())+"月");
				y1List.add(ylList.get(i).getValue());
				y2List.add(ylList.get(i).getValue1());
				y3List.add(ylList.get(i).getValue2());
				y4List.add(ylList.get(i).getValue3());
				y5List.add(ylList.get(i).getValue()+ylList.get(i).getValue1());
			}
		}
		StatsResultModel resultModel = new StatsResultModel();
		resultModel.setxList(xList);
		resultModel.setY1List(y1List);
		resultModel.setY2List(y2List);
		resultModel.setY3List(y3List);
		resultModel.setY4List(y4List);
		resultModel.setY5List(y5List);
		
		resultMap.put("summary", sumList);
		resultMap.put("charts", resultModel);
		return resultMap;
	}
	
	/**
	 * 	 获取机构的处方项类别的收入统计
	 */
	@Override
	public void getJGLBSRCharges(StatsPlatResultModel info, PageModel page)throws Exception {
		info.setPageNo(page.getPageNo());
		info.setPageSize(page.getPageSize());
		this.converDateInfo(info);
		medicantDao.getJGLBSRCharges(info, page);
	}
	
	/**
	 * 	 获取医疗菜单中区域总收入统计（echarts）
	 */
	@Override
	public Object getQXYLChargeStats(String incomeType, String orgCode)throws Exception {
		
		List<ResultMoneyModel> list = medicantDao.getQXYLChargeStats(incomeType, orgCode);
		
		if(list != null && list.size() > 0) {
			for(ResultMoneyModel info : list) {
				String name = info.getName().replaceAll("卫健局", "").replaceAll("云南省", "").replaceAll("曲靖市", "").replaceAll("街道办事处", "");
				info.setName(name);
			}
			//list中数据降序排列
			list.sort(new Comparator<ResultMoneyModel>() {
				@Override
				public int compare(ResultMoneyModel o1, ResultMoneyModel o2) {
					return (int) (o2.getValue() - o1.getValue());
				}
			});
		}
		return list;
	}
	
	/**
	 * 	获取某个地方各处方项类别的收入占比（echarts）
	 */
	@Override
	public Object getYLItemTypeStats(StatsPlatResultModel info)throws Exception {
		this.converDateInfo(info);
		return medicantDao.getYLItemTypeStats(info);
	}
	
	/**
	 * 	 获取医疗菜单中各处方项类别的收入（echarts）
	 */
	@Override
	public Map<String, Object> getYLItemChargeStats(StatsPlatResultModel info)throws Exception {
		
		this.converDateInfo(info);
		Map<String, Object> map = new HashMap<>();
		List<ResultMoneyModel> list = medicantDao.getYLItemChargeStats(info);
		//0105为医疗总收入，是0101住院和0102门诊的和
		if("0105".equals(info.getIncomeType()) || "0101".equals(info.getIncomeType()) || "0102".equals(info.getIncomeType())) {
			//住院和门诊时，处方项类别为11个
			List<Object> y1List = new ArrayList<>(); 
			List<Object> y2List = new ArrayList<>(); 
			List<Object> y3List = new ArrayList<>(); 
			List<Object> y4List = new ArrayList<>(); 
			List<Object> y5List = new ArrayList<>(); 
			List<Object> y6List = new ArrayList<>(); 
			List<Object> y7List = new ArrayList<>(); 
			List<Object> y8List = new ArrayList<>(); 
			List<Object> y9List = new ArrayList<>(); 
			List<Object> y10List = new ArrayList<>(); 
			for(ResultMoneyModel model : list) {
				y1List.add(model.getValue());
				y2List.add(model.getValue1());
				y3List.add(model.getValue2());
				y4List.add(model.getValue3());
				y5List.add(model.getValue4());
				y6List.add(model.getValue5());
				y7List.add(model.getValue6());
				y8List.add(model.getValue7());
				y9List.add(model.getValue8());
				y10List.add(model.getValue9());
			}
			map.put("y1List", y1List);
			map.put("y2List", y2List);
			map.put("y3List", y3List);
			map.put("y4List", y4List);
			map.put("y5List", y5List);
			map.put("y6List", y6List);
			map.put("y7List", y7List);
			map.put("y8List", y8List);
			map.put("y9List", y9List);
			map.put("y10List", y10List);
		}else {
			//检查、手术
			List<Object> y1List = new ArrayList<>(); 
			for(ResultMoneyModel model : list) {
				y1List.add(model.getValue());
			}
			map.put("y1List", y1List);
		}
		return map;
	}
	
	/**
	 * 	 获取机构的处方项类别的收入统计
	 */
	@Override
	public void getJGITSRCharges(StatsPlatResultModel info, PageModel page)throws Exception {
		info.setPageNo(page.getPageNo());
		info.setPageSize(page.getPageSize());
		this.converDateInfo(info);
		medicantDao.getJGITSRCharges(info, page);
	}
	
	/**
	 * 	 获取机构的处方项类别的各月份收入统计
	 */
	@Override
	public StatsResultModel getYLMonthItemChargeStats(StatsPlatResultModel info)throws Exception {
		
		this.converDateInfo(info);
		//x轴
		List<String> xList = new ArrayList<>();
		//处方项类别
		List<Object> y1List = new ArrayList<>();
		
		List<ResultMoneyModel> list = medicantDao.getYLItemChargeStats(info);
		
		if(list != null && list.size() > 0) {
			for(ResultMoneyModel resutlModel : list) {
				xList.add(Integer.parseInt(resutlModel.getName())+"月");
				y1List.add(resutlModel.getValue());
			}
		}
		
		StatsResultModel resultModel = new StatsResultModel();
		resultModel.setxList(xList);
		resultModel.setY1List(y1List);
		return resultModel;
	}
	
	/**
	 * 	获取各处方项类别的收入占比（echarts）
	 */
	@Override
	public Object getYLMonthItemPropStats(StatsPlatResultModel info)throws Exception {
		
		this.converDateInfo(info);
		List<ResultMoneyModel> list = medicantDao.getYLMonthItemPropStats(info);
		return list;
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
			if(info.getEndTime().length() > 4) {
				//当截止时间有的话，查询当前月的数据
				String endTime = info.getEndTime().substring(0, 4) + "-" + info.getEndTime().substring(4);
				info.setStartTime(endTime);
				info.setEndTime(endTime);
			}else {
				if(year.equals(info.getEndTime())) {
					info.setStartTime(year+"-01");
					info.setEndTime(dateStr);
				}else {
					info.setStartTime(info.getEndTime()+"-01");
					info.setEndTime(info.getEndTime()+"-12");
				}
			}
		}
	}

}
