package com.region.moudles.system.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;


@Entity
@Table(name="blt_medicant_type")
public class BltMedicantType extends BaseDomain {

    private static final long serialVersionUID = 4564729518133694581L;
    
    @Id
    private String id;
    //药品的编号
    private String code;
    //药品的简拼
    @Column(name="simple_py")
    private String simplePinyin;
    //药品名称
    private String name;
    //药品用法
    private String usage;
    //分类
    @Column(name="class_level")
    private String classLevel;
    @Column(name="class_base")
    private String classBase;
    @Column(name="class_zw")
    private String classZw;
    
    @JSONField(format = "yyyy-MM-dd")
    @Column(name="update_time")
	private Date updateTime;
    @Column(name="update_user")
	private String updateUser;
    private String status;
    
    public BltMedicantType() {
    	
    }
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSimplePinyin() {
		return simplePinyin;
	}

	public void setSimplePinyin(String simplePinyin) {
		this.simplePinyin = simplePinyin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public String getClassLevel() {
		return classLevel;
	}

	public void setClassLevel(String classLevel) {
		this.classLevel = classLevel;
	}

	public String getClassBase() {
		return classBase;
	}

	public void setClassBase(String classBase) {
		this.classBase = classBase;
	}

	public String getClassZw() {
		return classZw;
	}

	public void setClassZw(String classZw) {
		this.classZw = classZw;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    
}