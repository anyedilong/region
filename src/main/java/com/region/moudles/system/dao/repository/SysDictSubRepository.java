package com.region.moudles.system.dao.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.region.moudles.system.domain.SysDictSub;

/**
 * 
 * <br>
 * <b>功能：</b>DictSubRepository<br>
 * <b>作者：</b>blt<br>
 * <b>版权所有：<b>版权所有(C) 2016，blt<br>
 */ 
public interface SysDictSubRepository extends JpaRepository<SysDictSub, String> {


	@Modifying
	@Transactional
	@Query(value = "update sys_dict_sub ds set ds.status='3' where ds.id = :id",nativeQuery = true)
	void batchUpdateForDel(@Param("id") String id);
	
}
