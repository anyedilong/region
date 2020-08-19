package com.region.moudles.tripartdock.team.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.region.moudles.common.controller.BaseController;
import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.tripartdock.team.domain.SysTeam;
import com.region.moudles.tripartdock.team.service.TripartTeamService;

/**
 * @ClassName: TripartTeamController
 * @Description: 三方对接 保存团队项目相关信息
 * @author Administrator
 * @date 2019年7月25日
 */

@RestController
@RequestMapping("${hispath}/team")
public class TripartTeamController extends BaseController {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Inject
	private TripartTeamService teamService;

	/**
	 * @Description: 三方对接 保存项目相关信息
	 * @param @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("teamSave")
	public JsonResult teamSave() {
		String param = "";
		try {
			param = request.getParameter("param");
			List<SysTeam> list = JSONObject.parseArray(param, SysTeam.class);
			if (list != null && list.size() > 0) {
				Map<String, Object> map = teamService.saveTeamInfo(list);
				if(map != null && map.size() > 0) {
					logger.error("团队项目信息保存失败; 失败数据》》》》" + JSON.toJSONString(map) + "; ");
					return jsonResult(JSON.toJSONString(map), 10001, "保存失败");
				}
			}
			return jsonResult(null);
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("团队项目信息保存失败; 失败数据》》》》" + param + "; 失败原因》》》》" + e.getMessage());
			return jsonResult(param, 10001, "系统错误"+e.getMessage());
		}
	}

	
}
