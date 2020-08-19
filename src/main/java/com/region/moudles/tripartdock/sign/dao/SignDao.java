package com.region.moudles.tripartdock.sign.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.tripartdock.sign.dao.repository.SignRepository;
import com.region.moudles.tripartdock.sign.domain.Sign;


@Named
public class SignDao extends BaseDao<SignRepository, Sign> {

	/**
	 * @Description: 查询签约详情
	 * @param @param jmId
	 * @return void
	 * @throws
	 */
	public Sign querySignDetail(String jmId){
		
		Map<String, Object> paramMap = new HashMap<>();
        StringBuffer sql=new StringBuffer();
        sql.append(" select a.*, j.sj as phone, ");
        sql.append(" j.hzmc as signUserName, (floor(MONTHS_BETWEEN(sysdate, j.csrq)/12)) as nl  ");
        sql.append(" from blt_sign a ");
        sql.append(" join blt_jbxxjlb j on a.jmid = j.id ");
        sql.append(" where a.status = '1' and a.delete_flg = '0' ");
        sql.append(" and jmid = :jmId ");
        sql.append(" order by a.sign_time desc ");
        paramMap.put("jmId", jmId);
        return queryOne(sql.toString(), paramMap, Sign.class);
   }
	
}

	