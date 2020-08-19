package com.region.moudles.outpatient.dao.repository;


import com.region.moudles.outpatient.domain.Medicalrecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalrecordRepository extends JpaRepository<Medicalrecord,String> {
}
