package com.region.moudles.hospital.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.hospital.dao.repository.HospitalEmrDoctorRepository;
import com.region.moudles.hospital.domain.HospitalEmrDoctor;

@Named
public class HospitalEmrDoctorDao extends BaseDao<HospitalEmrDoctorRepository, HospitalEmrDoctor> {
	
	
	
    public List<HospitalEmrDoctor> getEmrDoctorList(String emrId){
        StringBuffer sql = new StringBuffer();
		sql.append(" select a.* ")
			.append(" from hospital_emr_doctor a  ")
			.append(" where a.ich_id = :emrId ");
		Map<String, Object> map = new HashMap<>();
		map.put("emrId", emrId);
        return queryList(sql.toString(), map, HospitalEmrDoctor.class);
    }
}
