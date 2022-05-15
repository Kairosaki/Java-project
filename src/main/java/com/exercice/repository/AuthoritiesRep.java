package com.exercice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercice.model.Authorities;

public interface AuthoritiesRep extends JpaRepository<Authorities, String> {

}
