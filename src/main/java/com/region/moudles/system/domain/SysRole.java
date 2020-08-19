package com.region.moudles.system.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.region.moudles.common.domain.BaseDomain;


/**
 * 
 * <br>
 * <b>功能：</b>SysRoleEntity<br>
 * <b>作者：</b>blt<br>
 * <b>版权所有：<b>版权所有(C) 2016，blt<br>
 */
@Entity
@Table(name = "sys_role")
public class SysRole extends BaseDomain {

	private static final long serialVersionUID = 1123123123L;

	@Id
	private String id;
	@Column(name = "role_name")
	private String roleName;// 角色名称
	private String status;// 状态 1 正常 2 冻结
	@Column(name = "org_id")
	private String orgId;// 机构ID
	private String remarks;// 备注
	@Column(name = "create_time")
	private Date createTime;// 创建时间
	@Column(name = "create_user")
	private String createUser;// 创建人
	@Column(name = "delete_flg")
	private String deleteFlg = "0";// 删除标识 0 否 1 是
	private String roleLevel;//等级

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

	public String getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	public String getRoleLevel() {
		return roleLevel;
	}

	public void setRoleLevel(String roleLevel) {
		this.roleLevel = roleLevel;
	}

}
