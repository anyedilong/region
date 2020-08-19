package com.region.moudles.outpatient.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.region.moudles.common.domain.BaseDomain;
import com.region.until.DictUtil;


@Entity
@Table(name="outpatient_rx_mingxi")
public class OutpatientRxMingxi  extends BaseDomain{

	private static final long serialVersionUID = 1234236355345L;
	
    @Id
    private String id;//
    private String hisId;//院内id，内码
    @Column(name="or_id")
    private String orId;//门诊处方内码
    private String orgCode;
    private String itemType;//处方项类别01:西药 02:中成药 03:中草药 04:麻醉、一类精神药品 05:检查 06:化验 07:放射 08:治疗 09:手术  99:其他
    private String drugClassCode;//药品分类代码
    private String drugClassName;//药品分类名称
    private String drugCode;//药品编号/项目编号
    private String drugName;//药品名称/项目名称
    private String spec;//规格
    private String unit;//单位
    private String quantity;//数量
    private String herbNum;//草药付数
    private String unitDose;//单位剂量
    private String orderDosage;//医嘱用量
    private String drugRoute;//用药方式
    private String drugFrequency;//执行频率
    private String price;
    @Column(name="drug_type")
    private String drugType;//等级分类 1.普通药品  2.贵重药品  3.麻醉药品 4.精神一类 5.毒性药品 6.特殊管理药 7.剧毒药品
    @Column(name="drug_heds")
    private String drugHeds;//基药分类：1.国家基药 2.国家常药 3.省挂网 4.非基药
    @Transient
    private String itemTypeText;
    
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getHisId() {
        return hisId;
    }

    public void setHisId(String hisId) {
        this.hisId = hisId;
    }

    public String getOrId() {
        return orId;
    }

    public void setOrId(String orId) {
        this.orId = orId;
    }

    public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getDrugClassCode() {
        return drugClassCode;
    }

    public void setDrugClassCode(String drugClassCode) {
        this.drugClassCode = drugClassCode;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
    	this.itemTypeText = DictUtil.getDictValue("100100", itemType);
        this.itemType = itemType;
    }

    public String getDrugClassName() {
        return drugClassName;
    }

    public void setDrugClassName(String drugClassName) {
        this.drugClassName = drugClassName;
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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getHerbNum() {
        return herbNum;
    }

    public void setHerbNum(String herbNum) {
        this.herbNum = herbNum;
    }

    public String getUnitDose() {
        return unitDose;
    }

    public void setUnitDose(String unitDose) {
        this.unitDose = unitDose;
    }

    public String getOrderDosage() {
        return orderDosage;
    }

    public void setOrderDosage(String orderDosage) {
        this.orderDosage = orderDosage;
    }

    public String getDrugRoute() {
        return drugRoute;
    }

    public void setDrugRoute(String drugRoute) {
        this.drugRoute = drugRoute;
    }

    public String getDrugFrequency() {
        return drugFrequency;
    }

    public void setDrugFrequency(String drugFrequency) {
        this.drugFrequency = drugFrequency;
    }

	public String getItemTypeText() {
		return itemTypeText;
	}

	public void setItemTypeText(String itemTypeText) {
		this.itemTypeText = itemTypeText;
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
