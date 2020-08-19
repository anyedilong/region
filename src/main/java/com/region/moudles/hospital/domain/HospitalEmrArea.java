package com.region.moudles.hospital.domain;

import com.region.moudles.common.domain.BaseDomain;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hospital_emr_area")
public class HospitalEmrArea extends BaseDomain {

     @Id
     private String id;//内码
     @Column(name="ich_id")
     private String ichId;//病案首页内码
     private  String addrTypeCode;//地址类别代码
     private String  addr;//地址
     private  String  cantCode;//行政区划编码
     private  String  province;//地址-省
     private  String city;//地址-市
     private  String  county;//地址-县
     private  String town;//地址-乡
     private  String  village;//地址-村
     private  String  houseNum;//地址-门牌号
     private  String postalCode;//邮政编码


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

    public String getAddrTypeCode() {
        return addrTypeCode;
    }

    public void setAddrTypeCode(String addrTypeCode) {
        this.addrTypeCode = addrTypeCode;
    }

    public String getAddr() {
        if (StringUtils.isBlank(addr))
            return (province + city + county + town + village + houseNum).replaceAll("null", "");
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getCantCode() {
        return cantCode;
    }

    public void setCantCode(String cantCode) {
        this.cantCode = cantCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
