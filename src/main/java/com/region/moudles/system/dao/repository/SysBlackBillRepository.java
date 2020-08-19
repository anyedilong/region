package com.region.moudles.system.dao.repository;

import com.region.moudles.system.domain.SysBlackBill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface SysBlackBillRepository extends JpaRepository<SysBlackBill, String> {

	@Query(value = "select * from sys_black_bill where user_ip = :ip", nativeQuery = true)
	SysBlackBill queryInfoByIp(@Param("ip") String ip);
	
	@Query(value = "update sys_black_bill set times = :times, status = :status where user_ip = :ip ", nativeQuery = true)
	@Modifying
	@Transactional
	void updateInfo(@Param("ip") String ip, @Param("times") Integer times, @Param("status") String status);

	@Query(value = "delete sys_black_bill where user_ip = :ip ", nativeQuery = true)
	@Modifying
	@Transactional
	void deleteByIp(@Param("ip") String ip);
}
