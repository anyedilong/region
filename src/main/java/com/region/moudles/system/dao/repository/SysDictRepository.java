package com.region.moudles.system.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.region.moudles.system.domain.SysDict;


public interface SysDictRepository extends JpaRepository<SysDict, String>{
	
	@Modifying
	@Query(value = "update sys_dict d set d.status='3' where d.id=:id",nativeQuery = true)
	@Transactional
	void updateForDel(@Param("id") String id);

	@Query(value = "select t.code from sys_dict t where t.id=:id",nativeQuery = true)
	String findCodeById(@Param("id") String id);
}
