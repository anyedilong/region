package com.region.moudles.system.service;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.system.domain.SysUserHealth;
import com.region.moudles.system.dto.SysUserHealthDto;

import java.util.List;


public interface SysUserHealthService {

    //获取卫生人员
	void getUserHealthPage(SysUserHealthDto userHealth, PageModel page);

    void saveuser(List<SysUserHealth> list);

}
