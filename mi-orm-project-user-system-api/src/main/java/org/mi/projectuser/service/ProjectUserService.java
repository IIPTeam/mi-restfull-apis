package org.mi.projectuser.service;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.mi.common.MergeUtil;
import org.mi.projectuser.domain.ProjectUserInfo;
import org.mi.projectuser.domain.Role;
import org.mi.projectuser.repository.ProjectUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectUserService {
	
	@Autowired
	private ProjectUserRepository repository;

	@Transactional
	public void update(ProjectUserInfo relation){
		ProjectUserInfo db_relation = repository.findOne(relation.getId());
		MergeUtil.simpleMerge(relation, db_relation, new String[]{""});
		repository.save(db_relation);
	}
	
	@Transactional
	public ProjectUserInfo add(ProjectUserInfo relation){
		return this.repository.save(relation);
	}
	
	public List<ProjectUserInfo> list(){
		return this.repository.findAll();
	}
	
	public ProjectUserInfo findRelationByUser(String ehr) {
		return this.repository.findByUserCode(ehr);
	}
	
	public List<ProjectUserInfo> findManagers(String projectCode) {
		List<ProjectUserInfo> relaList = this.repository.findManagers(projectCode);
		if (null != relaList && relaList.size() != 0) {
			Iterator<ProjectUserInfo> it = relaList.iterator();
			while(it.hasNext()) {
				ProjectUserInfo info = it.next();
				if (info.getRole().equals(Role.DEV)) {
					it.remove();
				}
			}
		}
		return relaList;
	}
}
