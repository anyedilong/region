package com.region.moudles.system.service;

import java.util.List;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.common.service.BaseService;
import com.region.moudles.system.domain.SysSupplier;
import com.region.moudles.system.dto.SysSupplierDto;


public interface SysSupplierService extends BaseService<SysSupplier>{

	//获取供应商列表(分页)
	void getSupplierPage(SysSupplierDto entity, PageModel page);
	//获取供应商列表
	List<SysSupplierDto> getSupplierList(SysSupplierDto supplierDto);
	
}
