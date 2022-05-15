package com.exercice.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "users")
public class User {

	private String username;
	private String password;
	private boolean enabled;	
	private Set<Authorities> authorities = new HashSet<>(0);	
	private List<Customer> customers;
	
	public User() {
	}

	public User(String username, String password, boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public User(String username, String password, boolean enabled, Set<Authorities> authorities) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.authorities = authorities;
	}
	
	public User(String username, String password, boolean enabled, List<Customer> customers) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.customers = customers;
	}

	@Id
	@Column(name = "username", unique = true, nullable = false, length = 45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 60)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "enabled", nullable = false)
	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "users_authorities", joinColumns = @JoinColumn(name = "user_name"), inverseJoinColumns = @JoinColumn(name = "authority_id"))
	public Set<Authorities> getAuthorities() {
		return this.authorities;
	}

	public void setAuthorities(Set<Authorities> authorities) {
		this.authorities = authorities;
	}

	@OneToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinColumn(name="u_name")
	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
}