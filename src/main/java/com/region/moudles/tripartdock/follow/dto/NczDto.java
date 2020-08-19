package com.region.moudles.tripartdock.follow.dto;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.until.DictUtil;

public class NczDto {

    private String orgId;
    private String orgName;
    private String sfys;
    private String sfysName;
    private String sffs;
    private String sffsName;
    private String hzxm;
    @JSONField(format="yyyy-MM-dd")
    private Date sfrq;
    private String id;

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
    	this.sffsName = DictUtil.getDictValue("sffs", sffs);
        this.sffs = sffs;
    }

    public String getSffsName() {
        return sffsName;
    }

    public void setSffsName(String sffsName) {
        this.sffsName = sffsName;
    }

    public String getHzxm() {
        return hzxm;
    }

    public void setHzxm(String hzxm) {
        this.hzxm = hzxm;
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
}
