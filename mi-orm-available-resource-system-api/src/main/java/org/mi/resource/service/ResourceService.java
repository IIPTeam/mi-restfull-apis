package org.mi.resource.service;

import java.util.List;

import javax.transaction.Transactional;

import org.mi.common.MergeUtil;
import org.mi.resource.domain.AvailableResourceInfo;
import org.mi.resource.domain.PendingResourceInfo;
import org.mi.resource.repository.AvailableResourceRepository;
import org.mi.resource.repository.PendingResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceService {
	
	@Autowired
	private AvailableResourceRepository repository;
	@Autowired
	private PendingResourceRepository pendingRepository;

	@Transactional
	public void update(AvailableResourceInfo ar){
		AvailableResourceInfo db_ar = repository.findOne(ar.getId());
		MergeUtil.simpleMerge(ar, db_ar, new String[]{""});
		repository.save(db_ar);
	}
	
	@Transactional
	public AvailableResourceInfo add(AvailableResourceInfo ar){
		return this.repository.save(ar);
	}
	
	public List<AvailableResourceInfo> list(){
		return this.repository.findAll();
	}
	
	@Transactional
	public void updatePendingResource(PendingResourceInfo pr){
		PendingResourceInfo db_pr = pendingRepository.findOne(pr.getId());
		MergeUtil.simpleMerge(pr, db_pr, new String[]{""});
		pendingRepository.save(db_pr);
	}
	
	@Transactional
	public PendingResourceInfo addPendingResource(PendingResourceInfo pr){
		return this.pendingRepository.save(pr);
	}
}
