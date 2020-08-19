package com.region.moudles.tripartdock.follow.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.until.DictUtil;

import java.util.Date;

public class GxbDto {

    private String hzmc;
    private String orgId;
    private String orgName;
    private String sfys;
    private String sfysName;
    private String sffs;
    private String sffsName;
    @JSONField(format="yyyy-MM-dd")
    private Date sfrq;
    private String id;

    public String getSfys() {
        return sfys;
    }

    public void setSfys(String sfys) {
        this.sfys = sfys;
    }

    public String getSfysName() {
        return sfysName;
    }

    public void setSfysName(String sfysName) {
        this.sfysName = sfysName;
    }

    public String getSffs() {
        return sffs;
    }

    public void setSffs(String sffs) {
        this.sffs = sffs;
    }

    public String getSffsName() {
        return DictUtil.getDictValue("sffs", this.sffs);
    }

    public void setSffsName(String sffsName) {
        this.sffsName = sffsName;
    }

    public Date getSfrq() {
        return sfrq;
    }

    public void setSfrq(Date sfrq) {
        this.sfrq = sfrq;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHzmc() {
        return hzmc;
    }

    public void setHzmc(String hzmc) {
        this.hzmc = hzmc;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}
