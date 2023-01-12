package com.capstone.compensation.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import com.capstone.compensation.authentication.AuthenticationUtills;
import com.capstone.compensation.entity.UserEntity;
import com.capstone.compensation.entity.UserRoleEntity;
import com.capstone.compensation.errorresponse.JwtResponse;
import com.capstone.compensation.errorresponse.MessageResponse;
import com.capstone.compensation.model.CompensationRequest;
import com.capstone.compensation.model.SignInRequest;
import com.capstone.compensation.model.SignUpRequest;
import com.capstone.compensation.model.UserRoles;
import com.capstone.compensation.repository.UserRepository;
import com.capstone.compensation.repository.UserRoleRepository;
import com.capstone.compensation.service.RegisterUserService;
import com.capstone.compensation.service.impl.UserDetailsImpl;

@Component
public class UserValidation {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	RegisterUserService registerUserService;

	@Autowired
	UserRoleRepository userRoleRepository;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AuthenticationUtills authenticationUtills ;
	
	
	
	
	
	
	
	
	////sign in code //////////	
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody SignInRequest SignInRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(SignInRequest.getEmailId(), SignInRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = authenticationUtills.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(
				new JwtResponse(jwt, userDetails.getEmployId(), userDetails.getEmailId(), roles));
			}
	
	
	
	//sign up code ////////////////////////////
	public ResponseEntity<?> validateUser(SignUpRequest signUpRequest) {

		if (registerUserService.existsByEmailId(signUpRequest.getEmailId())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}
		if (signUpRequest != null && signUpRequest.getRole() != null && !signUpRequest.getRole().isEmpty()) {
//				for (String s : signUpRequest.getRole()) {
			String s = signUpRequest.getRole();
			if (!s.equalsIgnoreCase("user") && !s.equalsIgnoreCase("reporter")
					&& !s.equalsIgnoreCase("compensation")) {
				return ResponseEntity.badRequest().body(new MessageResponse("Error: Role is Not Valid!"));
			}
		}
		UserEntity user = new UserEntity(signUpRequest.getFirstname(),       
				signUpRequest.getLastname(),signUpRequest.getEmailId()
				,encoder.encode(signUpRequest.getPassword()),signUpRequest.getJobtitle(),signUpRequest.getLocation(),signUpRequest.getDepartment(),signUpRequest.getRole());
		
			
		String strRoles = signUpRequest.getRole();
		Set<UserRoleEntity> roles = new HashSet<>();

		if (strRoles == null) {
			UserRoleEntity userRole = userRoleRepository.findByName(UserRoles.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
//						strRoles.forEach(role -> {
			switch (strRoles) {
			case "reporter":
				UserRoleEntity reporterRole = userRoleRepository.findByName(UserRoles.ROLE_REPORTER)
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				roles.add(reporterRole);

				break;
			case "admin":
				UserRoleEntity adminRole = userRoleRepository.findByName(UserRoles.ROLE_ADMIN)
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				roles.add(adminRole);

				break;
			   case "compensation":
				UserRoleEntity compensationRole = userRoleRepository.findByName(UserRoles.ROLE_COMPENSATION)
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				roles.add(compensationRole);

				break;
			default:
				UserRoleEntity userRole = userRoleRepository.findByName(UserRoles.ROLE_USER)
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				roles.add(userRole);
			}
//						});
		}
		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}
