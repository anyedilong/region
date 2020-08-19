package com.region.moudles.system.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.region.moudles.common.domain.BaseDomain;


/**
 * 
 * @ClassName SysRoleUser
 * @Description 用户角色关系
 * @author sen
 * @Date 2016年11月23日 下午4:32:34
 * @version 1.0.0
 */
@Entity
@Table(name = "sys_role_user")
public class SysRoleUser extends BaseDomain {

	private static final long serialVersionUID = 134536363L;

	@Id
	private String id;
	@Column(name = "role_id")
	private String roleId;// 角色id
	@Column(name = "user_id")
	private String userId;// 用户id

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
