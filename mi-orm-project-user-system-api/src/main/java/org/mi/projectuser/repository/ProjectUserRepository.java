package org.mi.projectuser.repository;

import java.util.List;

import org.mi.projectuser.domain.ProjectUserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProjectUserRepository extends JpaRepository<ProjectUserInfo, Long> {
	@Query("select relaShip from ProjectUserInfo relaShip where relaShip.userCode = ?1")
	public ProjectUserInfo findByUserCode(String userCode);
	
	@Query("select relaShip from ProjectUserInfo relaShip where relaShip.projectCode = ?1")
	public List<ProjectUserInfo> findManagers(String projectCode);
}
