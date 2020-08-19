package com.region.moudles.tripartdock.follow.dto;

import com.region.moudles.tripartdock.follow.domain.FollowEtJb;

public class EtJbDto extends FollowEtJb {
    private String xm;
    private String orgId;
    private String orgName;

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
