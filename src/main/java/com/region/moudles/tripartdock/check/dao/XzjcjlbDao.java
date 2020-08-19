package com.region.moudles.tripartdock.check.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.tripartdock.check.dao.repository.XzjcjlbRepository;
import com.region.moudles.tripartdock.check.domain.Xzjcjlb;


@Named
public class XzjcjlbDao extends BaseDao<XzjcjlbRepository, Xzjcjlb> {

	/**
	 * @Description: 查询辅助检查
	 * @param @param tjId
	 * @return void
	 * @throws
	 */
	public Xzjcjlb queryXzjcjlbDetail(String tjId){
		
		Map<String, Object> paramMap = new HashMap<>();
        StringBuffer sql=new StringBuffer();
        sql.append(" select a.* ");
        sql.append(" from blt_xzjcjlb a ");
        sql.append(" where tjid = :tjId ");
        paramMap.put("tjId", tjId);
        return queryOne(sql.toString(), paramMap, Xzjcjlb.class);
   }
	
}
