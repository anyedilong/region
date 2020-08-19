package com.region.moudles.his.authcode.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.region.moudles.common.controller.BaseController;
import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.his.authcode.domain.SysAuth;
import com.region.moudles.his.authcode.service.SysAuthService;
import com.region.until.StringUntil;
import com.region.until.UUIDUtil;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping("/authCode")
public class AuthCodeController extends BaseController {

    @Inject
    private SysAuthService sysAuthService;

    /**
     * 保存三方授权码
     * @return
     */
    @RequestMapping("saveauth")
    public JsonResult saveAuth(){
        try {
            String param=getParam(request);
            SysAuth sysAuth=JSONObject.parseObject(param, SysAuth.class);
            sysAuth.setAuthCode(UUIDUtil.getUUID());
            sysAuthService.save(sysAuth);
            return  jsonResult();
        }catch (Exception e){
            e.printStackTrace();
            return jsonResult(null,90001,"系统错误");
        }

    }

    /**
     * 修改授权状态
     * @return
     */
    @RequestMapping("updateAuth")
    public JsonResult updateAuth(){
        try {
            String param=getParam(request);
            JSONObject paramObj=JSONObject.parseObject(param);
            if(paramObj!=null){
                String id=paramObj.getString("id");
                String status=paramObj.getString("status");
                if(StringUntil.isNull(id)){
                    return  jsonResult(null,10001,"参数错误");
                }
                if(StringUntil.isNull(status)){
                    return  jsonResult(null,10001,"参数错误");
                }
                sysAuthService.updateAuth(id,status);
            }
            return  jsonResult();

        }catch (Exception e){
            e.printStackTrace();
            return  jsonResult(null,90001,"系统错误");
        }

    }

    /**
     *授权列表
     * @return
     */
    @RequestMapping("queryAuthPage")
    public JsonResult queryAuth(){
        try {
            String param=getParam(request);
            if(param != null){
            	SysAuth auth = JSONObject.parseObject(param, SysAuth.class);
                PageModel page=new PageModel();
                JSONObject paramObj=JSONObject.parseObject(param);
                JSONObject pageObj=paramObj.getJSONObject("page");
                if(pageObj!=null){
                    int pageNo=pageObj.getInteger("page_no");
                    int pageSize=pageObj.getInteger("page_size");
                    page=new PageModel(pageNo,pageSize);
                }
                sysAuthService.queryAuth(auth, page);
                return jsonResult(page);
            }else {
            	 return  jsonResult(null, 90001,"参数错误");
            }
        }catch (Exception e){
             return  jsonResult(null,90001,"系统错误");
        }

    }

    /**
	 * @Description 保存
	 * @return
	 * @author tz
	 */
	@RequestMapping("save")
	public JsonResult add() {
		try {
			// 获取参数
			String param = getParam(request);
			if (StringUtils.isNotBlank(param)) {
				SysAuth auth = JSON.parseObject(param, SysAuth.class);
				if(StringUntil.isNull(auth.getId())) {
					auth.setId(UUIDUtil.getUUID());
				}
				// 保存
				sysAuthService.save(auth);
				return jsonResult();
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}

	/**
	 * @Description 查看
	 * @return
	 * @author tz
	 */
	@RequestMapping("show")
	public JsonResult show() {
		try {
			// 获取参数
			String param = getParam(request);
			if (StringUtils.isNotBlank(param)) {
				JSONObject jsonObject = JSONObject.parseObject(param);
				String authId = jsonObject.getString("id");
				if (StringUntil.isNull(authId)) {
					return jsonResult(null, 10002, "授权码ID必填");
				}
				SysAuth auth = sysAuthService.get(authId);
				return jsonResult(auth);
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
	
	/**
	 * @Description 删除
	 * @return
	 * @author tz
	 */
	@RequestMapping("delete")
	public JsonResult delete() {
		try {
			// 获取参数
			String param = getParam(request);
			if (StringUtils.isNotBlank(param)) {
				JSONObject jsonObject = JSONObject.parseObject(param);
				String authId = jsonObject.getString("id");
				sysAuthService.delete(authId);
				return jsonResult();
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}


}
