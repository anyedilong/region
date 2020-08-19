package com.region.moudles.hospital.domain;


import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="hospital_emr_tel")
public class HospitalEmrTel  extends BaseDomain{

    @Id
    private  String id;//内码
    @Column(name="ich_id")
    private  String ichId;//病案首页内码
    private  String linkmanRelation;//联系人关系
    private  String linman;//联系人姓名
    private  String telType;//电话号码类别
    private  String telphone;//联系电话
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

    public String getLinkmanRelation() {
        return linkmanRelation;
    }

    public void setLinkmanRelation(String linkmanRelation) {
        this.linkmanRelation = linkmanRelation;
    }

    public String getLinman() {
        return linman;
    }

    public void setLinman(String linman) {
        this.linman = linman;
    }

    public String getTelType() {
        return telType;
    }

    public void setTelType(String telType) {
        this.telType = telType;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
