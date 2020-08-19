package com.region.moudles.system.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;

/**
 * 用户表
 */
@Entity
@Table(name = "sys_user")
public class SysUser extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 154646464848L;
	@Id
    private String id;//内码
    private String username;//用户名
    private String password;//密码
    private String name;//姓名
    private String orgId;//所属机构
    private String securityToken;//授权码
    private String status;//状态   1正常  2 冻结3删除
    private String remarks;//备注
    @JSONField(format = "yyyy-MM-dd")
    private Date createTime;//创建时间
    private String createUser;//创建人
    
    @Transient
    private String isCludeSubFlg;//是否包含子集
    @Transient
    private String roleIds;//角色ids
    @Transient
    private String roleNames;//角色ids

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getSecurityToken() {
		return securityToken;
	}

	public void setSecurityToken(String securityToken) {
		this.securityToken = securityToken;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getIsCludeSubFlg() {
		return isCludeSubFlg;
	}

	public void setIsCludeSubFlg(String isCludeSubFlg) {
		this.isCludeSubFlg = isCludeSubFlg;
	}

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	public String getRoleNames() {
		return roleNames;
	}

	public void setRoleNames(String roleNames) {
		this.roleNames = roleNames;
	}


}
