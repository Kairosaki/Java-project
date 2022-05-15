package com.exercice.repository;

import com.exercice.model.Customer;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRep extends CrudRepository<Customer, Long>{

}
