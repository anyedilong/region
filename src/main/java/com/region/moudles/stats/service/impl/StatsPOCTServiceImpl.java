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
import com.region.moudles.stats.dao.StatsPOCTDao;
import com.region.moudles.stats.dto.ResultModel;
import com.region.moudles.stats.dto.StatsPlatResultModel;
import com.region.moudles.stats.dto.StatsResultModel;
import com.region.moudles.stats.service.StatsPOCTService;
import com.region.until.StringUntil;

@Service("statsPOCTServiceImpl")
public class StatsPOCTServiceImpl implements StatsPOCTService {

	@Inject
	private StatsPOCTDao poctDao;
	
	/**
	 * 	 获取核酸检验统计菜单中检验人次、结果呈阳性、结果呈阴性（echarts）
	 */
	@Override
	public Map<String, Object> getNucleinCheckStats(StatsPlatResultModel info)throws Exception {
		
		Map<String, Object> resultMap = new HashMap<>();
		//核酸检验统计
		List<ResultModel> sumList = new ArrayList<>();
		//x轴
		List<String> xList = new ArrayList<>();
		//总人次
		List<Object> y1List = new ArrayList<>();
		//结果呈阴性的人次
		List<Object> y2List = new ArrayList<>();
		//结果呈阳性的人次
		List<Object> y3List = new ArrayList<>();
		
		this.converDateInfo(info);
		//核酸检验统计
		List<ResultModel> ylList = poctDao.getNucleinCheckStats(info);
		
		for(int i = 0; i < ylList.size(); i++) {
			if(ylList.size() == (i+2)) {
				//总计
				ResultModel zy = new ResultModel();
				zy.setName("核酸检验人次");
				zy.setValue(ylList.get(i).getValue());
				if(ylList.get(i).getValue() == 0) {
					zy.setValue1(0);
				}else {
					//核酸检验的人数与建档的人数占比
					Integer prop = poctDao.getNucleinCheckProp();
					zy.setValue1(prop);
				}
				sumList.add(zy);
				ResultModel mz = new ResultModel();
				mz.setName("检验结果呈阴性");
				mz.setValue(ylList.get(i).getValue1());
				if(mz.getValue() == 0) {
					mz.setValue1(0);
				}else {
					mz.setValue1(mz.getValue()*100/ylList.get(i).getValue());
				}
				sumList.add(mz);
				ResultModel jc = new ResultModel();
				jc.setName("检验结果呈阳性");
				jc.setValue(ylList.get(i).getValue2());
				if(jc.getValue() == 0) {
					jc.setValue1(0);
				}else {
					jc.setValue1(jc.getValue()*100/ylList.get(i).getValue());
				}
				sumList.add(jc);
				break;
			}else {
				xList.add(Integer.parseInt(ylList.get(i).getName())+"月");
				y1List.add(ylList.get(i).getValue());
				y2List.add(ylList.get(i).getValue1());
				y3List.add(ylList.get(i).getValue2());
			}
		}
		StatsResultModel resultModel = new StatsResultModel();
		resultModel.setxList(xList);
		resultModel.setY1List(y1List);
		resultModel.setY2List(y2List);
		resultModel.setY3List(y3List);
		
		resultMap.put("summary", sumList);
		resultMap.put("charts", resultModel);
		return resultMap;
	}
	
	/**
	 * 	 获取家庭签约的类别的统计（列表）
	 */
	@Override
	public void getJGLBTimesPage(StatsPlatResultModel info, PageModel page)throws Exception {
		info.setPageNo(page.getPageNo());
		info.setPageSize(page.getPageSize());
		this.converDateInfo(info);
		poctDao.getJGLBSRCharges(info, page);
	}
	
	/**
	 * 	获取某个地方各类别的收入占比（echarts）
	 */
	@Override
	public List<ResultModel> getJYItemPropStats(StatsPlatResultModel info)throws Exception {
		this.converDateInfo(info);
		return poctDao.getYLItemTypeStats(info);
	}
	
	/**
	 * 	获取家庭签约菜单中各类别的收入（echarts）
	 */
	@Override
	public Map<String, Object> getJYItemTimesStats(StatsPlatResultModel info)throws Exception {
		
		this.converDateInfo(info);
		Map<String, Object> map = new HashMap<>();
		List<ResultModel> list = poctDao.getYLItemChargeStats(info);
		//签约人次，履约人次、履约人数和解约人次；人群类别
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
		map.put("y10List", y10List);
		map.put("y11List", y11List);
			
		return map;
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
