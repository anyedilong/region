package com.region.moudles.system.domain;


import com.region.moudles.common.domain.BaseDomain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sys_disease")
public class SysDiseaseDomain extends BaseDomain {

    @Id
    private  String id;
    private  String diseaseCode;
    private  String diseaseName;
    private  String diseaseType;


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getDiseaseType() {
        return diseaseType;
    }

    public void setDiseaseType(String diseaseType) {
        this.diseaseType = diseaseType;
    }
}
