package com.region.moudles.system.service.impl;

import com.region.moudles.common.service.impl.BaseServiceImpl;
import com.region.moudles.system.dao.DepartmentDao;
import com.region.moudles.system.domain.Department;
import com.region.moudles.system.service.SystemService;
import com.region.until.StringUntil;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;


@Named
public class SystemServiceImpl  implements SystemService{

    @Inject
    private  DepartmentDao departmentDao;

    @Override
    public void getDep(List<Department> list) {

        for(Department department:list){
            String depCode=departmentDao.queryDep(null,department.getDepCode());
            if(StringUntil.isNull(depCode)){
                departmentDao.save(department);
            }
        }

    }
}
