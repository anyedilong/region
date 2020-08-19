package com.region.moudles.system.controller;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.region.moudles.common.controller.BaseController;
import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.system.domain.SysRole;
import com.region.moudles.system.dto.SysRoleDto;
import com.region.moudles.system.service.SysMenuRoleService;
import com.region.moudles.system.service.SysRoleService;
import com.region.moudles.system.service.SysRoleUserService;
import com.region.until.StringUntil;
import com.region.until.SysUtil;
import com.region.until.UUIDUtil;

@RestController
@RequestMapping("${familypath}/role")
public class SysRoleController extends BaseController {

	@Autowired
	private SysRoleService roleService;
	@Autowired
	private SysMenuRoleService sysMenuRoleService;
	@Autowired
	private SysRoleUserService sysRoleUserService;

	/**
	 * @Description 列表数据(分页)
	 * @return
	 * @author tz
	 */
	@RequestMapping("getRolePage")
	public JsonResult getRolePage() {
		try {
			String param = getParam(request);
    		if(StringUtils.isNoneBlank(param)){
    			SysRoleDto sysRole = JSON.parseObject(param, SysRoleDto.class);
    			if (sysRole == null) {
    				sysRole = new SysRoleDto();
    			}
				// 获取当前用户所属的组织机构
				String orgId = SysUtil.sysUser(request,response).getOrgId();// 机构ID
				sysRole.setOrgId(orgId);
				// 所属机构
				//List<OrgCache> orgList = SysUtil.sysUser(request, response).getOrgList();
				//role.setOrgList(orgList);
				JSONObject obj = JSON.parseObject(param).getJSONObject("page");
				PageModel page = new PageModel(obj.getInteger("pageNum"), obj.getInteger("pageSize"));
				roleService.getRolePage(sysRole, page);
				return jsonResult(page);
    		}else {
				return jsonResult(null, 10001, "参数错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
	
	/**
	 * @Description 列表数据
	 * @return
	 * @author tz
	 */
	@RequestMapping("getRoleList")
	public JsonResult getRoleList() {
		try {
			SysRoleDto roleDto = new SysRoleDto();
			// 获取当前用户所属的组织机构
			String orgId = "";
			//String orgId = SysUtil.sysUser(request,response).getOrgId();// 机构ID
			roleDto.setOrgId(orgId);
			List<SysRoleDto> list = roleService.getRoleList(roleDto);
			return jsonResult(list);
		} catch (Exception e) {
			return jsonResult(null, 90001, e.getMessage());
		}
	}

	/**
	 * @Description 角色保存
	 * @return
	 * @author tz
	 */
	@RequestMapping("save")
	public JsonResult add() {
		try {
			// 获取参数
			String param = getParam(request);
			if (StringUtils.isNotBlank(param)) {
				SysRole sysRole = JSON.parseObject(param, SysRole.class);
				// 获取当前用户所属的组织机构
				String userId = "";
				sysRole.setCreateTime(new Date());
				sysRole.setCreateUser(userId);
				//根据角色名称和所属机构判断是否被占用
				SysRoleDto tempRole = roleService.queryRoleByNameOrgId(sysRole);
				if(tempRole != null && StringUntil.isNull(sysRole.getId())) {
					return jsonResult(null, 10001, "该机构下的角色名称已被占用！");
				}else {
					// 保存
					if (StringUntil.isNull(sysRole.getId())) {
						sysRole.setId(UUIDUtil.getUUID());
					}
					roleService.save(sysRole);
					return jsonResult();
				}
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}

	/**
	 * @Description 角色查看
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
				String roleId = jsonObject.getString("id");
				if (StringUntil.isNull(roleId)) {
					return jsonResult(null, 10002, "角色ID必填");
				}
				SysRole sysRole = roleService.get(roleId);
				return jsonResult(sysRole);
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
	
	/**
	 * @Description 角色删除
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
				String roleId = jsonObject.getString("id");
				if (StringUntil.isNull(roleId)) {
					return jsonResult(null, 10002, "角色ID必填");
				}
				roleService.delete(roleId);
				sysMenuRoleService.batchDelMenuByRole(roleId);
				sysRoleUserService.batchDelUserByRole(roleId);
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
	 * @Description 角色授权
	 * @return
	 * @author sen
	 * @Date 2017年3月7日 下午2:57:05
	 */
	@RequestMapping("authorize")
	public JsonResult authorize() {
		try {
			String param = getParam(request);
			JSONObject paramObj = JSON.parseObject(param);
			if (paramObj != null) {
				// 授权功能
				List<Object> menuIds = paramObj.getJSONArray("menuIds");
				// 角色ID
				String roleId = paramObj.getString("id");
				sysMenuRoleService.authorize(roleId, menuIds);
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
			return jsonResult();
		}catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}

	/**
	 * @Description 查询角色授权信息
	 * @return
	 * @author tz
	 */
	@RequestMapping("showAuthorize")
	public JsonResult showAuthorize() {
		try {
			String param = getParam(request);
			JSONObject paramObj = JSON.parseObject(param);
			if (paramObj != null) {
				// 角色ID
				String roleId = paramObj.getString("id");
				List<String> roleMenuList = sysMenuRoleService.showAuthorize(roleId);
				return jsonResult(roleMenuList);
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
		}catch(Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}

	
}
