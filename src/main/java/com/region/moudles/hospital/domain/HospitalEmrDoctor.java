package com.region.moudles.hospital.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="hospital_emr_doctor")
public class HospitalEmrDoctor  extends BaseDomain{

    @Id
    private  String id;//内码
    @Column(name="ich_id")
    private  String ichId;//病案首页内码
    private  String doctorRoleCode;//医生角色代码
    private  String doctorRole;//医生角色
    private  String doctorCode;//医生代码
    private  String doctorName;//医生名称
    @JSONField(format="yyyy-MM-dd")
     private Date createTime;//创建时间

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

    public String getDoctorRoleCode() {
        return doctorRoleCode;
    }

    public void setDoctorRoleCode(String doctorRoleCode) {
        this.doctorRoleCode = doctorRoleCode;
    }

    public String getDoctorRole() {
        return doctorRole;
    }

    public void setDoctorRole(String doctorRole) {
        this.doctorRole = doctorRole;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
