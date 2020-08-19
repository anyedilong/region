package com.region.moudles.tripartdock.team.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.region.moudles.common.domain.BaseDomain;

@Entity
@Table(name = "sys_team_org")
public class SysTeamOrg extends BaseDomain{

	private static final long serialVersionUID = 16464864L;

	@Id
	private String id;//ID
	@Column(name = "team_id")
	private String teamId;// 团队ID
	
	@Column(name = "org_id")
	private String orgId;// 机构ID
	
	@Column(updatable = false)
	private Date createTime;// 操作时间
	@Column(updatable = false)
	private String createUser;// 操作人
	
	private Date updateTime;// 修改时间
	
	private String updateUser;// 修改人
	
	private String status;//状态 1正常 2删除
	
	@Transient
	private String operationType;// 操作类型 1 add 2 update 3 delete

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
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

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
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

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
}
