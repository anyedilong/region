package com.region.moudles.outpatient.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.PageModel;
import com.region.until.StringUntil;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;

public class JcDto {
    private String sfzh;
    private String name;
    private String sex;
    private String age;
    private Date startDate;
    private Date endDate;
    private String orgId;
    private String orgCode;
    private String patientType;
    private String inspectType;//检验类型 1 检验申请 2 样本接受 3 检验报告
    private String orgColumnName;
    private String dateColumnName;
    private String isReportReview;
    private String isUp;
    private String apparatusName; //仪器名称
    private String apparatusModel; //仪器型号
    private String month;
    @JSONField(format = "yyyy-MM-dd")
    private Date controlDate; //质控时间
    private Date nextControlDate; //质控时间

    private String id;//内码
    private String parentCode;//本次门诊标识号
    private String itemType;//测量项目类型
    private String itemCode;//测量项目代码
    private String itemName;//测量项目名称
    private String itemValue;//测量项目值
    @JSONField(format = "yyyy-MM-dd")
    private Date diagnosisTime;//测量项目时间
    private String itemUnit;//测量项目代码
    private String minValue;//最小范围值
    private String maxValue;//最大范围值
    private String hisId;
    private String parentId;// 门诊病历id
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

    private List<JcDto> reportList;
    private PageModel page;
    private Integer pageNo;
    private Integer pageSize;

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPatientType() {
        return patientType;
    }

    public void setPatientType(String patientType) {
        this.patientType = patientType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
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

    public String getHisId() {
        return hisId;
    }

    public void setHisId(String hisId) {
        this.hisId = hisId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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

    public PageModel getPage() {
        return page;
    }

    public void setPage(PageModel page) {
        this.page = page;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        if (StringUtils.isBlank(age))
            return StringUntil.getAge(sfzh);
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getInspectType() {
        return inspectType;
    }

    public void setInspectType(String inspectType) {
        this.inspectType = inspectType;
        //检验类型 1 检验申请 2 样本接受 3 检验报告
        if ("1".equals(inspectType)) {
            //this.orgColumnName = "item_qsjg_code";
            this.dateColumnName = "apply_date";//申请时间
        } else if ("2".equals(inspectType)) {
            //this.orgColumnName = "item_qsjg_code";
            this.dateColumnName = "item_qssj";//签收时间
        } else if ("3".equals(inspectType)) {
            //this.orgColumnName = "item_qsjg_code";
            this.dateColumnName = "report_date";//报告时间
        }
    }

    public void setItemQssj(Date itemQssj) {
        this.itemQssj = itemQssj;
    }

    public Date getItemQssj() {
        return itemQssj;
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

    public String getOrgColumnName() {
        return orgColumnName;
    }

    public void setOrgColumnName(String orgColumnName) {
        this.orgColumnName = orgColumnName;
    }

    public String getDateColumnName() {
        return dateColumnName;
    }

    public void setDateColumnName(String dateColumnName) {
        this.dateColumnName = dateColumnName;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getIsReportReview() {
        return isReportReview;
    }

    public void setIsReportReview(String isReportReview) {
        this.isReportReview = isReportReview;
    }

    public List<JcDto> getReportList() {
        return reportList;
    }

    public void setReportList(List<JcDto> reportList) {
        this.reportList = reportList;
    }

    public String getIsUp() {
        if (StringUtils.isNotBlank(itemValue) && StringUtils.isNotBlank(minValue) && StringUtils.isNotBlank(maxValue)) {
            Double value = Double.valueOf(itemValue);
            Double min = Double.valueOf(minValue);
            Double max = Double.valueOf(maxValue);
            if (value > max)
                return "1";
            else if (value < min)
                return "2";
            else
                return "0";
        }
        return isUp;
    }

    public void setIsUp(String isUp) {
        this.isUp = isUp;
    }

    public String getApparatusName() {
        return apparatusName;
    }

    public void setApparatusName(String apparatusName) {
        this.apparatusName = apparatusName;
    }

    public Date getControlDate() {
        return controlDate;
    }

    public void setControlDate(Date controlDate) {
        this.controlDate = controlDate;
    }

    public String getApparatusModel() {
        return apparatusModel;
    }

    public void setApparatusModel(String apparatusModel) {
        this.apparatusModel = apparatusModel;
    }

    public Date getNextControlDate() {
        return nextControlDate;
    }

    public void setNextControlDate(Date nextControlDate) {
        this.nextControlDate = nextControlDate;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
