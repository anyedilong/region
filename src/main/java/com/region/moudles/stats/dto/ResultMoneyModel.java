package com.region.moudles.stats.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName: ResultModel
 * @Description: 用于存储查询返回的数据model
 * @author Administrator
 * @date 2019年6月24日
 */
public class ResultMoneyModel implements Serializable{

	private static final long serialVersionUID = 646946163L;
	
	//x轴
	private String name;
	//y轴
	private float value;
	private float value1;
	private float value2;
	private float value3;
	private float value4;
	private float value5;
	private float value6;
	private float value7;
	private float value8;
	private float value9;
	private float value10;
	
	private float sum;
	private String orgCode;
	private String orgLevel;
	
	public ResultMoneyModel() {
		
	}
	
	public ResultMoneyModel(String name, float value) {
		this.name = name;
		this.value = value;
	}

	public ResultMoneyModel(String name, float value, String orgCode) {
		this.name = name;
		this.value = value;
		this.orgCode = orgCode;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		BigDecimal b = new BigDecimal(value);  
		this.value = b.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue(); 
	}

	public float getValue1() {
		return value1;
	}

	public void setValue1(float value1) {
		BigDecimal b = new BigDecimal(value1);  
		this.value1 = b.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue(); 
	}

	public float getValue2() {
		return value2;
	}

	public void setValue2(float value2) {
		BigDecimal b = new BigDecimal(value2);  
		this.value2 = b.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue(); 
	}

	public float getValue3() {
		return value3;
	}

	public void setValue3(float value3) {
		BigDecimal b = new BigDecimal(value3);  
		this.value3 = b.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue(); 
	}

	public float getValue4() {
		return value4;
	}

	public void setValue4(float value4) {
		BigDecimal b = new BigDecimal(value4);  
		this.value4 = b.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue(); 
	}

	public float getValue5() {
		return value5;
	}

	public void setValue5(float value5) {
		BigDecimal b = new BigDecimal(value5);  
		this.value5 = b.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue(); 
	}

	public float getValue6() {
		return value6;
	}

	public void setValue6(float value6) {
		BigDecimal b = new BigDecimal(value6);  
		this.value6 = b.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue(); 
	}

	public float getValue7() {
		return value7;
	}

	public void setValue7(float value7) {
		BigDecimal b = new BigDecimal(value7);  
		this.value7 = b.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue(); 
	}

	public float getValue8() {
		return value8;
	}

	public void setValue8(float value8) {
		BigDecimal b = new BigDecimal(value8);  
		this.value8 = b.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue(); 
	}

	public float getValue9() {
		return value9;
	}

	public void setValue9(float value9) {
		BigDecimal b = new BigDecimal(value9);  
		this.value9 = b.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue(); 
	}

	public float getValue10() {
		return value10;
	}

	public void setValue10(float value10) {
		BigDecimal b = new BigDecimal(value10);  
		this.value10 = b.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue(); 
	}

	public float getSum() {
		return sum;
	}

	public void setSum(float sum) {
		BigDecimal b = new BigDecimal(sum);  
		this.sum = b.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue(); 
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgLevel() {
		return orgLevel;
	}

	public void setOrgLevel(String orgLevel) {
		this.orgLevel = orgLevel;
	}

}
