package com.region.moudles.hospital.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;
import com.region.until.DictUtil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.util.Date;

@Entity
@Table(name="hospital_out_zd")
public class HospitalOutZd extends BaseDomain {

	private static final long serialVersionUID = 36666161616L;
	
    @Id
    private  String id;//内码
    @Column(name = "is_id")
    private  String isId;//结算单内码
    private  String diagnosisType;//疾病诊断类型
    private  String diseaseCode;//疾病诊断代码
    private  String diseaseName;//疾病诊断名称
    @JSONField(format="yyyy-MM-dd")
    private  Date diagnosisTime;//诊断时间
    private  String hisId;//院内ID

    @Transient
    private String diagnosisTypeText;

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getIsId() {
        return isId;
    }

    public void setIsId(String isId) {
        this.isId = isId;
    }

    public String getDiagnosisType() {
        return diagnosisType;
    }

    public void setDiagnosisType(String diagnosisType) {
    	this.diagnosisTypeText = DictUtil.getDictValue("disease_type", diagnosisType);
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

    public String getHisId() {
        return hisId;
    }

    public void setHisId(String hisId) {
        this.hisId = hisId;
    }


	public String getDiagnosisTypeText() {
		return diagnosisTypeText;
	}


	public void setDiagnosisTypeText(String diagnosisTypeText) {
		this.diagnosisTypeText = diagnosisTypeText;
	}
}
