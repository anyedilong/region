package com.region.moudles.system.dto;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.until.DictUtil;


public class SysPOCTResultDto implements Serializable {

    private static final long serialVersionUID = 646946464;
    
    private String orgName;//机构名称
    private String orgCode;//机构代码
    private String sfzh;   //身份证号
    private String residentName;//居民姓名
    private String xb;//性别
    private String nl;//年龄
    private String jtzz;//家庭住址
    private String checkResult;//检验结果
    @JSONField(format="yyyy-MM-dd")
    private String checkTime;//检验日期
    private String doctorName;//检验医生
    private String proName; //项目名称
    private String proGroupName;//项目组名称
    private String unit; //单位
    private String proDesc; //描述
    
    
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getSfzh() {
		return sfzh;
	}
	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}
	public String getResidentName() {
		return residentName;
	}
	public void setResidentName(String residentName) {
		this.residentName = residentName;
	}
	public String getXb() {
		return xb;
	}
	public void setXb(String xb) {
		this.xb = DictUtil.getDictValue("xb", xb);
	}
	public String getNl() {
		return nl;
	}
	public void setNl(String nl) {
		this.nl = nl;
	}
	public String getJtzz() {
		return jtzz;
	}
	public void setJtzz(String jtzz) {
		this.jtzz = jtzz;
	}
	
	public String getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProGroupName() {
		return proGroupName;
	}
	public void setProGroupName(String proGroupName) {
		this.proGroupName = proGroupName;
	}
	public String getCheckResult() {
		return checkResult;
	}
	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getProDesc() {
		return proDesc;
	}
	public void setProDesc(String proDesc) {
		this.proDesc = proDesc;
	}
    
    
}