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
import com.region.moudles.tripartdock.follow.domain.FollowYcfCh;
import com.region.moudles.tripartdock.follow.domain.FollowYcfCh42;
import com.region.moudles.tripartdock.follow.domain.FollowYcfCq;
import com.region.moudles.tripartdock.follow.domain.FollowYcfSc;
import com.region.moudles.tripartdock.follow.service.TripartYcfService;

/**
 * @ClassName: TripartYcfController
 * @Description: 三方对接 保存孕产妇信息
 * @author Administrator
 * @date 2019年8月1日
 */
@RestController
@RequestMapping("${hispath}/follow")
public class TripartYcfController extends BaseController {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Inject
	private TripartYcfService ycfService;

	//查询孕产妇列表
	@RequestMapping("getYcfList")
	public JsonResult getYcfList() throws Exception {
		String param = getParam(request);
		RequestDto request = JSONObject.parseObject(param, RequestDto.class);
		return ycfService.getYcfList(request);
	}

	//保存孕产妇产前首访的相关信息
	@RequestMapping("ycfCqSfSave")
	public JsonResult ycfCqSfSave() {
		String param = "";
		try {
			param = request.getParameter("param");
			String param1 = param.replaceAll("按位与", "&");
			List<FollowYcfSc> list = JSONObject.parseArray(param1, FollowYcfSc.class);
			if (list != null && list.size() > 0) {
				Map<String, Object> map = ycfService.saveYcfCqSfInfo(list);
				if(map != null && map.size() > 0) {
					logger.error("孕产妇产前首访随访相关信息保存失败; 失败数据》》》》" + JSON.toJSONString(map) + "; ");
					return jsonResult(JSON.toJSONString(map), 10001, "保存失败");
				}
			}
			return jsonResult(null);
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("孕产妇产前首访随访相关信息保存失败; 失败数据》》》》"+param+"; 失败原因》》》》"+e.getMessage());
			return jsonResult(param, 10001, "系统错误"+e.getMessage());
		}
	}

	//查询孕产妇产前首访详情
	@RequestMapping("getYcfscInfo")
	public JsonResult getYcfscInfo() throws Exception {
		String param = getParam(request);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		FollowYcfSc follow = ycfService.getYcfscInfo(id);
		return jsonResult(follow);
	}

	//查询孕产妇产前首访列表
	@RequestMapping("getYcfscList")
	public JsonResult getYcfscList() throws Exception {
		String param = getParam(request);
		RequestDto request = JSONObject.parseObject(param, RequestDto.class);
		return ycfService.getYcfscList(request);
	}
	
	//保存孕产妇产前2-5次随访信息
	@RequestMapping("ycfCqTwoToFiveSfSave")
	public JsonResult ycfCqTwoToFiveSfSave() {
		String param = "";
		try {
			param = request.getParameter("param");
			List<FollowYcfCq> list = JSONObject.parseArray(param, FollowYcfCq.class);
			if (list != null && list.size() > 0) {
				Map<String, Object> map = ycfService.saveCqTwoToFiveInfo(list);
				if(map != null && map.size() > 0) {
					logger.error("孕产妇2到5次随访信息信息保存失败; 失败数据》》》》" + JSON.toJSONString(map) + "; ");
					return jsonResult(JSON.toJSONString(map), 10001, "保存失败");
				}
			}
			return jsonResult(null);
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("孕产妇2到5次随访信息保存失败; 失败数据》》》》"+param+"; 失败原因》》》》"+e.getMessage());
			return jsonResult(param, 10001, "系统错误"+e.getMessage());
		}
	}

	//查询孕产妇产前2-5次详情
	@RequestMapping("getYcfcqInfo")
	public JsonResult getYcfcqInfo() throws Exception {
		String param = getParam(request);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		FollowYcfCq follow = ycfService.getYcfcqInfo(id);
		return jsonResult(follow);
	}

	//查询孕产妇产前2-5次列表
	@RequestMapping("getYcfcqList")
	public JsonResult getYcfcqList() throws Exception {
		String param = getParam(request);
		RequestDto request = JSONObject.parseObject(param, RequestDto.class);
		return ycfService.getYcfcqList(request);
	}

	//保存孕产妇产后随访信息
	@RequestMapping("ycfChSave")
	public JsonResult ycfChSave() {
		String param = "";
		try {
			param = request.getParameter("param");
			List<FollowYcfCh> list = JSONObject.parseArray(param, FollowYcfCh.class);
			if (list != null && list.size() > 0) {
				Map<String, Object> map = ycfService.saveYcfChInfo(list);
				if(map != null && map.size() > 0) {
					logger.error("孕产妇产后随访信息保存失败; 失败数据》》》》" + JSON.toJSONString(map) + "; ");
					return jsonResult(JSON.toJSONString(map), 10001, "保存失败");
				}
			}
			return jsonResult(null);
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("孕产妇产后随访信息保存失败; 失败数据》》》》"+param+"; 失败原因》》》》"+e.getMessage());
			return jsonResult(param, 10001, "系统错误"+e.getMessage());
		}
	}

	//查询孕产妇产后详情
	@RequestMapping("getYcfchInfo")
	public JsonResult getYcfchInfo() throws Exception {
		String param = getParam(request);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		FollowYcfCh follow = ycfService.getYcfchInfo(id);
		return jsonResult(follow);
	}

	//查询孕产妇产产后列表
	@RequestMapping("getYcfchList")
	public JsonResult getYcfchList() throws Exception {
		String param = getParam(request);
		RequestDto request = JSONObject.parseObject(param, RequestDto.class);
		return ycfService.getYcfchList(request);
	}
	
	//保存孕产妇产后42天随访信息
	@RequestMapping("ycfChFortyTwoSave")
	public JsonResult ycfChFortyTwoSave() {
		String param = "";
		try {
			param = request.getParameter("param");
			List<FollowYcfCh42> list = JSONObject.parseArray(param, FollowYcfCh42.class);
			if (list != null && list.size() > 0) {
				Map<String, Object> map = ycfService.saveYcfChFortyTwoInfo(list);
				if(map != null && map.size() > 0) {
					logger.error("孕产妇产后42天随访信息保存失败; 失败数据》》》》" + JSON.toJSONString(map) + "; ");
					return jsonResult(JSON.toJSONString(map), 10001, "保存失败");
				}
			}
			return jsonResult(null);
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("孕产妇产后42天随访信息保存失败; 失败数据》》》》"+param+"; 失败原因》》》》"+e.getMessage());
			return jsonResult(param, 10001, "系统错误"+e.getMessage());
		}
	}

	//查询孕产妇产后42天详情
	@RequestMapping("getYcfch42Info")
	public JsonResult getYcfch42Info() throws Exception {
		String param = getParam(request);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		FollowYcfCh42 follow = ycfService.getYcfch42Info(id);
		return jsonResult(follow);
	}

	//查询孕产妇产后42天列表
	@RequestMapping("getYcfch42List")
	public JsonResult getYcfch42List() throws Exception {
		String param = getParam(request);
		RequestDto request = JSONObject.parseObject(param, RequestDto.class);
		return ycfService.getYcfch42List(request);
	}
}
