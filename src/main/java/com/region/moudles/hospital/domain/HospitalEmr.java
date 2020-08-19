package com.region.moudles.hospital.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.region.until.DictUtil;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;

@Entity
@Table(name="hospital_emr")
public class HospitalEmr extends BaseDomain {

	private static final long serialVersionUID = 66484531311L;
	
	@Id
    private  String id;//内码
    @Column(name="his_id")
    private  String hisId;//
    private  String orgCode;//医院机构代码
    private  String orgName;//医院机构名称
    private  String inpatientTimes;//住院次数
    private  String chargeMode;//医疗付费方式
    private  String totalAmount;//住院总费用
    private  String caseNum;//病案号
    private  String admissionNum;//住院号
    private  String admissionId;//本次住院标识号
    private  String name;//姓名
    @JSONField(format="yyyy-MM-dd")
    private   Date bornDate;//出生日期
    private  String age;//年龄
    private  String sex;//性别
    private  String maritalStatus;//婚姻情况
    private  String occupation;//职业
    private  String nation;//民族
    private  String country;//国籍
    private  String idType;//身份证类别
    private  String idNum;//身份证件号码
    private  String workingOrg;//工作单位名称
    @JSONField(format="yyyy-MM-dd")
    private  Date admissionDate;//入院日期
    @JSONField(format="yyyy-MM-dd")
    private  String dischargeDate;//出院日期
    private  String inpatientDay;//实际住院天数
    private  String injuryCause;//损伤和中毒外部原因
    private  String  caseQuality;//病案质量代码
    private  String isAutopsy;//死亡患者尸检
    private  String bloodAbo;//血型
    private  String  bloodRh;//rh血型
    private  String citizenId;//个人内码
    @JSONField(format="yyyy-MM-dd")
    private  Date effectiveTime;//活动发生日期
    @JSONField(format="yyyy-MM-dd")
    private  Date createTime;//创建时间
    private  String districtCode;//所属区划
    private  String  admissionType;//入院途径
    private  String birthBodyWeight;//新生儿出生体重
    private  String  admissionBodyWeight;//新生儿入院体重
    private  String  pathologyNum;//病理号
    private  String  isAllergy;//药物过敏标志
    private  String  dischargeType;//离院方式
    private  String   receiveOrgName;//拟接收医疗机构名称
    private  String  isReadmission;//是否有出院31天内再住院计划
    private  String  readmissionPurpose;//再住院目的
    private  String  priorComaDays;//入院前昏迷天数
    private  String  priorComaHours;//入院前昏迷小时数
    private  String  priorComaMinutes;//入院前昏迷分钟数
    private  String  alterComaDays;//入院后昏迷天数
    private  String  alterComaHours;//入院后昏迷小时数
    private  String  alterComaMinutes;//入院后昏迷分钟数
    private  String ageMonth;//年龄(月)
    private  String ageDay;//年龄(天)
    private  String agehour;//年龄(小时)
    private  String homeType;//病案首页类型
    @JSONField(format="yyyy-MM-dd")
    private  Date qcDate;//质控日期
    private  String treateType;//治疗类别
    private  String pathwayType;//实施临床路径
    private  String isUseHerb;//使用医疗机构中药制剂
    private  String isUseEquip;//使用中医诊疗设备
    private  String isUseTech;//使用中医诊疗技术
    private  String isDialectialNursting;//辩证施护
    private String hospitalId;

    private  String maritalStatusText;//婚姻情况明文
    private  String occupationText;//职业明文
    private  String nationText;//民族明文
    private  String countryText;//国籍明文

    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "ich_id",referencedColumnName = "his_id",insertable = false,updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<HospitalEmrArea> emr_ich_addr;//病案首页-地址

    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "ich_id",referencedColumnName = "his_id",insertable = false,updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<HospitalEmrCost> emr_ich_charge;//病案首页-住院费用

    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "ich_id",referencedColumnName = "his_id",insertable = false,updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<HospitalEmrDep> emr_ich_department;//住院病案首页-科别

    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "ich_id",referencedColumnName = "his_id",insertable = false,updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<HospitalEmrDoctor> emr_ich_doctor;//住院病案首页-医生信息

    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "ich_id",referencedColumnName = "his_id",insertable = false,updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<HospitalEmrGm> emr_ich_allergies;//住院病案首页-过敏药物

    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "ich_id",referencedColumnName = "his_id",insertable = false,updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<HospitalEmrSs> emr_ich_operation;//住院病案首页-手术

    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "ich_id",referencedColumnName = "his_id",insertable = false,updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<HospitalEmrSsDoctor> emr_ich_operation_doctor;//住院病案首页-手术操作医师

    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "ich_id",referencedColumnName = "his_id",insertable = false,updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<HospitalEmrTel> emr_ich_tel;//住院病案首页-电话

    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "ich_id",referencedColumnName = "his_id",insertable = false,updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<HospitalEmrZd> emr_ich_diagnosis;//住院病案首页-诊断


    @Override
    public String getId() {
        return id;
    }

    @Override
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

    public String getInpatientTimes() {
        return inpatientTimes;
    }

    public void setInpatientTimes(String inpatientTimes) {
        this.inpatientTimes = inpatientTimes;
    }

    public String getChargeMode() {
        return chargeMode;
    }

    public void setChargeMode(String chargeMode) {
        this.chargeMode = chargeMode;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCaseNum() {
        return caseNum;
    }

    public void setCaseNum(String caseNum) {
        this.caseNum = caseNum;
    }

    public String getAdmissionNum() {
        return admissionNum;
    }

    public void setAdmissionNum(String admissionNum) {
        this.admissionNum = admissionNum;
    }

    public String getAdmissionId() {
        return admissionId;
    }

    public void setAdmissionId(String admissionId) {
        this.admissionId = admissionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getWorkingOrg() {
        return workingOrg;
    }

    public void setWorkingOrg(String workingOrg) {
        this.workingOrg = workingOrg;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(String dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getInpatientDay() {
        return inpatientDay;
    }

    public void setInpatientDay(String inpatientDay) {
        this.inpatientDay = inpatientDay;
    }

    public String getInjuryCause() {
        return injuryCause;
    }

    public void setInjuryCause(String injuryCause) {
        this.injuryCause = injuryCause;
    }

    public String getCaseQuality() {
        return caseQuality;
    }

    public void setCaseQuality(String caseQuality) {
        this.caseQuality = caseQuality;
    }

    public String getIsAutopsy() {
        return isAutopsy;
    }

    public void setIsAutopsy(String isAutopsy) {
        this.isAutopsy = isAutopsy;
    }

    public String getBloodAbo() {
        return bloodAbo;
    }

    public void setBloodAbo(String bloodAbo) {
        this.bloodAbo = bloodAbo;
    }

    public String getBloodRh() {
        return bloodRh;
    }

    public void setBloodRh(String bloodRh) {
        this.bloodRh = bloodRh;
    }

    public String getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(String citizenId) {
        this.citizenId = citizenId;
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getAdmissionType() {
        return admissionType;
    }

    public void setAdmissionType(String admissionType) {
        this.admissionType = admissionType;
    }

    public String getBirthBodyWeight() {
        return birthBodyWeight;
    }

    public void setBirthBodyWeight(String birthBodyWeight) {
        this.birthBodyWeight = birthBodyWeight;
    }

    public String getAdmissionBodyWeight() {
        return admissionBodyWeight;
    }

    public void setAdmissionBodyWeight(String admissionBodyWeight) {
        this.admissionBodyWeight = admissionBodyWeight;
    }

    public String getPathologyNum() {
        return pathologyNum;
    }

    public void setPathologyNum(String pathologyNum) {
        this.pathologyNum = pathologyNum;
    }

    public String getIsAllergy() {
        return isAllergy;
    }

    public void setIsAllergy(String isAllergy) {
        this.isAllergy = isAllergy;
    }

    public String getDischargeType() {
        return dischargeType;
    }

    public void setDischargeType(String dischargeType) {
        this.dischargeType = dischargeType;
    }

    public String getReceiveOrgName() {
        return receiveOrgName;
    }

    public void setReceiveOrgName(String receiveOrgName) {
        this.receiveOrgName = receiveOrgName;
    }

    public String getIsReadmission() {
        return isReadmission;
    }

    public void setIsReadmission(String isReadmission) {
        this.isReadmission = isReadmission;
    }

    public String getReadmissionPurpose() {
        return readmissionPurpose;
    }

    public void setReadmissionPurpose(String readmissionPurpose) {
        this.readmissionPurpose = readmissionPurpose;
    }

    public String getPriorComaDays() {
        return priorComaDays;
    }

    public void setPriorComaDays(String priorComaDays) {
        this.priorComaDays = priorComaDays;
    }

    public String getPriorComaHours() {
        return priorComaHours;
    }

    public void setPriorComaHours(String priorComaHours) {
        this.priorComaHours = priorComaHours;
    }

    public String getPriorComaMinutes() {
        return priorComaMinutes;
    }

    public void setPriorComaMinutes(String priorComaMinutes) {
        this.priorComaMinutes = priorComaMinutes;
    }

    public String getAlterComaDays() {
        return alterComaDays;
    }

    public void setAlterComaDays(String alterComaDays) {
        this.alterComaDays = alterComaDays;
    }

    public String getAlterComaHours() {
        return alterComaHours;
    }

    public void setAlterComaHours(String alterComaHours) {
        this.alterComaHours = alterComaHours;
    }

    public String getAlterComaMinutes() {
        return alterComaMinutes;
    }

    public void setAlterComaMinutes(String alterComaMinutes) {
        this.alterComaMinutes = alterComaMinutes;
    }

    public String getAgeMonth() {
        return ageMonth;
    }

    public void setAgeMonth(String ageMonth) {
        this.ageMonth = ageMonth;
    }

    public String getAgeDay() {
        return ageDay;
    }

    public void setAgeDay(String ageDay) {
        this.ageDay = ageDay;
    }

    public String getAgehour() {
        return agehour;
    }

    public void setAgehour(String agehour) {
        this.agehour = agehour;
    }

    public String getHomeType() {
        return homeType;
    }

    public void setHomeType(String homeType) {
        this.homeType = homeType;
    }

    public Date getQcDate() {
        return qcDate;
    }

    public void setQcDate(Date qcDate) {
        this.qcDate = qcDate;
    }

    public String getTreateType() {
        return treateType;
    }

    public void setTreateType(String treateType) {
        this.treateType = treateType;
    }

    public String getPathwayType() {
        return pathwayType;
    }

    public void setPathwayType(String pathwayType) {
        this.pathwayType = pathwayType;
    }

    public String getIsUseHerb() {
        return isUseHerb;
    }

    public void setIsUseHerb(String isUseHerb) {
        this.isUseHerb = isUseHerb;
    }

    public String getIsUseEquip() {
        return isUseEquip;
    }

    public void setIsUseEquip(String isUseEquip) {
        this.isUseEquip = isUseEquip;
    }

    public String getIsUseTech() {
        return isUseTech;
    }

    public void setIsUseTech(String isUseTech) {
        this.isUseTech = isUseTech;
    }

    public String getIsDialectialNursting() {
        return isDialectialNursting;
    }

    public void setIsDialectialNursting(String isDialectialNursting) {
        this.isDialectialNursting = isDialectialNursting;
    }

    public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public List<HospitalEmrArea> getEmr_ich_addr() {
        return emr_ich_addr;
    }

    public void setEmr_ich_addr(List<HospitalEmrArea> emr_ich_addr) {
        this.emr_ich_addr = emr_ich_addr;
    }

    public List<HospitalEmrCost> getEmr_ich_charge() {
        return emr_ich_charge;
    }

    public void setEmr_ich_charge(List<HospitalEmrCost> emr_ich_charge) {
        this.emr_ich_charge = emr_ich_charge;
    }

    public List<HospitalEmrDep> getEmr_ich_department() {
        return emr_ich_department;
    }

    public void setEmr_ich_department(List<HospitalEmrDep> emr_ich_department) {
        this.emr_ich_department = emr_ich_department;
    }

    public List<HospitalEmrDoctor> getEmr_ich_doctor() {
        return emr_ich_doctor;
    }

    public void setEmr_ich_doctor(List<HospitalEmrDoctor> emr_ich_doctor) {
        this.emr_ich_doctor = emr_ich_doctor;
    }

    public List<HospitalEmrGm> getEmr_ich_allergies() {
        return emr_ich_allergies;
    }

    public void setEmr_ich_allergies(List<HospitalEmrGm> emr_ich_allergies) {
        this.emr_ich_allergies = emr_ich_allergies;
    }

    public List<HospitalEmrSs> getEmr_ich_operation() {
        return emr_ich_operation;
    }

    public void setEmr_ich_operation(List<HospitalEmrSs> emr_ich_operation) {
        this.emr_ich_operation = emr_ich_operation;
    }

    public List<HospitalEmrSsDoctor> getEmr_ich_operation_doctor() {
        return emr_ich_operation_doctor;
    }

    public void setEmr_ich_operation_doctor(List<HospitalEmrSsDoctor> emr_ich_operation_doctor) {
        this.emr_ich_operation_doctor = emr_ich_operation_doctor;
    }

    public List<HospitalEmrTel> getEmr_ich_tel() {
        return emr_ich_tel;
    }

    public void setEmr_ich_tel(List<HospitalEmrTel> emr_ich_tel) {
        this.emr_ich_tel = emr_ich_tel;
    }

    public List<HospitalEmrZd> getEmr_ich_diagnosis() {
        return emr_ich_diagnosis;
    }

    public void setEmr_ich_diagnosis(List<HospitalEmrZd> emr_ich_diagnosis) {
        this.emr_ich_diagnosis = emr_ich_diagnosis;
    }

    public String getMaritalStatusText() {
        String text = DictUtil.getDictValue("da-hyzk", maritalStatus);
        if (StringUtils.isBlank(text))
            return maritalStatus;
        return text;
    }

    public void setMaritalStatusText(String maritalStatusText) {
        this.maritalStatusText = maritalStatusText;
    }

    public String getOccupationText() {
        String text = DictUtil.getDictValue("da-zy", occupation);
        if (StringUtils.isBlank(text))
            return occupation;
        return text;
    }

    public void setOccupationText(String occupationText) {
        this.occupationText = occupationText;
    }

    public String getNationText() {
        if (StringUtils.isNotBlank(nation) && nation.length() == 1)
            nation = "0" + nation;
        String text = DictUtil.getDictValue("da-mz", nation);
        if (StringUtils.isBlank(text))
            return nation;
        return text;
    }

    public void setNationText(String nationText) {
        this.nationText = nationText;
    }

    public String getCountryText() {
        return country;
    }

    public void setCountryText(String countryText) {
        this.countryText = countryText;
    }
}
