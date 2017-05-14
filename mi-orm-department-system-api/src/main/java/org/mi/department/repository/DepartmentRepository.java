package org.mi.department.repository;

import org.mi.department.domain.DepartmentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentInfo, Long>{

}
