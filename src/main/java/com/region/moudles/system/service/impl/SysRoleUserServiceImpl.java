package com.region.moudles.system.service.impl;

import javax.inject.Named;

import com.region.moudles.common.service.impl.BaseServiceImpl;
import com.region.moudles.system.dao.SysRoleUserDao;
import com.region.moudles.system.domain.SysMenuRole;
import com.region.moudles.system.service.SysRoleUserService;


@Named
public class SysRoleUserServiceImpl extends BaseServiceImpl<SysRoleUserDao, SysMenuRole> implements SysRoleUserService {

		
	@Override
	public String showAuthorize(String userId) {
		return dao.showAuthorize(userId);
	}
	
	@Override
	public void batchDelRoleByUserId(String userId) {
		dao.batchDelRoleByUserId(userId);
	}

	@Override
	public void batchDelUserByRole(String roleId) {
		dao.batchDelUserByRole(roleId);
	}
}
