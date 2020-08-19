package com.region.moudles.stats.dto;

import java.io.Serializable;

/**
 * @ClassName: ResultModel
 * @Description: 用于存储查询返回的数据model
 * @author Administrator
 * @date 2019年6月24日
 */
public class ResultModel implements Serializable{

	private static final long serialVersionUID = 646946163L;
	
	//x轴
	private String name;
	//y轴
	private Integer value;
	private Integer value1;
	private Integer value2;
	private Integer value3;
	private Integer value4;
	private Integer value5;
	private Integer value6;
	private Integer value7;
	private Integer value8;
	private Integer value9;
	private Integer value10;
	
	private Integer sum;
	private String prop;
	private String orgCode;
	private String orgId;
	private String orgLevel;
	
	public ResultModel() {
		
	}
	
	public ResultModel(String name, Integer value) {
		this.name = name;
		this.value = value;
	}

	public ResultModel(String name, Integer value, String orgCode) {
		this.name = name;
		this.value = value;
		this.orgCode = orgCode;
	}
	
	public ResultModel(String name, Integer value, String orgCode, String orgId, String orgLevel) {
		this.name = name;
		this.value = value;
		this.orgCode = orgCode;
		this.orgId = orgId;
		this.orgLevel = orgLevel;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Integer getValue1() {
		return value1;
	}

	public void setValue1(Integer value1) {
		this.value1 = value1;
	}

	public Integer getValue2() {
		return value2;
	}

	public void setValue2(Integer value2) {
		this.value2 = value2;
	}

	public Integer getValue3() {
		return value3;
	}

	public void setValue3(Integer value3) {
		this.value3 = value3;
	}

	public Integer getValue4() {
		return value4;
	}

	public void setValue4(Integer value4) {
		this.value4 = value4;
	}

	public Integer getValue5() {
		return value5;
	}

	public void setValue5(Integer value5) {
		this.value5 = value5;
	}

	public Integer getValue6() {
		return value6;
	}

	public void setValue6(Integer value6) {
		this.value6 = value6;
	}

	public Integer getValue7() {
		return value7;
	}

	public void setValue7(Integer value7) {
		this.value7 = value7;
	}

	public Integer getValue8() {
		return value8;
	}

	public void setValue8(Integer value8) {
		this.value8 = value8;
	}

	public Integer getValue9() {
		return value9;
	}

	public void setValue9(Integer value9) {
		this.value9 = value9;
	}

	public Integer getValue10() {
		return value10;
	}

	public void setValue10(Integer value10) {
		this.value10 = value10;
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	public String getProp() {
		return prop;
	}

	public void setProp(String prop) {
		this.prop = prop;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgLevel() {
		return orgLevel;
	}

	public void setOrgLevel(String orgLevel) {
		this.orgLevel = orgLevel;
	}

}
