package com.region.moudles.tripartdock.follow.dto;

import com.region.moudles.tripartdock.follow.domain.FollowGxySz;

public class GxySzDto extends FollowGxySz {

    private String orgId;
    private String orgName;

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
