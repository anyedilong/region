package com.region.moudles.tripartdock.team.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.alibaba.fastjson.annotation.JSONField;
import com.region.moudles.common.domain.BaseDomain;
import com.region.until.validate.Validate;

@Entity
@Table(name = "sys_team")
public class SysTeam extends BaseDomain {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;// null

	@Validate(name = { "save" }, required = true)
	private String teamName;// 团队名称

	@Validate(name = { "save" }, required = true)
	@Column(name = "team_leader_id")
	private String teamLeaderId;// 团队长（用户ID）

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "team_introduction", columnDefinition = "CLOB", nullable = true)
	private String teamIntroduction;// 团队简介

	private String healthPhone;// 健康电话
	private Date updateTime;// 修改时间
	private String updateUser;// 修改人

	@Column(name = "org_id", updatable = false)
	@Validate(name = { "save" }, required = true)
	private String orgId;// 所属机构

	@Column(updatable = true)
	@Validate(name = { "save" }, required = true)
	@JSONField(format = "yyyy-MM-dd")
	private Date establishTime;// 成立时间

	@Column(updatable = false)
	@JSONField(format = "yyyy-MM-dd")
	private Date createTime;// 创建时间

	@Column(updatable = false)
	private String createUser;// 创建人

	@Column(updatable = false)
	private String status;// 状态 1正常 2冻结 3解散

	@Column(updatable = false)
	private String teamLevel;// 等级

	@Column(updatable = false)
	private Integer score;// 评分

	@Column(updatable = false)
	@JSONField(format = "yyyy-MM-dd")
	private Date disbandTime;// 解散时间
	@Column(updatable = false)
	private String disbandUser;// 解散人

	@Column(updatable = false)
	@JSONField(format = "yyyy-MM-dd")
	private Date disbandRemarks;// 解散备注
	@Column(updatable = false)
	private String electronicSignature;// 电子签章

	@Transient
	private List<SysTeamUser> teamUserList;// 团队成员
	@Transient
	private List<SysTeamOrg> teamOrgList;// 团队管辖机构
	@Transient
	private List<SysTeamArea> teamAreaList; //团队区划
	@Transient
	private List<SysTeamHis> teamHisList; //团队成员责任
	@Transient
	private String orgName;
	
	private String remarks;// 备注
	
	
	public List<SysTeamArea> getTeamAreaList() {
		return teamAreaList;
	}

	public void setTeamAreaList(List<SysTeamArea> teamAreaList) {
		this.teamAreaList = teamAreaList;
	}

	public List<SysTeamOrg> getTeamOrgList() {
		return teamOrgList;
	}

	public void setTeamOrgList(List<SysTeamOrg> teamOrgList) {
		this.teamOrgList = teamOrgList;
	}
	
	public List<SysTeamUser> getTeamUserList() {
		return teamUserList;
	}

	public void setTeamUserList(List<SysTeamUser> teamUserList) {
		this.teamUserList = teamUserList;
	}

	public List<SysTeamHis> getTeamHisList() {
		return teamHisList;
	}

	public void setTeamHisList(List<SysTeamHis> teamHisList) {
		this.teamHisList = teamHisList;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTeamName() {
		return this.teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamLeaderId() {
		return this.teamLeaderId;
	}

	public void setTeamLeaderId(String teamLeaderId) {
		this.teamLeaderId = teamLeaderId;
	}

	public String getTeamIntroduction() {
		return teamIntroduction;
	}

	public void setTeamIntroduction(String teamIntroduction) {
		this.teamIntroduction = teamIntroduction;
	}

	public String getHealthPhone() {
		return this.healthPhone;
	}

	public void setHealthPhone(String healthPhone) {
		this.healthPhone = healthPhone;
	}

	public String getOrgId() {
		return this.orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public Date getEstablishTime() {
		return this.establishTime;
	}

	public void setEstablishTime(Date establishTime) {
		this.establishTime = establishTime;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTeamLevel() {
		return this.teamLevel;
	}

	public void setTeamLevel(String teamLevel) {
		this.teamLevel = teamLevel;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Date getDisbandTime() {
		return this.disbandTime;
	}

	public void setDisbandTime(Date disbandTime) {
		this.disbandTime = disbandTime;
	}

	public Date getDisbandRemarks() {
		return disbandRemarks;
	}

	public void setDisbandRemarks(Date disbandRemarks) {
		this.disbandRemarks = disbandRemarks;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getElectronicSignature() {
		return this.electronicSignature;
	}

	public void setElectronicSignature(String electronicSignature) {
		this.electronicSignature = electronicSignature;
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

	public String getDisbandUser() {
		return disbandUser;
	}

	public void setDisbandUser(String disbandUser) {
		this.disbandUser = disbandUser;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}


}
