package com.region.moudles.system.dao.repository;

import com.region.moudles.system.domain.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface SysMenuRepository extends JpaRepository<SysMenu,String>{


    @Modifying
    @Query(value = "update  sys_menu a set a.status=:status where id=:id",nativeQuery = true)
    @Transactional
     void updateMenu(@Param("id")String id,@Param("status")String status);
}
