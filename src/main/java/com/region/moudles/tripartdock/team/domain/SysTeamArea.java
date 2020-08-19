package com.region.moudles.tripartdock.team.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


import com.region.moudles.common.domain.BaseDomain;

@Entity
@Table(name = "sys_team_area")
public class SysTeamArea extends BaseDomain{

	private static final long serialVersionUID = 15856564L;
	
	@Id
	private String id;
	@Column(name = "team_id")
	private String teamId;
	
	@Column(name = "area_id")
	private String areaId;
	
	@Column(updatable = false)
	private Date createTime;// 操作时间
	@Column(updatable = false)
	private String createUser;// 操作人
	
	private Date updateTime;// 修改时间
	
	private String updateUser;// 修改人
	
	private String status;//状态 1正常 2删除
	
	@Transient
	private String operationType;// 操作类型 1 add 2 update 3 delete
	
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

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
	
}
