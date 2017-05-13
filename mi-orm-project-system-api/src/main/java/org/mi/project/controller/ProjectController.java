package org.mi.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.mi.project.domain.ProjectInfo;
import org.mi.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/process/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(method = RequestMethod.PUT)
	public void update(@RequestBody @Valid ProjectInfo project){
		projectService.update(project);
	}
	
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public ProjectInfo add(@RequestBody ProjectInfo project) {
		return projectService.add(project);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ProjectInfo> list(){
		return projectService.list();
	}
}
