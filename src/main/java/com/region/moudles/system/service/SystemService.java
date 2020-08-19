package com.region.moudles.system.service;

import com.region.moudles.common.service.BaseService;
import com.region.moudles.system.domain.Department;

import java.util.List;

public interface SystemService {

    //获取科室
    void getDep(List<Department> list);

}
