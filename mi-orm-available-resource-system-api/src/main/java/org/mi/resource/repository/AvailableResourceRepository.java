package org.mi.resource.repository;

import org.mi.resource.domain.AvailableResourceInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailableResourceRepository extends JpaRepository<AvailableResourceInfo, Long>{

}
