package com.region.moudles.system.controller;

import java.util.List;

import javax.inject.Inject;

import com.region.moudles.common.utils.cache.OrgCache;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.region.moudles.common.controller.BaseController;
import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.common.utils.cache.AreaCache;
import com.region.moudles.system.domain.SysArea;
import com.region.moudles.system.domain.SysOrg;
import com.region.moudles.system.service.SysAreaService;
import com.region.moudles.system.service.SysOrgService;
import com.region.until.StringUntil;
import com.region.until.UUIDUtil;
import com.region.until.cache.CacheEmun;
import com.region.until.cache.CacheUtils;


@RestController
@RequestMapping("${familypath}/org")
public class SysOrgController extends BaseController {

    @Inject
    private SysOrgService sysOrgService;
    @Inject
    private SysAreaService sysAreaService;
    
    /**
     * 机构列表
     * @return
     */
    @RequestMapping("queryOrgList")
    public JsonResult queryOrgList(){
        try {
            return  jsonResult(sysOrgService.queryOrgList());
        }catch (Exception e){
            e.printStackTrace();
            return  jsonResult(null,90001,"系统错误");
        }
    }
    
    /**
     * 机构列表(分业)
     * @return
     */
    @RequestMapping("queryOrgPage")
    public JsonResult queryOrgPage(){
        try {
        	
        	String param = getParam(request);
    		if(StringUtils.isNoneBlank(param)){
    			SysOrg sysOrg = JSON.parseObject(param, SysOrg.class);
    			if (sysOrg == null) {
    				sysOrg = new SysOrg();
    			}
				JSONObject obj = JSON.parseObject(param).getJSONObject("page");
				PageModel page = new PageModel(obj.getInteger("pageNum"), obj.getInteger("pageSize"));
				sysOrgService.queryOrgPage(sysOrg, page);
				return jsonResult(page);
    		}else {
				return jsonResult(null, 10001, "参数错误");
			}
        }catch (Exception e){
            e.printStackTrace();
            return  jsonResult(null,90001,"系统错误");
        }
    }
    
    /**
     * @Description: 保存机构
     * @param @return
     * @return JsonResult
     * @throws
     */
	@RequestMapping("save")
	public JsonResult save() {
		try {
			String param = getParam(request);
			SysOrg org = JSON.parseObject(param, SysOrg.class);
			if (org != null) {
				SysOrg orgInfo = sysOrgService.queryOrgByCode(org.getOrgCode());
				if(orgInfo != null && StringUntil.isNull(org.getId())) {
					return jsonResult("", 10001, "机构的编码已经存在！");
				}
				SysArea sysArea = sysAreaService.get(org.getAreaId());
				if(sysArea != null) {
					if("5".equals(sysArea.getAreaLevel())) {
						return jsonResult(org.getAreaId(), 10001, "上级机构已是最低等级！");
					}else {
						String orgLevel = Integer.parseInt(sysArea.getAreaLevel()) + 1 + "";
						org.setOrgLevel(orgLevel);
					}
				}else {
					return jsonResult(org.getAreaId(), 10001, "区划id找不到！");
				}
				if(StringUntil.isNull(org.getId())) {
					org.setId(UUIDUtil.getUUID());
				}
				sysOrgService.save(org);
				return jsonResult(org.getId());

			} else {
				return jsonResult(null, 10001, "参数错误！");
			}
		}catch (Exception e){
            e.printStackTrace();
            return  jsonResult(null,90001,"系统错误");
        }
	}

	/**
	 * @Description: 查看机构信息
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("show")
	public JsonResult show() {
		String param = getParam(request);
		JSONObject paramObj = JSON.parseObject(param);
		if (paramObj != null) {
			String id = paramObj.getString("id");//
			if (StringUntil.isNull(id)) {
				return jsonResult(null, 10002, "机构ID必填");
			}
			SysOrg org = sysOrgService.get(id);
			return jsonResult(org);
		} else {
			return jsonResult(null, 10001, "参数错误");
		}

	}

	/**
	 * @Description: 删除机构 
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("delete")
	public JsonResult delete() {
		String param = getParam(request);
		JSONObject paramObj = JSON.parseObject(param);
		if (paramObj != null) {
			String id = paramObj.getString("id");
			if (StringUntil.isNull(id)) {
				return jsonResult(null, 10002, "机构ID必填");
			}
			sysOrgService.delete(id);
		} else {
			return jsonResult(null, 10001, "参数错误");
		}
		return jsonResult();

	}

	/**
     * 区划列表
     * @return
     */
    @RequestMapping("queryAreaList")
    public JsonResult queryAreaList(){
        try {
        	List<AreaCache> areaList = CacheUtils.getArray(CacheEmun.SYS_CACHE, CacheUtils.SYS_AREA, AreaCache.class);
            return  jsonResult(areaList);
        }catch (Exception e){
            e.printStackTrace();
            return  jsonResult(null,90001,"系统错误");
        }
    }

    //根据ID获取下属机构
	@RequestMapping("getChildOrg")
	public List<OrgCache> getChildOrg(){
		String param = getParam(request);
		logger.info("根据ID获取下属机构请求参数：" + param);
		String orgId = JSONObject.parseObject(param).getString("orgId");
		List<OrgCache> list = sysOrgService.getChildOrg(orgId);
		logger.info("根据ID获取下属机构返回：" + JSON.toJSONString(list));
    	return list;

	}
}
