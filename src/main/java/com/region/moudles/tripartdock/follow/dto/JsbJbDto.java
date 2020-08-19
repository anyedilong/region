package com.region.moudles.tripartdock.follow.dto;

import com.region.moudles.tripartdock.follow.domain.FollowJsbJb;

public class JsbJbDto extends FollowJsbJb {

    private String hzmc;
    private String orgId;
    private String orgName;

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
