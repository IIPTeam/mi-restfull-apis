package org.mi.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;
import org.mi.user.domain.User;
import org.mi.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("user")
@Api("user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.POST)
	public User add(@RequestBody @Valid User user) {
		return userService.add(user);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void update(@RequestBody @Valid User u) {
		userService.update(u);
	}

	// retrieve user by userid/ehr/staffid
	@RequestMapping(value = "/{ID}", method = RequestMethod.GET)
	public User findUserById(@PathVariable("ID") @NotEmpty Long ID) {
		return userService.findById(ID);
	}

	//enquiry users against various search condition
	@RequestMapping(value="list",method=RequestMethod.GET)
	public List<User> findUser(){
		return userService.findUsers();
	}
}
