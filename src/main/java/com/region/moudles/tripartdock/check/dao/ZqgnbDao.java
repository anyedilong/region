package com.region.moudles.tripartdock.check.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.tripartdock.check.dao.repository.ZqgnbRepository;
import com.region.moudles.tripartdock.check.domain.Zqgnb;


@Named
public class ZqgnbDao extends BaseDao<ZqgnbRepository, Zqgnb> {

	/**
	 * @Description: 查询脏器功能
	 * @param @param tjId
	 * @return void
	 * @throws
	 */
	public Zqgnb queryZqgnbDetail(String tjId){
		
		Map<String, Object> paramMap = new HashMap<>();
        StringBuffer sql=new StringBuffer();
        sql.append(" select a.* ");
        sql.append(" from blt_zqgnb a ");
        sql.append(" where tjid = :tjId ");
        paramMap.put("tjId", tjId);
        return queryOne(sql.toString(), paramMap, Zqgnb.class);
   }
	
}
