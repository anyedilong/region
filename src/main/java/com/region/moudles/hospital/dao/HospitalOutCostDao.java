package com.region.moudles.hospital.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.hospital.dao.repository.HospitalOutCostRepository;
import com.region.moudles.hospital.domain.HospitalOutCost;

@Named
public class HospitalOutCostDao extends BaseDao<HospitalOutCostRepository,HospitalOutCost> {
	
	
	/**
     *	 获取出院结算列表（分页-公卫）
     * @param String
     * @param page
     * @return
     */
    public void getCYJSInfoPage(String sfzh, PageModel page){
        StringBuffer sql = new StringBuffer();
		sql.append(" select a.* ")
			.append(" from hospital_out_cost a  ")
			.append(" where a.sfzh = :sfzh ")
			.append(" order by a.discharge_date desc ");
		Map<String, Object> map = new HashMap<>();
		map.put("sfzh", sfzh);
        queryPage(sql.toString(), map, page, HospitalOutCost.class);
    }
    
    /**
     * @Description: 获取出院结算列表（健康浏览器）
     * @param @param arId
     * @return void
     * @throws
     */
    public List<HospitalOutCost> getHospitalCostList(String zyId){
    	Map<String, Object> map = new HashMap<>();
        StringBuffer sql = new StringBuffer();
		sql.append(" select a.* ")
			.append(" from hospital_out_cost a  ")
			.append(" where a.hospital_id = :zyId ")
			.append(" order by a.discharge_date desc ");
		map.put("zyId", zyId);
        return queryList(sql.toString(), map, HospitalOutCost.class);
    }

}
