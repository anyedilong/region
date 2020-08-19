package com.region.moudles.tripartdock.sign.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.region.moudles.common.controller.BaseController;
import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.tripartdock.sign.domain.Sign;
import com.region.moudles.tripartdock.sign.dto.SignRecordDto;
import com.region.moudles.tripartdock.sign.service.TripartSignService;

/**
 * @ClassName: TripartSignController
 * @Description: 三方对接 保存签约的信息
 * @author Administrator
 * @date 2019年7月25日
 */

@RestController
@RequestMapping("${hispath}/sign")
public class TripartSignController extends BaseController {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Inject
	private TripartSignService signService;

	/**
	 * @Description: 三方对接 保存签约的信息
	 * @param @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("signSave")
	public JsonResult servicePackageSave() {
		String param = "";
		try {
			param = request.getParameter("param");
			List<Sign> list = JSONObject.parseArray(param, Sign.class);
			if (list != null && list.size() > 0) {
				Map<String, Object> map = signService.saveSignInfo(list);
				if(map != null && map.size() > 0) {
					logger.error("签约信息保存失败; 失败数据》》》》" + JSON.toJSONString(map) + "; ");
					return jsonResult(JSON.toJSONString(map), 10001, "保存失败");
				}
			}
			return jsonResult(null);
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("签约信息保存失败; 失败数据》》》》" + param + "; 失败原因》》》》" + e.getMessage());
			return jsonResult(param, 10001, "系统错误"+e.getMessage());
		}
	}

	//查询签约详情
	@RequestMapping("getSignInfo")
	public JsonResult getSignInfo() throws Exception {
		String param = getParam(request);
		JSONObject paramObj = JSONObject.parseObject(param);
		String jmId = paramObj.getString("jmId");
		if (StringUtils.isBlank(jmId)) {
			return jsonResult(null, 90001, "居民编号不能为空！");
		}
		Sign sign = signService.getSignInfo(jmId);
		return jsonResult(sign);
	}

	//获取履约服务列表
	@RequestMapping("getSignServiceList")
	public JsonResult getSignServiceList() throws Exception {
		String param = getParam(request);
		JSONObject paramObj = JSONObject.parseObject(param);
		String jmId = paramObj.getString("jmId");
		if (StringUtils.isBlank(jmId)) {
			return jsonResult(null, 90001, "居民编号不能为空！");
		}
		return jsonResult(signService.getSignServiceList(jmId));
	}
	
	//查询履约服务详情
	@RequestMapping("getSignServiceInfo")
	public JsonResult getSignServiceInfo() throws Exception {
		String param = getParam(request);
		JSONObject paramObj = JSONObject.parseObject(param);
		String signId = paramObj.getString("signId");
		String packeageId = paramObj.getString("packeageId");
		String projectId = paramObj.getString("projectId");
		if (StringUtils.isBlank(signId) || StringUtils.isBlank(packeageId) || StringUtils.isBlank(projectId)) {
			return jsonResult(null, 90001, "参数不能为空！");
		}
		List<SignRecordDto> list = signService.getSignServiceInfo(signId, packeageId, projectId);
		return jsonResult(list);
	}
}
