package com.region.moudles.system.dto;

import java.io.Serializable;

import com.region.moudles.common.domain.PageModel;

public class SysRoleDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;// null
	private String roleName;// 角色名称
	private String status;// 状态 1正常 2 冻结
	private String orgId;// 机构ID
	private String remarks;// 备注
	private String orgName;// 机构名称
	private String userId;
	private String level;
	
	private PageModel page;// 分页
	// 机构集合
	//private List<OrgCache> orgList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public PageModel getPage() {
		return page;
	}

	public void setPage(PageModel page) {
		this.page = page;
	}

}
