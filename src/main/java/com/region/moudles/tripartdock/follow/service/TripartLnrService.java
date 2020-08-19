package com.region.moudles.tripartdock.follow.service;

import java.util.List;
import java.util.Map;

import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.tripartdock.follow.domain.FollowLnrJkpg;
import com.region.moudles.tripartdock.follow.domain.FollowLnrZyygl;
import com.region.moudles.tripartdock.follow.dto.RequestDto;

/**
 * @ClassName: TripartLnrService
 * @Description: 三方对接 保存老年人信息
 * @author Administrator
 * @date 2019年8月2日
 */
public interface TripartLnrService {

	//保存老年人健康评估信息
	Map<String, Object> saveLnrJkpgInfo(List<FollowLnrJkpg> list) throws Exception;
	//查询老年人健康评估信息
	FollowLnrJkpg getJkpgInfo(String id) throws Exception;
	//查询老年人健康评估列表
	JsonResult getJkpgList(RequestDto request) throws Exception;
    
    //保存老年人中医药管理信息
	Map<String, Object> saveLnrZyyglInfo(List<FollowLnrZyygl> list) throws Exception;
	//查询老年人中医药管理信息
	FollowLnrZyygl getZyyglInfo(String id) throws Exception;
	//查询老年人中医药管理列表
	JsonResult getZyyglList(RequestDto request) throws Exception;
    
}
