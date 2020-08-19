package com.region.moudles.tripartdock.check.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.tripartdock.check.dao.repository.YbzzbRepository;
import com.region.moudles.tripartdock.check.domain.Ybzzb;


@Named
public class YbzzbDao extends BaseDao<YbzzbRepository, Ybzzb>{

	/**
	 * @Description: 查询一般症状
	 * @param @param tjId
	 * @return void
	 * @throws
	 */
	public Ybzzb queryYbzzbDetail(String tjId){
		
		Map<String, Object> paramMap = new HashMap<>();
        StringBuffer sql=new StringBuffer();
        sql.append(" select a.* ");
        sql.append(" from blt_ybzzb a ");
        sql.append(" where tjid = :tjId ");
        paramMap.put("tjId", tjId);
        return queryOne(sql.toString(), paramMap, Ybzzb.class);
   }
	
}
