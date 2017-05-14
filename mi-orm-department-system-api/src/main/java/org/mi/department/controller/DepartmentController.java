package org.mi.department.controller;

import java.util.List;

import javax.validation.Valid;

import org.mi.department.domain.DepartmentInfo;
import org.mi.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/process/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(method = RequestMethod.PUT)
	public void update(@RequestBody @Valid DepartmentInfo department){
		departmentService.update(department);
	}
	
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public DepartmentInfo add(@RequestBody DepartmentInfo department) {
		return departmentService.add(department);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<DepartmentInfo> list(){
		return departmentService.list();
	}
}
