package com.region.moudles.hospital.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.hospital.dao.repository.HospitalOutZdRepository;
import com.region.moudles.hospital.domain.HospitalOutZd;

@Named
public class HospitalOutZdDao extends BaseDao<HospitalOutZdRepository,HospitalOutZd> {
	
	/**
     *	 获取出院结算诊断列表（分页）
     * @param String
     * @param page
     * @return
     */
    public void getCYJSZDList(String hisId, PageModel page){
        StringBuffer sql = new StringBuffer();
		sql.append(" select a.* ")
			.append(" from hospital_out_zd a  ")
			.append(" where a.is_id = :hisId ");
		Map<String, Object> map = new HashMap<>();
		map.put("hisId", hisId);
        queryPage(sql.toString(), map, page, HospitalOutZd.class);
    }
    
    /**
     *	 获取出院结算诊断列表（健康浏览器）
     * @param String
     * @param page
     * @return
     */
    public List<HospitalOutZd> getHospitalCostZdList(String hisId){
        StringBuffer sql = new StringBuffer();
		sql.append(" select distinct a.diagnosis_type, a.disease_code, a.disease_name, a.diagnosis_time ")
			.append(" from hospital_out_zd a  ")
			.append(" where a.is_id = :hisId ");
		Map<String, Object> map = new HashMap<>();
		map.put("hisId", hisId);
        return queryList(sql.toString(), map, HospitalOutZd.class);
    }
}
