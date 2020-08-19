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
public class StatsPOCTDao extends QueryDao {

	/**
	 * @Description:  获取核酸检验统计菜单中检验人次、结果呈阳性、结果呈阴性
	 * @param @param StatsPlatResultModel
	 * @return List<ResultModel>
	 */
	public List<ResultModel> getNucleinCheckStats(StatsPlatResultModel info) {

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
	
	public Integer getNucleinCheckProp() {
		
		StringBuffer sql = new StringBuffer();
		sql.append(" select count(distinct r.resident_id) ");
		sql.append(" from sys_poct_result r ");
		sql.append(" join blt_jbxxjlb j on r.resident_id = j.id ");
		sql.append(" where (j.sfsc = 'N' or j.sfsc is null) ");
		Integer nucleinNum = queryOne(sql.toString(), null, Integer.class);
		
		StringBuffer sql1 = new StringBuffer();
		sql1.append(" select count(1) from blt_jbxxjlb r where (r.sfsc = 'N' or r.sfsc is null) ");
		Integer num = queryOne(sql1.toString(), null, Integer.class);
		if(num == 0) {
			return 0;
		}
		return nucleinNum*100/num;
	}

}
