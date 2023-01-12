         package com.capstone.compensation.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignUpRequest {

	@NotBlank
	@Size(min = 3, max = 20)
	private String firstname;
	@NotBlank
	@Size(min = 3, max = 20)
	private String lastname;
	@NotBlank
	@Size(max = 50)
	@Email
	private String emailId;
	@NotBlank
	@Size(max = 50)
	private String location;
	@NotBlank
	@Size(max = 50)
	private String jobtitle;
	@NotBlank
	@Size(max = 50)
	private String department;
	@NotBlank
	private String role;
	@NotBlank
	@Size(min = 6, max = 40)
	private String password;
	
	
//Getters and setters 
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getJobtitle() {
		return jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
