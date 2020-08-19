package com.region.moudles.outpatient.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.outpatient.dao.repository.OutpatientZdRepository;
import com.region.moudles.outpatient.domain.OutpatientZd;

@Named
public class OutpatientZdDao  extends BaseDao<OutpatientZdRepository,OutpatientZd>{
	
	
	/**
     *	 获取诊断列表（分页）
     * @param page
     * @return
     */
    public void getOutpatientZDInfo(String sfzh, PageModel page){
        StringBuffer sql = new StringBuffer();
		sql.append(" select b.DISEASE_NAME, b.DIAGNOSIS_TIME ")
			.append(" from medical_record a  ")
			.append(" join outpatient_zd b on a.outpatient_num = b.outpatient_num ")
			.append(" where a.sfzh = :sfzh ");
		sql.append(" order by b.DIAGNOSIS_TIME desc ");
		Map<String, Object> map = new HashMap<>();
		map.put("sfzh", sfzh);
        queryPage(sql.toString(), map, page, OutpatientZd.class);
    }
    
    /**
     * @Description: 根据门诊id查询病历诊断列表（健康浏览器）
     * @param @param mzId
     * @return void
     * @throws
     */
    public List<OutpatientZd> getOutpatientZDList(String mzId) {
    	StringBuffer sql = new StringBuffer();
    	sql.append("select a.* ");
    	sql.append(" from outpatient_zd a ");
    	sql.append(" where a.medical_record_id = :mzId");
    	sql.append(" order by a.diagnosis_time desc");
		Map<String, Object> map = new HashMap<>();
		map.put("mzId", mzId);
        return queryList(sql.toString(), map, OutpatientZd.class);
    }
    
}
