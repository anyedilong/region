package com.region.moudles.hospital.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.hospital.dao.repository.HospitalJcRepository;
import com.region.moudles.hospital.domain.HospitalJc;

@Named
public class HospitalJcDao extends BaseDao<HospitalJcRepository, HospitalJc> {
	
	/**
     * @Description: 查询住院检查的详情(健康浏览器)
     * @param @param arId
     * @return void
     * @throws
     */
    public List<HospitalJc> getHospitalJcList(String zyId){
        StringBuffer sql = new StringBuffer();
		sql.append(" select a.item_type,a.diagnosis_time ")
			.append(" from hospital_jcz a  ")
			.append(" where a.hospital_id = :zyId ")
		    .append(" group by a.item_type,a.diagnosis_time")
			.append(" order by a.diagnosis_time desc ");
		Map<String, Object> map = new HashMap<>();
		map.put("zyId", zyId);
        return queryList(sql.toString(), map, HospitalJc.class);
    }

	public List<HospitalJc> getJcListByType(String zyId, String itemType) {
		StringBuffer sql = new StringBuffer();
		sql.append("select a.* ");
		sql.append(" from hospital_jcz a ");
		sql.append(" where a.hospital_id = :zyId");
		sql.append(" and a.item_type = :itemType");
		sql.append(" order by a.diagnosis_time desc");
		Map<String, Object> map = new HashMap<>();
		map.put("zyId", zyId);
		map.put("itemType", itemType);
		return queryList(sql.toString(), map, HospitalJc.class);
	}
    
}
