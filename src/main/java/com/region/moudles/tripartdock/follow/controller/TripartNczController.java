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
import com.region.moudles.tripartdock.follow.domain.FollowNcz;
import com.region.moudles.tripartdock.follow.service.TripartNczService;

/**
 * @ClassName: TripartNczController
 * @Description: 三方对接 保存脑卒中随访信息
 * @author Administrator
 * @date 2019年8月2日
 */
@RestController
@RequestMapping("${hispath}/follow")
public class TripartNczController extends BaseController {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Inject
	private TripartNczService nczService;

	//保存脑卒中随访信息
	@RequestMapping("nczSave")
	public JsonResult nczSave() {
		String param = "";
		try {
			param = request.getParameter("param");
			List<FollowNcz> list = JSONObject.parseArray(param, FollowNcz.class);
			if (list != null && list.size() > 0) {
				Map<String, Object> map = nczService.saveNczSdInfo(list);
				if(map != null && map.size() > 0) {
					logger.error("脑卒中随访信息保存失败; 失败数据》》》》" + JSON.toJSONString(map) + "; ");
					return jsonResult(JSON.toJSONString(map), 10001, "保存失败");
				}
			}
			return jsonResult(null);
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("脑卒中随访信息保存失败; 失败数据》》》》"+param+"; 失败原因》》》》"+e.getMessage());
			return jsonResult(param, 10001, "系统错误"+e.getMessage());
		}
	}

	//查询脑卒中信息
	@RequestMapping("getNczInfo")
	public JsonResult getNczInfo() throws Exception {
		String param = getParam(request);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		FollowNcz follow = nczService.getNczInfo(id);
		return jsonResult(follow);
	}

	//查询脑卒中列表
	@RequestMapping("getNczList")
	public JsonResult getNczList() throws Exception {
		String param = getParam(request);
		RequestDto request = JSONObject.parseObject(param, RequestDto.class);
		return nczService.getNczList(request);
	}
}
