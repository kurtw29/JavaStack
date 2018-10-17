package com.web.authentication.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.web.authentication.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	User findUserByEmail(String email);
}
