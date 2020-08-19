package com.region.moudles.outpatient.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="outpatient_jcz")
public class OutpatientJc extends BaseDomain {

	private static final long serialVersionUID = 1974946L;
	
	@Id
    private  String  id;//内码
    @Column(name = "outpatient_num")
    private  String  outpatientNum;//本次门诊标识号
    private  String  itemType;//测量项目类型
    private  String  itemCode;//测量项目代码
    private  String  itemName;//测量项目名称
    private  String  itemValue;//测量项目值
    @JSONField(format = "yyyy-MM-dd")
    private  Date diagnosisTime;//测量项目时间
    private  String  itemUnit;//测量项目单位
    private  String  minValue;//最小范围值
    private  String  maxValue;//最大范围值
    private  String  hisId;
    @Column(name = "medical_record_id")
    private String medicalRecordId;// 门诊病历id
    private String sampleCode;//样本号
    private String itemZd;  //诊断
    @JSONField(format = "yyyy-MM-dd")
    private Date itemQssj; //签收时间
    private String itemQsdoctorName; //签收医生
    private String itemQsdoctorId; //签收医生标识
    private String itemSfyc; //是否异常
    private String itemQsjgName; //签收机构名称
    private String itemQsjgCode; //签收机构名称
    private String itemQsdepName; //签收科室名称
    private String remark; //备注

    private String applyDept;// 申请科室
    @JSONField(format = "yyyy-MM-dd")
    private Date applyDate;// 申请时间
    private String applyDoctor;// 申请医生
    private String chargeType;// 收费类型(自费、医保)
    private String sampleType;// 标本类型
    @JSONField(format = "yyyy-MM-dd")
    private Date sampleDate;// 采样时间
    private String sendDoctor;// 送检医生
    @JSONField(format = "yyyy-MM-dd")
    private Date reportDate;// 报告时间
    private String inspector;// 检验员
    private String checker;// 审核员

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

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }

    public Date getDiagnosisTime() {
        return diagnosisTime;
    }

    public void setDiagnosisTime(Date diagnosisTime) {
        this.diagnosisTime = diagnosisTime;
    }

    public String getItemUnit() {
        return itemUnit;
    }

    public void setItemUnit(String itemUnit) {
        this.itemUnit = itemUnit;
    }

    public String getMinValue() {
        return minValue;
    }

    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
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

	public String getSampleCode() {
		return sampleCode;
	}

	public void setSampleCode(String sampleCode) {
		this.sampleCode = sampleCode;
	}

	public String getItemZd() {
		return itemZd;
	}

	public void setItemZd(String itemZd) {
		this.itemZd = itemZd;
	}

    public Date getItemQssj() {
        return itemQssj;
    }

    public void setItemQssj(Date itemQssj) {
        this.itemQssj = itemQssj;
    }

    public String getItemQsdoctorName() {
		return itemQsdoctorName;
	}

	public void setItemQsdoctorName(String itemQsdoctorName) {
		this.itemQsdoctorName = itemQsdoctorName;
	}

	public String getItemQsdoctorId() {
		return itemQsdoctorId;
	}

	public void setItemQsdoctorId(String itemQsdoctorId) {
		this.itemQsdoctorId = itemQsdoctorId;
	}

	public String getItemSfyc() {
		return itemSfyc;
	}

	public void setItemSfyc(String itemSfyc) {
		this.itemSfyc = itemSfyc;
	}

	public String getItemQsjgName() {
		return itemQsjgName;
	}

	public void setItemQsjgName(String itemQsjgName) {
		this.itemQsjgName = itemQsjgName;
	}

	public String getItemQsjgCode() {
		return itemQsjgCode;
	}

	public void setItemQsjgCode(String itemQsjgCode) {
		this.itemQsjgCode = itemQsjgCode;
	}

	public String getItemQsdepName() {
		return itemQsdepName;
	}

	public void setItemQsdepName(String itemQsdepName) {
		this.itemQsdepName = itemQsdepName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

    public String getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getApplyDoctor() {
        return applyDoctor;
    }

    public void setApplyDoctor(String applyDoctor) {
        this.applyDoctor = applyDoctor;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public String getSampleType() {
        return sampleType;
    }

    public void setSampleType(String sampleType) {
        this.sampleType = sampleType;
    }

    public Date getSampleDate() {
        return sampleDate;
    }

    public void setSampleDate(Date sampleDate) {
        this.sampleDate = sampleDate;
    }

    public String getSendDoctor() {
        return sendDoctor;
    }

    public void setSendDoctor(String sendDoctor) {
        this.sendDoctor = sendDoctor;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }
}
