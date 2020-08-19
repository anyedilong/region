package com.region.moudles.system.dao;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.system.dao.repository.SysMenuRoleRepository;
import com.region.moudles.system.domain.SysMenuRole;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;


@Named
public class SysMenuRoleDao extends BaseDao<SysMenuRoleRepository, SysMenuRole>{

   @Inject
   private SysMenuRoleRepository sysMenuRoleRepository;

   /**
	 * @Description 批量删除角色授权信息
	 * @param roleId
	 * @author tz
	 */
	public void batchDelMenuByRole(String roleId) {
		sysMenuRoleRepository.deleteByRoleId(roleId);
	}
   
	/**
	 * @Description 批量删除菜单授权信息
	 * @param roleId
	 * @author tz
	 */
	public void batchDelRoleByMenu(String menuId) {
		sysMenuRoleRepository.deleteByMenuId(menuId);
	}
	
	/**
	 * @Description 批量保存授权信息
	 * @param roleMenuList
	 * @author tz
	 */
	public void batchSaveRoleMenu(List<SysMenuRole> roleMenuList) {
		sysMenuRoleRepository.save(roleMenuList);
	}
	/**
	 * @Description 查看授权信息
	 * @param roleIds
	 * @author tz
	 */
	public List<String> showAuthorize(String roleId) {
		String sql = " select menu_id from sys_menu_role where role_id=:roleId ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("roleId", roleId);
		return queryList(sql, paramMap, String.class);
	}
	
}
