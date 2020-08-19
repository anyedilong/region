package com.region.moudles.system.dao.repository;

import com.region.moudles.system.domain.SysMenuRole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface SysMenuRoleRepository extends JpaRepository<SysMenuRole, String> {

	@Query(value = "delete from sys_menu_role where role_id = :roleId", nativeQuery = true)
	@Modifying
	@Transactional
	void deleteByRoleId(@Param("roleId") String roleId);
	
	@Query(value = "delete from sys_menu_role where menu_id = :menuId", nativeQuery = true)
	@Modifying
	@Transactional
	void deleteByMenuId(@Param("menuId") String menuId);

}
