package com.capstone.compensation.model;

import javax.validation.constraints.NotBlank;

public class SignInRequest {

	
	
		@NotBlank
		private String emailId;

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		@NotBlank
		private String password;



		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		

		

}



