package com.region.moudles.tripartdock.follow.dto;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class JkpgDto {

    private String id;
    private String hzxm;
    private String orgId;
    private String orgName;
    private String sfys;
    private String sfysName;
    private String zdf;
    
    @JSONField(format = "yyyy-MM-dd")
    private Date sfrq;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHzxm() {
        return hzxm;
    }

    public void setHzxm(String hzxm) {
        this.hzxm = hzxm;
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

    public String getZdf() {
		return zdf;
	}

	public void setZdf(String zdf) {
		this.zdf = zdf;
	}

	public Date getSfrq() {
        return sfrq;
    }

    public void setSfrq(Date sfrq) {
        this.sfrq = sfrq;
    }
}
