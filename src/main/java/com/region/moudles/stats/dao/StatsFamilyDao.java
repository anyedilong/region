package com.region.moudles.stats.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.QueryDao;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.stats.dto.ResultModel;
import com.region.moudles.stats.dto.StatsPlatResultModel;

@Named
public class StatsFamilyDao extends QueryDao {

	/**
	 * @Description: 获取医疗收入（住院、门诊、检查检验、手术）
	 * @param @param StatsPlatResultModel
	 * @return List<ResultModel>
	 */
	public List<ResultModel> getYLCharges(StatsPlatResultModel info) {

		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * from table(stats_plat_ylsr_count(:startTime, :endTime, :incomeType, :orgCode)) ");

		return queryList(sql.toString(), info, ResultModel.class);
	}

	/**
	 * @Description: 获取机构的处方项类别的收入统计
	 * @param @param StatsPlatResultModel
	 * @return List<ResultModel>
	 */
	public void getJGLBSRCharges(StatsPlatResultModel info, PageModel page) {

		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * from table(stats_plat_yl_list(:startTime, :endTime, :incomeType, :orgCode, :pageSize, :pageNo)) ");
		List<ResultModel> list = queryList(sql.toString(), info, ResultModel.class);
		if (list == null) {
			list = new ArrayList<>();
		}
		// 查询不分页时的总数量
		String sql_1 = "select o.id from sys_org o where o.parent_id = (select id from sys_org where org_code = :orgCode) and o.status = '1'";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("orgCode", info.getOrgCode());
		long count = queryCount(sql_1, paramMap);
		page.setCount(count);
		page.setList(list);
	}

	/**
	 * @Description: 获取各县区的总收入
	 * @param @param StatsPlatResultModel
	 * @return List<ResultModel>
	 */
	public List<ResultModel> getQXYLChargeStats(String incomeType, String orgCode) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select name, value, value1, value3 as orgCode from table(stats_plat_ylxqsr_count(:incomeType, :orgCode)) ");

		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("orgCode", orgCode);
		paramMap.put("incomeType", incomeType);
		return queryList(sql.toString(), paramMap, ResultModel.class);
	}

	/**
	 * @Description: 获取机构的处方项类别的收入统计
	 * @param @param StatsPlatResultModel
	 * @return List<ResultModel>
	 */
	public List<ResultModel> getYLItemTypeStats(StatsPlatResultModel info) {

		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * from table(stats_plat_yl_prop(:startTime, :endTime, :incomeType, :orgCode)) ");
		return queryList(sql.toString(), info, ResultModel.class);
	}

	/**
	 * @Description: 获取医疗菜单中各处方项类别的收入（echarts）
	 * @param @param StatsPlatResultModel
	 * @return List<ResultModel>
	 */
	public List<ResultModel> getYLItemChargeStats(StatsPlatResultModel info) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select * from table(stats_plat_yl_item(:startTime, :endTime, :incomeType, :orgCode)) ");
		return queryList(sql.toString(), info, ResultModel.class);
	}

}
