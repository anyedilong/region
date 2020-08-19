package com.region.moudles.outpatient.domain;

import java.util.Date;

import javax.persistence.*;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;

/**
 * 门诊诊断
 */
@Entity
@Table(name = "outpatient_zd")
public class OutpatientZd extends BaseDomain {

	private static final long serialVersionUID = 36534345345L;
	
	@Id
	private String id;// 内码
	@Column(name = "outpatient_num")
	private String outpatientNum;// 本次门诊标识号
	private String diagnosisType;// 疾病诊断类型
	private String diseaseCode;// 疾病诊断代码
	private String diseaseName;// 疾病诊断名称
	@JSONField(format = "yyyy-MM-dd")
	private Date diagnosisTime;// 诊断时间
	private String hisId;
	@Column(name = "medical_record_id")
	private String medicalRecordId;// 门诊病历id

	@Transient
	private String orgCode;

	public String getHisId() {
		return hisId;
	}

	public void setHisId(String hisId) {
		this.hisId = hisId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOutpatientNum() {
		return outpatientNum;
	}

	public void setOutpatientNum(String outpatientNum) {
		this.outpatientNum = outpatientNum;
	}

	public String getDiagnosisType() {
		return diagnosisType;
	}

	public void setDiagnosisType(String diagnosisType) {
		this.diagnosisType = diagnosisType;
	}

	public String getDiseaseCode() {
		return diseaseCode;
	}

	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}

	public String getDiseaseName() {
		return diseaseName;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	public Date getDiagnosisTime() {
		return diagnosisTime;
	}

	public void setDiagnosisTime(Date diagnosisTime) {
		this.diagnosisTime = diagnosisTime;
	}

	public String getMedicalRecordId() {
		return medicalRecordId;
	}

	public void setMedicalRecordId(String medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
}
