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
import com.region.moudles.system.domain.SysManufacturer;
import com.region.moudles.system.dto.SysManufacturerDto;
import com.region.moudles.system.service.SysManufacturerService;
import com.region.until.StringUntil;
import com.region.until.UUIDUtil;

@RestController
@RequestMapping("${familypath}/manufacturer")
public class SysManufacturerController extends BaseController {

	@Autowired
	private SysManufacturerService sysManufacturerService;

	/**
	 * @Description 列表数据(分页)
	 * @return
	 * @author tz
	 */
	@RequestMapping("getManufacturerPage")
	public JsonResult getManufacturerPage() {
		try {
			String param = getParam(request);
    		if(StringUtils.isNoneBlank(param)){
    			SysManufacturerDto sysManufacturerDto = JSON.parseObject(param, SysManufacturerDto.class);
    			if (sysManufacturerDto == null) {
    				sysManufacturerDto = new SysManufacturerDto();
    			}
    			JSONObject obj = JSON.parseObject(param).getJSONObject("page");
				PageModel page = new PageModel(obj.getInteger("pageNum"), obj.getInteger("pageSize"));
				sysManufacturerService.getManufacturerPage(sysManufacturerDto, page);
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
	@RequestMapping("getManufacturerList")
	public JsonResult getManufacturerList() {
		try {
			String param = getParam(request);
    		if(StringUtils.isNoneBlank(param)){
    			SysManufacturerDto manufacturerDto = JSON.parseObject(param, SysManufacturerDto.class);
    			if (manufacturerDto == null) {
    				manufacturerDto = new SysManufacturerDto();
    			}
				List<SysManufacturerDto> list = sysManufacturerService.getManufacturerList(manufacturerDto);
				return jsonResult(list);
    		}else {
				return jsonResult(null, 10001, "参数错误");
			}
		} catch (Exception e) {
			return jsonResult(null, 90001, e.getMessage());
		}
	}

	/**
	 * @Description 生产厂商保存
	 * @return
	 * @author tz
	 */
	@RequestMapping("save")
	public JsonResult add() {
		try {
			// 获取参数
			String param = getParam(request);
			if (StringUtils.isNotBlank(param)) {
				SysManufacturer sysManufacturer = JSON.parseObject(param, SysManufacturer.class);
				if(StringUntil.isNull(sysManufacturer.getId())) {
					sysManufacturer.setId(UUIDUtil.getUUID());
				}
				String userId = "";
				//String userId = SysUtil.sysUser(request, response).getUserId()
				sysManufacturer.setStatus("1");
				sysManufacturer.setUpdateTime(new Date());
				sysManufacturer.setUpdateUser(userId);
				// 保存
				sysManufacturerService.save(sysManufacturer);
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
	 * @Description 生产厂商查看
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
				String manufacturerId = jsonObject.getString("id");
				if (StringUntil.isNull(manufacturerId)) {
					return jsonResult(null, 10002, "生产厂商ID必填");
				}
				SysManufacturer sysManufacturer = sysManufacturerService.get(manufacturerId);
				return jsonResult(sysManufacturer);
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
	
	/**
	 * @Description 生产厂商删除
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
				String manufacturerId = jsonObject.getString("id");
				sysManufacturerService.delete(manufacturerId);
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
