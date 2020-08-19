package com.region.moudles.stats.controller;


import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.region.moudles.common.controller.BaseController;
import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.stats.dto.StatsPlatResultModel;
import com.region.moudles.stats.service.StatsPOCTService;
import com.region.until.StringUntil;
import com.region.until.SysUtil;

/**
 * @ClassName: StatsFamilySignController
 * @Description: 核酸检测数据获取入口
 * @author Administrator
 * @date 2019年6月20日
 */

@RestController
@RequestMapping("${familypath}/statspoct")
public class StatsPOCTController extends BaseController {

	@Inject
	private StatsPOCTService poctService;
	
	
	/**
	 * @Description: 获取核酸检验统计菜单中检验人次、结果呈阳性、结果呈阴性（echarts）
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getNucleinCheckStats")
    public JsonResult getNucleinCheckStats(){
    	try {
    		String param = getParam(request);
    		
            StatsPlatResultModel info = JSON.parseObject(param, StatsPlatResultModel.class);
            if (info == null) {
                info = new StatsPlatResultModel();
            }
            if(StringUntil.isNull(info.getOrgCode())) {
            	//获取当前登录人的机构code 
                String orgCode = SysUtil.sysUser(request, response).getOrg().getOrgCode();
                info.setOrgCode(orgCode);
            }
            return jsonResult(poctService.getNucleinCheckStats(info));
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 获取机构核酸检验统计（列表）
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getNucleinCheckTimesPage")
    public JsonResult getNucleinCheckTimesPage(){
    	try {
    		String param = getParam(request);
            StatsPlatResultModel info = JSON.parseObject(param, StatsPlatResultModel.class);
            if (info == null) {
                info = new StatsPlatResultModel();
            }
            if(StringUntil.isNull(info.getOrgCode())) {
            	//获取当前登录人的机构code 
            	String orgCode = SysUtil.sysUser(request, response).getOrg().getOrgCode();
                info.setOrgCode(orgCode);
            }
            JSONObject obj = JSON.parseObject(param);
			PageModel page = new PageModel(obj.getInteger("pageNum"), obj.getInteger("pageSize"));
			poctService.getJGLBTimesPage(info, page);
            return jsonResult(page);
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 获取核酸检验统计菜单中各检验结果（echarts）
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getNucleinCheckItemTimesStats")
    public JsonResult getNucleinCheckItemTimesStats(){
    	try {
    		String param = getParam(request);
            StatsPlatResultModel info = JSON.parseObject(param, StatsPlatResultModel.class);
            if (info == null) {
                info = new StatsPlatResultModel();
            }
            if(StringUntil.isNull(info.getOrgCode())) {
            	//获取当前登录人的机构code 
            	String orgCode = SysUtil.sysUser(request, response).getOrg().getOrgCode();
                info.setOrgCode(orgCode);
            }
    		return jsonResult(poctService.getJYItemTimesStats(info));
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
	
	/**
	 * @Description: 获取某个地方各检验结果占比（echarts）
	 * @param    
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getNucleinCheckItemPropStats")
    public JsonResult getNucleinCheckItemPropStats(){
    	try {
    		String param = getParam(request);
            StatsPlatResultModel info = JSON.parseObject(param, StatsPlatResultModel.class);
            if (info == null) {
                info = new StatsPlatResultModel();
            }
            if(StringUntil.isNull(info.getOrgCode())) {
            	//获取当前登录人的机构code 
            	String orgCode = SysUtil.sysUser(request, response).getOrg().getOrgCode();
                info.setOrgCode(orgCode);
            }
    		return jsonResult(poctService.getJYItemPropStats(info));
    	}catch(Exception e) {
    		e.printStackTrace();
    		return jsonResult(null, 9001, "获取失败");
    	}
    }
}