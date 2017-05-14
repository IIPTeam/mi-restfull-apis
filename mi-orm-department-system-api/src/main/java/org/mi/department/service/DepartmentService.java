package org.mi.department.service;

import java.util.List;

import javax.transaction.Transactional;

import org.mi.common.MergeUtil;
import org.mi.department.domain.DepartmentInfo;
import org.mi.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository repository;

	@Transactional
	public void update(DepartmentInfo dept){
		DepartmentInfo db_dept = repository.findOne(dept.getId());
		MergeUtil.simpleMerge(dept, db_dept, new String[]{""});
		repository.save(db_dept);
	}
	
	@Transactional
	public DepartmentInfo add(DepartmentInfo dept){
		return this.repository.save(dept);
	}
	
	public List<DepartmentInfo> list(){
		return this.repository.findAll();
	}
}
