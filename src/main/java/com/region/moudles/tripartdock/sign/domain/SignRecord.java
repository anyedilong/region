package com.region.moudles.tripartdock.sign.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.region.moudles.common.domain.BaseDomain;

@Entity
@Table(name = "blt_sign_record")
public class SignRecord extends BaseDomain {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;// ID

	private Date servicetime;// 服务时间

	private Date nextservicetime;// 下次服务时间

	private String servicenumber;// 服务次数

	private String specification;// 详述
	@Column(name = "servicepackage")
	private String servicepackageid;//服务包id

	private String doctorid;// 医生id

	private String patientid;// 患者id

	private String serviceprojectid;// 服务项目id

	private String servicetype;// 服务类型

	private String evaluatescore;// 评价分数

	private String evaluatecontent;// 评级内容

	private String signid;// 签约id

	private String deleteflg;// 删除标志

	private String synFlg;// 同步标志 新加字段
	private String synTime;// 同步时间 新加字段

	public String getSynFlg() {
		return synFlg;
	}

	public void setSynFlg(String synFlg) {
		this.synFlg = synFlg;
	}

	public String getSynTime() {
		return synTime;
	}

	public void setSynTime(String synTime) {
		this.synTime = synTime;
	}

	public String getDeleteflg() {
		return deleteflg;
	}

	public void setDeleteflg(String deleteflg) {
		this.deleteflg = deleteflg;
	}

	public String getSignid() {
		return signid;
	}

	public void setSignid(String signid) {
		this.signid = signid;
	}

	public String getEvaluatescore() {
		return evaluatescore;
	}

	public void setEvaluatescore(String evaluatescore) {
		this.evaluatescore = evaluatescore;
	}

	public String getEvaluatecontent() {
		return evaluatecontent;
	}

	public void setEvaluatecontent(String evaluatecontent) {
		this.evaluatecontent = evaluatecontent;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getServicetime() {
		return servicetime;
	}

	public void setServicetime(Date servicetime) {
		this.servicetime = servicetime;
	}

	public Date getNextservicetime() {
		return nextservicetime;
	}

	public void setNextservicetime(Date nextservicetime) {
		this.nextservicetime = nextservicetime;
	}

	public String getServicenumber() {
		return servicenumber;
	}

	public void setServicenumber(String servicenumber) {
		this.servicenumber = servicenumber;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getServicepackageid() {
		return servicepackageid;
	}

	public void setServicepackageid(String servicepackageid) {
		this.servicepackageid = servicepackageid;
	}

	public String getDoctorid() {
		return doctorid;
	}

	public void setDoctorid(String doctorid) {
		this.doctorid = doctorid;
	}

	public String getPatientid() {
		return patientid;
	}

	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}

	public String getServiceprojectid() {
		return serviceprojectid;
	}

	public void setServiceprojectid(String serviceprojectid) {
		this.serviceprojectid = serviceprojectid;
	}

	public String getServicetype() {
		return servicetype;
	}

	public void setServicetype(String servicetype) {
		this.servicetype = servicetype;
	}

}
