package com.region.moudles.tripartdock.yunzhi.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.tripartdock.yunzhi.dao.repository.FdssUserRepository;
import com.region.moudles.tripartdock.yunzhi.domain.FdssUser;
import com.region.until.StringUntil;

@Named
public class FdssUserDao extends BaseDao<FdssUserRepository, FdssUser> {


	public List<FdssUser> getDoctorlList(String orgId) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<>();
		sql.append(" select r.id, r.username, r.password, r.serial_num, r.name, ");
		sql.append(" r.org_id, r.org_name, r.email, r.idcard, r.role_id, r.region_id  ");
		sql.append(" from fdss_user r ");
		sql.append(" where r.status = '0' and r.delete_flg = '0' ");
		if(!StringUntil.isNull(orgId)) {
			sql.append(" and r.org_id = :orgId ");
			paramMap.put("orgId", orgId);
		}
		return queryList(sql.toString(), paramMap, FdssUser.class);
	}
	
}
