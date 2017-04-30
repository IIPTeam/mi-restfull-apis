package org.mi.user.service;

import java.util.List;

import org.mi.user.domain.User;
import org.mi.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	public User add(User user){
		return this.repository.saveAndFlush(user);
	}
	
	public User findById(Long ID){
		return this.repository.findOne(ID);
	}
	
	public void update(User u){
		this.repository.save(u);
	}
	
	public List<User> findUsers(){
		//TODO the search condition is TBD
		
		return repository.findUsers();
	}
}
