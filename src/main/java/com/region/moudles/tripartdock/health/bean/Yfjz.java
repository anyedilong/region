package com.region.moudles.tripartdock.health.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 预防接种
 */
@Entity
@Table(name = "HEALTH_YFJZ")
public class Yfjz extends BaseDomain {

    @Id
    private String id;//自增id
    private String jmid;//居民id
    private String sfzh;// 身份证号
    @Column(name = "bacterin_name")
    private String bacterinName;//疫苗
    @Column(name = "needle_no")
    private String needleNo;//剂次
    @Column(name = "immu_date")
    @JSONField(format = "yyyy-MM-dd")
    private Date immuDate;//接种日期
    @Column(name = "immu_site")
    private String immuSite;//接种部位
    @Column(name = "bacterin_no")
    private String bacterinNo;//疫苗批号
    @Column(name = "immu_doc")
    private String immuDoc;//接种医生
    @Column(name = "other_info")
    private String otherInfo;//备注
    @Column(name = "immu_organ")
    private String immuOrgan;//接种单位
    @Column(name = "immu_product")
    private String immuProduct;//生产企业
    @Column(name = "health_id")
    private String healthId;//健康体检ID
    @Column(name = "invalid")
    private String invalid;//标记作废
    @JSONField(format = "yyyy-MM-dd")
    @Column(name = "create_time")
    private Date createTime;//数据插入时间

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getJmid() {
        return jmid;
    }

    public void setJmid(String jmid) {
        this.jmid = jmid;
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public String getBacterinName() {
        return bacterinName;
    }

    public void setBacterinName(String bacterinName) {
        this.bacterinName = bacterinName;
    }

    public String getNeedleNo() {
        return needleNo;
    }

    public void setNeedleNo(String needleNo) {
        this.needleNo = needleNo;
    }

    public Date getImmuDate() {
        return immuDate;
    }

    public void setImmuDate(Date immuDate) {
        this.immuDate = immuDate;
    }

    public String getImmuSite() {
        return immuSite;
    }

    public void setImmuSite(String immuSite) {
        this.immuSite = immuSite;
    }

    public String getBacterinNo() {
        return bacterinNo;
    }

    public void setBacterinNo(String bacterinNo) {
        this.bacterinNo = bacterinNo;
    }

    public String getImmuDoc() {
        return immuDoc;
    }

    public void setImmuDoc(String immuDoc) {
        this.immuDoc = immuDoc;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    public String getImmuOrgan() {
        return immuOrgan;
    }

    public void setImmuOrgan(String immuOrgan) {
        this.immuOrgan = immuOrgan;
    }

    public String getImmuProduct() {
        return immuProduct;
    }

    public void setImmuProduct(String immuProduct) {
        this.immuProduct = immuProduct;
    }

    public String getHealthId() {
        return healthId;
    }

    public void setHealthId(String healthId) {
        this.healthId = healthId;
    }

    public String getInvalid() {
        return invalid;
    }

    public void setInvalid(String invalid) {
        this.invalid = invalid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
