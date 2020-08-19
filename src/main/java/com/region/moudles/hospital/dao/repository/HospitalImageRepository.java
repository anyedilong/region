package com.region.moudles.hospital.dao.repository;

import com.region.moudles.hospital.domain.HospitalImage;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HospitalImageRepository extends JpaRepository<HospitalImage,String> {

	@Modifying
	@Query(value = " update hospital_image a set a.image_jpg_url = :imageJpgPath where a.id = :imageId ",nativeQuery = true)
	@Transactional
	void updateImageJpgPath(@Param("imageId") String imageId, @Param("imageJpgPath") String imageJpgPath);
	
}
