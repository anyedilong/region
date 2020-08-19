package com.region.moudles.hospital.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.hospital.dao.repository.HospitalOutMingXiRepository;
import com.region.moudles.hospital.domain.HospitalOutMingXi;
import com.region.until.StringUntil;

@Named
public class HospitalOutMingXiDao extends BaseDao<HospitalOutMingXiRepository,HospitalOutMingXi> {

	/**
     *	 获取出院结算明细列表（分页）
     * @param String
     * @param page
     * @return
     */
    public void getCYJSList(String hisId, PageModel page){
        StringBuffer sql = new StringBuffer();
		sql.append(" select a.* ")
			.append(" from hospital_out_mingxi a  ")
			.append(" where a.out_id = :hisId ");
		Map<String, Object> map = new HashMap<>();
		map.put("hisId", hisId);
        queryPage(sql.toString(), map, page, HospitalOutMingXi.class);
    }
	
    /**
     *	 获取出院结算明细详情列表
     * @param String
     * @return
     */
    public HospitalOutMingXi getCYJSMXDetail(String mxId){
        StringBuffer sql = new StringBuffer();
		sql.append(" select a.* ")
			.append(" from hospital_out_mingxi a  ")
			.append(" where a.id = :mxId ");
		Map<String, Object> map = new HashMap<>();
		map.put("mxId", mxId);
        return queryOne(sql.toString(), map, HospitalOutMingXi.class);
    }
    
    /**
     *	 获取出院结算明细列表（健康浏览器）
     * @param String
     * @param page
     * @return
     */
    public List<HospitalOutMingXi> getHospitalCostMingXiList(String hisId, String name, String startTime, String endTime){
    	Map<String, Object> map = new HashMap<>();
        StringBuffer sql = new StringBuffer();
		sql.append(" select a.* ")
			.append(" from hospital_out_mingxi a  ")
			.append(" where a.out_id = :hisId ");
		if(!StringUntil.isNull(name)) {
			sql.append(" and a.drug_name like concat(concat('%', :name), '%')  ");
			map.put("name", name);
		}
		if(!StringUntil.isNull(startTime)) {
			sql.append(" and a.issue_date >= to_date(:startTime, 'yyyy-mm-dd') ");
			map.put("startTime", startTime);
		}
		if(!StringUntil.isNull(endTime)) {
			sql.append(" and a.issue_date <= (to_date(:endTime, 'yyyy-mm-dd')+1) ");
			map.put("endTime", endTime);
		}
		map.put("hisId", hisId);
        return queryList(sql.toString(), map, HospitalOutMingXi.class);
    }
	
}
