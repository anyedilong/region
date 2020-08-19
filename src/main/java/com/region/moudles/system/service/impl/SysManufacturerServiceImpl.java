package com.region.moudles.system.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.common.service.impl.BaseServiceImpl;
import com.region.moudles.system.dao.SysManufacturerDao;
import com.region.moudles.system.domain.SysManufacturer;
import com.region.moudles.system.dto.SysManufacturerDto;
import com.region.moudles.system.service.SysManufacturerService;

/**
 * 
 * <br>
 * <b>功能：</b>SysManufacturerService<br>
 * <b>作者：</b>blt<br>
 * <b>版权所有：<b>版权所有(C) 2019，blt<br>
 */
@Service("sysManufacturerService")
public class SysManufacturerServiceImpl extends BaseServiceImpl<SysManufacturerDao, SysManufacturer> implements SysManufacturerService {


	@Override
	public void getManufacturerPage(SysManufacturerDto sysManufacturerDto, PageModel page) {
		dao.getManufacturerPage(sysManufacturerDto, page);
	}

	@Override
	public List<SysManufacturerDto> getManufacturerList(SysManufacturerDto sysManufacturerDto) {
		return dao.getManufacturerList(sysManufacturerDto);
	}

}
