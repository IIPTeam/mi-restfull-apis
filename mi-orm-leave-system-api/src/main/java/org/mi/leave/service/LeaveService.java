package org.mi.leave.service;

import javax.transaction.Transactional;

import org.mi.leave.domain.StaffLeave;
import org.mi.leave.domain.StaffLeaveRemain;
import org.mi.leave.repository.LeaveRemainRepository;
import org.mi.leave.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LeaveService {
	@Autowired
	private LeaveRepository repository;
	
	@Autowired
	private LeaveRemainRepository remainrepository;
	
	@Transactional
	public StaffLeave add(StaffLeave Leave){
		return this.repository.saveAndFlush(Leave);
	}
	
	@Transactional
	public String find(Long userId){
		
		return this.remainrepository.findLeaves(userId);
	}
	
}
