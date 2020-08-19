package com.region.moudles.tripartdock.follow.service;

import java.util.List;
import java.util.Map;

import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.tripartdock.follow.domain.FollowFjh;
import com.region.moudles.tripartdock.follow.domain.FollowFjhJb;
import com.region.moudles.tripartdock.follow.domain.FollowFjhrh;
import com.region.moudles.tripartdock.follow.dto.RequestDto;

/**
 * @ClassName: TripartFjhService
 * @Description: 三方对接 保存肺结核信息
 * @author Administrator
 * @date 2019年8月1日
 */
public interface TripartFjhService {

	//保存肺结核基本信息
	Map<String, Object> saveFjhJbInfo(List<FollowFjhJb> list) throws Exception;
	//查询肺结核基本信息
	FollowFjhJb getFjhJbInfo(String id) throws Exception;
    
    //保存肺结核入户信息
	Map<String, Object> saveFjhRhInfo(List<FollowFjhrh> list) throws Exception;
	//查询肺结核入户信息
	FollowFjhrh getFjhRhInfo(String id) throws Exception;
	//查询肺结核入户列表
	JsonResult getFjhRhList(RequestDto request) throws Exception;
    
    //保存肺结核随访信息
	Map<String, Object> saveFjhSfInfo(List<FollowFjh> list) throws Exception;
	//查询肺结核随访信息
	FollowFjh getFjhSfInfo(String id) throws Exception;
	//查询肺结核随访列表
	JsonResult getFjhSfList(RequestDto request) throws Exception;
}
