package com.region.moudles.healthbrowser.service;

import java.util.List;

import com.region.moudles.healthbrowser.dto.FollowMenuDto;

public interface HealthSysService{

	//验证第三方登录健康居民浏览器的用户是否符合
	String checkUserLegal(String orgId, String authCode, String doctorCode, String doctorName) throws Exception;
  
	//验证第三方登录健康居民浏览器的用户是否符合
	List<FollowMenuDto> getfollowMenu(String sfzh) throws Exception;
}
