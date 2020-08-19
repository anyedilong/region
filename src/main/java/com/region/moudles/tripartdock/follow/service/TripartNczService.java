package com.region.moudles.tripartdock.follow.service;

import java.util.List;
import java.util.Map;

import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.tripartdock.follow.domain.FollowNcz;
import com.region.moudles.tripartdock.follow.dto.RequestDto;

/**
 * @ClassName: TripartNczService
 * @Description: 三方对接 保存脑卒中随访信息
 * @author Administrator
 * @date 2019年8月2日
 */
public interface TripartNczService {

	//保存脑卒中随访信息
	Map<String, Object> saveNczSdInfo(List<FollowNcz> list) throws Exception;
	//查询脑卒中随访信息
	FollowNcz getNczInfo(String id) throws Exception;
	//查询脑卒中列表
	JsonResult getNczList(RequestDto request) throws Exception;
}
