package com.region.moudles.system.service;

import java.util.List;


public interface SysMenuRoleService{

	//角色授权
	void authorize(String roleId, List<Object> menuIds) throws Exception ;
	//查询角色授权信息
	List<String> showAuthorize(String roleId);
	
	void batchDelMenuByRole(String roleId);
	
	void batchDelRoleByMenu(String menuId);
}
