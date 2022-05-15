package com.exercice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="customers")
public class Customer {	
	@Id
	@Column(name="id")
	@GenericGenerator(name="generator", strategy="increment")
	@GeneratedValue(generator="generator")
	private Long id;
	
	@Column(name="first_name")
	@Size(min=3,max=12)
	private String firstName;
	
	@Column(name="last_name")
	@Size(min=3,max=12)
	private String lastName;
		
	private String u_name;
	
	public Customer() {}

	public Customer(Long id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;	
		this.lastName = lastName;
	}
	
	public Customer(Long id, String firstName, String lastName, String u_name) {
		this.id = id;
		this.firstName = firstName;	
		this.lastName = lastName;
		this.u_name = u_name;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Customer {id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "}";
	}

}
