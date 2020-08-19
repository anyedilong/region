package com.region.moudles.system.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.common.service.impl.BaseServiceImpl;
import com.region.moudles.common.utils.cache.UserCache;
import com.region.moudles.system.dao.SysRoleUserDao;
import com.region.moudles.system.dao.SysUserDao;
import com.region.moudles.system.domain.SysRoleUser;
import com.region.moudles.system.domain.SysUser;
import com.region.moudles.system.service.SysUserService;
import com.region.until.StringUntil;
import com.region.until.UUIDUtil;
import com.region.until.encode.Md5Encrypt;

@Named
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUser> implements SysUserService{

	@Inject
	private SysRoleUserDao sysRoleUserDao;
	
	@Override
	public List<SysUser> getUserList(SysUser sysUser) {
		return dao.getUserList(sysUser);
	}

	@Override
	public void getUserPage(SysUser sysUser, PageModel page) {
		 dao.getUserPage(sysUser, page);
	}

	@Override
	public void saveUserInfo(SysUser sysUser)throws Exception {
		
		SysUser user = dao.getUserByUserName(sysUser.getUsername());
		if(user != null && StringUntil.isNull(sysUser.getId())) {
			throw new Exception("账号已被占用！！！");
		}
		//判断是否时新增或是编辑
		if(StringUntil.isNull(sysUser.getId())) {
			sysUser.setId(UUIDUtil.getUUID());
			String password = "123456";
			if(!StringUntil.isNull(sysUser.getPassword())) {
				password = sysUser.getPassword();
			}
			sysUser.setPassword(Md5Encrypt.getMD5Code(password));
		}
		sysUser.setSecurityToken(UUIDUtil.getUUID());
		sysUser.setCreateTime(new Date());
		sysUser.setCreateUser("");
		sysUser.setStatus("1");
		dao.save(sysUser);
		sysRoleUserDao.batchDelRoleByUserId(sysUser.getId());
		//保存用户和角色的关系
		List<String> roleIds = Arrays.asList(sysUser.getRoleIds().split(","));
		List<SysRoleUser> list = new ArrayList<>();
		for(String roleId : roleIds) {
			SysRoleUser info = new SysRoleUser();
			info.setId(UUIDUtil.getUUID());
			info.setRoleId(roleId);
			info.setUserId(sysUser.getId());
			list.add(info);
		}
		sysRoleUserDao.batchSaveRoleUser(list);
	}
	
	@Override
	public SysUser getUserByUserName(String userName)throws Exception {
		return dao.getUserByUserName(userName);
	}
	
	@Override
	public UserCache getUserInfoByName(String userName)throws Exception {
		return dao.getUserInfoByName(userName);
	}

}
