package com.region.moudles.hospital.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.region.moudles.hospital.domain.HospitalOrderItem;

public interface HospitalOrderItemRepository extends JpaRepository<HospitalOrderItem,String> {

}
