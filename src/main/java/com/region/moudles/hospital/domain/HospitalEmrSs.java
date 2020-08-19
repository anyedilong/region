package com.region.moudles.hospital.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name ="hospital_emr_operation")
public class HospitalEmrSs extends BaseDomain {

    @Id
    private  String id;//内码
    @Column(name="ich_id")
    private  String ichId;//病案首页内码
    private  String snNum;//序号
    private  String operationCode;//手术/操作代码
    private  String operationName;//手术/操作名称
    @JSONField(format="yyyy-MM-dd")
    private  Date  operationDate;//手术操作日期
    private  String anaesthesia;//麻醉-方法
    private  String healingGrade;//切口愈合等级
    @JSONField(format="yyyy-MM-dd")
    private  Date createTime;//创建时间
    private  String operationGrade;//手术级别



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

    public String getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public String getAnaesthesia() {
        return anaesthesia;
    }

    public void setAnaesthesia(String anaesthesia) {
        this.anaesthesia = anaesthesia;
    }

    public String getHealingGrade() {
        return healingGrade;
    }

    public void setHealingGrade(String healingGrade) {
        this.healingGrade = healingGrade;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOperationGrade() {
        return operationGrade;
    }

    public void setOperationGrade(String operationGrade) {
        this.operationGrade = operationGrade;
    }
}
