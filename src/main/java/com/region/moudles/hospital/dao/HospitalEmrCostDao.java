package com.region.moudles.hospital.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.hospital.dao.repository.HospitalEmrCostRepository;
import com.region.moudles.hospital.domain.HospitalEmrCost;

@Named
public class HospitalEmrCostDao extends BaseDao<HospitalEmrCostRepository, HospitalEmrCost> {
	
	
	
    public List<HospitalEmrCost> getEmrCostList(String emrId){
        StringBuffer sql = new StringBuffer();
		sql.append(" select a.* ")
			.append(" from hospital_emr_cost a  ")
			.append(" where a.ich_id = :emrId ");
		Map<String, Object> map = new HashMap<>();
		map.put("emrId", emrId);
        return queryList(sql.toString(), map, HospitalEmrCost.class);
    }
}
