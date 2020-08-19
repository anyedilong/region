package com.region.moudles.tripartdock.servicepackage.dao.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.region.moudles.tripartdock.servicepackage.domain.ServicePackageProject;

public interface ServicePackageProjectRepository extends JpaRepository<ServicePackageProject, String> {

	
}
