package com.region.moudles.tripartdock.servicepackage.dao.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.region.moudles.tripartdock.servicepackage.domain.ServicePackage;

/**
 * 
 * <br>
 * <b>功能：</b>ServicePackageRepository<br>
 * <b>作者：</b>blt<br>
 * <b>版权所有：<b>版权所有(C) 2016，blt<br>
 */ 
public interface ServicePackageRepository extends JpaRepository<ServicePackage, String> {


}
