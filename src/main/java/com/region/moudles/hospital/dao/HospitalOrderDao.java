package com.region.moudles.hospital.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.hospital.dao.repository.HospitalOrderRepository;
import com.region.moudles.hospital.domain.HospitalOrder;

@Named
public class HospitalOrderDao extends BaseDao<HospitalOrderRepository, HospitalOrder> {
	
	

    public List<HospitalOrder> getHospitalOrderList(String zyId){
        StringBuffer sql = new StringBuffer();
		sql.append(" select a.id, a.org_name, a.name, a.admission_num, a.dep_code, a.dep_name, a.effective_time, a.order_type ")
			.append(" from hospital_order a  ")
			.append(" where a.hospital_id = :zyId ");
		Map<String, Object> map = new HashMap<>();
		map.put("zyId", zyId);
        return queryList(sql.toString(), map, HospitalOrder.class);
    }
	
    public HospitalOrder getHospitalOrderDetail(String id){
        StringBuffer sql = new StringBuffer();
		sql.append(" select a.* ")
			.append(" from hospital_order a  ")
			.append(" where a.id = :id ");
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
        return queryOne(sql.toString(), map, HospitalOrder.class);
    }
}
