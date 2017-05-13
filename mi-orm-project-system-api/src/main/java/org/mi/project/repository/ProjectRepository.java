package org.mi.project.repository;

import org.mi.project.domain.ProjectInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectInfo, Long>{

}
