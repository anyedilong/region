package com.region.moudles.tripartdock.check.controller;

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
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.tripartdock.check.domain.Check;
import com.region.moudles.tripartdock.check.domain.Jkjc;
import com.region.moudles.tripartdock.check.domain.Jkwtb;
import com.region.moudles.tripartdock.check.domain.Jzbcs;
import com.region.moudles.tripartdock.check.domain.Jzs;
import com.region.moudles.tripartdock.check.domain.Pgzdjlb;
import com.region.moudles.tripartdock.check.domain.Shfs;
import com.region.moudles.tripartdock.check.domain.Xzjcjlb;
import com.region.moudles.tripartdock.check.domain.Ybzzb;
import com.region.moudles.tripartdock.check.domain.Yjjlb;
import com.region.moudles.tripartdock.check.domain.Zqgnb;
import com.region.moudles.tripartdock.check.domain.Zys;
import com.region.moudles.tripartdock.check.service.TripartCheckService;
import com.region.until.StringUntil;

/**
 * @ClassName: TripartCheckController
 * @Description: 三方对接 保存体检信息
 * @author Administrator
 * @date 2019年7月29日
 */
@RestController
@RequestMapping("${hispath}/check")
public class TripartCheckController extends BaseController {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Inject
	private TripartCheckService checkService;

	
	//保存体检相关信息
	@RequestMapping("checkSave")
	public JsonResult archiveSave() {
		String param = "";
		try {
			param = request.getParameter("param");
			List<Check> list = JSONObject.parseArray(param, Check.class);
			if (list != null && list.size() > 0) {
				Map<String, Object> map = checkService.saveCheckInfo(list);
				if(map != null && map.size() > 0) {
					logger.error("体检信息保存失败; 失败数据》》》》" + JSON.toJSONString(map) + "; ");
					return jsonResult(JSON.toJSONString(map), 10001, "保存失败");
				}
			}
			return jsonResult(null);
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("体检信息保存失败; 失败数据》》》》" + param + "; 失败原因》》》》" + e.getMessage());
			return jsonResult(param, 10001, "系统错误"+e.getMessage());
		}
	}
	
	// 获取最近两次体检的数据(惠民平台)
	@RequestMapping("getCompareCheckInfo")
	public JsonResult getCompareCheckInfo() {
		try {
			String sfzh = request.getParameter("sfzh");
			String jcrq = request.getParameter("jcrq");
			String pageSize = StringUntil.isNull(request.getParameter("pageSize")) ? "2" : request.getParameter("pageSize");
			String pageNo = StringUntil.isNull(request.getParameter("pageNo")) ? "1" : request.getParameter("pageNo");
			PageModel page = new PageModel(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
			Map<String, Object> resultMap = checkService.getCompareCheckInfo(sfzh, jcrq, page);
            return jsonResult(resultMap);
		}catch(Exception e) {
			e.printStackTrace();
			return jsonResult("", -1, "系统错误");
		}
	}
	
	//体检列表(健康浏览器)
	@RequestMapping("getCheckPage")
	public PageModel getCheckPage() {
		try {
			String jmId = request.getParameter("jmId");
			String pageSize = request.getParameter("pageSize");
			String pageNo = request.getParameter("pageNo");
			PageModel page = new PageModel(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
            checkService.getCheckPage(jmId, page);
            return page;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//体检详情(健康浏览器)
	@RequestMapping("queryCheckDetail")
	public Check queryCheckDetail() {
		try {
			String tjId = request.getParameter("tjId");
			return checkService.queryCheckDetail(tjId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//健康检查详情(健康浏览器)
	@RequestMapping("queryJkjcDetail")
	public Jkjc queryJkjcDetail() {
		try {
			String tjId = request.getParameter("tjId");
			return checkService.queryJkjcDetail(tjId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//健康问题详情(健康浏览器)
	@RequestMapping("queryJkwtbDetail")
	public Jkwtb queryJkwtbDetail() {
		try {
			String tjId = request.getParameter("tjId");
			return checkService.queryJkwtbDetail(tjId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//评估指导详情(健康浏览器)
	@RequestMapping("queryPgzdjlbDetail")
	public Pgzdjlb queryPgzdjlbDetail() {
		try {
			String tjId = request.getParameter("tjId");
			return checkService.queryPgzdjlbDetail(tjId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//生活方式详情(健康浏览器)
	@RequestMapping("queryShfsDetail")
	public Shfs queryShfsDetail() {
		try {
			String tjId = request.getParameter("tjId");
			return checkService.queryShfsDetail(tjId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//辅助检查详情(健康浏览器)
	@RequestMapping("queryXzjcjlbDetail")
	public Xzjcjlb queryXzjcjlbDetail() {
		try {
			String tjId = request.getParameter("tjId");
			return checkService.queryXzjcjlbDetail(tjId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//获取一般症状详情(健康浏览器)
	@RequestMapping("queryYbzzbDetail")
	public Ybzzb queryYbzzbDetail() {
		try {
			String tjId = request.getParameter("tjId");
			return checkService.queryYbzzbDetail(tjId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//脏器功能详情(健康浏览器)
	@RequestMapping("queryZqgnbDetail")
	public Zqgnb queryZqgnbDetail() {
		try {
			String tjId = request.getParameter("tjId");
			return checkService.queryZqgnbDetail(tjId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//家族病床史详情(健康浏览器)
	@RequestMapping("queryJzbcsDetail")
	public List<Jzbcs> queryJzbcsDetail() {
		try {
			String tjId = request.getParameter("tjId");
			return checkService.queryJzbcsDetail(tjId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//接种史详情(健康浏览器)
	@RequestMapping("queryJzsDetail")
	public List<Jzs> queryJzsDetail() {
		try {
			String tjId = request.getParameter("tjId");
			return checkService.queryJzsDetail(tjId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//药剂记录详情(健康浏览器)
	@RequestMapping("queryYjjlbDetail")
	public List<Yjjlb> queryYjjlbDetail() {
		try {
			String tjId = request.getParameter("tjId");
			return checkService.queryYjjlbDetail(tjId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//住院史详情(健康浏览器)
	@RequestMapping("queryZysDetail")
	public List<Zys> queryZysDetail() {
		try {
			String tjId = request.getParameter("tjId");
			return checkService.queryZysDetail(tjId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
