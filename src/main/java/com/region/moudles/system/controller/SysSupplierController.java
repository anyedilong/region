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
import com.region.moudles.system.domain.SysSupplier;
import com.region.moudles.system.dto.SysSupplierDto;
import com.region.moudles.system.service.SysSupplierService;
import com.region.until.StringUntil;
import com.region.until.UUIDUtil;

@RestController
@RequestMapping("${familypath}/supplier")
public class SysSupplierController extends BaseController {

	@Autowired
	private SysSupplierService sysSupplierService;

	/**
	 * @Description 列表数据(分页)
	 * @return
	 * @author tz
	 */
	@RequestMapping("getSupplierPage")
	public JsonResult getSupplierPage() {
		try {
			String param = getParam(request);
    		if(StringUtils.isNoneBlank(param)){
    			SysSupplierDto sysSupplierDto = JSON.parseObject(param, SysSupplierDto.class);
    			if (sysSupplierDto == null) {
    				sysSupplierDto = new SysSupplierDto();
    			}
    			JSONObject obj = JSON.parseObject(param).getJSONObject("page");
				PageModel page = new PageModel(obj.getInteger("pageNum"), obj.getInteger("pageSize"));
	    		sysSupplierService.getSupplierPage(sysSupplierDto, page);
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
	@RequestMapping("getSupplierList")
	public JsonResult getSupplierList() {
		try {
			String param = getParam(request);
    		if(StringUtils.isNoneBlank(param)){
    			SysSupplierDto sysSupplierDto = JSON.parseObject(param, SysSupplierDto.class);
    			if (sysSupplierDto == null) {
    				sysSupplierDto = new SysSupplierDto();
    			}
				List<SysSupplierDto> list = sysSupplierService.getSupplierList(sysSupplierDto);
				return jsonResult(list);
    		}else {
				return jsonResult(null, 10001, "参数错误");
			}
		} catch (Exception e) {
			return jsonResult(null, 90001, e.getMessage());
		}
	}

	/**
	 * @Description 供应商保存
	 * @return
	 * @author tz
	 */
	@RequestMapping("save")
	public JsonResult add() {
		try {
			// 获取参数
			String param = getParam(request);
			if (StringUtils.isNotBlank(param)) {
				SysSupplier sysSupplier = JSON.parseObject(param, SysSupplier.class);
				if(StringUntil.isNull(sysSupplier.getId())) {
					sysSupplier.setId(UUIDUtil.getUUID());
				}
				String userId = "";
				//String userId = SysUtil.sysUser(request, response).getUserId()
				sysSupplier.setStatus("1");
				sysSupplier.setUpdateTime(new Date());
				sysSupplier.setUpdateUser(userId);
				// 保存
				sysSupplierService.save(sysSupplier);
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
	 * @Description 供应商查看
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
				String supplierId = jsonObject.getString("id");
				if (StringUntil.isNull(supplierId)) {
					return jsonResult(null, 10002, "供应商ID必填");
				}
				SysSupplier sysSupplier = sysSupplierService.get(supplierId);
				return jsonResult(sysSupplier);
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
	
	/**
	 * @Description 供应商删除
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
				String supplierId = jsonObject.getString("id");
				sysSupplierService.delete(supplierId);
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
