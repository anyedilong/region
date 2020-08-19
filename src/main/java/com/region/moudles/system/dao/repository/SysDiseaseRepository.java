package com.region.moudles.system.dao.repository;

import com.region.moudles.system.domain.SysDiseaseDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysDiseaseRepository extends JpaRepository<SysDiseaseDomain,String> {

}
