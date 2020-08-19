package com.region.moudles.outpatient.domain;

import com.region.moudles.common.domain.BaseDomain;
import com.region.moudles.system.domain.SysDiseaseTypeDomain;
import com.region.until.DictUtil;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;


@Entity
@Table(name = "outpatient_rx_zd")
public class OutpatientRxZd extends BaseDomain {

	private static final long serialVersionUID = 126846455345L;
	
    @Id
    private String id;//
    private String hisId;//院内id，内码
    @Column(name="or_id")
    private String orId;//门诊处方内码
    @Column(name="diagnosis_type")
    private String diagnosisType;//门诊处方疾病诊断类型
    private String diseaseCode;//平台门诊处方疾病诊断代码
    private String hisDiseaseCode;//院内his诊断代码
    private String diseaseName;//门诊处方疾病诊断名称
    private String sn;//序号，诊断顺序
    @Transient
    private String orgCode;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH, optional = false)
    @JoinColumn(name = "diagnosis_type", referencedColumnName = "disease_type_code", insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private SysDiseaseTypeDomain diseaseTypeDomain;

    @Transient
    private String diagnosisTypeText;
    
    
    public SysDiseaseTypeDomain getDiseaseTypeDomain() {
        return diseaseTypeDomain;
    }

    public void setDiseaseTypeDomain(SysDiseaseTypeDomain diseaseTypeDomain) {
        this.diseaseTypeDomain = diseaseTypeDomain;
    }

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getHisId() {
        return hisId;
    }

    public void setHisId(String hisId) {
        this.hisId = hisId;
    }

    public String getOrId() {
        return orId;
    }

    public void setOrId(String orId) {
        this.orId = orId;
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

    public String getHisDiseaseCode() {
        return hisDiseaseCode;
    }

    public void setHisDiseaseCode(String hisDiseaseCode) {
        this.hisDiseaseCode = hisDiseaseCode;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getDiagnosisTypeText() {
		return diagnosisTypeText;
	}

	public void setDiagnosisTypeText(String diagnosisTypeText) {
		this.diagnosisTypeText = diagnosisTypeText;
	}

}
