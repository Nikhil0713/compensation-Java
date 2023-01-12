package com.capstone.compensation.errorresponse;

import java.util.List;



public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Long employid;
	private String emailId;
	private List<String> roles;

	public JwtResponse(String accessToken, Long employid, String emailId, List<String> roles) {
		this.token = accessToken;
		this.employid = employid;
		this.emailId = emailId;		
		this.roles = roles;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getEmployid() {
		return employid;
	}

	public void setEmployid(Long employid) {
		this.employid = employid;
	}
	
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public List<String> getRoles() {
		return roles;
	}
}
