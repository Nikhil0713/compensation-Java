package com.capstone.compensation.config;

import com.capstone.compensation.service.RegisterUserService;
import com.capstone.compensation.service.UserService;
import com.capstone.compensation.service.impl.RegisterUserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

	@Bean("registerUserService")
	public RegisterUserService getRegisterUserService() {
		return new RegisterUserServiceImpl();
	}
	
	@Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
