package com.region.moudles.tripartdock.team.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.region.moudles.common.domain.BaseDomain;
import com.region.until.DictUtil;
import com.region.until.validate.Validate;

@Entity
@Table(name = "sys_team_user")
public class SysTeamUser extends BaseDomain {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;// ID

	@Column(name = "team_id")
	private String teamId;// 团队ID

	@Column(name = "user_id")
	@Validate(name = { "save" }, required = true)
	private String userId;// 用户ID
    
	@Validate(name = { "save" }, required = true)
	private String teamRole;// 团队职责（用户类型）
	
	private String remarks;// 备注
	private String teamLeaderFlg;// 是否团队长 0 否 1 是
	@Column(updatable = false)
	private String status;// 状态1正常 2 删除
	@Column(updatable = false)
	private Date createTime;// 操作时间
	@Column(updatable = false)
	private String createUser;// 操作人
	@Transient
	private String teamRoleName;
	private Date updateTime;// 修改时间
	
	private String updateUser;// 修改人

	@Transient
	private String operationType;// 操作类型 1 add 2 update 3 delete

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public String getId() {
		return this.id;
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

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {

		this.userId = userId;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getTeamRole() {
		return teamRole;
	}

	public void setTeamRole(String teamRole) {
		this.teamRoleName = DictUtil.getDictValue("teamRole", teamRole);
		this.teamRole = teamRole;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getTeamLeaderFlg() {
		return this.teamLeaderFlg;
	}

	public void setTeamLeaderFlg(String teamLeaderFlg) {
		this.teamLeaderFlg = teamLeaderFlg;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getTeamRoleName() {
		return this.teamRoleName = DictUtil.getDictValue("teamRole", teamRole);
	}

	public void setTeamRoleName(String teamRoleName) {
		this.teamRoleName = teamRoleName;
	}


}
