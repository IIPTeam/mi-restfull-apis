package org.mi.resource.controller;

import java.util.List;

import javax.validation.Valid;

import org.mi.resource.domain.AvailableResourceInfo;
import org.mi.resource.domain.PendingResourceInfo;
import org.mi.resource.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/process/resource")
public class ResourceController {
	
	@Autowired
	private ResourceService resourceService;
	
	@RequestMapping(method = RequestMethod.PUT)
	public void update(@RequestBody @Valid AvailableResourceInfo project){
		resourceService.update(project);
	}
	
	@RequestMapping(value = "/generateResource", method = RequestMethod.POST)
	public AvailableResourceInfo generate(@RequestBody AvailableResourceInfo ar) {
		return resourceService.add(ar);
	}
	
	@RequestMapping(value = "/consumeResource", method = RequestMethod.POST)
	public PendingResourceInfo consume(@RequestBody PendingResourceInfo pr) {
		return resourceService.addPendingResource(pr);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<AvailableResourceInfo> list(){
		return resourceService.list();
	}
}
