package com.region.moudles.tripartdock.sign.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.region.moudles.tripartdock.sign.domain.SignLog;

public interface SignLogRepository extends JpaRepository<SignLog, String> {
    
	
}
