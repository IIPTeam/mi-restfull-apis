package org.mi.leave.controller;


import javax.validation.Valid;


import org.mi.leave.domain.Leave;
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
	
	@RequestMapping(method = RequestMethod.POST)
	public Leave add(@RequestBody @Valid Leave leave) {
		return this.service.add(leave);
	}

}
