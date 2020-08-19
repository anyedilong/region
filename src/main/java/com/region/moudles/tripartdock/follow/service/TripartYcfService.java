package com.region.moudles.tripartdock.follow.service;

import java.util.List;
import java.util.Map;

import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.tripartdock.follow.domain.FollowYcfCh;
import com.region.moudles.tripartdock.follow.domain.FollowYcfCh42;
import com.region.moudles.tripartdock.follow.domain.FollowYcfCq;
import com.region.moudles.tripartdock.follow.domain.FollowYcfSc;
import com.region.moudles.tripartdock.follow.dto.RequestDto;

/**
 * @ClassName: TripartYcfService
 * @Description: 三方对接 保存孕产妇信息
 * @author Administrator
 * @date 2019年8月2日
 */
public interface TripartYcfService {

	JsonResult getYcfList(RequestDto request) throws Exception;

	//保存孕产妇产前首访的相关信息
	Map<String, Object> saveYcfCqSfInfo(List<FollowYcfSc> list) throws Exception;
	//查询孕产妇首次随访详情
	FollowYcfSc getYcfscInfo(String id) throws Exception;
	//查询孕产妇首次随访列表
	JsonResult getYcfscList(RequestDto request) throws Exception;
    
    //保存孕产妇产前2-5次随访信息
	Map<String, Object> saveCqTwoToFiveInfo(List<FollowYcfCq> list) throws Exception;
	//查询孕产妇产前2-5次随访详情
	FollowYcfCq getYcfcqInfo(String id) throws Exception;
	//查询孕产妇产前2-5次随访列表
	JsonResult getYcfcqList(RequestDto request) throws Exception;
    
    //保存孕产妇产后随访信息
	Map<String, Object> saveYcfChInfo(List<FollowYcfCh> list) throws Exception;
	//查询孕产妇产后随访详情
	FollowYcfCh getYcfchInfo(String id) throws Exception;
	//查询孕产妇产后随访列表
	JsonResult getYcfchList(RequestDto request) throws Exception;
    
    //保存孕产妇产后42天随访信息
	Map<String, Object> saveYcfChFortyTwoInfo(List<FollowYcfCh42> list) throws Exception;
	//查询孕产妇产后42天随访详情
	FollowYcfCh42 getYcfch42Info(String id) throws Exception;
	//查询孕产妇产后42天随访列表
	JsonResult getYcfch42List(RequestDto request) throws Exception;
    
}
