package com.region.moudles.tripartdock.servicepackage.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.region.moudles.common.domain.BaseDomain;

@Entity
@Table(name = "sys_service_project_org")
public class ServiceProjectOrg extends BaseDomain {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;// null

	@Column(name = "project_id", updatable = false)
	private String projectId;// 服务项目ID
	@Column(updatable = false)
	private String orgId;// 机构ID
	private String availableFlg;// 是否可用 0 否 1 是
	private String subAvailableFlg;// 下级是否可用 0 否 1 是

	@Transient
	private String orgCode;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
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

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

}
