package com.region.moudles.system.service;



public interface SysRoleUserService{

	//查询用户授权信息
	String showAuthorize(String userId);
	
	void batchDelRoleByUserId(String userId);
	
	void batchDelUserByRole(String roleId);
}
