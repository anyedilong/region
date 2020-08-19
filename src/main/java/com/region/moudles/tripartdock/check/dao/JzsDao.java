package com.region.moudles.tripartdock.check.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.tripartdock.check.dao.repository.JzsRepository;
import com.region.moudles.tripartdock.check.domain.Jzs;



@Named
public class JzsDao extends BaseDao<JzsRepository, Jzs>{

	
	/**
	 * @Description: 查询接种史
	 * @param @param tjId
	 * @return void
	 * @throws
	 */
	public List<Jzs> queryJzsList(String tjId){
		
		Map<String, Object> paramMap = new HashMap<>();
        StringBuffer sql=new StringBuffer();
        sql.append(" select a.jzs as tjdw, a.* ");
        sql.append(" from blt_jzs a ");
        sql.append(" join blt_khjbxxb b on a.tjid = b.id ");
        sql.append(" where tjid = :tjId ");
        paramMap.put("tjId", tjId);
        return queryList(sql.toString(), paramMap, Jzs.class);
   }
	
}
