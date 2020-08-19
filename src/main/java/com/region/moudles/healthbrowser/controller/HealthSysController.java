package com.region.moudles.healthbrowser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.region.moudles.common.controller.BaseController;
import com.region.moudles.healthbrowser.dto.FollowMenuDto;
import com.region.moudles.healthbrowser.service.HealthSysService;
import com.region.moudles.system.domain.SysOrg;
import com.region.moudles.system.service.SysOrgService;

@RestController
@RequestMapping("/his/healthbrowser")
public class HealthSysController extends BaseController {

	@Autowired
	private HealthSysService healthSysService;
	@Autowired
	private SysOrgService sysOrgService;

	/**
	 * @Description: 验证第三方登录健康居民浏览器的用户是否符合
	 *  @param 
	 *  @return @return String 
	 *  @throws
	 */
	@RequestMapping("checkUserLegal")
	public String checkUserLegal() {
		try {
			String orgId = request.getParameter("orgId");
			String authCode = request.getParameter("authCode");
			String doctorCode = request.getParameter("doctorCode");
			String doctorName = request.getParameter("doctorName");
			return healthSysService.checkUserLegal(orgId, authCode, doctorCode, doctorName);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	/**
	 * @Description: 查询四五级的机构
	 *  @param 
	 *  @return @return JsonHisResult 
	 *  @throws
	 */
	@RequestMapping("queryOrgInfoList")
	public List<SysOrg> queryOrgInfoList() {
		try {
			return sysOrgService.queryOrgInfoList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @Description: 查询健康浏览器随访菜单
	 *  @param 
	 *  @return @return JsonHisResult 
	 *  @throws
	 */
	@RequestMapping("getfollowMenu")
	public List<FollowMenuDto> getfollowMenu() {
		try {
			String param = getParam(request);
			JSONObject paramObject = JSONObject.parseObject(param);
			String sfzh = paramObject.getString("sfzh");
			return healthSysService.getfollowMenu(sfzh);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
