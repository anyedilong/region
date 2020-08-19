package com.region.moudles.hospital.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.region.moudles.hospital.domain.HospitalOrderDoctor;

public interface HospitalOrderDoctorRepository extends JpaRepository<HospitalOrderDoctor,String> {

}
