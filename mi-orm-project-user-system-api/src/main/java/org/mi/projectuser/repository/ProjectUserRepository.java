package org.mi.projectuser.repository;

import org.mi.projectuser.domain.ProjectUserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectUserRepository extends JpaRepository<ProjectUserInfo, Long>{

}
