package com.region.moudles.outpatient.domain;

import com.region.moudles.common.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="outpatient_cost")
public class OutpatientCost extends BaseDomain {

	private static final long serialVersionUID = 6944196;
	
    @Id
    private String id;//
    private String hisId;//院内id，内码
    private String orgCode;//医院组织机构代码
    private String orgName;//医院名称
    private String receiptNum;//结算收据号
    private String outpatientNum;//本次门诊标识号
    private String caseNum;//病历号
    private String name;//姓名
    private Date settleDate;//结算日期(yyyy-mm-dd)
    private String chargeType;//收费类别（01:城镇职工基本医疗保险 02:城镇居民基本医疗保险
    // 03:新型农村合作医疗 04:贫因救助 05:商业医疗保险 06:全公费 07:全自费 08:其他社会保险 99:其他）
    private String insuranceNum;//医疗保险号
    private String totalAmount;//费用合计
    private String advanceAmount;//统筹金额
    private String ownAmount;//自费金额
    private String doctorCode;//收费医生代码
    private String doctorName;//收费医生名称
    @Column(name = "medical_record_id")
	private String medicalRecordId;// 门诊病历id

    public String getAdvanceAmount() {
        return advanceAmount;
    }

    public void setAdvanceAmount(String advanceAmount) {
        this.advanceAmount = advanceAmount;
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

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getReceiptNum() {
        return receiptNum;
    }

    public void setReceiptNum(String receiptNum) {
        this.receiptNum = receiptNum;
    }

    public String getOutpatientNum() {
        return outpatientNum;
    }

    public void setOutpatientNum(String outpatientNum) {
        this.outpatientNum = outpatientNum;
    }

    public String getCaseNum() {
        return caseNum;
    }

    public void setCaseNum(String caseNum) {
        this.caseNum = caseNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(Date settleDate) {
        this.settleDate = settleDate;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public String getInsuranceNum() {
        return insuranceNum;
    }

    public void setInsuranceNum(String insuranceNum) {
        this.insuranceNum = insuranceNum;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getOwnAmount() {
        return ownAmount;
    }

    public void setOwnAmount(String ownAmount) {
        this.ownAmount = ownAmount;
    }

    public String getDoctorCode() {
        return doctorCode;
    }

    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

	public String getMedicalRecordId() {
		return medicalRecordId;
	}

	public void setMedicalRecordId(String medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}
}
