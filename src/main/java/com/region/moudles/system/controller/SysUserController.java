package com.region.moudles.system.controller;

import java.util.List;
import javax.inject.Inject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.region.moudles.common.controller.BaseController;
import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.common.utils.cache.UserCache;
import com.region.moudles.system.domain.SysUser;
import com.region.moudles.system.service.SysRoleUserService;
import com.region.moudles.system.service.SysUserService;
import com.region.until.StringUntil;
import com.region.until.SysUtil;


@RestController
@RequestMapping("${familypath}/user")
public class SysUserController extends BaseController {

    @Inject
    private SysUserService sysUserService;
    @Inject
    private SysRoleUserService sysRoleUserService;
   
    /**
     * @Description: 用户列表 
     * @param @return
     * @return JsonResult
     * @throws
     */
    @RequestMapping("getUserList")
    public JsonResult getUserList(){
    	try{
    		String param=getParam(request);
    		SysUser sysUser = JSON.parseObject(param, SysUser.class);
    		List<SysUser> list = sysUserService.getUserList(sysUser);
    		return jsonResult(list);
    	}catch (Exception e){
    		e.printStackTrace();
    		return jsonResult(null,10001,"系统错误");
	    }
	}
	   
    /**
     * @Description: 用户列表(分页)
     * @param @return
     * @return JsonResult
     * @throws
     */
    @RequestMapping("getUserPage")
    public JsonResult getUserPage(){
    	try {
    		String param=getParam(request);
    		JSONObject paramObj=JSONObject.parseObject(param);
    		if(paramObj != null){
    			PageModel page=new PageModel();
    			JSONObject pageObj=paramObj.getJSONObject("page");
    			if(pageObj != null){
    				int pageNo=pageObj.getInteger("page_no");
    				int pageSize=pageObj.getInteger("page_size");
    				page=new PageModel(pageNo, pageSize);
    			}
    			SysUser sysUser = JSON.parseObject(param, SysUser.class);
    			sysUserService.getUserPage(sysUser, page);
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
     * @Description: 用户保存
     * @param @return
     * @return JsonResult
     * @throws
     */
    @RequestMapping("save")
    public JsonResult saveMenu(){
        try {
			String param = getParam(request);
			if(param != null){
				SysUser sysUser = JSONObject.parseObject(param, SysUser.class);
				sysUserService.saveUserInfo(sysUser);
	            return jsonResult();
			}else{
	            return jsonResult(null,10001,"参数错误");
	        }
        }catch (Exception e){
             e.printStackTrace();
            return jsonResult(null,10001, e.getMessage());
        }
    }
    
    /**
     * @Description: 
     * @param @return 用户详情
     * @return JsonResult
     * @throws
     */
    @RequestMapping("show")
    public JsonResult getMenu(){
        try {
	        String param=getParam(request);
	        JSONObject paramObj=JSONObject.parseObject(param);
	        if(paramObj != null){
	            String id = paramObj.getString("id");
	            if(StringUntil.isNull(id)){
	                return  jsonResult(null,10001,"参数错误");
	            }
	            SysUser sysUser = sysUserService.get(id);
	            if(sysUser != null) {
	            	String roleIds = sysRoleUserService.showAuthorize(sysUser.getId());
	            	sysUser.setRoleIds(roleIds);
	            }
	            return jsonResult(sysUser);
	        }else{
	            return jsonResult(null,10001,"参数错误");
	        }
        }catch (Exception e){
            e.printStackTrace();
            return jsonResult(null,10001,"系统错误");
        }

    }
    
    /**
     * @Description: 用户删除
     * @param @return
     * @return JsonResult
     * @throws
     */
	@RequestMapping("delete")
	@ResponseBody
	public JsonResult delete() {
		try {
			String param = getParam(request);
			JSONObject paramObj = JSON.parseObject(param);
			if (paramObj != null) {
				String id = paramObj.getString("id");
				sysUserService.delete(id);
				sysRoleUserService.batchDelRoleByUserId(id);
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
			return jsonResult();
		}catch(Exception e) {
			e.printStackTrace();
			return jsonResult(null,10001,"系统错误");
		}
	}
	
	// 获取用户信息
	@RequestMapping("getUserInfo")
	public JsonResult getUserInfo() {
		try {
			UserCache sysUser = SysUtil.sysUser(request, response);
			return jsonResult(sysUser);
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}

}
