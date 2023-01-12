package com.capstone.compensation.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.compensation.model.SignInRequest;
import com.capstone.compensation.model.SignUpRequest;
import com.capstone.compensation.service.RegisterUserService;
import com.capstone.compensation.validation.UserValidation;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class RegisterUserController {

	@Autowired
	@Qualifier("registerUserService")
	RegisterUserService registerUserService;

	@Autowired
	private UserValidation userValidation;
	
	
	@PostMapping("/signin")
	public ResponseEntity<?> signInUser(@Valid @RequestBody SignInRequest signInRequest) {
		return userValidation.authenticateUser(signInRequest);
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
		return userValidation.validateUser(signUpRequest);
	}
	
	

}
