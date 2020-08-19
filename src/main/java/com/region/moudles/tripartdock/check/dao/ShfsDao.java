package com.region.moudles.tripartdock.check.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.tripartdock.check.dao.repository.ShfsRepository;
import com.region.moudles.tripartdock.check.domain.Shfs;


@Named
public class ShfsDao extends BaseDao<ShfsRepository,Shfs> {

	/**
	 * @Description: 查询生活方式
	 * @param @param tjId
	 * @return void
	 * @throws
	 */
	public Shfs queryShfsDetail(String tjId){
		
		Map<String, Object> paramMap = new HashMap<>();
        StringBuffer sql=new StringBuffer();
        sql.append(" select a.* ");
        sql.append(" from blt_shfs a ");
        sql.append(" where tjid = :tjId ");
        paramMap.put("tjId", tjId);
        return queryOne(sql.toString(), paramMap, Shfs.class);
   }
	
}
