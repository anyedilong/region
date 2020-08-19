package com.region.moudles.tripartdock.statis.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.QueryDao;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.stats.dto.ResultModel;
import com.region.moudles.stats.dto.StatsPlatResultModel;
import com.region.moudles.tripartdock.statis.dto.StatisJcDto;

@Named
public class StatisDao extends QueryDao {

	/**
	 * @Description: 获取机构工作量charts数据
	 * @param @param param
	 * @return List<ResultModel>
	 */
	public List<StatisJcDto> getOrgWorkCharts(StatsPlatResultModel info) {
		StringBuffer sql = new StringBuffer();
   		sql.append(" SELECT name, value from table(stats_exam_jc_count(:startTime, :endTime, '0101', :orgId, :itemGroupName, 30, 1)) ");
		return queryList(sql.toString(), info, StatisJcDto.class);
	}
	
	/**
	 * @Description: 获取机构工作量的列表
	 * @param @param param
	 * @return List<ResultModel>
	 */
	public void getOrgWorkList(StatsPlatResultModel info, PageModel page){
		StringBuffer sql = new StringBuffer();
   		sql.append(" SELECT id, name, value, org_level from table(stats_exam_jc_count(:startTime, :endTime, '0101', :orgId, :itemGroupName, :pageSize, :pageNo)) ");
		List<StatisJcDto> list = queryList(sql.toString(), info, StatisJcDto.class);
		float sum = 0;
		if (list == null) {
			list = new ArrayList<>();
		}else {
			StringBuffer sql1 = new StringBuffer();
			sql1.append(" SELECT id, name, value, org_level from table(stats_exam_jc_count(:startTime, :endTime, '0101', :orgId, :itemGroupName, 100, 1)) ");
			List<StatisJcDto> list1 = queryList(sql1.toString(), info, StatisJcDto.class);
			for(StatisJcDto jc : list1) {
				sum += Float.parseFloat(jc.getValue());
			}
		}
		for(StatisJcDto jc : list) {
			if(Float.parseFloat(jc.getValue()) == 0 || sum == 0) {
				jc.setRatio("0.00%");
			}else {
				String ratio = String.format("%.2f",(Float.parseFloat(jc.getValue())*100)/sum);
				jc.setRatio(ratio+"%");
			}
		}
		// 查询不分页时的总数量
		String sql_1 = "select o.id from sys_org o where o.parent_id = :orgId and o.status = '1'";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("orgId", info.getOrgId());
		long count = queryCount(sql_1, paramMap);
		page.setCount(count);
		page.setList(list);
	}
	
	/**
	 * @Description: 获取项目组别charts数据
	 * @param @param param
	 * @return List<ResultModel>
	 */
	public List<StatisJcDto> getItemGroupCharts(StatsPlatResultModel info) {
		StringBuffer sql = new StringBuffer();
   		sql.append(" select t.text as name, count(t.id) as value  ");
   		sql.append(" from ((select ds.text, s.id ");
   		sql.append(" 	from sys_dict_sub ds  ");
   		sql.append("    left join (select distinct j.medical_record_id as id, j.item_type, j.diagnosis_time ");
   		sql.append("  		from outpatient_jcz j	");
   		sql.append("  		join medical_record m on m.id = j.medical_record_id ");
   		sql.append("  		join sys_org o on m.org_code like concat(o.org_code, '%') and o.id = :orgId ");
   		sql.append("  		where j.diagnosis_time between to_date(:startTime, 'yyyy-MM-dd') and to_date(:endTime, 'yyyy-MM-dd')");
   		sql.append("  	union all");
   		sql.append("  		select distinct j.hospital_id as id, j.item_type, j.diagnosis_time ");
   		sql.append("  		from hospital_jcz j ");
   		sql.append("  		join hospital_infto m on m.id = j.hospital_id ");
   		sql.append("  		join sys_org o on m.org_code like concat(o.org_code, '%') and o.id = :orgId ");
   		sql.append("  		where j.diagnosis_time between to_date(:startTime, 'yyyy-MM-dd') and to_date(:endTime, 'yyyy-MM-dd')");
   		sql.append("  	) s on ds.text like concat(s.item_type, '%') ");
   		sql.append("  where ds.dict_id = 'f2e195be6a0f4b5482ef95d45ade24ff' ) ");
   		sql.append("  ) t group by t.text ");
		return queryList(sql.toString(), info, StatisJcDto.class);
	}
	
	/**
	 * @Description: 获取项目组别的列表
	 * @param @param param
	 * @return List<ResultModel>
	 */
	public void getItemGroupList(StatsPlatResultModel info, PageModel page){
		StringBuffer sql = new StringBuffer();
		sql.append(" select t.text as name, count(t.id) as value  ");
   		sql.append(" from ((select ds.text, s.id ");
   		sql.append(" 	from sys_dict_sub ds  ");
   		sql.append("    left join (select distinct j.medical_record_id as id, j.item_type, j.diagnosis_time ");
   		sql.append("  		from outpatient_jcz j	");
   		sql.append("  		join medical_record m on m.id = j.medical_record_id ");
   		sql.append("  		join sys_org o on m.org_code like concat(o.org_code, '%') and o.id = :orgId ");
   		sql.append("  		where j.diagnosis_time between to_date(:startTime, 'yyyy-MM-dd') and to_date(:endTime, 'yyyy-MM-dd')");
   		sql.append("  	union all");
   		sql.append("  		select distinct j.hospital_id as id, j.item_type, j.diagnosis_time ");
   		sql.append("  		from hospital_jcz j ");
   		sql.append("  		join hospital_infto m on m.id = j.hospital_id ");
   		sql.append("  		join sys_org o on m.org_code like concat(o.org_code, '%') and o.id = :orgId ");
   		sql.append("  		where j.diagnosis_time between to_date(:startTime, 'yyyy-MM-dd') and to_date(:endTime, 'yyyy-MM-dd')");
   		sql.append("  	) s on ds.text like concat(s.item_type, '%') ");
   		sql.append("  where ds.dict_id = 'f2e195be6a0f4b5482ef95d45ade24ff' ) ");
   		sql.append("  ) t group by t.text ");
		queryPage(sql.toString(), info, page, StatisJcDto.class);
		List<StatisJcDto> list = page.getList();
		float sum = 0;
		if (list == null) {
			list = new ArrayList<>();
		}else {
			PageModel page1 = new PageModel(1, 100);
			queryPage(sql.toString(), info, page1, StatisJcDto.class);
			List<StatisJcDto> list1 = page1.getList();
			for(StatisJcDto jc : list1) {
				sum += Float.parseFloat(jc.getValue());
			}
		}
		for(StatisJcDto jc : list) {
			if(Float.parseFloat(jc.getValue()) == 0 || sum == 0) {
				jc.setRatio("0.00%");
			}else {
				String ratio = String.format("%.2f",(Float.parseFloat(jc.getValue())*100)/sum);
				jc.setRatio(ratio+"%");
			}
		}
		// 查询不分页时的总数量
		String sql_1 = "select o.id from sys_dict_sub o where o.dict_id = :dictId and o.status = '1'";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("dictId", "f2e195be6a0f4b5482ef95d45ade24ff");
		long count = queryCount(sql_1, paramMap);
		page.setCount(count);
		page.setList(list);
	}
	
	/**
	 * @Description: 获取检验申请charts柱状图数据
	 * @param @param param
	 * @return List<ResultModel>
	 */
	public List<StatisJcDto> getExamApplyBarCharts(StatsPlatResultModel info) {
		StringBuffer sql = new StringBuffer();
   		if("0".equals(info.getMonth())) {
   			//x轴为月份
   			sql.append(" SELECT name, value from table(stats_exam_jc_count(:startTime, :endTime, '030101', :orgId, :itemGroupName, 30, 1)) ");
   		}else {
   			////x轴为天数
   			sql.append(" SELECT name, value from table(stats_exam_jc_count(:startTime, :endTime, '030102', :orgId, :itemGroupName, 30, 1)) ");
   		}
		return queryList(sql.toString(), info, StatisJcDto.class);
	}
	
	/**
	 * @Description: 获取检验申请charts饼状图数据
	 * @param @param param
	 * @return List<ResultModel>
	 */
	public List<StatisJcDto> getExamApplyPieCharts(StatsPlatResultModel info) {
		StringBuffer sql = new StringBuffer();
   		sql.append(" SELECT name, value from table(stats_exam_jc_count(:startTime, :endTime, '0302', :orgId, :itemGroupName, 30, 1)) ");
		return queryList(sql.toString(), info, StatisJcDto.class);
	}
	
	/**
	 * @Description: 获取检验申请的列表
	 * @param @param param
	 * @return List<ResultModel>
	 */
	public void getExamApplyList(StatsPlatResultModel info, PageModel page){
		StringBuffer sql = new StringBuffer();
   		sql.append(" SELECT id, name, value, org_level from table(stats_exam_jc_count(:startTime, :endTime, '0303', :orgId, :itemGroupName, :pageSize, :pageNo)) ");
		List<StatisJcDto> list = queryList(sql.toString(), info, StatisJcDto.class);
		float sum = 0;
		if (list == null) {
			list = new ArrayList<>();
		}else {
			StringBuffer sql1 = new StringBuffer();
			sql1.append(" SELECT id, name, value, org_level from table(stats_exam_jc_count(:startTime, :endTime, '0303', :orgId, :itemGroupName, 100, 1)) ");
			List<StatisJcDto> list1 = queryList(sql1.toString(), info, StatisJcDto.class);
			for(StatisJcDto jc : list1) {
				sum += Float.parseFloat(jc.getValue());
			}
		}
		for(StatisJcDto jc : list) {
			if(Float.parseFloat(jc.getValue()) == 0 || sum == 0) {
				jc.setRatio("0.00%");
			}else {
				String ratio = String.format("%.2f",(Float.parseFloat(jc.getValue())*100)/sum);
				jc.setRatio(ratio+"%");
			}
		}
		// 查询不分页时的总数量
		String sql_1 = "select o.id from sys_org o where o.parent_id = :orgId and o.status = '1'";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("orgId", info.getOrgId());
		long count = queryCount(sql_1, paramMap);
		page.setCount(count);
		page.setList(list);
	}
	
	/**
	 * @Description: 获取标本量统计charts柱状图数据
	 * @param @param param
	 * @return List<ResultModel>
	 */
	public List<StatisJcDto> getSampleBarCharts(StatsPlatResultModel info) {
		StringBuffer sql = new StringBuffer();
   		if("0".equals(info.getMonth())) {
   			//x轴为月份
   			sql.append(" SELECT name, value from table(stats_exam_jc_count(:startTime, :endTime, '030401', :orgId, :itemGroupName, 30, 1)) ");
   		}else {
   			////x轴为天数
   			sql.append(" SELECT name, value from table(stats_exam_jc_count(:startTime, :endTime, '030402', :orgId, :itemGroupName, 30, 1)) ");
   		}
		return queryList(sql.toString(), info, StatisJcDto.class);
	}
	
	/**
	 * @Description: 获取标本量统计charts饼状图数据
	 * @param @param param
	 * @return List<ResultModel>
	 */
	public List<StatisJcDto> getSamplePieCharts(StatsPlatResultModel info) {
		StringBuffer sql = new StringBuffer();
   		sql.append(" select t.name, count(t.id) as value  ");
   		sql.append(" from (select es.name, m.id as id ");
   		sql.append(" 	from bltexam.sys_exam_sample es ");
   		sql.append(" 	left join (select distinct j.medical_record_id, j.sample_type, j.diagnosis_time from outpatient_jcz j ");
   		sql.append(" 		where j.diagnosis_time between to_date(:startTime, 'yyyy-MM-dd') and to_date(:endTime, 'yyyy-MM-dd') and j.sample_code is not null) s on es.name = s.sample_type ");
   		sql.append(" 	left join medical_record m on m.id = s.medical_record_id  ");
   		sql.append(" 	left join sys_org o on m.org_code = o.org_code and o.id = :orgId ");
   		sql.append(" union all ");
   		sql.append(" 	select es.name, m.id as id ");
   		sql.append(" 	from bltexam.sys_exam_sample es  ");
   		sql.append(" 	left join (select distinct j.hospital_id, j.sample_type, j.diagnosis_time from hospital_jcz j ");
   		sql.append(" 		where j.diagnosis_time between to_date(:startTime, 'yyyy-MM-dd') and to_date(:endTime, 'yyyy-MM-dd') and j.sample_code is not null) s on es.name = s.sample_type ");
   		sql.append(" 	left join hospital_infto m on m.id = s.hospital_id ");
   		sql.append(" 	left join sys_org o on m.org_code = o.org_code and o.id = :orgId ");
   		sql.append(" 	) t group by t.name ");
		return queryList(sql.toString(), info, StatisJcDto.class);
	}
	
	/**
	 * @Description: 获取标本量统计charts折线图数据
	 * @param @param param
	 * @return List<ResultModel>
	 */
	public List<StatisJcDto> getSampleLineCharts(StatsPlatResultModel info) {
		StringBuffer sql = new StringBuffer();
   		if("0".equals(info.getMonth())) {
   			//x轴为月份
   			sql.append(" SELECT name, value, value1, value2 from table(stats_exam_jc_count(:startTime, :endTime, '030403', :orgId, :itemGroupName, 30, 1)) ");
   		}else {
   			////x轴为天数
   			sql.append(" SELECT name, value, value1, value2 from table(stats_exam_jc_count(:startTime, :endTime, '030404', :orgId, :itemGroupName, 30, 1)) ");
   		}
		return queryList(sql.toString(), info, StatisJcDto.class);
	}
	
	/**
	 * @Description: 获取检验数据charts数据
	 * @param @param param
	 * @return List<ResultModel>
	 */
	public List<StatisJcDto> getExamDataLineCharts(StatsPlatResultModel info) {
		StringBuffer sql = new StringBuffer();
   		sql.append(" SELECT name, value, value1 from table(stats_exam_jc_count(:startTime, :endTime, '0501', :orgId, :itemGroupName, 30, 1)) ");
		return queryList(sql.toString(), info, StatisJcDto.class);
	}
	
	/**
	 * @Description: 获取检验数据的列表
	 * @param @param param
	 * @return List<ResultModel>
	 */
	public void getExamDataList(StatsPlatResultModel info, PageModel page){
		StringBuffer sql = new StringBuffer();
   		sql.append(" SELECT id, name, value, value1, org_level from table(stats_exam_jc_count(:startTime, :endTime, '0501', :orgId, :itemGroupName, :pageSize, :pageNo)) ");
		List<StatisJcDto> list = queryList(sql.toString(), info, StatisJcDto.class);
		if (list == null) {
			list = new ArrayList<>();
		}
		// 查询不分页时的总数量
		String sql_1 = "select o.id from sys_org o where o.parent_id = :orgId and o.status = '1'";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("orgId", info.getOrgId());
		long count = queryCount(sql_1, paramMap);
		page.setCount(count);
		page.setList(list);
	}
	
	public List<ResultModel> getCommonExamStatis(String startDate, String endDate, String orgId, String type){
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT name, value, value1, value2, value3, value4, org_code, id as orgId from table(stats_daping_exam(:startDate, :endDate, :dataType, :orgId)) ");

		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("startDate", startDate);
		paramMap.put("endDate", endDate);
		paramMap.put("orgId", orgId);
		paramMap.put("dataType", type);
		return queryList(sql.toString(), paramMap, ResultModel.class);
	}
	/**
	 * @Description: 判断项目是否已经有检验数据
	 * @param @param itemCode
	 * @param @param itemName
	 * @param @return
	 * @return Integer
	 * @throws
	 */
	public Integer isExamDataExist(String itemCode, String itemName) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select count(s.id) ");
		sql.append(" from ");
		sql.append(" (select o.id from outpatient_jcz o where o.item_code = :itemCode and o.item_name = :itemName ");
		sql.append(" 	union ");
		sql.append(" select h.id from hospital_jcz h where h.item_code = :itemCode and h.item_name = :itemName) s ");

		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("itemCode", itemCode);
		paramMap.put("itemName", itemName);
		return queryOne(sql.toString(), paramMap, Integer.class);
	}
}
