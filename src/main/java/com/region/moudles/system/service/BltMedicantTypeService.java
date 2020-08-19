package com.region.moudles.system.service;

import java.util.List;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.common.service.BaseService;
import com.region.moudles.system.domain.BltMedicantType;
import com.region.moudles.system.dto.MedicantTypeDto;
import com.region.moudles.system.dto.SysDrugDto;


public interface BltMedicantTypeService extends BaseService<BltMedicantType>{

	//获取药品列表(分页)
	void getMedicantTypePage(MedicantTypeDto entity, PageModel page);
	//获取药品列表
	List<MedicantTypeDto> getMedicantTypeList(MedicantTypeDto info);

	List<SysDrugDto> getdrug();
	
}
