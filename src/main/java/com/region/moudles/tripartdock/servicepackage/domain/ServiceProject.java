package com.region.moudles.tripartdock.servicepackage.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.region.moudles.common.domain.BaseDomain;
import com.region.until.validate.Validate;

@Entity
@Table(name = "sys_service_project")
public class ServiceProject extends BaseDomain {

	private static final long serialVersionUID = 1L;

	@Id
	@Validate(name = { "delete", "show" }, required = true)
	private String id;// null

	@Column(name="org_id",updatable = false)
	private String orgId;// 机构ID
	@Transient
	private ServiceProjectOrg serviceProjectOrg;
	
	@Validate(name = { "save" }, required = true)
	private String projectName;// 项目名称

	private String projectNum;// 项目编号
	private double score;// 分值
	private String cycle;// 周期 1日 2月 3季度 4年
	private Integer frequency;// 次数
	private double money;// 金额 默认为0
	private String projectDesc;// 项目描述
	@Column(updatable = false)
	private String customFlg;// 是否自定义 0 否 1是
	@Column(updatable = false)
	private String status;// 状态 1 正常 2 禁用 3 删除
	private String remarks;// 备注
	private String detailUrl;// 服务详情界面
	@Column(updatable = false)
	private String createUser;// 创建人
	@Column(updatable = false)
	private Date createTime;// 创建时间
	private String updateUser;// 修改人
	private Date updateTime;// 修改时间
	private String projectDetail;//项目随访分类
	private String projectDetailName;//项目随访分类名称
	
	@Transient
	private String availableFlg;// 是否可用 0 否 1 是
	@Transient
	private String subAvailableFlg;// 下级是否可用 0 否 1 是
	@Transient
	private String updateFlg;//是否可以修改 0 否 1 是
	
	public String getProjectDetailName() {
		return projectDetailName;
	}

	public void setProjectDetailName(String projectDetailName) {
		this.projectDetailName = projectDetailName;
	}

	public String getProjectDetail() {
		return projectDetail;
	}

	public void setProjectDetail(String projectDetail) {
		this.projectDetail = projectDetail;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrgId() {
		return this.orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectNum() {
		return this.projectNum;
	}

	public void setProjectNum(String projectNum) {
		this.projectNum = projectNum;
	}

	public double getScore() {
		return this.score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getCycle() {
		return this.cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	public Integer getFrequency() {
		return this.frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	public double getMoney() {
		return this.money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getProjectDesc() {
		return this.projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}
	public String getCustomFlg() {
		return this.customFlg;
	}
	public void setCustomFlg(String customFlg) {
		this.customFlg = customFlg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getDetailUrl() {
		return this.detailUrl;
	}

	public void setDetailUrl(String detailUrl) {
		this.detailUrl = detailUrl;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getAvailableFlg() {
		return availableFlg;
	}

	public void setAvailableFlg(String availableFlg) {
		this.availableFlg = availableFlg;
	}

	public String getSubAvailableFlg() {
		return subAvailableFlg;
	}

	public void setSubAvailableFlg(String subAvailableFlg) {
		this.subAvailableFlg = subAvailableFlg;
	}

	public String getUpdateFlg() {
		return updateFlg;
	}

	public void setUpdateFlg(String updateFlg) {
		this.updateFlg = updateFlg;
	}

	public ServiceProjectOrg getServiceProjectOrg() {
		return serviceProjectOrg;
	}

	public void setServiceProjectOrg(ServiceProjectOrg serviceProjectOrg) {
		this.serviceProjectOrg = serviceProjectOrg;
	}

}
