package com.region.moudles.stats.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.QueryDao;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.stats.dto.ResultMoneyModel;
import com.region.moudles.stats.dto.StatsPlatResultModel;

@Named
public class StatsSPMSMoneyDao extends QueryDao {

	
	/**
	 * @Description: 同期折线统计
	 * @param @param info
	 * @param @return
	 * @return List<ResultModel>
	 * @throws
	 */
	public List<ResultMoneyModel> getTQLineData(StatsPlatResultModel info) {
		
		StringBuffer sql = new StringBuffer();
   		sql.append(" select * from table(stats_plat_onelevel_line(:startTime, :endTime, :incomeType, :orgCode)) ");
		return queryList(sql.toString(), info, ResultMoneyModel.class);
		
	}
	/**
	 * @Description: 运营（科室和医疗）分类各种情况的占比
	 * @param @param mode
	 * @param @return
	 * @return List<ResultModel>
	 * @throws
	 */
	public List<ResultMoneyModel> getMedicantChartsData(StatsPlatResultModel mode) {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from table(stats_plat_onelevel_other(:startTime, :endTime, :incomeType, :orgCode)) ");
		return queryList(sql.toString(), mode, ResultMoneyModel.class);
		
	}

	/**
	 * @Description: 获取机构的运营（科室和医疗）各类型的统计(列表)
	 * @param @param StatsPlatResultModel
	 * @return List<ResultModel>
	 */
	public void getMedicantTypePage(StatsPlatResultModel info, PageModel page){
		
		StringBuffer sql = new StringBuffer();
   		sql.append(" SELECT * from table(stats_plat_twolevel_list(:startTime, :endTime, :incomeType, :orgCode, :pageSize, :pageNo)) ");
   		List<ResultMoneyModel> list = queryList(sql.toString(), info, ResultMoneyModel.class);
   		if(list == null) {
   			list = new ArrayList<>();
   		}
   		//查询不分页时的总数量
        String sql_1 = "select o.id from sys_org o where o.parent_id = (select id from sys_org where org_code = :orgCode) and o.status = '1'";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("orgCode", info.getOrgCode());
        long count = queryCount(sql_1, paramMap);
        page.setCount(count);
        page.setList(list); 
	}
	
	/**
	 * @Description: 获取各月份的运营（科室和医疗）各类型的统计(柱状)
	 * @param @param mode
	 * @param @return
	 * @return List<ResultModel>
	 * @throws
	 */
	public List<ResultMoneyModel> getMedicantTypeByMonth(StatsPlatResultModel mode) {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from table(stats_plat_twolevel_item(:startTime, :endTime, :incomeType, :orgCode)) ");
		return queryList(sql.toString(), mode, ResultMoneyModel.class);
	}
	
	/**
	 * @Description: 获取各运营（科室和医疗）类型的占比（饼状）
	 * @param @param mode
	 * @param @return
	 * @return List<ResultModel>
	 * @throws
	 */
	public List<ResultMoneyModel> getMedicantTypeProp(StatsPlatResultModel mode) {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from table(stats_plat_twolevel_prop(:startTime, :endTime, :incomeType, :orgCode)) ");
		return queryList(sql.toString(), mode, ResultMoneyModel.class);
	}
	
}
