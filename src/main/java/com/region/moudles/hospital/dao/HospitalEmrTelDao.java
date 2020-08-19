package com.region.moudles.hospital.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.hospital.dao.repository.HospitalEmrTelRepository;
import com.region.moudles.hospital.domain.HospitalEmrTel;

@Named
public class HospitalEmrTelDao extends BaseDao<HospitalEmrTelRepository, HospitalEmrTel> {
	
	
	
    public List<HospitalEmrTel> getHospitalTelList(String emrId){
        StringBuffer sql = new StringBuffer();
		sql.append(" select a.* ")
			.append(" from hospital_emr_tel a  ")
			.append(" where a.ich_id = :emrId ");
		Map<String, Object> map = new HashMap<>();
		map.put("emrId", emrId);
        return queryList(sql.toString(), map, HospitalEmrTel.class);
    }
}
