package com.meda.user.userservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name= "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="userId")
	private Long userId;
	
	@Column(unique=true)
	private String userName;
	private String Password;
	private String location;
	
	@Length(max=1)
	private String status;
	
	
	/*
	 * @ManyToMany
	 * 
	 * @JoinTable(name="UserRoles",joinColumns= {@JoinColumn(name="userId")},
	 * inverseJoinColumns= {@JoinColumn(name="roleID")})
	 * 
	 * 
	 * private List<Role> roles = new ArrayList<Role>();
	 */
	
	@ManyToOne
	@JoinColumn(name="roleId")
	private Role role;
	
	public Role getRole() {
		return role;
	}

	public void setRoles(Role role) {
		this.role = role;
	}
	
    

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	
}
