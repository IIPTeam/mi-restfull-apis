package org.mi.leave.repository;

import java.util.List;

import org.mi.leave.domain.StaffLeave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRepository extends JpaRepository<StaffLeave, Long> {

	@Query("select leave from StaffLeave leave")
	public List<StaffLeave> findUsers();
	
	@Query("select leave from StaffLeave leave where leave.userID= :userID")
	public List<StaffLeave> findLeaveById(@Param(value = "userID") Long userID);
	
}
