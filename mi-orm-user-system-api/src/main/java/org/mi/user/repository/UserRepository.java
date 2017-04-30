package org.mi.user.repository;

import java.util.List;

import org.mi.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("select user from User user")
	public List<User> findUsers();
	
}
