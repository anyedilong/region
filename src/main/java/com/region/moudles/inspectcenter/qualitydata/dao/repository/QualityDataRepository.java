package com.region.moudles.inspectcenter.qualitydata.dao.repository;

import com.region.moudles.inspectcenter.qualitydata.domain.QualityData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QualityDataRepository extends JpaRepository<QualityData, String> {
}
