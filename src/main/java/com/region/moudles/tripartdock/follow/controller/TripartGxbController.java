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
import com.region.moudles.tripartdock.follow.domain.FollowGxb;
import com.region.moudles.tripartdock.follow.service.TripartGxbService;

/**
 * @ClassName: TripartGxbController
 * @Description: 三方对接 保存冠心病信息
 * @author Administrator
 * @date 2019年8月2日
 */
@RestController
@RequestMapping("${hispath}/follow")
public class TripartGxbController extends BaseController {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Inject
	private TripartGxbService gxbService;

	//保存冠心病信息
	@RequestMapping("gxbSave")
	public JsonResult gxbSave() {
		String param = "";
		try {
			param = request.getParameter("param");
			List<FollowGxb> list = JSONObject.parseArray(param, FollowGxb.class);
			if (list != null && list.size() > 0) {
				Map<String, Object> map = gxbService.saveGxbSfInfo(list);
				if(map != null && map.size() > 0) {
					logger.error("冠心病信息保存失败; 失败数据》》》》" + JSON.toJSONString(map) + "; ");
					return jsonResult(JSON.toJSONString(map), 10001, "保存失败");
				}
			}
			return jsonResult(null);
		}catch(Exception e) {
			//e.printStackTrace();
			logger.error("冠心病保存失败; 失败数据》》》》"+param+"; 失败原因》》》》"+e.getMessage());
			return jsonResult(param, 10001, "系统错误:"+e.getMessage());
		}
	}

	//查询冠心病随访信息
	@RequestMapping("getGxbSfInfo")
	public JsonResult getGxbSfInfo() throws Exception {
		String param = getParam(request);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		FollowGxb follow = gxbService.getGxbSfInfo(id);
		return jsonResult(follow);
	}

	//查询冠心病随访列表
	@RequestMapping("getGxbSfList")
	public JsonResult getGxbSfList() throws Exception {
		String param = getParam(request);
		RequestDto request = JSONObject.parseObject(param, RequestDto.class);
		return gxbService.getGxbSfList(request);
	}
}
