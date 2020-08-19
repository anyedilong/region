package com.region.moudles.tripartdock.sign.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.region.moudles.tripartdock.sign.domain.SignRecord;

public interface SignRecordRepository extends JpaRepository<SignRecord, String> {

	
}
