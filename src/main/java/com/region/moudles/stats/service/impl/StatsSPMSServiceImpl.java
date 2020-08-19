package com.region.moudles.stats.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.stats.dao.StatsSPMSDao;
import com.region.moudles.stats.dao.StatsSPMSMoneyDao;
import com.region.moudles.stats.dto.ResultModel;
import com.region.moudles.stats.dto.ResultMoneyModel;
import com.region.moudles.stats.dto.StatsPlatResultModel;
import com.region.moudles.stats.dto.StatsResultModel;
import com.region.moudles.stats.service.StatsSPMSService;
import com.region.until.StringUntil;

@Service("statsSPMSService")
public class StatsSPMSServiceImpl implements StatsSPMSService {

	@Inject
	private StatsSPMSDao statsSPMSDao;
	@Inject
	private StatsSPMSMoneyDao statsSPMSMoneyDao;
	
	@Override
	public StatsResultModel getTQLineData(StatsPlatResultModel info) throws Exception {
		List<String> listX = new ArrayList<>();
		List<Object> listY = new ArrayList<>();
		List<Object> listY2 = new ArrayList<>();
		this.converDateInfo(info);
		//判断是否为计算收入；精确度不同
		//02.科室收入 05.药品收入
		if("02".equals(info.getIncomeType()) || "05".equals(info.getIncomeType())) {
			List<ResultMoneyModel> list = statsSPMSMoneyDao.getTQLineData(info);
			for (ResultMoneyModel resultModel : list) {
				listX.add(resultModel.getName()+"月");
				listY.add(resultModel.getValue());
				listY2.add(resultModel.getValue1());
			}
		}else {
			List<ResultModel> list = statsSPMSDao.getTQLineData(info);
			for (ResultModel resultModel : list) {
				listX.add(resultModel.getName()+"月");
				listY.add(resultModel.getValue());
				listY2.add(resultModel.getValue1());
			}
		}
		
		StatsResultModel resultModel = new StatsResultModel();
		resultModel.setxList(listX);
		resultModel.setY1List(listY);
		resultModel.setY2List(listY2);
		return resultModel;
	}

	@Override
	public Map<String,Object> getMedicantChartsData(StatsPlatResultModel mode) throws Exception  {
		Map<String,Object> resultMap = new HashMap<>();
		this.converDateInfo(mode);
		//判断是否为计算收入；精确度不同
		//0201.科室收入  0501.药品中外 0502.药品基药 0503.药品等级 
		if("0201".equals(mode.getIncomeType()) || "0501".equals(mode.getIncomeType())
				|| "0502".equals(mode.getIncomeType()) || "0503".equals(mode.getIncomeType())) {
			List<ResultMoneyModel> list = statsSPMSMoneyDao.getMedicantChartsData(mode);
			float sum = 0;
			for (ResultMoneyModel resultModel : list) {
				if(resultModel.getValue() > 0) {
					sum+=resultModel.getValue();
				}
			}
			resultMap.put("pie", list);
			resultMap.put("sum", sum);
		}else {
			List<ResultModel> list = statsSPMSDao.getMedicantChartsData(mode);
			int sum = 0;
			for (ResultModel resultModel : list) {
				if(resultModel.getValue() > 0) {
					sum+=resultModel.getValue();
				}
			}
			resultMap.put("pie", list);
			resultMap.put("sum", sum);
		}
		return resultMap;
	}

	@Override
	public void getMedicantTypePage(StatsPlatResultModel info, PageModel page) throws Exception {
		info.setPageNo(page.getPageNo());
		info.setPageSize(page.getPageSize());
		this.converDateInfo(info);
		//判断是否为计算收入；精确度不同
		//0201.科室收入  0501.药品中外 0502.药品基药 0503.药品等级 
		if("0201".equals(info.getIncomeType()) || "0501".equals(info.getIncomeType())
				|| "0502".equals(info.getIncomeType()) || "0503".equals(info.getIncomeType())) {
			statsSPMSMoneyDao.getMedicantTypePage(info, page);
		}else {
			statsSPMSDao.getMedicantTypePage(info, page);
		}
	}

	@Override
	public Map<String, Object> getMedicantTypeByMonth(StatsPlatResultModel info) throws Exception {
		this.converDateInfo(info);
		
		Map<String, Object> map = new HashMap<>();
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
		List<Object> y11List = new ArrayList<>(); 
		
		//判断是否为计算收入；精确度不同
		//0201.科室收入  0501.药品中外 0502.药品基药 0503.药品等级 
		if("0201".equals(info.getIncomeType()) || "0501".equals(info.getIncomeType())
				|| "0502".equals(info.getIncomeType()) || "0503".equals(info.getIncomeType())) {
			List<ResultMoneyModel> list = statsSPMSMoneyDao.getMedicantTypeByMonth(info);
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
				y11List.add(model.getValue10());
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
			map.put("y10List", y11List);
			map.put("y11List", y11List);
		}else {
			List<ResultModel> list = statsSPMSDao.getMedicantTypeByMonth(info);
			for(ResultModel model : list) {
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
				y11List.add(model.getValue10());
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
			map.put("y10List", y11List);
			map.put("y11List", y11List);
		}
		return map;
	}

	@Override
	public Object getMedicantTypeProp(StatsPlatResultModel info) throws Exception {
		this.converDateInfo(info);
		//判断是否为计算收入；精确度不同
		//0201.科室收入  0501.药品中外 0502.药品基药 0503.药品等级 
		if("0201".equals(info.getIncomeType()) || "0501".equals(info.getIncomeType())
				|| "0502".equals(info.getIncomeType()) || "0503".equals(info.getIncomeType())) {
			return statsSPMSMoneyDao.getMedicantTypeProp(info);
		}else {
			return statsSPMSDao.getMedicantTypeProp(info);
		}
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
