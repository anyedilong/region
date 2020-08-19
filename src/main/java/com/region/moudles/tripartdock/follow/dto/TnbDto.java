package com.region.moudles.tripartdock.follow.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.tripartdock.follow.domain.FollowNcz;
import com.region.until.DictUtil;

import java.util.Date;

public class TnbDto {

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
        this.sffs = sffs;
    }

    public String getSffsName() {
        return DictUtil.getDictValue("sffs", this.sffs);
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
