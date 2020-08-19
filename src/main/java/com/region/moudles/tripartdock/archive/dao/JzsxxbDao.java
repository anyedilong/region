package com.region.moudles.tripartdock.archive.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.tripartdock.archive.dao.repository.JzsxxbRepository;
import com.region.moudles.tripartdock.archive.domain.Jzsxxb;


@Named
public class JzsxxbDao extends BaseDao<JzsxxbRepository, Jzsxxb> {
	

	/**
	 * @Description: 查询家族史信息
	 * @param @param archiveId
	 * @return void
	 * @throws
	 */
	public Jzsxxb queryJZSxxDetail(String jmId){
		
		Map<String, Object> paramMap = new HashMap<>();
        StringBuffer sql=new StringBuffer();
        sql.append(" select a.* ");
        sql.append(" from blt_jzsxxb a ");
        sql.append(" where jmid = :jmId ");
        paramMap.put("jmId", jmId);
        return queryOne(sql.toString(), paramMap, Jzsxxb.class);
   }
	
}
