package com.meda.user.userservice.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="roles")
public class Role {
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="roleId" , updatable = false, nullable = false)
	int roleId;
	
	@Length(max=50)
	String roleName;
	
	@OneToMany(mappedBy="role",cascade=CascadeType.ALL)
	private List<User> users = new ArrayList<User>();

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
