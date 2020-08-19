package com.region.moudles.system.dto;


import java.io.Serializable;

public class SysDiseaseDto  implements Serializable {

    private  String diseaseCode;
    private  String diseaseName;
    private  String diseaseTypeCode;


    public String getDiseaseTypeCode() {
        return diseaseTypeCode;
    }

    public void setDiseaseTypeCode(String diseaseTypeCode) {
        this.diseaseTypeCode = diseaseTypeCode;
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


}
