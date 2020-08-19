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
import com.region.moudles.tripartdock.follow.domain.FollowJsb;
import com.region.moudles.tripartdock.follow.domain.FollowJsbJb;
import com.region.moudles.tripartdock.follow.service.TripartJsbService;

/**
 * @ClassName: TripartJsbController
 * @Description: 三方对接 保存精神病信息
 * @author Administrator
 * @date 2019年8月1日
 */
@RestController
@RequestMapping("${hispath}/follow")
public class TripartJsbController extends BaseController {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Inject
	private TripartJsbService jsbService;

	//保存精神病基本信息
	@RequestMapping("jsbJbSave")
	public JsonResult jsbJbSave() {
		String param = "";
		try {
			param = request.getParameter("param");
			List<FollowJsbJb> list = JSONObject.parseArray(param, FollowJsbJb.class);
			if (list != null && list.size() > 0) {
				Map<String, Object> map = jsbService.saveJsbJbInfo(list);
				if(map != null && map.size() > 0) {
					logger.error("精神病基本信息保存失败; 失败数据》》》》" + JSON.toJSONString(map) + "; ");
					return jsonResult(JSON.toJSONString(map), 10001, "保存失败");
				}
			}
			return jsonResult(null);
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("精神病基本信息保存失败; 失败数据》》》》"+param+"; 失败原因》》》》"+e.getMessage());
			return jsonResult(param, 10001, "系统错误"+e.getMessage());
		}
	}

	//查询精神病基本信息
	@RequestMapping("getJsbJbInfo")
	public JsonResult getJsbJbInfo() throws Exception {
		String param = getParam(request);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		FollowJsbJb follow = jsbService.getJsbJbInfo(id);
		return jsonResult(follow);
	}

	//查询精神病基本信息列表
	@RequestMapping("getJsbJbList")
	public JsonResult getJsbJbList() throws Exception {
		String param = getParam(request);
		RequestDto request = JSONObject.parseObject(param, RequestDto.class);
		return jsbService.getJsbJbList(request);
	}
	
	//保存精神病随访信息
	@RequestMapping("jsbSfSave")
	public JsonResult jsbSfSave() {
		String param = "";
		try {
			param = request.getParameter("param");
			List<FollowJsb> list = JSONObject.parseArray(param, FollowJsb.class);
			if (list != null && list.size() > 0) {
				Map<String, Object> map = jsbService.saveJsbSfInfo(list);
				if(map != null && map.size() > 0) {
					logger.error("精神病随访信息保存失败; 失败数据》》》》" + JSON.toJSONString(map) + "; ");
					return jsonResult(JSON.toJSONString(map), 10001, "保存失败");
				}
			}
			return jsonResult(null);
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("精神病随访信息保存失败; 失败数据》》》》"+param+"; 失败原因》》》》"+e.getMessage());
			return jsonResult(param, 10001, "系统错误"+e.getMessage());
		}
	}

	//查询精神病随访信息
	@RequestMapping("getJsbSfInfo")
	public JsonResult getJsbSfInfo() throws Exception {
		String param = getParam(request);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		FollowJsb follow = jsbService.getJsbSfInfo(id);
		return jsonResult(follow);
	}

	//查询精神病随访列表
	@RequestMapping("getJsbSfList")
	public JsonResult getJsbSfList() throws Exception {
		String param = getParam(request);
		RequestDto request = JSONObject.parseObject(param, RequestDto.class);
		return jsbService.getJsbSfList(request);
	}
}
