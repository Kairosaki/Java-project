package com.exercice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercice.model.User;

public interface UserRep extends JpaRepository<User, String> {
	
	User findByUsername(String username);
}
