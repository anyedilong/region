package com.region.moudles.tripartdock.servicepackage.controller;

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
import com.region.moudles.tripartdock.servicepackage.domain.ServicePackage;
import com.region.moudles.tripartdock.servicepackage.domain.ServiceProject;
import com.region.moudles.tripartdock.servicepackage.service.TripartServicePackageService;

/**
 * @ClassName: TripartServicePackageController
 * @Description: 三方对接 保存服务包和服务项
 * @author Administrator
 * @date 2019年7月25日
 */

@RestController
@RequestMapping("${hispath}/servicepackage")
public class TripartServicePackageController extends BaseController {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Inject
	private TripartServicePackageService servicePackageService;

	/**
	 * @Description: 三方对接 保存服务包
	 * @param @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("servicePackageSave")
	public JsonResult servicePackageSave() {
		String param = "";
		try {
			param = request.getParameter("param");
			List<ServicePackage> list = JSONObject.parseArray(param, ServicePackage.class);
			if (list != null && list.size() > 0) {
				Map<String, Object> map = servicePackageService.saveServicePackageInfo(list);
				if(map != null && map.size() > 0) {
					logger.error("服务包信息保存失败; 失败数据》》》》" + JSON.toJSONString(map) + "; ");
					return jsonResult(JSON.toJSONString(map), 10001, "保存失败");
				}
			}
			return jsonResult(null);
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("服务包信息保存失败; 失败数据》》》》" + param + "; 失败原因》》》》" + e.getMessage());
			return jsonResult(param, 10001, "系统错误"+e.getMessage());
		}
	}

	/**
	 * @Description: 三方对接 保存服务项
	 * @param @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("serviceProjectSave")
	public JsonResult serviceProjectSave() {
		String param = "";
		try {
			param = request.getParameter("param");
			List<ServiceProject> list = JSONObject.parseArray(param, ServiceProject.class);
			if (list != null && list.size() > 0) {
				Map<String, Object> map = servicePackageService.saveServiceProjectInfo(list);
				if(map != null && map.size() > 0) {
					logger.error("服务项信息保存失败; 失败数据》》》》" + JSON.toJSONString(map) + "; ");
					return jsonResult(JSON.toJSONString(map), 10001, "保存失败");
				}
			}
			return jsonResult(null);
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("服务项信息保存失败; 失败数据》》》》" + param + "; 失败原因》》》》" + e.getMessage());
			return jsonResult(param, 10001, "系统错误"+e.getMessage());
		}
	}
}
