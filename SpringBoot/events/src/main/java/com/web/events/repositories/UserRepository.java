package com.web.events.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.web.events.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findUserByEmail(String email);
}
