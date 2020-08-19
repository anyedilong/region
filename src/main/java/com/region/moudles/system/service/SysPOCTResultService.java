package com.region.moudles.system.service;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.common.service.BaseService;
import com.region.moudles.system.domain.SysPOCTResult;
import com.region.moudles.system.dto.SysPOCTResultDto;


public interface SysPOCTResultService extends BaseService<SysPOCTResult>{

	//获取核酸检测结果列表(分页)
	void getNucleinResultPage(SysPOCTResultDto nucleinResultDto, PageModel page);
	
}
