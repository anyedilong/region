package com.region.moudles.tripartdock.follow.service;

import java.util.List;
import java.util.Map;

import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.tripartdock.follow.domain.FollowGxb;
import com.region.moudles.tripartdock.follow.dto.RequestDto;

/**
 * @ClassName: TripartGxbService
 * @Description: 三方对接 保存冠心病随访
 * @author Administrator
 * @date 2019年8月2日
 */
public interface TripartGxbService {

	//保存冠心病随访信息
	Map<String, Object> saveGxbSfInfo(List<FollowGxb> list) throws Exception;
	//查询冠心病随访信息
	FollowGxb getGxbSfInfo(String id) throws Exception;
	//查询冠心病随访列表
	JsonResult getGxbSfList(RequestDto request) throws Exception;
    
}
