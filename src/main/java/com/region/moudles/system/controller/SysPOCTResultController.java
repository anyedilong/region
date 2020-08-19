package com.region.moudles.system.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.region.moudles.common.controller.BaseController;
import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.system.dto.SysPOCTResultDto;
import com.region.moudles.system.service.SysPOCTResultService;

@RestController
@RequestMapping("${familypath}/poct")
public class SysPOCTResultController extends BaseController {

	@Autowired
	private SysPOCTResultService poctResultService;

	/**
	 * @Description 列表数据(分页)
	 * @return
	 * @author tz
	 */
	@RequestMapping("getNucleinResultPage")
	public JsonResult getNucleinResultPage() {
		try {
			String param = getParam(request);
    		if(StringUtils.isNoneBlank(param)){
    			SysPOCTResultDto nucleinResultDto = JSON.parseObject(param, SysPOCTResultDto.class);
    			if (nucleinResultDto == null) {
    				nucleinResultDto = new SysPOCTResultDto();
    			}
    			JSONObject obj = JSON.parseObject(param).getJSONObject("page");
				PageModel page = new PageModel(obj.getInteger("pageNum"), obj.getInteger("pageSize"));
				poctResultService.getNucleinResultPage(nucleinResultDto, page);
				return jsonResult(page);
    		}else {
				return jsonResult(null, 10001, "参数错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
}
