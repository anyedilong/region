package com.region.moudles.system.dto;

import java.io.Serializable;


public class MedicantTypeDto implements Serializable {

    private static final long serialVersionUID = 4564729518133694581L;
    
    private String id;
    //药品的编号
    private String code;
    //药品的简拼
    private String simplePinyin;
    //药品名称
    private String name;
    //药品用法
    private String usage;
    
    private String orgId;
    //分类
    private String classLevel;
    private String classBase;
    private String classZw;
    
    private String updateTime;
    
    private String startDate;
    private String endDate;
    
    public MedicantTypeDto() {
    	
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

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
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

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
    
}