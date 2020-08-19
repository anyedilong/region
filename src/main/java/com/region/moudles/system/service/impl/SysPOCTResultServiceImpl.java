package com.region.moudles.system.service.impl;

import org.springframework.stereotype.Service;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.common.service.impl.BaseServiceImpl;
import com.region.moudles.system.dao.SysPOCTResultDao;
import com.region.moudles.system.domain.SysPOCTResult;
import com.region.moudles.system.dto.SysPOCTResultDto;
import com.region.moudles.system.service.SysPOCTResultService;

/**
 * 
 * <br>
 * <b>功能：</b>SysSupplierService<br>
 * <b>作者：</b>blt<br>
 * <b>版权所有：<b>版权所有(C) 2019，blt<br>
 */
@Service("sysPOCTResultServiceImpl")
public class SysPOCTResultServiceImpl extends BaseServiceImpl<SysPOCTResultDao, SysPOCTResult> implements SysPOCTResultService {


	@Override
	public void getNucleinResultPage(SysPOCTResultDto nucleinResultDto, PageModel page) {
		dao.getNucleinResultPage(nucleinResultDto, page);
	}

}
