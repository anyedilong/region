package com.region.moudles.hospital.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.hospital.dao.repository.HospitalZdRepository;
import com.region.moudles.hospital.domain.HospitalZd;

@Named
public class HospitalZdDao extends BaseDao<HospitalZdRepository, HospitalZd> {
	
	
	/**
     * @Description: 查询住院诊断的详情(健康浏览器)
     * @param @param arId
     * @return void
     * @throws
     */
    public List<HospitalZd> getHospitalZDList(String zyId){
        StringBuffer sql = new StringBuffer();
		sql.append(" select a.* ")
			.append(" from hospital_zd a  ")
			.append(" where a.hospital_id = :zyId ")
			.append(" order by a.diagnosis_time desc ");
		Map<String, Object> map = new HashMap<>();
		map.put("zyId", zyId);
        return queryList(sql.toString(), map, HospitalZd.class);
    }
    
}
