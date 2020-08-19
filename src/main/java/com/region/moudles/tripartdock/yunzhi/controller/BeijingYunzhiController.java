package com.region.moudles.tripartdock.yunzhi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.region.moudles.common.controller.BaseController;
import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.system.domain.SysOrg;
import com.region.moudles.system.domain.SysPOCTResult;
import com.region.moudles.tripartdock.yunzhi.domain.FdssUser;
import com.region.moudles.tripartdock.yunzhi.service.BeijingYunzhiService;
import com.region.until.StringUntil;

/**
 * @ClassName: BeijingYunzhiController
 * @Description: 三方对接 提供机构、医生信息、患者信息以及核酸检测信息
 * @author Administrator
 * @date 2019年7月29日
 */
@RestController
@RequestMapping("/tripart/supply")
public class BeijingYunzhiController extends BaseController {

	@Inject
	private BeijingYunzhiService yunzhiService;
	
	//提供老家医的机构信息
	@RequestMapping("getOrgList")
	public Map<String, Object> getOrgList() {
		Map<String, Object> map = new HashMap<>();
		try {
			List<SysOrg> list = yunzhiService.getOrgList();
			map.put("orgjson", list);
			map.put("code", 200);
		}catch(Exception e) {
			e.printStackTrace();
			map.put("orgjson", new ArrayList<>());
			map.put("code", -1);
		}
		return map;
	}
	
	//提供老家医的医生信息
	@RequestMapping("getDoctorlList")
	public Map<String, Object> getDoctorlList() {
		Map<String, Object> map = new HashMap<>();
		try {
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			//参数
			String orgId = paramObj.containsKey("orgId") ? paramObj.getString("orgId") : "";
			List<FdssUser> list = yunzhiService.getDoctorlList(orgId);
			map.put("doctorjson", list);
			map.put("code", 200);
		}catch(Exception e) {
			e.printStackTrace();
			map.put("orgjson", new ArrayList<>());
			map.put("code", -1);
		}
		return map;
	}
	
	//提供老家医的患者信息
	@RequestMapping("getResidentList")
	public Map<String, Object> getResidentList() {
		Map<String, Object> map = new HashMap<>();
		try {
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			//参数
			String orgId = paramObj.containsKey("orgId") ? paramObj.getString("orgId") : "";
			String pageNo = paramObj.containsKey("pageNo") ? paramObj.getString("pageNo") : "1";
			String pageSize = paramObj.containsKey("pageSize") ? paramObj.getString("pageSize") : "10";
			PageModel page = new PageModel(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
			yunzhiService.getResidentPage(orgId, page);
			map.put("resjson", page.getList());
			map.put("totalPage", page.getTotalPage());
			map.put("count", page.getCount());
			map.put("code", 200);
		}catch(Exception e) {
			e.printStackTrace();
			map.put("resjson", new ArrayList<>());
			map.put("code", -1);
		}
		return map;
	}
	
	//获取核酸检测的结果并保存
	@RequestMapping("syncNucleinReslut")
	public JsonResult syncNucleinReslut() {
		try {
			String param = getParam(request);
			SysPOCTResult info = JSONObject.parseObject(param, SysPOCTResult.class);
			if(StringUntil.isNull(info.getOrgId())) {
				return jsonResult(null, 9001, "机构标识不能为空");
			}
			if(StringUntil.isNull(info.getResidentId())) {
				return jsonResult(null, 9001, "居民标识不能为空");
			}
			if(StringUntil.isNull(info.getCheckResult())) {
				return jsonResult(null, 9001, "测量结果不能为空");
			}
			if(info.getCheckTime() == null) {
				return jsonResult(null, 9001, "测量日期不能为空");
			}
			if(StringUntil.isNull(info.getProName())) {
				return jsonResult(null, 9001, "项目名称不能为空");
			}
			if(StringUntil.isNull(info.getProDesc())) {
				return jsonResult(null, 9001, "描述不能为空");
			}
			
			yunzhiService.syncNucleinReslut(info);
			return jsonResult();
		}catch(Exception e) {
			e.printStackTrace();
			return jsonResult(null, -1, "同步失败");
		}
	}
	

}
