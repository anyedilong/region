package com.region.moudles.outpatient.dao;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.outpatient.dao.repository.OutpatientRecipeRepository;
import com.region.moudles.outpatient.domain.OutpatientRecipe;

import javax.inject.Inject;
import javax.inject.Named;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
public class OutpatientRecipeDao extends BaseDao<OutpatientRecipeRepository,OutpatientRecipe> {

    @Inject
    private OutpatientRecipeRepository outpatientRecipeRepository;

    public List<OutpatientRecipe> getOutpatientCfIBySfzh(String sfzh){
        return outpatientRecipeRepository.getOutpatientCfIBySfzh(sfzh);
    }

    /**
     * @Description: 根据门诊id查询病历处方列表（健康浏览器）
     * @param @param mzId
     * @return void
     * @throws
     */
    public List<OutpatientRecipe> getOutpatientCfList(String mzId) {
    	StringBuffer sql = new StringBuffer();
    	sql.append("select a.* ");
    	sql.append(" from outpatient_rx a ");
    	sql.append(" where a.medical_record_id = :mzId");
    	sql.append(" order by a.prescribe_date desc");
		Map<String, Object> map = new HashMap<>();
		map.put("mzId", mzId);
        return queryList(sql.toString(), map, OutpatientRecipe.class);
    }
}
