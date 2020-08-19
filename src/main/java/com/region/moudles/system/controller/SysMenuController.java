package com.region.moudles.system.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.region.moudles.common.controller.BaseController;
import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.system.domain.SysMenu;
import com.region.moudles.system.service.SysMenuRoleService;
import com.region.moudles.system.service.SysMenuService;
import com.region.until.StringUntil;
import com.region.until.SysUtil;
import com.region.until.UUIDUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

import java.util.List;


@RestController
@RequestMapping("${familypath}/menu")
public class SysMenuController extends BaseController {

     @Inject
     private SysMenuService sysMenuService;
     @Autowired
 	 private SysMenuRoleService sysMenuRoleService;
    
    /**
     * 	菜单树形查询
     */
    @RequestMapping("getmenutree")
     public JsonResult getMenuTree(){
         try{
            List<SysMenu> list=sysMenuService.getMenuTree();
            return  jsonResult(list);
         }catch (Exception e){
             e.printStackTrace();
             return  jsonResult(null,10001,"系统错误");
         }
}
    /**
     * 	菜单列表查询
     */
    @RequestMapping("querymenu")
    public JsonResult queryMenu(){
	     try {
	        String param=getParam(request);
	        JSONObject paramObj=JSONObject.parseObject(param);
	        if(paramObj!=null){
	            PageModel page=new PageModel();
	            JSONObject pageObj=paramObj.getJSONObject("page");
	            if(pageObj!=null){
	                int pageNo=pageObj.getInteger("page_no");
	                int pageSize=pageObj.getInteger("page_size");
	                page=new PageModel(pageNo,pageSize);
	            }
	            SysMenu sysmenu = JSON.parseObject(param, SysMenu.class);
	            String parentId = sysmenu.getParentId();
	    		if (StringUntil.isNull(parentId)) {
	    			sysmenu.setParentId("0");
	    		}
	
	            sysMenuService.queryMenuPage(sysmenu, page);
	            return  jsonResult(page);
	        }else{
	            return  jsonResult(null,10001,"参数错误");
	        }
        }catch (Exception e){
            e.printStackTrace();
            return  jsonResult(null,10001,"系统错误");
        }

    }
    /**
     * 	获取登录这的菜单导航
     */
    @RequestMapping("getUserMenuTree")
    public JsonResult getUserMenuTree(){
		try{
		    return jsonResult(SysUtil.sysUser(request, response).getMenuNav());
		}catch (Exception e){
		    e.printStackTrace();
		    return  jsonResult(null,10001,"系统错误");
		}
    }
    /**
     *	 保存菜单
     */
    @RequestMapping("save")
    public JsonResult saveMenu(){
        try {
             String param=getParam(request);
             SysMenu sysMenu=JSONObject.parseObject(param, SysMenu.class);
             if(StringUntil.isNull(sysMenu.getId())) {
            	 sysMenu.setId(UUIDUtil.getUUID());
             }
             if(StringUntil.isNull(sysMenu.getParentId())) {
            	 sysMenu.setParentId("0");
             }
             sysMenu.setStatus("1");
             sysMenuService.save(sysMenu);
            return  jsonResult();
        }catch (Exception e){
             e.printStackTrace();
            return  jsonResult(null,10001,"系统错误");
        }
    }
    /**
     *  	修改菜单状态
     */
    @RequestMapping("updatemenu")
    public JsonResult updateMenu(){
        String param=getParam(request);
        JSONObject paramObj=JSONObject.parseObject(param);
        if(paramObj!=null){
               String id=paramObj.getString("id");
               String status=paramObj.getString("status");
               sysMenuService.updateMenu(id,status);
        }
        return jsonResult();
    }
    /**
     *	 菜单详情
     */
    @RequestMapping("show")
    public JsonResult getMenu(){
        try {

        String param=getParam(request);
        JSONObject paramObj=JSONObject.parseObject(param);
        if(paramObj!=null){
              String id=paramObj.getString("id");
              if(StringUntil.isNull(id)){
                  return  jsonResult(null,10001,"参数错误");
              }
               SysMenu sysMenu=sysMenuService.get(id);
              return  jsonResult(sysMenu);
        }else{
            return  jsonResult(null,10001,"参数错误");
        }
        }catch (Exception e){
            e.printStackTrace();
            return  jsonResult(null,10001,"系统错误");
        }

    }
    
    /**
	 *  删除
	 */
	@RequestMapping("delete")
	@ResponseBody
	public JsonResult delete() {
		try {
			String param = getParam(request);
			JSONObject paramObj = JSON.parseObject(param);
			if (paramObj != null) {
				String id = paramObj.getString("id");
				sysMenuRoleService.batchDelRoleByMenu(id);
				sysMenuService.delete(id);
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
			return jsonResult();
		}catch(Exception e) {
			e.printStackTrace();
			return jsonResult(null,10001,"系统错误");
		}
	}
}
