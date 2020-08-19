package com.region.moudles.tripartdock.archive.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.tripartdock.archive.dao.repository.ShhjbRepository;
import com.region.moudles.tripartdock.archive.domain.Shhjb;


@Named
public class ShhjbDao extends BaseDao<ShhjbRepository, Shhjb> {
	

	/**
	 * @Description: 查询生活环境信息
	 * @param @param archiveId
	 * @return void
	 * @throws
	 */
	public Shhjb querySHhjDetail(String jmId){
		
		Map<String, Object> paramMap = new HashMap<>();
        StringBuffer sql=new StringBuffer();
        sql.append(" select a.* ");
        sql.append(" from blt_shhjb a ");
        sql.append(" where jmid = :jmId ");
        paramMap.put("jmId", jmId);
        return queryOne(sql.toString(), paramMap, Shhjb.class);
   }
	
}
