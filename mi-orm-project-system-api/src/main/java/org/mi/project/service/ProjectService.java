package org.mi.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.mi.common.MergeUtil;
import org.mi.project.domain.ProjectInfo;
import org.mi.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository repository;

	@Transactional
	public void update(ProjectInfo project){
		ProjectInfo db_project = repository.findOne(project.getId());
		MergeUtil.simpleMerge(project, db_project, new String[]{""});
		repository.save(db_project);
	}
	
	@Transactional
	public ProjectInfo add(ProjectInfo ot){
		return this.repository.save(ot);
	}
	
	public List<ProjectInfo> list(){
		return this.repository.findAll();
	}
}
