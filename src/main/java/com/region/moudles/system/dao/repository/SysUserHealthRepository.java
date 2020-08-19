package com.region.moudles.system.dao.repository;

import com.region.moudles.system.domain.SysUserHealth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SysUserHealthRepository extends JpaRepository<SysUserHealth, String> {

	 @Query(value = "select a.role from sys_user_health a where a.doctor_code = :doctorCode and a.doctor_name = :doctorName",nativeQuery = true)
	 String queryUserRoleByCond(@Param("doctorCode") String doctorCode, @Param("doctorName") String doctorName);
}
