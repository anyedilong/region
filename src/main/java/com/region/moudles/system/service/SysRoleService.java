package com.region.moudles.system.service;

import java.util.List;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.common.service.BaseService;
import com.region.moudles.system.domain.SysRole;
import com.region.moudles.system.dto.SysRoleDto;


public interface SysRoleService extends BaseService<SysRole>{

	//获取角色列表(分页)
	void getRolePage(SysRoleDto entity, PageModel page);
	//获取角色列表
	List<SysRoleDto> getRoleList(SysRoleDto role);
	//根据角色名称和所属机构判断是否被占用
	SysRoleDto queryRoleByNameOrgId(SysRole sysRole);
	
}
