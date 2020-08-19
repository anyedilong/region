package com.region.moudles.hospital.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.region.moudles.hospital.domain.HospitalOrder;

public interface HospitalOrderRepository extends JpaRepository<HospitalOrder,String> {

}
