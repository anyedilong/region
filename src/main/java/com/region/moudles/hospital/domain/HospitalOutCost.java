package com.region.moudles.hospital.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;
import com.region.until.DictUtil;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "hospital_out_cost")
public class HospitalOutCost extends BaseDomain {

	private static final long serialVersionUID = 864646466L;
	
	@Id
    private  String id;//内码
    @Column(name = "his_id")
    private  String hisId;//院内结算内码
    private  String orgCode;//医院代码
    private  String orgName;//医院名称
    @Column(name = "ar_id")
    private  String arId;//入院登记码
    private  String receiptNum;//结算收据号
    private  String name;//姓名
    @JSONField(format="yyyy-MM-dd")
    private  Date settleDate;//结算日期
    private  String chargeType;//收费类别
    private  String insuranceNum;//医疗保险号
    private  String totalAmount;//费用合计
    @Column(name = "advance_amount")
    private String advanceAmount;//统筹金额
    private  String ownAmount;//自费金额
    @JSONField(format="yyyy-MM-dd")
    private  Date dischargeDate;//出院日期
    private  String billStatus;//单据状态
    private  String doctorCode;//收费医生代码
    private  String doctorName;//收费医生名字
    private  String depCode;//收费科室代码
    private  String depName;//收费科室名称
    private  String payType;//付款方式
    private  String sfzh;//身份证号
    private String hospitalId;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "is_id", referencedColumnName = "his_id", insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<HospitalOutZd> diagnosisList;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "out_id", referencedColumnName = "his_id", insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<HospitalOutMingXi> hospitalOutMingXiList;

    @Transient
    private String chargeTypeText;//收费类别
    @Transient
    private String payTypeText;//付款方式

    public List<HospitalOutMingXi> getHospitalOutMingXiList() {
		return hospitalOutMingXiList;
	}

	public void setHospitalOutMingXiList(List<HospitalOutMingXi> hospitalOutMingXiList) {
		this.hospitalOutMingXiList = hospitalOutMingXiList;
	}

	public List<HospitalOutZd> getDiagnosisList() {
        return diagnosisList;
    }

    public void setDiagnosisList(List<HospitalOutZd> diagnosisList) {
        this.diagnosisList = diagnosisList;
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

    public String getArId() {
        return arId;
    }

    public void setArId(String arId) {
        this.arId = arId;
    }

    public String getReceiptNum() {
        return receiptNum;
    }

    public void setReceiptNum(String receiptNum) {
        this.receiptNum = receiptNum;
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
    	this.chargeTypeText = DictUtil.getDictValue("120000", chargeType);
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

    public Date getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
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

    public String getDepCode() {
        return depCode;
    }

    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
    	this.payTypeText = DictUtil.getDictValue("230000", payType);
        this.payType = payType;
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

	public String getAdvanceAmount() {
		return advanceAmount;
	}

	public void setAdvanceAmount(String advanceAmount) {
		this.advanceAmount = advanceAmount;
	}

	public String getChargeTypeText() {
		return chargeTypeText;
	}

	public void setChargeTypeText(String chargeTypeText) {
		this.chargeTypeText = chargeTypeText;
	}

	public String getPayTypeText() {
		return payTypeText;
	}

	public void setPayTypeText(String payTypeText) {
		this.payTypeText = payTypeText;
	}

	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
}
