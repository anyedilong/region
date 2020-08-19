package com.region.moudles.his.authcode.dao.repository;


import com.region.moudles.his.authcode.domain.SysAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface SysAuthRepository extends JpaRepository<SysAuth, String> {

    @Query(value = "select a.id from sys_auth a where a.auth_code=:authCode",nativeQuery = true)
    String queryAuth(@Param("authCode") String authCode);

    @Modifying
    @Query(value = "update sys_auth a set a.status=:status where id=:id",nativeQuery = true)
    @Transactional
    void updateAuth(@Param("id") String id,@Param("status") String status);
    
    @Query(value = "select a.id from sys_auth a where a.auth_code = :authCode and a.org_id = :orgId",nativeQuery = true)
    String queryAuthByCond(@Param("authCode") String authCode, @Param("orgId") String orgId);
}
