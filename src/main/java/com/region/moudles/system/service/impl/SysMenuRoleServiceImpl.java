package com.region.moudles.system.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import com.region.moudles.common.service.impl.BaseServiceImpl;
import com.region.moudles.system.dao.SysMenuDao;
import com.region.moudles.system.dao.SysMenuRoleDao;
import com.region.moudles.system.dao.SysRoleDao;
import com.region.moudles.system.domain.SysMenu;
import com.region.moudles.system.domain.SysMenuRole;
import com.region.moudles.system.service.SysMenuRoleService;
import com.region.until.StringUntil;
import com.region.until.UUIDUtil;


@Named
public class SysMenuRoleServiceImpl extends BaseServiceImpl<SysMenuRoleDao, SysMenuRole> implements SysMenuRoleService {

	@Inject
	private SysMenuRoleDao sysMenuRoleDao;
	@Inject
	private SysRoleDao sysRoleDao;
	@Inject
	private SysMenuDao sysMenuDao;
	

	@Override
	public void authorize(String roleId, List<Object> menuIds) throws Exception {
		//验证角色是否存在
		if(!sysRoleDao.exists(roleId)){
			throw new Exception("授权角色无效");
		}
		//批量删除角色
		sysMenuRoleDao.batchDelMenuByRole(roleId);
		Set<String> resultSet = new HashSet<>();
		for(Object menuId : menuIds) {
			//判断当前的菜单是否为根菜单
			SysMenu sysMenu = sysMenuDao.getMenuInfoById(menuId.toString());
			if(sysMenu != null) {
				resultSet.add(sysMenu.getId());
				getMenuIdsByChilds(menuId.toString(), resultSet);
			}
		}
		
		List<String> resutlList = new ArrayList<>(resultSet);
		List<SysMenuRole> roleFunList = new ArrayList<>();
		for (String menuId : resutlList) {
			SysMenuRole roleFun= new SysMenuRole();
			roleFun.setMenuId(menuId);
			roleFun.setRoleId(roleId);
			roleFun.setId(UUIDUtil.getUUID());
			roleFunList.add(roleFun);
		}
		sysMenuRoleDao.batchSaveRoleMenu(roleFunList);
	}
		
	private void getMenuIdsByChilds(String menuId, Set<String> resultSet) throws Exception{
		if(!StringUntil.isNull(menuId)) {
			SysMenu menu = sysMenuDao.getFarMenuInfoByChildId(menuId);
			if(menu != null) {
				resultSet.add(menu.getId());
				if(!"0".equals(menu.getParentId())) {
					getMenuIdsByChilds(menu.getId(), resultSet);
				}
			}
		}
	}
	
	
	@Override
	public List<String> showAuthorize(String roleId) {
		return sysMenuRoleDao.showAuthorize(roleId);
	}

	@Override
	public void batchDelMenuByRole(String roleId) {
		sysMenuRoleDao.batchDelMenuByRole(roleId);
	}

	@Override
	public void batchDelRoleByMenu(String menuId) {
		sysMenuRoleDao.batchDelRoleByMenu(menuId);
	}
}
