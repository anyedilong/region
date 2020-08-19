package com.region.moudles.hospital.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.hospital.dao.repository.HospitalOrderItemRepository;
import com.region.moudles.hospital.domain.HospitalOrderItem;

@Named
public class HospitalOrderItemDao extends BaseDao<HospitalOrderItemRepository, HospitalOrderItem> {
	
	
	public List<HospitalOrderItem> getOrderItemList(String orderId){
        StringBuffer sql = new StringBuffer();
		sql.append(" select a.* ")
			.append(" from hospital_order_item a  ")
			.append(" where a.order_id = :orderId ");
		Map<String, Object> map = new HashMap<>();
		map.put("orderId", orderId);
        return queryList(sql.toString(), map, HospitalOrderItem.class);
    }
   
	public List<HospitalOrderItem> getHospitalOrderItemList(String zyId){
        StringBuffer sql = new StringBuffer();
		sql.append(" select i.id, i.drug_name, i.prescribe_date, i.execute_date, i.stop_date, o.order_type ")
			.append(" from hospital_order_item i  ")
			.append(" join hospital_order o on i.order_id = o.id ")
			.append(" where o.hospital_id = :zyId");
		Map<String, Object> map = new HashMap<>();
		map.put("zyId", zyId);
        return queryList(sql.toString(), map, HospitalOrderItem.class);
    }
	
}
