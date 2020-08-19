package com.region.moudles.tripartdock.follow.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import com.region.moudles.tripartdock.follow.dto.RequestDto;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.region.moudles.common.controller.BaseController;
import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.tripartdock.follow.domain.FollowFjh;
import com.region.moudles.tripartdock.follow.domain.FollowFjhJb;
import com.region.moudles.tripartdock.follow.domain.FollowFjhrh;
import com.region.moudles.tripartdock.follow.service.TripartFjhService;

/**
 * @ClassName: TripartFjhController
 * @Description: 三方对接 保存肺结核信息
 * @author Administrator
 * @date 2019年8月1日
 */
@RestController
@RequestMapping("${hispath}/follow")
public class TripartFjhController extends BaseController {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Inject
	private TripartFjhService fjhService;

	//保存肺结核基本信息
	@RequestMapping("fjhJbSave")
	public JsonResult fjhJbSave() {
		String param = "";
		try {
			param = request.getParameter("param");
			List<FollowFjhJb> list = JSONObject.parseArray(param, FollowFjhJb.class);
			if (list != null && list.size() > 0) {
				Map<String, Object> map = fjhService.saveFjhJbInfo(list);
				if(map != null && map.size() > 0) {
					logger.error("肺结核信息保存失败; 失败数据》》》》" + JSON.toJSONString(map) + "; ");
					return jsonResult(JSON.toJSONString(map), 10001, "保存失败");
				}
			}
			return jsonResult(null);
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("肺结核基本信息保存失败; 失败数据》》》》"+param+"; 失败原因》》》》"+e.getMessage());
			return jsonResult(param, 10001, "系统错误"+e.getMessage());
		}
	}

	//查询肺结核基本信息
	@RequestMapping("getFjhJbInfo")
	public JsonResult getFjhJbInfo() throws Exception {
		String param = getParam(request);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		FollowFjhJb follow = fjhService.getFjhJbInfo(id);
		return jsonResult(follow);
	}
	
	//保存肺结核入户信息
	@RequestMapping("fjhRhSave")
	public JsonResult fjhRhSave() {
		String param = "";
		try {
			param = request.getParameter("param");
			List<FollowFjhrh> list = JSONObject.parseArray(param, FollowFjhrh.class);
			if (list != null && list.size() > 0) {
				Map<String, Object> map = fjhService.saveFjhRhInfo(list);
				if(map != null && map.size() > 0) {
					logger.error("肺结核入户信息保存失败; 失败数据》》》》" + JSON.toJSONString(map) + "; ");
					return jsonResult(JSON.toJSONString(map), 10001, "保存失败");
				}
			}
			return jsonResult(null);
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("肺结核入户信息保存失败; 失败数据》》》》"+param+"; 失败原因》》》》"+e.getMessage());
			return jsonResult(param, 10001, "系统错误"+e.getMessage());
		}
	}

	//查询肺结核入户详情
	@RequestMapping("getFjhRhInfo")
	public JsonResult getFjhRhInfo() throws Exception {
		String param = getParam(request);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		FollowFjhrh follow = fjhService.getFjhRhInfo(id);
		return jsonResult(follow);
	}

	//查询肺结核入户列表
	@RequestMapping("getFjhRhList")
	public JsonResult getFjhRhList() throws Exception {
		String param = getParam(request);
		RequestDto request = JSONObject.parseObject(param, RequestDto.class);
		return fjhService.getFjhRhList(request);
	}

	//保存肺结核随访信息
	@RequestMapping("fjhSfSave")
	public JsonResult fjhSfSave() {
		String param = "";
		try {
			param = request.getParameter("param");
			List<FollowFjh> list = JSONObject.parseArray(param, FollowFjh.class);
			if (list != null && list.size() > 0) {
				Map<String, Object> map = fjhService.saveFjhSfInfo(list);
				if(map != null && map.size() > 0) {
					logger.error("肺结核随访信息保存失败; 失败数据》》》》" + JSON.toJSONString(map) + "; ");
					return jsonResult(JSON.toJSONString(map), 10001, "保存失败");
				}
			}
			return jsonResult(null);
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("肺结核随访信息保存失败; 失败数据》》》》"+param+"; 失败原因》》》》"+e.getMessage());
			return jsonResult(param, 10001, "系统错误"+e.getMessage());
		}
	}

	//查询肺结核入户详情
	@RequestMapping("getFjhSfInfo")
	public JsonResult getFjhSfInfo() throws Exception {
		String param = getParam(request);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		FollowFjh follow = fjhService.getFjhSfInfo(id);
		return jsonResult(follow);
	}

	//查询肺结核入户列表
	@RequestMapping("getFjhSfList")
	public JsonResult getFjhSfList() throws Exception {
		String param = getParam(request);
		RequestDto request = JSONObject.parseObject(param, RequestDto.class);
		return fjhService.getFjhSfList(request);
	}
}
