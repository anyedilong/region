package com.region.moudles.hospital.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.hospital.dao.repository.HospitalEmrZdRepository;
import com.region.moudles.hospital.domain.HospitalEmrZd;

@Named
public class HospitalEmrZdDao extends BaseDao<HospitalEmrZdRepository, HospitalEmrZd> {
	
	
	
    public List<HospitalEmrZd> getHospitalZdList(String emrId){
        StringBuffer sql = new StringBuffer();
		sql.append(" select a.* ")
			.append(" from hospital_emr_disease a  ")
			.append(" where a.ich_id = :emrId ");
		Map<String, Object> map = new HashMap<>();
		map.put("emrId", emrId);
        return queryList(sql.toString(), map, HospitalEmrZd.class);
    }
}
