package com.region.moudles.system.dao;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.system.dao.repository.SysRoleUserRepository;
import com.region.moudles.system.domain.SysRoleUser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;


@Named
public class SysRoleUserDao extends BaseDao<SysRoleUserRepository, SysRoleUser>{

   @Inject
   private SysRoleUserRepository sysRoleUserRepository;

   /**
	 * @Description 批量删除角色授权信息
	 * @param roleId
	 * @author tz
	 */
	public void batchDelRoleByUserId(String userId) {
		sysRoleUserRepository.deleteByUserId(userId);
	}
	
	/**
	 * @Description 批量删除角色授权信息
	 * @param roleId
	 * @author tz
	 */
	public void batchDelUserByRole(String roleId) {
		sysRoleUserRepository.batchDelUserByRole(roleId);
	}
   
	/**
	 * @Description 批量保存授权信息
	 * @param roleMenuList
	 * @author tz
	 */
	public void batchSaveRoleUser(List<SysRoleUser> roleUserList) {
		sysRoleUserRepository.save(roleUserList);
	}
	/**
	 * @Description 查看授权信息
	 * @param roleIds
	 * @author tz
	 */
	public String showAuthorize(String userId) {
		String sql = " select listagg(to_char(a.role_id), ',') WITHIN GROUP(ORDER BY a.id) from sys_role_user a where a.user_id=:userId ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", userId);
		return queryList(sql, paramMap, String.class).get(0);
	}
}
