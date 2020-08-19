package com.region.moudles.tripartdock.health.dto;

import com.region.moudles.tripartdock.health.bean.Yfjz;

public class YfjzDto extends Yfjz {
    private String hzmc;
    private String jzys;
    private String orgId;
    private String orgName;

    public String getHzmc() {
        return hzmc;
    }

    public void setHzmc(String hzmc) {
        this.hzmc = hzmc;
    }

    public String getJzys() {
        return jzys;
    }

    public void setJzys(String jzys) {
        this.jzys = jzys;
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
