package com.web.events.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.web.events.models.User;
import com.web.events.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepo;
	
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	//Register a user
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return userRepo.save(user);
	}
	
	//Retrieve user by id
	public User findUserById(Long id) {
		Optional<User> u = userRepo.findById(id);
		if(u.isPresent()) {
			return u.get();
		}else {
			System.out.println("Came to UserService // ***Unable to find userById(id) - returning NULL***");
			return null;
		}
	}
	
	//Retrieve a user by email
	public User findUserByEmail(String email) {
		return userRepo.findUserByEmail(email);
	}
	
	//authenticate user & password
	public boolean authenticateUser(String email, String password) {
		User user = userRepo.findUserByEmail(email);
		if(user == null) {
			return false;
		}else {
			if(BCrypt.checkpw(password, user.getPassword())) {
				return true;
			}else {
				return false;
			}
		}
	}
	
}
