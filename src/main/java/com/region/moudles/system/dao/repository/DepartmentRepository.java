package com.region.moudles.system.dao.repository;

import com.region.moudles.system.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,String> {

}
