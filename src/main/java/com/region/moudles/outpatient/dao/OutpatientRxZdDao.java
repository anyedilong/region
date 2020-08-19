package com.region.moudles.outpatient.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.outpatient.dao.repository.OutpatientRxZdRepository;
import com.region.moudles.outpatient.domain.OutpatientRxZd;

@Named
public class OutpatientRxZdDao  extends BaseDao<OutpatientRxZdRepository,OutpatientRxZd>{

	
	/**
     * @Description: 根据处方id查询处方诊断的详情（健康浏览器）
     * @param @param hisId
     * @return void
     * @throws
     */
    public List<OutpatientRxZd> getCfZdDetail(String recipeNum, String orgCode) {
    	StringBuffer sql = new StringBuffer();
    	sql.append("select a.* ");
    	sql.append(" from outpatient_rx_zd a ");
    	sql.append(" where a.or_id = :recipeNum");
    	sql.append(" and a.org_code = :orgCode");
		Map<String, Object> map = new HashMap<>();
		map.put("recipeNum", recipeNum);
		map.put("orgCode", orgCode);
        return queryList(sql.toString(), map, OutpatientRxZd.class);
    }
	
}
