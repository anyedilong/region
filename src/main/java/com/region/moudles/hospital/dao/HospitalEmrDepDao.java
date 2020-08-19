package com.region.moudles.hospital.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.hospital.dao.repository.HospitalEmrDepRepository;
import com.region.moudles.hospital.domain.HospitalEmrDep;

@Named
public class HospitalEmrDepDao extends BaseDao<HospitalEmrDepRepository, HospitalEmrDep> {
	
	
    public List<HospitalEmrDep> getDepList(String emrId){
        StringBuffer sql = new StringBuffer();
		sql.append(" select a.* ")
			.append(" from hospital_emr_dep a  ")
			.append(" where a.ich_id = :emrId ");
		Map<String, Object> map = new HashMap<>();
		map.put("emrId", emrId);
        return queryList(sql.toString(), map, HospitalEmrDep.class);
    }
}
