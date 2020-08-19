package com.region.moudles.outpatient.dao.repository;

import com.region.moudles.outpatient.domain.OutpatientImage;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OutpatientBchaoRepository extends JpaRepository<OutpatientImage,String> {

	@Modifying
	@Query(value = " update outpatient_image a set a.image_jpg_url = :imageJpgPath where a.id = :imageId ",nativeQuery = true)
	@Transactional
	void updateImageJpgPath(@Param("imageId") String imageId, @Param("imageJpgPath") String imageJpgPath);
	
}
