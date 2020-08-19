package com.region.moudles.tripartdock.health.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;

/**
 * 转诊
 */
@Entity
@Table(name = "blt_referral")
public class Referral extends BaseDomain {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    @Column(name = "idcard", updatable = false)
    private String idcard;//   成员身份证号
    @JSONField(format = "yyyy-MM-dd")
    private Date referralTime;//   转诊时间
    private String impression;// 初步印象
    private String telephone;//联系电话
    private String patientNum;//病案号
    private String receiveHospital;//接诊医院
    private String receiveDept;//接诊科室
    private String receiveUserId;//接诊操作人Id
    private String receiveUserName;//接诊操作人

    private String referralHospital;// 转诊医院
    private String referralDept;// 转诊科室
    private String referralUserId;// 转诊操作人id
    private String referralUserName;// 转诊操作人

    @JSONField(format = "yyyy-MM-dd")
    private Date referralOperationTime;// 转诊操作时间
    private String doctorTelephone;// 医生联系电话
    private String pastHistory;// 主要既往史
    private String referralCause;// 转诊原因
    private String treatmentCourse;// 治疗经过
    private String address;//家庭住址
    private String diagnosticResult;// 诊断结果
    private String inspectionResult;// 检查结果
    private String rehabilitationAdvice;// 康复建议
    private String referralRemarks;//备注
    private String deleteFlg;// 是否删除 1正常 2删除
    private String dataSource;// 数据源 1平台 2平板 3手机
    private String dataSourceNo;// 数据来源唯一标识
    private String uploadDeviceNum;// 设备编号
    private String uploadIp;// IP
    @JSONField(format = "yyyy-MM-dd")
    @Column(updatable = false)
    private Date uploadTime;// 上传时间
    @Column(updatable = false)
    private String uploadUser;// 上传人
    @JSONField(format = "yyyy-MM-dd")
    private Date returnTime;//转回时间
    @JSONField(format = "yyyy-MM-dd")
    @Column(updatable = false)
    private Date createTime;//创建时间
    @Column(updatable = false)
    private String createUser;//创建人
    @JSONField(format = "yyyy-MM-dd")
    private Date updateTime;//修改时间
    private String updateUser;//修改人
    private String status;//状态  1、转入 2、转出
    @Column(name = "jmid")
    private String jmId;
    
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH, optional = false)
    @JoinColumn(name = "jmid", referencedColumnName = "id", insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private BaseCustomerDomain Customer;// 户主基本信息

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public BaseCustomerDomain getCustomer() {
        return Customer;
    }

    public void setCustomer(BaseCustomerDomain customer) {
        Customer = customer;
    }

    public Date getReferralTime() {
        return this.referralTime;
    }

    public void setReferralTime(Date referralTime) {
        this.referralTime = referralTime;
    }

    public String getReferralHospital() {
        return this.referralHospital;
    }

    public void setReferralHospital(String referralHospital) {
        this.referralHospital = referralHospital;
    }

    public String getReferralDept() {
        return this.referralDept;
    }

    public void setReferralDept(String referralDept) {
        this.referralDept = referralDept;
    }

    public Date getReturnTime() {
        return this.returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return this.createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return this.updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReferralUserId() {
        return referralUserId;
    }

    public void setReferralUserId(String referralUserId) {
        this.referralUserId = referralUserId;
    }

    public String getReferralUserName() {
        return referralUserName;
    }

    public void setReferralUserName(String referralUserName) {
        this.referralUserName = referralUserName;
    }

    public String getReceiveHospital() {
        return receiveHospital;
    }

    public void setReceiveHospital(String receiveHospital) {
        this.receiveHospital = receiveHospital;
    }

    public String getReceiveDept() {
        return receiveDept;
    }

    public void setReceiveDept(String receiveDept) {
        this.receiveDept = receiveDept;
    }

    public String getReceiveUserId() {
        return receiveUserId;
    }

    public void setReceiveUserId(String receiveUserId) {
        this.receiveUserId = receiveUserId;
    }

    public String getReceiveUserName() {
        return receiveUserName;
    }

    public void setReceiveUserName(String receiveUserName) {
        this.receiveUserName = receiveUserName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPatientNum() {
        return patientNum;
    }

    public void setPatientNum(String patientNum) {
        this.patientNum = patientNum;
    }

    public Date getReferralOperationTime() {
        return referralOperationTime;
    }

    public void setReferralOperationTime(Date referralOperationTime) {
        this.referralOperationTime = referralOperationTime;
    }

    public String getDoctorTelephone() {
        return doctorTelephone;
    }

    public void setDoctorTelephone(String doctorTelephone) {
        this.doctorTelephone = doctorTelephone;
    }

    public String getImpression() {
        return impression;
    }

    public void setImpression(String impression) {
        this.impression = impression;
    }

    public String getPastHistory() {
        return pastHistory;
    }

    public void setPastHistory(String pastHistory) {
        this.pastHistory = pastHistory;
    }

    public String getReferralCause() {
        return referralCause;
    }

    public void setReferralCause(String referralCause) {
        this.referralCause = referralCause;
    }

    public String getTreatmentCourse() {
        return treatmentCourse;
    }

    public void setTreatmentCourse(String treatmentCourse) {
        this.treatmentCourse = treatmentCourse;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDiagnosticResult() {
        return diagnosticResult;
    }

    public void setDiagnosticResult(String diagnosticResult) {
        this.diagnosticResult = diagnosticResult;
    }

    public String getInspectionResult() {
        return inspectionResult;
    }

    public void setInspectionResult(String inspectionResult) {
        this.inspectionResult = inspectionResult;
    }

    public String getRehabilitationAdvice() {
        return rehabilitationAdvice;
    }

    public void setRehabilitationAdvice(String rehabilitationAdvice) {
        this.rehabilitationAdvice = rehabilitationAdvice;
    }

    public String getReferralRemarks() {
        return referralRemarks;
    }

    public void setReferralRemarks(String referralRemarks) {
        this.referralRemarks = referralRemarks;
    }

    public String getDeleteFlg() {
        return deleteFlg;
    }

    public void setDeleteFlg(String deleteFlg) {
        this.deleteFlg = deleteFlg;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getDataSourceNo() {
        return dataSourceNo;
    }

    public void setDataSourceNo(String dataSourceNo) {
        this.dataSourceNo = dataSourceNo;
    }

    public String getUploadDeviceNum() {
        return uploadDeviceNum;
    }

    public void setUploadDeviceNum(String uploadDeviceNum) {
        this.uploadDeviceNum = uploadDeviceNum;
    }

    public String getUploadIp() {
        return uploadIp;
    }

    public void setUploadIp(String uploadIp) {
        this.uploadIp = uploadIp;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getUploadUser() {
        return uploadUser;
    }

    public void setUploadUser(String uploadUser) {
        this.uploadUser = uploadUser;
    }

	public String getJmId() {
		return jmId;
	}

	public void setJmId(String jmId) {
		this.jmId = jmId;
	}
}

