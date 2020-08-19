package com.region.moudles.tripartdock.follow.service;

import java.util.List;
import java.util.Map;

import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.tripartdock.follow.domain.FollowJsb;
import com.region.moudles.tripartdock.follow.domain.FollowJsbJb;
import com.region.moudles.tripartdock.follow.dto.RequestDto;

/**
 * @ClassName: TripartJsbService
 * @Description: 三方对接 保存精神病信息
 * @author Administrator
 * @date 2019年8月1日
 */
public interface TripartJsbService {

	//保存精神病基本信息
	Map<String, Object> saveJsbJbInfo(List<FollowJsbJb> list) throws Exception;
	//查询精神病基本信息
	FollowJsbJb getJsbJbInfo(String id) throws Exception;
	//查询精神病基本信息列表
	JsonResult getJsbJbList(RequestDto request) throws Exception;
    
    //保存精神病随访信息
	Map<String, Object> saveJsbSfInfo(List<FollowJsb> list) throws Exception;
	//查询精神病随访信息
	FollowJsb getJsbSfInfo(String id) throws Exception;
	//查询精神病随访列表
	JsonResult getJsbSfList(RequestDto request) throws Exception;
    
}
