package org.mi.resource.repository;

import org.mi.resource.domain.PendingResourceInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PendingResourceRepository extends JpaRepository<PendingResourceInfo, Long>{

}
