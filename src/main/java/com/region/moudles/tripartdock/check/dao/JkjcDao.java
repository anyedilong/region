package com.region.moudles.tripartdock.check.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.tripartdock.check.dao.repository.JkjcRepository;
import com.region.moudles.tripartdock.check.domain.Jkjc;


@Named
public class JkjcDao extends BaseDao<JkjcRepository,Jkjc>{

	/**
	 * @Description: 查询健康检查
	 * @param @param tjId
	 * @return void
	 * @throws
	 */
	public Jkjc queryJkjcDetail(String tjId){
		
		Map<String, Object> paramMap = new HashMap<>();
        StringBuffer sql=new StringBuffer();
        sql.append(" select a.* ");
        sql.append(" from blt_jkjc a ");
        sql.append(" where tjid = :tjId ");
        paramMap.put("tjId", tjId);
        return queryOne(sql.toString(), paramMap, Jkjc.class);
   }
	
}
