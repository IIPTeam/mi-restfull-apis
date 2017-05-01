package org.mi.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.mi.user.config.PropertyConfig;
import org.mi.user.vo.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private PropertyConfig config;
	
	@RequestMapping(consumes="application/json",method=RequestMethod.POST)
	public UserView add(@RequestBody @Valid UserView userView,HttpServletRequest request){
		RestTemplate restTemplate = new RestTemplate();
		String url = config.userProcessAPIURL + "process/user";
		UserView rsp = restTemplate.postForObject(url, userView, UserView.class);
		
		return rsp;
	}

}
