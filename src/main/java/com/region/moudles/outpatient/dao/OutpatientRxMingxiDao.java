package com.region.moudles.outpatient.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.outpatient.dao.repository.OutpatientRxMingxiRepository;
import com.region.moudles.outpatient.domain.OutpatientRxMingxi;

@Named
public class OutpatientRxMingxiDao  extends BaseDao<OutpatientRxMingxiRepository,OutpatientRxMingxi>{

    
    
	 /**
     * @Description: 根据处方id查询处方的明细（健康浏览器）
     * @param @param hisId
     * @return void
     * @throws
     */
    public List<OutpatientRxMingxi> getCfMingxiDetail(String recipeNum, String orgCode) {
    	StringBuffer sql = new StringBuffer();
    	sql.append("select a.* ");
    	sql.append(" from outpatient_rx_mingxi a ");
    	sql.append(" where a.or_id = :recipeNum");
    	sql.append(" and a.org_code = :orgCode");
		Map<String, Object> map = new HashMap<>();
		map.put("recipeNum", recipeNum);
		map.put("orgCode", orgCode);
        return queryList(sql.toString(), map, OutpatientRxMingxi.class);
    }

}
