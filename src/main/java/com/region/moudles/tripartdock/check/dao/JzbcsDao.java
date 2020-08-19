package com.region.moudles.tripartdock.check.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.tripartdock.check.dao.repository.JzbcsRepository;
import com.region.moudles.tripartdock.check.domain.Jzbcs;



@Named
public class JzbcsDao extends BaseDao<JzbcsRepository, Jzbcs> {

	/**
	 * @Description: 查询家族病床史
	 * @param @param tjId
	 * @return void
	 * @throws
	 */
	public List<Jzbcs> queryJzbcsList(String tjId){
		
		Map<String, Object> paramMap = new HashMap<>();
        StringBuffer sql=new StringBuffer();
        sql.append(" select a.* ");
        sql.append(" from blt_jzbcs a ");
        sql.append(" where tjid = :tjId ");
        paramMap.put("tjId", tjId);
        return queryList(sql.toString(), paramMap, Jzbcs.class);
   }
	
}
