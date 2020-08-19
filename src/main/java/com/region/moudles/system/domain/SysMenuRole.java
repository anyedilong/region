package com.region.moudles.system.domain;

import com.region.moudles.common.domain.BaseDomain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 菜单权限表
 */
@Entity
@Table(name = "sys_menu_role")
public class SysMenuRole extends BaseDomain {

	private static final long serialVersionUID = 164646416341L;
	
	@Id
	private  String id;//内码
    private  String menuId;//菜单ID
    private  String roleId;//权限ID


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
