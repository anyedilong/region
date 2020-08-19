package com.region.moudles.system.dto;

public class SysDrugDto {

    private  String drugName;
    private  String drugCode;
    private  String drugUnit;
    private  String drugType;
    private  String drugHeds;
    private  String drugCountries;

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(String drugCode) {
        this.drugCode = drugCode;
    }

    public String getDrugUnit() {
        return drugUnit;
    }

    public void setDrugUnit(String drugUnit) {
        this.drugUnit = drugUnit;
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

    public String getDrugCountries() {
        return drugCountries;
    }

    public void setDrugCountries(String drugCountries) {
        this.drugCountries = drugCountries;
    }
}
