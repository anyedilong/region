package com.region.moudles.hospital.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="hospital_emr_cost")
public class HospitalEmrCost extends BaseDomain {

    @Id
     private  String id;//内码
    @Column(name="ich_id")
     private  String ichId;//病案首页内码
     private  String chargeTypeCode;//住院费用分类代码
     private  String chargeType;//住院费用分类
     private  String chargeAmount;//住院费用金额
     @JSONField(format="yyyy-MM-dd")
     private  Date  createTime;//创建时间


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

    public String getChargeTypeCode() {
        return chargeTypeCode;
    }

    public void setChargeTypeCode(String chargeTypeCode) {
        this.chargeTypeCode = chargeTypeCode;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public String getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(String chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
