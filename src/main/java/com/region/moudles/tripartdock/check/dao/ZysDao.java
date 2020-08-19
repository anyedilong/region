package com.region.moudles.tripartdock.check.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.tripartdock.check.dao.repository.ZysRepository;
import com.region.moudles.tripartdock.check.domain.Zys;


@Named
public class ZysDao extends BaseDao<ZysRepository, Zys> {

	/**
	 * @Description: 查询住院史
	 * @param @param tjId
	 * @return void
	 * @throws
	 */
	public List<Zys> queryZysList(String tjId){
		
		Map<String, Object> paramMap = new HashMap<>();
        StringBuffer sql=new StringBuffer();
        sql.append(" select a.* ");
        sql.append(" from blt_zys a ");
        sql.append(" where tjid = :tjId ");
        paramMap.put("tjId", tjId);
        return queryList(sql.toString(), paramMap, Zys.class);
   }
	
}
