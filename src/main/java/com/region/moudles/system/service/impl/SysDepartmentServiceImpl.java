package com.region.moudles.system.service.impl;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.system.dao.DepartmentDao;
import com.region.moudles.system.domain.Department;
import com.region.moudles.system.dto.DepartmentDto;
import com.region.moudles.system.dto.SysDepartmentDto;
import com.region.moudles.system.service.SysDepartmentService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;


@Named
public class SysDepartmentServiceImpl implements SysDepartmentService{

    @Inject
    private DepartmentDao departmentDao;

	@Override
	public void getDepPage(SysDepartmentDto department, PageModel page) {
		departmentDao.getDepPage(department, page);
	}

	@Override
	public List<DepartmentDto> getdep() {
		return departmentDao.getdep();
	}
}
