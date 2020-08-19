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
import com.region.moudles.tripartdock.follow.domain.FollowLnrJkpg;
import com.region.moudles.tripartdock.follow.domain.FollowLnrZyygl;
import com.region.moudles.tripartdock.follow.service.TripartLnrService;

/**
 * @ClassName: TripartLnrController
 * @Description: 三方对接 保存老年人信息
 * @author Administrator
 * @date 2019年8月2日
 */
@RestController
@RequestMapping("${hispath}/follow")
public class TripartLnrController extends BaseController {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Inject
	private TripartLnrService lnrService;

	//保存老年人健康评估信息
	@RequestMapping("lnrJkpgSave")
	public JsonResult lnrJkpgSave() {
		String param = "";
		try {
			param = request.getParameter("param");
			List<FollowLnrJkpg> list = JSONObject.parseArray(param, FollowLnrJkpg.class);
			if (list != null && list.size() > 0) {
				Map<String, Object> map = lnrService.saveLnrJkpgInfo(list);
				if(map != null && map.size() > 0) {
					logger.error("老年人健康评估信息保存失败; 失败数据》》》》" + JSON.toJSONString(map) + "; ");
					return jsonResult(JSON.toJSONString(map), 10001, "保存失败");
				}
			}
			return jsonResult(null);
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("老年人健康评估保存失败; 失败数据》》》》"+param+"; 失败原因》》》》"+e.getMessage());
			return jsonResult(param, 10001, "系统错误"+e.getMessage());
		}
	}

	//查询老年人健康评估信息
	@RequestMapping("getJkpgInfo")
	public JsonResult getJkpgInfo() throws Exception {
		String param = getParam(request);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		FollowLnrJkpg follow = lnrService.getJkpgInfo(id);
		return jsonResult(follow);
	}

	//查询老年人健康评估列表
	@RequestMapping("getJkpgList")
	public JsonResult getJkpgList() throws Exception {
		String param = getParam(request);
		RequestDto request = JSONObject.parseObject(param, RequestDto.class);
		return lnrService.getJkpgList(request);
	}
	
	//保存老年人中医药管理相关信息
	@RequestMapping("lnrZyyglSave")
	public JsonResult lnrZyyglSave() {
		String param = "";
		try {
			param = request.getParameter("param");
			List<FollowLnrZyygl> list = JSONObject.parseArray(param, FollowLnrZyygl.class);
			if (list != null && list.size() > 0) {
				Map<String, Object> map = lnrService.saveLnrZyyglInfo(list);
				if(map != null && map.size() > 0) {
					logger.error("老年人中医药管理信息保存失败; 失败数据》》》》" + JSON.toJSONString(map) + "; ");
					return jsonResult(JSON.toJSONString(map), 10001, "保存失败");
				}
			}
			return jsonResult(null);
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("老年人中医药管理保存失败; 失败数据》》》》"+param+"; 失败原因》》》》"+e.getMessage());
			return jsonResult(param, 10001, "系统错误"+e.getMessage());
		}
	}

	//查询老年人中医药管理信息
	@RequestMapping("getZyyglInfo")
	public JsonResult getZyyglInfo() throws Exception {
		String param = getParam(request);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		FollowLnrZyygl follow = lnrService.getZyyglInfo(id);
		return jsonResult(follow);
	}

	//查询老年人中医药管理列表
	@RequestMapping("getZyyglList")
	public JsonResult getZyyglList() throws Exception {
		String param = getParam(request);
		RequestDto request = JSONObject.parseObject(param, RequestDto.class);
		return lnrService.getZyyglList(request);
	}
}
