package com.region.moudles.healthbrowser.dto;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @ClassName: JyInfoDto
 * @Description: 检验信息实体类(惠民平台使用)
 * @author Administrator
 * @date 2020年3月9日
 */
public class JyInfoDto implements Serializable {
	
	private static final long serialVersionUID = 4777216161L;
	
	private String id; 		//门诊或者住院的id
    private String type;	//类型1.门诊 2.住院
    private String itemType;//检验类型
    private String itemCode;//检验code
    private String itemName;//检验项目名
    private String itemUnit;//单位
    private String itemValue;//检验值
    private String minValue;//正常范围-最小值
    private String maxValue;//正常范围-最大值
    @JSONField(format = "yyyy-MM-dd")
    private Date qzrq;//检验日期
    private String hospital;
    private String deptName;
    
    private String code;
    private String name;
    private String value;
    private String status;
    
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemUnit() {
		return itemUnit;
	}

	public void setItemUnit(String itemUnit) {
		this.itemUnit = itemUnit;
	}

	public String getItemValue() {
		return itemValue;
	}

	public void setItemValue(String itemValue) {
		this.itemValue = itemValue;
	}

	public String getMinValue() {
		return minValue;
	}

	public void setMinValue(String minValue) {
		this.minValue = minValue;
	}

	public String getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
	}

	public Date getQzrq() {
		return qzrq;
	}

	public void setQzrq(Date qzrq) {
		this.qzrq = qzrq;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
}
