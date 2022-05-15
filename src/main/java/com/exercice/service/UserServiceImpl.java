package com.exercice.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.exercice.model.Authorities;
import com.exercice.model.User;
import com.exercice.repository.UserRep;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRep userRep;
		
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	// Exclude ADMIN ROLE for new users
	@Override
	public void save(User user) {
		Authorities auth = new Authorities(1L , "ROLE_USER");
		Set<Authorities> authorities = new HashSet<>();
		authorities.add(auth);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setAuthorities(authorities);
		userRep.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userRep.findByUsername(username);
	}

}
