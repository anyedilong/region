package com.region.moudles.tripartdock.follow.service;

import java.util.List;
import java.util.Map;

import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.tripartdock.follow.domain.FollowTnb;
import com.region.moudles.tripartdock.follow.dto.RequestDto;

/**
 * @ClassName: TripartTnbService
 * @Description: 三方对接 保存糖尿病信息
 * @author Administrator
 * @date 2019年7月31日
 */
public interface TripartTnbService {

	//保存糖尿病随访信息
	Map<String, Object> saveTnbInfo(List<FollowTnb> list) throws Exception;
	//查询糖尿病随访信息
	FollowTnb getTnbInfo(String id) throws Exception;
	//查询糖尿病列表
	JsonResult getTnbList(RequestDto request) throws Exception;
}
