package com.exercice.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Authorities")
public class Authorities{

	private Long authoritiesId;
	private String authority;
	private Set<User> users;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "authorities_id", unique = true, nullable = false)
	public Long getAuthoritiesId() {
		return authoritiesId;
	}

	public Authorities() {}
	
	public Authorities(Long authoritiesId, String authority) {
		this.authoritiesId = authoritiesId;
		this.authority = authority;
	}

	public void setAuthoritiesId(Long authoritiesId) {
		this.authoritiesId = authoritiesId;
	}

	@ManyToMany(mappedBy = "authorities")
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Column(name = "authority", nullable = false, length = 45)
	public String getAuthority() {
		return this.authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}