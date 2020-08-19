package com.region.moudles.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.common.service.impl.BaseServiceImpl;
import com.region.moudles.system.dao.SysSupplierDao;
import com.region.moudles.system.domain.SysSupplier;
import com.region.moudles.system.dto.SysSupplierDto;
import com.region.moudles.system.service.SysSupplierService;

/**
 * 
 * <br>
 * <b>功能：</b>SysSupplierService<br>
 * <b>作者：</b>blt<br>
 * <b>版权所有：<b>版权所有(C) 2019，blt<br>
 */
@Service("sysSupplierService")
public class SysSupplierServiceImpl extends BaseServiceImpl<SysSupplierDao, SysSupplier> implements SysSupplierService {

	@Autowired
	private SysSupplierDao sysSupplierDao;

	@Override
	public void getSupplierPage(SysSupplierDto sysSupplierDto, PageModel page) {
		sysSupplierDao.getSupplierPage(sysSupplierDto, page);
	}

	@Override
	public List<SysSupplierDto> getSupplierList(SysSupplierDto sysSupplierDto) {
		return sysSupplierDao.getSupplierList(sysSupplierDto);
	}

}
