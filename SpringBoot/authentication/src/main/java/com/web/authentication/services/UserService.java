package com.web.authentication.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.web.authentication.models.User;
import com.web.authentication.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepo;
	
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	// register user and hash the password
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return userRepo.save(user);
	}
	
	// find user by email
	public User findByEmail(String email) {
		return userRepo.findUserByEmail(email);
	}
	
	// find user by id
	public User findById(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}else {
			return null;
		}
	}
	
	//authenticate user
	public boolean authenticateUser(String email, String password) {
		//find user by email
		User user = userRepo.findUserByEmail(email);
		if(user == null) {
			return false;
		}else {
			// if the passwords match, return true otherwise return false
			if(BCrypt.checkpw(password, user.getPassword())) {
				return true;
			}else {
				return false;
			}
		}
	}
}
