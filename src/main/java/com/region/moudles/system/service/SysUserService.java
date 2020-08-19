package com.region.moudles.system.service;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.common.service.BaseService;
import com.region.moudles.common.utils.cache.UserCache;
import com.region.moudles.system.domain.SysUser;

import java.util.List;


public interface SysUserService extends BaseService<SysUser>{

	//用户列表
    List<SysUser> getUserList(SysUser sysUser);
    //用户列表(分页)
    void getUserPage(SysUser sysUser, PageModel page);
    //保存用户信息
    void saveUserInfo(SysUser sysUser)throws Exception;
    //根据用户名查询用户信息
    SysUser getUserByUserName(String userName)throws Exception;
    //根据用户名和授权码查询用户信息
    UserCache getUserInfoByName(String userName)throws Exception;
}
