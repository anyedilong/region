package com.region.moudles.system.dto;


import com.region.moudles.common.domain.BaseDomain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


public class DepartmentDto {

    private  String depCode;//科室代码
    private  String depName;//科室名称






    public String getDepCode() {
        return depCode;
    }

    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }
}
