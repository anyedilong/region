package com.region.moudles.his.authcode.domain;

import com.region.moudles.common.domain.BaseDomain;

import javax.persistence.*;

@Entity
@Table(name = "sys_auth")
public class SysAuth extends BaseDomain {

	private static final long serialVersionUID = 156496496L;
	
	@Id
    private String id;
    @Column(name = "org_id")
    private String orgId;
    @Column(name = "auth_code")
    private String authCode;
    @Transient
    private String status;
    @Transient
    private String orgName;

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
}
