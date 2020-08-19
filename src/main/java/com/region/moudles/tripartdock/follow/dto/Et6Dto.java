package com.region.moudles.tripartdock.follow.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.tripartdock.follow.domain.FollowEtSf6;

import java.util.Date;

public class Et6Dto {
    private String stage;
    private String xm;
    private String orgId;
    private String orgName;

    private String id;//
    private String jmid;//居民id
    private String bs;//
    private String sfys;
    private String dah;
    private String sfysName;
    @JSONField(format="yyyy-MM-dd")
    private Date sfrq;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJmid() {
        return jmid;
    }

    public void setJmid(String jmid) {
        this.jmid = jmid;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    public String getSfys() {
        return sfys;
    }

    public void setSfys(String sfys) {
        this.sfys = sfys;
    }

    public String getDah() {
        return dah;
    }

    public void setDah(String dah) {
        this.dah = dah;
    }

    public String getSfysName() {
        return sfysName;
    }

    public void setSfysName(String sfysName) {
        this.sfysName = sfysName;
    }

    public Date getSfrq() {
        return sfrq;
    }

    public void setSfrq(Date sfrq) {
        this.sfrq = sfrq;
    }

    public String getStage() {
        if ("0".equals(stage)) {
            return "9";
        } else if ("1".equals(stage)) {
            return "10";
        } else if ("2".equals(stage)) {
            return "11";
        } else if ("3".equals(stage)) {
            return "12";
        }
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
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
