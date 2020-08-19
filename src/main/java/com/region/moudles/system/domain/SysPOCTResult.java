package com.region.moudles.system.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;


@Entity
@Table(name="sys_poct_result")
public class SysPOCTResult extends BaseDomain {

    private static final long serialVersionUID = 4564726412133694581L;
    
    @Id
    private String id;
    private String orgId; //机构标识
    private String orgCode;//机构编号
    private String doctorId;//医生标识
    private String doctorName;//医生名称
    private String residentId;//居民标识
    private String residentName;//居民名称
    private String checkResult;  //检测结果
    @JSONField(format = "yyyy-MM-dd")
	private Date checkTime; //检测日期
    @JSONField(format = "yyyy-MM-dd")
	private Date createTime; //创建日期
    private String unit;//单位
    private String checkValue;//测量值
    private String standard;//参考标准
    private String proName;//项目名称
    private String proGroupName;//项目组名称
    private String ph;//批号
    private String proDesc;//描述
    @JSONField(format = "yyyy-MM-dd")
    private Date uploadTime;//上报日期
    
    public SysPOCTResult() {
    	
    }
    
    public SysPOCTResult(String orgId, String orgCode, String doctorId, String doctorName, 
    		String residentId, String residentName, String checkResult, Date checkTime, String unit, String checkValue,
    		String standard, String proName, String proGroupName, String ph, String proDesc, Date uploadTime) {
    	this.orgId = orgId;
    	this.orgCode = orgCode;
    	this.doctorId = doctorId;
    	this.doctorName = doctorName;
    	this.residentId = residentId;
    	this.residentName = residentName;
    	this.checkResult = checkResult;
    	this.checkTime = checkTime;
    	this.unit = unit;
    	this.checkValue = checkValue;
    	this.standard = standard;
    	this.proName = proName;
    	this.proGroupName = proGroupName;
    	this.ph = ph;
    	this.proDesc = proDesc;
    	this.uploadTime = uploadTime;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getResidentId() {
		return residentId;
	}

	public void setResidentId(String residentId) {
		this.residentId = residentId;
	}

	public String getResidentName() {
		return residentName;
	}

	public void setResidentName(String residentName) {
		this.residentName = residentName;
	}

	public String getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getCheckValue() {
		return checkValue;
	}

	public void setCheckValue(String checkValue) {
		this.checkValue = checkValue;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
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

	public String getPh() {
		return ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	public String getProDesc() {
		return proDesc;
	}

	public void setProDesc(String proDesc) {
		this.proDesc = proDesc;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

    
}