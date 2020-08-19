package com.region.moudles.system.domain;


import com.region.moudles.common.domain.BaseDomain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sys_deppartment")
public class Department extends BaseDomain {

	private static final long serialVersionUID = 146161616L;
	
	@Id
    private  String id;//内码
    private  String depCode;//科室代码
    private  String depName;//科室名称


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



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
