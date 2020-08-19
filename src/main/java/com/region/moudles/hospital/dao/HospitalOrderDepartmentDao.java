package com.region.moudles.hospital.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.hospital.dao.repository.HospitalOrderDepartmentRepository;
import com.region.moudles.hospital.domain.HospitalOrderDepartment;

@Named
public class HospitalOrderDepartmentDao extends BaseDao<HospitalOrderDepartmentRepository, HospitalOrderDepartment> {
	
	
	public List<HospitalOrderDepartment> getOiDepList(String oiId){
        StringBuffer sql = new StringBuffer();
		sql.append(" select a.* ")
			.append(" from hospital_order_department a  ")
			.append(" where a.order_id = :oiId ");
		Map<String, Object> map = new HashMap<>();
		map.put("oiId", oiId);
        return queryList(sql.toString(), map, HospitalOrderDepartment.class);
    }
   
	
}
