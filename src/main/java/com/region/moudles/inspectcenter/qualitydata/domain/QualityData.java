package com.region.moudles.inspectcenter.qualitydata.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 质控数据
 */
@Entity
@Table(name = "blt_quality_data")
public class QualityData extends BaseDomain {
    @Id
    private String id;
    private String orgCode; //所属机构代码
    private String orgName; //所属机构名称
    private String apparatusName; //仪器名称
    private String apparatusModel; //仪器型号
    private String projectName; //质控项目名称
    private String controlResult; //质控结果（正常，失控）
    private String controlType; //质控类型（手动、自动）
    @JSONField(format = "yyyy-MM-dd")
    private Date controlDate; //质控时间
    private String result1;//结果1
    private String result2;//结果2
    private String result3;//结果3
    private String result4;//结果4
    private String result5;//结果5
    private String result6;//结果6
    private String result7;//结果7
    private String result8;//结果8

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
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

    public String getApparatusName() {
        return apparatusName;
    }

    public void setApparatusName(String apparatusName) {
        this.apparatusName = apparatusName;
    }

    public String getApparatusModel() {
        return apparatusModel;
    }

    public void setApparatusModel(String apparatusModel) {
        this.apparatusModel = apparatusModel;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getControlResult() {
        return controlResult;
    }

    public void setControlResult(String controlResult) {
        this.controlResult = controlResult;
    }

    public String getControlType() {
        return controlType;
    }

    public void setControlType(String controlType) {
        this.controlType = controlType;
    }

    public Date getControlDate() {
        return controlDate;
    }

    public void setControlDate(Date controlDate) {
        this.controlDate = controlDate;
    }

    public String getResult1() {
        return result1;
    }

    public void setResult1(String result1) {
        this.result1 = result1;
    }

    public String getResult2() {
        return result2;
    }

    public void setResult2(String result2) {
        this.result2 = result2;
    }

    public String getResult3() {
        return result3;
    }

    public void setResult3(String result3) {
        this.result3 = result3;
    }

    public String getResult4() {
        return result4;
    }

    public void setResult4(String result4) {
        this.result4 = result4;
    }

    public String getResult5() {
        return result5;
    }

    public void setResult5(String result5) {
        this.result5 = result5;
    }

    public String getResult6() {
        return result6;
    }

    public void setResult6(String result6) {
        this.result6 = result6;
    }

    public String getResult7() {
        return result7;
    }

    public void setResult7(String result7) {
        this.result7 = result7;
    }

    public String getResult8() {
        return result8;
    }

    public void setResult8(String result8) {
        this.result8 = result8;
    }
}
