package com.capstone.compensation.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@Table(name = "User_details")
@JsonDeserialize(as = UserEntity.class)
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employ_id")
	private long employId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email_id")
	private String emailId;
	@Column(name = "job_title")
	private String jobtitle;
	@Column(name = "location")
	private String location;
	@Column(name = "department")
	private String department;	
	@Column(name = "role")
	private String role;
	@Column(name = "password")
	private String password;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles",
	              joinColumns = @JoinColumn(name = "employ_id"),
	              inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<UserRoleEntity> roles = new HashSet<>();

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getEmployId() {
		return employId;
	}

	public void setEmployId(long employId) {
		this.employId = employId;
	}

	public String getJobtitle() {
		return jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Set<UserRoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRoleEntity> roles) {
		this.roles = roles;
	}
	
	public UserEntity() {
		super();
	}

	public UserEntity(String emailId) {
		super();
		this.emailId = emailId;
	}

	

	public UserEntity(String firstName, String lastName, String emailId, String password, String jobtitle,
			String location, String department , String role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.jobtitle = jobtitle;
		this.department = department;
		this.location = location;
		this.role= role;
		this.password = password;

	}

	public UserEntity(long employId, String firstName, String lastName, String emailId, String password,
			String jobtitle, String location, String department , String role ) {
		this(firstName, lastName, emailId, password, jobtitle, department, location, role);
		this.employId = employId;
	}

	public UserEntity(String firstName, String email, String password) {
		this.firstName = firstName;
		this.emailId = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + employId + ", userName=" + emailId + "]";
	}

	

}
