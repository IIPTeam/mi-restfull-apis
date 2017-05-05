package org.mi.leave.service;

import javax.transaction.Transactional;

import org.mi.leave.domain.Leave;
import org.mi.leave.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveService {
	@Autowired
	private LeaveRepository repository;
	
	@Transactional
	public Leave add(Leave Leave){
		return this.repository.saveAndFlush(Leave);
	}
	
}
