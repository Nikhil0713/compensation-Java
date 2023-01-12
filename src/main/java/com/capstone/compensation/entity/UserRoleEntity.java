package com.capstone.compensation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.capstone.compensation.model.UserRoles;

@Entity
@Table(name = "user_role")
public class UserRoleEntity {

	@Id
	@Column(name = "role_id")
	private Long roleId;
	@Column(name = "role_name")
	private String roleName;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private UserRoles name;
	

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public UserRoles getName() {
		return name;
	}

	public void setName(UserRoles name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserRoleEntity [roleId=" + roleId + ", roleName=" + roleName + ", name=" + name + " ]";
	}

	public UserRoleEntity() {
		super();
	}

	public UserRoleEntity(Long roleId, String roleName, UserRoles name) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.name = name;
		
	}

}
