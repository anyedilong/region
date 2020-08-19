package com.region.moudles.system.service;

import java.util.List;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.common.service.BaseService;
import com.region.moudles.system.domain.SysManufacturer;
import com.region.moudles.system.dto.SysManufacturerDto;


public interface SysManufacturerService extends BaseService<SysManufacturer>{

	//获取生产厂商列表(分页)
	void getManufacturerPage(SysManufacturerDto entity, PageModel page);
	//获取生产厂商列表
	List<SysManufacturerDto> getManufacturerList(SysManufacturerDto manufacturerDto);
	
}
