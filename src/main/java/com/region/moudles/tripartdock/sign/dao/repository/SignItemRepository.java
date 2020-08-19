package com.region.moudles.tripartdock.sign.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.region.moudles.tripartdock.sign.domain.SignItem;


public interface SignItemRepository extends JpaRepository<SignItem, String> {
	
}
