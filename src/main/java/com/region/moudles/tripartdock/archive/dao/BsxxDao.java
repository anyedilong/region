package com.region.moudles.tripartdock.archive.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.tripartdock.archive.dao.repository.BsxxRepository;
import com.region.moudles.tripartdock.archive.domain.Bsxx;


@Named
public class BsxxDao extends BaseDao<BsxxRepository, Bsxx> {
	
	
	/**
	 * @Description: 查询病史信息
	 * @param @param archiveId
	 * @return void
	 * @throws
	 */
	public List<Bsxx> queryBSxxDetail(String jmId){
		
		Map<String, Object> paramMap = new HashMap<>();
        StringBuffer sql=new StringBuffer();
        sql.append(" select a.* ");
        sql.append(" from blt_bsxx a ");
        sql.append(" where jmid = :jmId ");
        paramMap.put("jmId", jmId);
        return queryList(sql.toString(), paramMap, Bsxx.class);
   }
	
}
