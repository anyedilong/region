package com.region.moudles.inspectcenter.poct.dao.repository;

import com.region.moudles.inspectcenter.poct.domain.Poct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoctRepository extends JpaRepository<Poct, String> {
}
