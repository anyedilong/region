package com.region.moudles.tripartdock.check.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.region.moudles.tripartdock.check.domain.Check;

 
public interface CheckRepository extends JpaRepository<Check, String> {
	
	
}
