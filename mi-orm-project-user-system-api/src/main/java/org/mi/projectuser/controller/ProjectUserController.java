package org.mi.projectuser.controller;

import java.util.List;

import javax.validation.Valid;

import org.mi.projectuser.domain.ProjectUserInfo;
import org.mi.projectuser.service.ProjectUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/process/projectUser")
public class ProjectUserController {
	
	@Autowired
	private ProjectUserService projectUserService;
	
	@RequestMapping(method = RequestMethod.PUT)
	public void update(@RequestBody @Valid ProjectUserInfo project){
		projectUserService.update(project);
	}
	
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public ProjectUserInfo add(@RequestBody ProjectUserInfo project) {
		return projectUserService.add(project);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ProjectUserInfo> list(){
		return projectUserService.list();
	}
}
