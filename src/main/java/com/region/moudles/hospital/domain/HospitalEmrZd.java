package com.region.moudles.hospital.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="hospital_emr_disease")
public class HospitalEmrZd extends BaseDomain {

    @Id
    private  String id;//内码
    @Column(name="ich_id")
    private  String ichId;//病案首页内码
    private  String snNum;//序号
    private  String diagnosisType;//疾病诊断类型
    private  String diseaseCode;//疾病代码
    private  String disease;//疾病名称
    @JSONField(format="yyyy-MM-dd")
    private  Date diagnosisDate;//确诊时间
    private  String admissionCondition;//入院病情
    @JSONField(format="yyyy-MM-dd")
    private  Date createTime;//创建时间


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getIchId() {
        return ichId;
    }

    public void setIchId(String ichId) {
        this.ichId = ichId;
    }

    public String getSnNum() {
        return snNum;
    }

    public void setSnNum(String snNum) {
        this.snNum = snNum;
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

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public Date getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(Date diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    public String getAdmissionCondition() {
        return admissionCondition;
    }

    public void setAdmissionCondition(String admissionCondition) {
        this.admissionCondition = admissionCondition;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
