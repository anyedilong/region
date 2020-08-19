package com.region.moudles.tripartdock.archive.dao.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.region.moudles.tripartdock.archive.domain.Jbxxjlb;

/**
 * 
 * <br>
 * <b>功能：</b>CustomerRepository<br>
 * <b>作者：</b>blt<br>
 * <b>版权所有：<b>版权所有(C) 2016，blt<br>
 */
@Repository
public interface JbxxjlbRepository extends JpaRepository<Jbxxjlb, String> {
	   
	@Query(value = "select a.id from blt_jbxxjlb a where a.sfzh = :sfzh and (a.sfsc = 'N' or a.sfsc is null)", nativeQuery = true)
	String queryArchiveIdBySfzh(@Param("sfzh") String sfzh);
	
}
