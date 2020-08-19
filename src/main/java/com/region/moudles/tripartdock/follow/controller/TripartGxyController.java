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
import com.region.moudles.tripartdock.follow.domain.FollowGxy;
import com.region.moudles.tripartdock.follow.domain.FollowGxyJb;
import com.region.moudles.tripartdock.follow.domain.FollowGxySz;
import com.region.moudles.tripartdock.follow.service.TripartGxyService;

/**
 * @ClassName: TripartGxyController
 * @Description: 三方对接 保存高血压信息
 * @author Administrator
 * @date 2019年7月31日
 */
@RestController
@RequestMapping("${hispath}/follow")
public class TripartGxyController extends BaseController {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Inject
	private TripartGxyService gxyService;

	//保存高血压基本信息
	@RequestMapping("gxyJbSave")
	public JsonResult gxyJbSave() {
		String param = "";
		try {
			param = request.getParameter("param");
			List<FollowGxyJb> list = JSONObject.parseArray(param, FollowGxyJb.class);
			if (list != null && list.size() > 0) {
				Map<String, Object> map = gxyService.saveGxyJbInfo(list);
				if(map != null && map.size() > 0) {
					logger.error("高血压基本信息保存失败; 失败数据》》》》" + JSON.toJSONString(map) + "; ");
					return jsonResult(JSON.toJSONString(map), 10001, "保存失败");
				}
			}
			return jsonResult(null);
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("高血压基本信息保存失败; 失败数据》》》》"+param+"; 失败原因》》》》"+e.getMessage());
			return jsonResult(param, 10001, "系统错误"+e.getMessage());
		}
	}

	//查询高血压基本信息
	@RequestMapping("getGxyJbInfo")
	public JsonResult getGxyJbInfo() throws Exception {
		String param = getParam(request);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		FollowGxyJb follow = gxyService.getGxyJbInfo(id);
		return jsonResult(follow);
	}
	
	//保存高血压随访信息
	@RequestMapping("gxySfSave")
	public JsonResult gxySfSave() {
		String param = "";
		try {
			param = request.getParameter("param");
			List<FollowGxy> list = JSONObject.parseArray(param, FollowGxy.class);
			if (list != null && list.size() > 0) {
				Map<String, Object> map = gxyService.saveGxySfInfo(list);
				if(map != null && map.size() > 0) {
					logger.error("高血压随访信息保存失败; 失败数据》》》》" + JSON.toJSONString(map) + "; ");
					return jsonResult(JSON.toJSONString(map), 10001, "保存失败");
				}
			}
			return jsonResult(null);
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("高血压随访信息保存失败; 失败数据》》》》"+param+"; 失败原因》》》》"+e.getMessage());
			return jsonResult(param, 10001, "系统错误"+e.getMessage());
		}
	}

	//查询高血压随访信息
	@RequestMapping("getGxySfInfo")
	public JsonResult getGxySfInfo() throws Exception {
		String param = getParam(request);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		FollowGxy follow = gxyService.getGxySfInfo(id);
		return jsonResult(follow);
	}

	//查询高血压随访列表
	@RequestMapping("getGxySfList")
	public JsonResult getGxySfList() throws Exception {
		String param = getParam(request);
		logger.info("查询高血压随访列表请求参数：" + param);
		RequestDto request = JSONObject.parseObject(param, RequestDto.class);
		JsonResult result =  gxyService.getGxySfList(request);
		logger.info("查询高血压随访列表返回：" + JSON.toJSONString(result));
		return result;
	}

	//保存高血压首诊信息
	@RequestMapping("gxySzSave")
	public JsonResult gxySzSave() {
		String param = "";
		try {
			param = request.getParameter("param");
			List<FollowGxySz> list = JSONObject.parseArray(param, FollowGxySz.class);
			if (list != null && list.size() > 0) {
				Map<String, Object> map = gxyService.saveGxySzInfo(list);
				if(map != null && map.size() > 0) {
					logger.error("高血压首诊信息保存失败; 失败数据》》》》" + JSON.toJSONString(map) + "; ");
					return jsonResult(JSON.toJSONString(map), 10001, "保存失败");
				}
			}
			return jsonResult(null);
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("高血压首诊信息保存失败; 失败数据》》》》"+param+"; 失败原因》》》》"+e.getMessage());
			return jsonResult(param, 10001, "系统错误"+e.getMessage());
		}
	}

	//查询高血压首诊信息
	@RequestMapping("getGxySzInfo")
	public JsonResult getGxySzInfo() throws Exception {
		String param = getParam(request);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		FollowGxySz follow = gxyService.getGxySzInfo(id);
		return jsonResult(follow);
	}

	//查询高血压首诊列表
	@RequestMapping("getGxySzList")
	public JsonResult getGxySzList() throws Exception {
		String param = getParam(request);
		RequestDto request = JSONObject.parseObject(param, RequestDto.class);
		return gxyService.getGxySzList(request);
	}
}
