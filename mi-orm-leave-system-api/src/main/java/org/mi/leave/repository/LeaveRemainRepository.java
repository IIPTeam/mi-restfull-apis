package org.mi.leave.repository;


import org.mi.leave.domain.StaffLeaveRemain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRemainRepository extends JpaRepository<StaffLeaveRemain,Long> {
	
	@Query("select userID from StaffLeaveRemain staffLeaveRemain where staffLeaveRemain.userID= :userID")
	public StaffLeaveRemain findLeaves(@Param(value = "userID") Long userID);
	
}
