package com.region.moudles.hospital.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.hospital.dao.repository.HospitalOrderDoctorRepository;
import com.region.moudles.hospital.domain.HospitalOrderDoctor;

@Named
public class HospitalOrderDoctorDao extends BaseDao<HospitalOrderDoctorRepository, HospitalOrderDoctor> {
	
	public List<HospitalOrderDoctor> getOiDoctorList(String oiId){
        StringBuffer sql = new StringBuffer();
		sql.append(" select a.* ")
			.append(" from hospital_order_doctor a  ")
			.append(" where a.order_id = :oiId ");
		Map<String, Object> map = new HashMap<>();
		map.put("oiId", oiId);
        return queryList(sql.toString(), map, HospitalOrderDoctor.class);
    }

   
}
