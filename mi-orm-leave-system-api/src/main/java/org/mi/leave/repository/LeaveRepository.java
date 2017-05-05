package org.mi.leave.repository;

import java.util.List;

import org.mi.leave.domain.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Long> {

	@Query("select user from User user")
	public List<Leave> findUsers();
	
}
