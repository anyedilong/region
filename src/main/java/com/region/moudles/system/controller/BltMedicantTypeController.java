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
import com.region.moudles.system.domain.BltMedicantType;
import com.region.moudles.system.dto.MedicantTypeDto;
import com.region.moudles.system.service.BltMedicantTypeService;
import com.region.until.StringUntil;
import com.region.until.SysUtil;
import com.region.until.UUIDUtil;


@RestController
@RequestMapping("${familypath}/medicanttype")
public class BltMedicantTypeController extends BaseController {

	@Autowired
	private BltMedicantTypeService medicantTypeService;

	/**
	 * @Description 列表数据(分页)
	 * @return
	 * @author tz
	 */
	@RequestMapping("getMedicantTypePage")
	public JsonResult getMedicantTypePage() {
		try {
			String param = getParam(request);
    		if(StringUtils.isNoneBlank(param)){
    			MedicantTypeDto medicantType = JSON.parseObject(param, MedicantTypeDto.class);
    			if (medicantType == null) {
    				medicantType = new MedicantTypeDto();
    			}
				// 获取当前用户所属的组织机构
				String orgId = SysUtil.sysUser(request,response).getOrgId();// 机构ID
				medicantType.setOrgId(orgId);
				JSONObject obj = JSON.parseObject(param).getJSONObject("page");
				PageModel page = new PageModel(obj.getInteger("pageNum"), obj.getInteger("pageSize"));
	    		medicantTypeService.getMedicantTypePage(medicantType, page);
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
	@RequestMapping("getMedicantTypeList")
	public JsonResult getMedicantTypeList() {
		try {
			String param = getParam(request);
    		if(StringUtils.isNoneBlank(param)){
    			MedicantTypeDto medicantType = JSON.parseObject(param, MedicantTypeDto.class);
    			if (medicantType == null) {
    				medicantType = new MedicantTypeDto();
    			}
				// 获取当前用户所属的组织机构
				String orgId = "";
				//String orgId = SysUtil.sysUser(request,response).getOrgId();// 机构ID
				medicantType.setOrgId(orgId);
				
				List<MedicantTypeDto> list = medicantTypeService.getMedicantTypeList(medicantType);
				return jsonResult(list);
    		}else {
				return jsonResult(null, 10001, "参数错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}

	/**
	 * @Description 药品保存
	 * @return
	 * @author tz
	 */
	@RequestMapping("save")
	public JsonResult add() {
		try {
			// 获取参数
			String param = getParam(request);
			if (StringUtils.isNotBlank(param)) {
				BltMedicantType medicantType = JSON.parseObject(param, BltMedicantType.class);
				// 获取当前用户所属的组织机构
//				String orgId = "";
				String userId = "";
				//String orgId = SysUtil.sysUser(request, response).getOrgId();
				//String userId = SysUtil.sysUser(request, response).getUserId()
				if(StringUntil.isNull(medicantType.getId())) {
					medicantType.setId(UUIDUtil.getUUID());
				}
				medicantType.setUpdateTime(new Date());
				medicantType.setUpdateUser(userId);
				medicantType.setStatus("0");
				// 保存
				medicantTypeService.save(medicantType);
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
	 * @Description 药品查看
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
				String medId = jsonObject.getString("id");
				if (StringUntil.isNull(medId)) {
					return jsonResult(null, 10002, "药品ID必填");
				}
				BltMedicantType medicantType = medicantTypeService.get(medId);
				return jsonResult(medicantType);
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
	
	/**
	 * @Description 药品删除
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
				String medId = jsonObject.getString("id");
				medicantTypeService.delete(medId);
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
