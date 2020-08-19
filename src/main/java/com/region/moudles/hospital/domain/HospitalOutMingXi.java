package com.region.moudles.hospital.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;
import com.region.until.DictUtil;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "hospital_out_mingxi")
public class HospitalOutMingXi extends BaseDomain {

    private static final long serialVersionUID = 76416161616L;

    @Id
    private String id;//内码
    private String itemCode;//明细项目编号
    private String drugClassCode;//药品分类代码
    private String drugCode;//药物编号/项目编号
    private String drugName;//药物名称/项目名称
    private String formName;//剂型名称
    private String spec;//规格
    private String unit;//单位
    private String price;//单价
    private String quantity;//数量
    private String issueMark;//发药标志
    private String manufacturerName;//生产厂家名称
    @JSONField(format = "yyyy-MM-dd")
    private Date issueDate;//发药日期
    private String receivableAmount;//应收金额
    private String ownAmount;//自费金额
    private String hisId;//院内内码
    @Column(name = "out_id")
    private String outId;//结算单内码
    private String itemType;//处方项类别01:西药 02:中成药 03:中草药 04:麻醉、一类精神药品 05:检查 06:化验 07:放射 08:治疗 09:手术  99:其他
    private String drugType;//等级分类 1.普通药品  2.贵重药品  3.麻醉药品 4.精神一类 5.毒性药品 6.特殊管理药 7.剧毒药品
    private String drugHeds;//基药分类：1.国家基药 2.国家常药 3.省挂网 4.非基药

    @Transient
    private String isId;
    @Transient
    private String orgCode;

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getIsId() {
        return isId;
    }

    public void setIsId(String isId) {
        this.isId = isId;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getDrugClassCode() {
        return DictUtil.getDictValue("200200", drugClassCode);
    }

    public void setDrugClassCode(String drugClassCode) {
        this.drugClassCode = drugClassCode;
    }

    public String getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(String drugCode) {
        this.drugCode = drugCode;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getIssueMark() {
        return issueMark;
    }

    public void setIssueMark(String issueMark) {
        this.issueMark = issueMark;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String getReceivableAmount() {
        return receivableAmount;
    }

    public void setReceivableAmount(String receivableAmount) {
        this.receivableAmount = receivableAmount;
    }

    public String getOwnAmount() {
        return ownAmount;
    }

    public void setOwnAmount(String ownAmount) {
        this.ownAmount = ownAmount;
    }

    public String getHisId() {
        return hisId;
    }

    public void setHisId(String hisId) {
        this.hisId = hisId;
    }

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
    }


    public String getItemType() {
        return itemType;
    }


    public void setItemType(String itemType) {
        this.itemType = itemType;
    }


    public String getDrugType() {
        return drugType;
    }


    public void setDrugType(String drugType) {
        this.drugType = drugType;
    }


    public String getDrugHeds() {
        return drugHeds;
    }


    public void setDrugHeds(String drugHeds) {
        this.drugHeds = drugHeds;
    }
}
