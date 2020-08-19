package com.region.moudles.system.dao;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.common.utils.cache.UserCache;
import com.region.moudles.system.dao.repository.SysUserRepository;
import com.region.moudles.system.domain.SysUser;
import com.region.until.StringUntil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

@Named
public class SysUserDao extends BaseDao<SysUserRepository, SysUser> {

	public List<SysUser> getUserList(SysUser sysUser){
	      StringBuffer sql = new StringBuffer();
	      sql.append(" select u.id, u.username, u.password, u.name, u.org_id, u.status ");
	      sql.append(" from sys_user u ");
	      sql.append(" join sys_org o on u.org_id = o.id ");
	      sql.append(" where u.status != '3' and o.status != '3' ");
	      if(!StringUntil.isNull(sysUser.getUsername())) {
	    	  sql.append(" and u.username like concat(concat('%', :username), '%') ");
	      }
	      if(!StringUntil.isNull(sysUser.getName())) {
	    	  sql.append(" and u.name like concat(concat('%', :name), '%') ");
	      }
	      if(!StringUntil.isNull(sysUser.getIsCludeSubFlg())) {
	    	  sql.append(" and o.org_code like concat((select org_code from sys_org where id = :orgId), '%') ");
	      }else {
	    	  sql.append(" and o.id = :orgId ");
	      }
	      return queryList(sql.toString(), sysUser, SysUser.class);

	 }

	 public void getUserPage(SysUser sysUser, PageModel page){
		  StringBuffer sql = new StringBuffer();
	      sql.append(" select u.id, u.username, u.password, u.name, u.org_id, u.status, ");
	      sql.append(" (select listagg(to_char(a.role_name), ',') WITHIN GROUP(ORDER BY a.create_time) ");
	      sql.append(" 		from sys_role a join sys_role_user b on a.id = b.role_id where b.user_id = u.id) as roleNames ");
	      sql.append(" from sys_user u ");
	      sql.append(" join sys_org o on u.org_id = o.id ");
	      sql.append(" where u.status != '3' and o.status != '3' ");
	      if(!StringUntil.isNull(sysUser.getUsername())) {
	    	  sql.append(" and u.username like concat(concat('%', :username), '%') ");
	      }
	      if(!StringUntil.isNull(sysUser.getName())) {
	    	  sql.append(" and u.name like concat(concat('%', :name), '%') ");
	      }
	      if(!StringUntil.isNull(sysUser.getIsCludeSubFlg())) {
	    	  sql.append(" and o.org_code like concat((select org_code from sys_org where id = :orgId), '%') ");
	      }else {
	    	  sql.append(" and o.id = :orgId ");
	      }
	      queryPage(sql.toString(), sysUser, page, SysUser.class);
	 } 
   
	 public SysUser getUserByUserName(String userName) {
		  StringBuffer sql = new StringBuffer();
	      sql.append(" select u.id, u.username, u.password, u.name, u.security_token, u.org_id, u.status ");
	      sql.append(" from sys_user u ");
	      sql.append(" where u.status != '3' and  u.username like concat(concat('%', :userName), '%') ");
	     
	      Map<String, Object> map = new HashMap<>();
	      map.put("userName", userName);
	      return queryOne(sql.toString(), map, SysUser.class);
	 }
	 
	 public UserCache getUserInfoByName(String userName) {
		  StringBuffer sql = new StringBuffer();
	      sql.append(" select u.id as userId, u.username as userName, u.name, u.org_id, u.security_token, u.status ");
	      sql.append(" from sys_user u ");
	      sql.append(" where u.status != '3' ");
	      sql.append(" and u.status != '3' and  u.username like concat(concat('%', :userName), '%') ");
	     
	      Map<String, Object> map = new HashMap<>();
	      map.put("userName", userName);
	      return queryOne(sql.toString(), map, UserCache.class);
	 }
}
