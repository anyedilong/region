package com.region.moudles.system.service;

import com.region.moudles.common.domain.PageModel;
import com.region.moudles.system.domain.Department;
import com.region.moudles.system.dto.DepartmentDto;
import com.region.moudles.system.dto.SysDepartmentDto;

import java.util.List;


public interface SysDepartmentService {

    //获取科室
	void getDepPage(SysDepartmentDto department, PageModel page);

	List<DepartmentDto>  getdep();

}
