package com.region.moudles.tripartdock.statis.dto;

import java.io.Serializable;


public class StatisJcDto implements Serializable {

	private static final long serialVersionUID = 19748966L;
	
    private String  id;//机构标识
    private String  name;//机构名称
    private String  ratio;//占比
    private String  orgLevel;//机构等级
    
    private String  value;//数量
    private String  value1;
    private String  value2;
    
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRatio() {
		return ratio;
	}
	public void setRatio(String ratio) {
		this.ratio = ratio;
	}
	
	public String getOrgLevel() {
		return orgLevel;
	}
	public void setOrgLevel(String orgLevel) {
		this.orgLevel = orgLevel;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getValue1() {
		return value1;
	}
	public void setValue1(String value1) {
		this.value1 = value1;
	}
	public String getValue2() {
		return value2;
	}
	public void setValue2(String value2) {
		this.value2 = value2;
	}
    
}
