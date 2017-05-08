package org.mi.leave.controller;


import javax.validation.Valid;


import org.mi.leave.domain.StaffLeave;
import org.mi.leave.domain.StaffLeaveRemain;
import org.mi.leave.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("process/leave")
public class LeaveController {
	@Autowired
	private LeaveService service;
	
	@RequestMapping(value ="/generate",method = RequestMethod.POST)
	public StaffLeave add(@RequestBody @Valid StaffLeave leave) {
		return this.service.add(leave);
	}
	
	@RequestMapping(value ="/remain",method = RequestMethod.POST)
	public String findBYStaff(@RequestBody @Valid StaffLeaveRemain remain) {
		return this.service.find(remain.getUserID());
	}

}
