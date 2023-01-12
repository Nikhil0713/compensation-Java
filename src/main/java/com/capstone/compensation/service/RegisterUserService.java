package com.capstone.compensation.service;

import org.springframework.stereotype.Service;

@Service
public interface RegisterUserService  {
	Boolean existsByEmailId(String emailId);
}
