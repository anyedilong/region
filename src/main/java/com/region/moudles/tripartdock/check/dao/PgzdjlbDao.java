package com.region.moudles.tripartdock.check.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.tripartdock.check.dao.repository.PgzdjlbRepository;
import com.region.moudles.tripartdock.check.domain.Pgzdjlb;


@Named
public class PgzdjlbDao extends BaseDao<PgzdjlbRepository, Pgzdjlb> {

	/**
	 * @Description: 查询评估指导
	 * @param @param tjId
	 * @return void
	 * @throws
	 */
	public Pgzdjlb queryPgzdjlbDetail(String tjId){
		
		Map<String, Object> paramMap = new HashMap<>();
        StringBuffer sql=new StringBuffer();
        sql.append(" select a.* ");
        sql.append(" from blt_pgzdjlb a ");
        sql.append(" where tjid = :tjId ");
        paramMap.put("tjId", tjId);
        return queryOne(sql.toString(), paramMap, Pgzdjlb.class);
   }
	
}
