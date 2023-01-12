package com.capstone.compensation.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.capstone.compensation.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl  implements UserDetails {
  private static final long serialVersionUID = 1L;

    private long employId;
	private String firstName;
	private String lastName;
	private String jobtitle;
	private String  emailId;
	private String department;
	private String location;
	private String role;	
	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(long employId , String firstName, String lastName, String emailId, String jobtitle, String department,
			String location, String role, String password, Collection<? extends GrantedAuthority> authorities) {
		this.employId = employId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId  =emailId;
		this.jobtitle = jobtitle;
		this.department = department;
		this.location = location;
		this.role= role;
		this.password = password;
		this.authorities= authorities;
		
	}
	


	public static UserDetailsImpl build(UserEntity user) {
		
  
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());

		return new UserDetailsImpl( 
				user.getEmployId(),
				user.getFirstName(),
				user.getLastName(),
				user.getEmailId(),
				user.getJobtitle(),
				user.getDepartment(),
				user.getLocation(),
				user.getRole(),
				user.getPassword(),
				authorities);
		
	}

	public long getEmployId() {
		return employId;
	}



	public void setEmployId(long employId) {
		this.employId = employId;
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

	@Override
	public String getUsername() {
		return null;
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



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(employId, user.employId);
	}



	



	
}


