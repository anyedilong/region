package com.region.moudles.system.service.impl;

import java.util.List;

import com.region.moudles.system.dto.SysDrugDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.common.service.impl.BaseServiceImpl;
import com.region.moudles.system.dao.BltMedicantTypeDao;
import com.region.moudles.system.domain.BltMedicantType;
import com.region.moudles.system.dto.MedicantTypeDto;
import com.region.moudles.system.service.BltMedicantTypeService;

/**
 * 
 * <br>
 * <b>功能：</b>SysRoleService<br>
 * <b>作者：</b>blt<br>
 * <b>版权所有：<b>版权所有(C) 2016，blt<br>
 */
@Service("bltMedicantTypeService")
public class BltMedicantTypeServiceImpl extends BaseServiceImpl<BltMedicantTypeDao, BltMedicantType> implements BltMedicantTypeService {

	@Autowired
	private BltMedicantTypeDao dao;

	@Override
	public void getMedicantTypePage(MedicantTypeDto medicantTypeDto, PageModel page) {
		dao.getMedicantTypePage(medicantTypeDto, page);
	}

	@Override
	public List<MedicantTypeDto> getMedicantTypeList(MedicantTypeDto medicantType) {
		return dao.getMedicantTypeList(medicantType);
	}

	@Override
	public List<SysDrugDto> getdrug() {
		return dao.getdrug();
	}

}
