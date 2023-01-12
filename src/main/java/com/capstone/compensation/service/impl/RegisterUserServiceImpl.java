package com.capstone.compensation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.capstone.compensation.repository.UserRepository;
import com.capstone.compensation.service.RegisterUserService;

public class RegisterUserServiceImpl implements RegisterUserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public Boolean existsByEmailId(String emailId)

	{
		return userRepository.existsByEmailId(emailId);

	}
}
