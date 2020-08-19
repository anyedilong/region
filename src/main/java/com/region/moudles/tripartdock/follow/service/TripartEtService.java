package com.region.moudles.tripartdock.follow.service;

import java.util.List;
import java.util.Map;

import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.tripartdock.follow.domain.FollowEtJb;
import com.region.moudles.tripartdock.follow.domain.FollowEtSf1;
import com.region.moudles.tripartdock.follow.domain.FollowEtSf3;
import com.region.moudles.tripartdock.follow.domain.FollowEtSf6;
import com.region.moudles.tripartdock.follow.domain.FollowEtXse;
import com.region.moudles.tripartdock.follow.domain.FollowEtZyygl1;
import com.region.moudles.tripartdock.follow.domain.FollowEtZyygl3;
import com.region.moudles.tripartdock.follow.domain.FollowEtZyygl6;
import com.region.moudles.tripartdock.follow.dto.RequestDto;

/**
 * @ClassName: TripartEtService
 * @Description: 三方对接 保存儿童信息
 * @author Administrator
 * @date 2019年8月1日
 */
public interface TripartEtService {

	//查询儿童列表
	JsonResult getEtList(RequestDto request) throws Exception;

	// 保存儿童基本信息
	Map<String, Object> saveEtJbInfo(List<FollowEtJb> list) throws Exception;
	//查询儿童基本信息详情
	FollowEtJb getEtJbInfo(String id) throws Exception;
	//查询儿童基本信息列表
	JsonResult getEtJbList(RequestDto request) throws Exception;

	// 保存新生儿家庭访视
	Map<String, Object> savetXsebInfo(List<FollowEtXse> list) throws Exception;
	//查询新生儿详情
	FollowEtXse getXseInfo(String id) throws Exception;
	//查询新生儿列表
	JsonResult getXseList(RequestDto request) throws Exception;

	// 保存一岁以内的儿童随访
	Map<String, Object> saveEtOneYearSfInfo(List<FollowEtSf1> list) throws Exception;
	//查询一岁以内儿童详情
	FollowEtSf1 getEtOneInfo(String id) throws Exception;
	//查询一岁以内儿童列表
	JsonResult getEtOneList(RequestDto request) throws Exception;

	// 保存1-3岁以内儿童随访
	Map<String, Object> saveEtThreeYearInfo(List<FollowEtSf3> list) throws Exception;
	// 查询1-3岁儿童随访
	FollowEtSf3 getEtThreeInfo(String id) throws Exception;
	//查询1-3岁儿童列表
	JsonResult getEtThreeList(RequestDto request) throws Exception;

	// 保存3-6岁以内儿童随访
	Map<String, Object> saveEtSixYearInfo(List<FollowEtSf6> list) throws Exception;
	// 查询3-6岁儿童随访
	FollowEtSf6 getEtSixInfo(String id) throws Exception;
	//查询3-6岁儿童列表
	JsonResult getEtSixList(RequestDto request) throws Exception;

	// 保存1岁以内儿童中医随访
	Map<String, Object> saveEtOneYearZyInfo(List<FollowEtZyygl1> list) throws Exception;
	// 查询1岁儿童中医随访
	FollowEtZyygl1 getEtOneZy(String id) throws Exception;
	//查询1岁儿童中医列表
	JsonResult getEtOneZyList(RequestDto request) throws Exception;

	// 保存1-3岁以内儿童中医随访
	Map<String, Object> saveEtThreeYearZyInfo(List<FollowEtZyygl3> list) throws Exception;
	// 查询1-3岁儿童中医随访
	FollowEtZyygl3 getEtThreeZy(String id) throws Exception;
	//查询1岁儿童中医列表
	JsonResult getEtThreeZyList(RequestDto request) throws Exception;

	// 保存3-6岁以内儿童中医随访
	Map<String, Object> saveEtSixYearZyInfo(List<FollowEtZyygl6> list) throws Exception;
	// 查询3-6岁儿童中医随访
	FollowEtZyygl6 getEtSixZy(String id) throws Exception;
	//查询3-6岁儿童中医列表
	JsonResult getEtSixZyList(RequestDto request) throws Exception;

}
