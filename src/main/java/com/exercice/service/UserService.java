package com.exercice.service;

import com.exercice.model.User;

public interface UserService {
	
	void save(User user);
	
	User findByUsername(String username);
}
