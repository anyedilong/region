package com.region.moudles.stats.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.QueryDao;
import com.region.moudles.stats.dto.ResultModel;
import com.region.moudles.stats.dto.ResultMoneyModel;
import com.region.moudles.stats.dto.StatsPlatResultModel;

@Named
public class StatsDao extends QueryDao {

	/**
	 * @Description: 获取公共方法数据（1.签约/解约人次 2.门诊/急诊 3.入院/出院 4.家医签约 5.就诊人次 ）
	 * @param @param param
	 * @return List<ResultModel>
	 */
	public List<ResultModel> getStatsCommon(StatsPlatResultModel param){
		StringBuffer sql = new StringBuffer();
   		sql.append(" SELECT name, value, value1, value2 from table(stats_common_count(:startTime, :endTime, :incomeType, :orgCode)) ");
		return queryList(sql.toString(), param, ResultModel.class);
	}
	
	/**
	 * @Description: 获取公共方法数据（1.签约/解约人次 2.门诊/急诊 3.入院/出院 4.家医签约 5.就诊人次 ）
	 * @param @param param
	 * @return List<ResultModel>
	 */
	public List<ResultMoneyModel> getStatsIncomeCommon(StatsPlatResultModel param){
		StringBuffer sql = new StringBuffer();
   		sql.append(" SELECT name, value, value1, value2 from table(stats_common_count(:startTime, :endTime, :incomeType, :orgCode)) ");
		return queryList(sql.toString(), param, ResultMoneyModel.class);
	}
	
	/**
	 * @Description: 获取人群类型占比
	 * @param @param orgCode
	 * @return List<ResultModel>
	 */
	public List<ResultModel> getPopTypeProp(String orgCode){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
   		sql.append(" SELECT name, value from table(stats_rqlx_count(:orgCode)) ");
   		paramMap.put("orgCode", orgCode);
		return queryList(sql.toString(), paramMap, ResultModel.class);
	}
	
	/**
	 * @Description: 获取履约的人数
	 * @param @param orgCode
	 * @return ResultModel
	 */
	public ResultModel getRecordData(String orgCode){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
   		sql.append(" select '履约人数'  as name, count(distinct b.sign_customer_idcard) as value ");
   		sql.append(" from blt_sign_record a ");
   		sql.append(" join blt_sign b on a.signid = b.id and b.delete_flg = '0' ");
   		sql.append(" join blt_jbxxjlb c on b.sign_customer_idcard = c.sfzh and c.sfsc = 'N' ");
   		sql.append(" join sys_org d on c.org_id = d.id ");
   		sql.append(" where a.deleteflg = '0' and d.org_code like concat(:orgCode, '%') ");
   		sql.append(" and to_char(a.servicetime, 'yyyy') = to_char(sysdate, 'yyyy') and b.status = '1' ");
   		paramMap.put("orgCode", orgCode);
		return queryOne(sql.toString(), paramMap, ResultModel.class);
	}
	
	/**
	 * @Description: 获取签约的人数
	 * @param @param orgCode
	 * @return ResultModel
	 */
	public ResultModel getSignData(String orgCode){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
   		sql.append(" select '签约人数'  as name, count(distinct a.sign_customer_idcard) as value ");
   		sql.append(" from blt_sign a ");
   		sql.append(" join blt_jbxxjlb b on a.sign_customer_idcard = b.sfzh and b.sfsc = 'N' ");
   		sql.append(" join sys_org c on b.org_id = c.id ");
   		sql.append(" where a.delete_flg = '0' and a.status = '1' ");
   		sql.append(" and c.org_code like concat(:orgCode, '%') ");
   		sql.append(" and to_char(a.create_time, 'yyyy') = to_char(sysdate, 'yyyy') ");
   		paramMap.put("orgCode", orgCode);
		return queryOne(sql.toString(), paramMap, ResultModel.class);
	}
	
	/**
	 * @Description: 获取建档、签约、体检的人数(各区县)
	 * @param @param orgCode
	 * @return List<ResultModel>
	 */
	public List<ResultModel> getPopTypesSpread(String orgCode){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
   		sql.append(" SELECT county as name, orgCode, archiveNum as value, signNum as value1, tjNum as value2, pkNum as value3, tpNum as value4 ");
   		sql.append(" from table(stats_map_count(:orgCode)) ");
   		paramMap.put("orgCode", orgCode);
   		return queryList(sql.toString(), paramMap, ResultModel.class);
	}
	
	/**
	 * @Description: 获取各县区医院就诊人数
	 * @param @param orgCode regType
	 * @return List<ResultModel>
	 */
	public List<ResultModel> getHospitalVisits(String orgCode, String regType){
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT * from table(stats_xqmzzyrc_count(:orgCode, :regType)) ");
   		paramMap.put("orgCode", orgCode);
   		paramMap.put("regType", regType);
		return queryList(sql.toString(), paramMap, ResultModel.class);
	}
		
	/**
	 * @Description: 获取卫生院的公共方法数据（1.各类人数统计 2.随访人次 3.医生签约(饼状) 4.就诊人次(饼状)
	 * @param @param orgCode type
	 * @return List<ResultModel>
	 */
	public List<ResultModel> getWSYStatsCommon(String orgCode, String type){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
   		sql.append(" SELECT name, value from table(stats_wsy_count(:orgCode, :type)) ");
   		paramMap.put("orgCode", orgCode);
   		paramMap.put("type", type);
		return queryList(sql.toString(), paramMap, ResultModel.class);
	}
	
	/**
	 * @Description: 获取卫生院的公共方法数据（5.年度总收入 6.医保收入 7.本月收入）
	 * @param @param orgCode type
	 * @return List<ResultModel>
	 */
	public List<ResultMoneyModel> getWSYStatsIncomeCommon(String orgCode, String type){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
   		sql.append(" SELECT name, value from table(stats_wsy_count(:orgCode, :type)) ");
   		paramMap.put("orgCode", orgCode);
   		paramMap.put("type", type);
		return queryList(sql.toString(), paramMap, ResultMoneyModel.class);
	}
	
	/**
	 * @Description: 获取服务动态数据
	 * @param @param orgCode 
	 * @return List<ResultModel>
	 */
	public List<String> getServiceData(String orgCode){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
   		sql.append(" SELECT name from table(stats_syservice_count(:orgCode)) ");
   		paramMap.put("orgCode", orgCode);
		return queryList(sql.toString(), paramMap, String.class);
	}
	
}
