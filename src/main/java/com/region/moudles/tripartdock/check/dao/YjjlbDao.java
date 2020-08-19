package com.region.moudles.tripartdock.check.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.tripartdock.check.dao.repository.YjjlbRepository;
import com.region.moudles.tripartdock.check.domain.Yjjlb;


@Named
public class YjjlbDao extends BaseDao<YjjlbRepository, Yjjlb> {

	/**
	 * @Description: 查询药剂记录
	 * @param @param tjId
	 * @return void
	 * @throws
	 */
	public List<Yjjlb> queryYjjlbList(String tjId){
		
		Map<String, Object> paramMap = new HashMap<>();
        StringBuffer sql=new StringBuffer();
        sql.append(" select a.* ");
        sql.append(" from blt_yjjlb a ");
        sql.append(" where tjid = :tjId ");
        paramMap.put("tjId", tjId);
        return queryList(sql.toString(), paramMap, Yjjlb.class);
   }
	
}
