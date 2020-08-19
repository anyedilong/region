package com.region.moudles.system.service.impl;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.common.service.impl.BaseServiceImpl;
import com.region.moudles.system.dao.SysUserHealthDao;
import com.region.moudles.system.domain.SysUserHealth;
import com.region.moudles.system.dto.SysUserHealthDto;
import com.region.moudles.system.service.SysUserHealthService;
import com.region.until.UUIDUtil;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;


@Named
public class SysUserHealthServiceImpl extends BaseServiceImpl<SysUserHealthDao, SysUserHealth> implements SysUserHealthService {

    @Inject
    private SysUserHealthDao sysUserHealthDao;

	@Override
	public void getUserHealthPage(SysUserHealthDto userHealth, PageModel page) {
		sysUserHealthDao.getUserHealthPage(userHealth, page);
	}

	@Override
	public void saveuser(List<SysUserHealth> list) {
		    for(SysUserHealth sysUserHealth:list){
		    	 sysUserHealth.setId(UUIDUtil.getUUID());
		    	 sysUserHealthDao.save(sysUserHealth);
			}
	}
}
