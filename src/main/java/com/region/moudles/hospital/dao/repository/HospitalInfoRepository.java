package com.region.moudles.hospital.dao.repository;

import com.region.moudles.hospital.domain.HospitalInfto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalInfoRepository extends JpaRepository<HospitalInfto,String>{
}
