package com.region.moudles.tripartdock.follow.service;

import java.util.List;
import java.util.Map;

import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.tripartdock.follow.domain.FollowGxy;
import com.region.moudles.tripartdock.follow.domain.FollowGxyJb;
import com.region.moudles.tripartdock.follow.domain.FollowGxySz;
import com.region.moudles.tripartdock.follow.dto.RequestDto;

/**
 * @ClassName: TripartGxyService
 * @Description: 三方对接 保存高血压信息
 * @author Administrator
 * @date 2019年7月31日
 */
public interface TripartGxyService {

	//保存高血压基本信息
	Map<String, Object> saveGxyJbInfo(List<FollowGxyJb> list) throws Exception;
	//查询高血压基本信息
	FollowGxyJb getGxyJbInfo(String id) throws Exception;
    
    //保存高血压随访信息
	Map<String, Object> saveGxySfInfo(List<FollowGxy> list) throws Exception;
	//查询高血压随访信息
	FollowGxy getGxySfInfo(String id) throws Exception;
	//查询高血压随访列表
	JsonResult getGxySfList(RequestDto request) throws Exception;
    
    //保存高血压首诊信息
	Map<String, Object> saveGxySzInfo(List<FollowGxySz> list) throws Exception;
	//查询高血压首诊信息
	FollowGxySz getGxySzInfo(String id) throws Exception;
	//查询高血压首诊列表
	JsonResult getGxySzList(RequestDto request) throws Exception;
    
}
