package com.region.moudles.tripartdock.check.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.tripartdock.check.dao.repository.JkwtbRepository;
import com.region.moudles.tripartdock.check.domain.Jkwtb;


@Named
public class JkwtbDao extends BaseDao<JkwtbRepository,Jkwtb> {

	
	/**
	 * @Description: 查询健康问题
	 * @param @param tjId
	 * @return void
	 * @throws
	 */
	public Jkwtb queryJkwtbDetail(String tjId){
		
		Map<String, Object> paramMap = new HashMap<>();
        StringBuffer sql=new StringBuffer();
        sql.append(" select a.* ");
        sql.append(" from blt_jkwtb a ");
        sql.append(" where tjid = :tjId ");
        paramMap.put("tjId", tjId);
        return queryOne(sql.toString(), paramMap, Jkwtb.class);
   }
	
}
