package com.capstone.compensation.service;


import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.capstone.comensation.utility.UserManagmentException;
import com.capstone.compensation.entity.CompensationEntity;
import com.capstone.compensation.entity.UserEntity;
import com.capstone.compensation.errorresponse.MessageResponse;
import com.capstone.compensation.model.CompensationRequest;
import com.capstone.compensation.repository.UserComepnsationRepository;
import com.capstone.compensation.repository.UserRepository;
import com.capstone.compensation.service.impl.UserDetailsImpl;


@Service
public class UserService  implements UserDetailsService {


	public static final Logger logger = LoggerFactory.getLogger(UserService.class);


	
	@Autowired(required = true)
	private UserRepository userRepository;
	
	@Autowired(required = true)
	private UserComepnsationRepository comepnsationRepository;


	public List<UserEntity> getAllUserDetailsUsers() {
		return userRepository.findAll();
	}

	@Cacheable(value = "movielibrary", key = "#employId")
	public UserEntity getUserByEmployId(Long employId ) throws Exception {
		Optional<UserEntity> user = userRepository.findById(employId);
		if (user.isEmpty()) {
			throw new Exception("Can not find user with employId: " + employId);
		} else {
			return user.get();
		}
	}
	public UserEntity insertUserData(UserEntity user) {
		return userRepository.save(user);
	}
	
	@CachePut(value = "userlibrary", key = "#id")
	public UserEntity updateUserData(UserEntity user) throws Exception {
		if (user != null && user.getEmployId() > 0) {
			return userRepository.save(user);
		} else {
			throw new Exception("Can not find user with id: ");
		}
	}

	@CacheEvict(value = "userlibrary", key = "#employId")
	public UserEntity deleteUserByemployId(Long employId) throws Exception {
		if (employId > 0) {
			UserEntity user = getUserByEmployId(employId);
			if (user != null && !"".equalsIgnoreCase(user.getEmailId())) {
				userRepository.deleteById(employId);
				return user;
			}
		}
		throw new UserManagmentException("Can not delete User with employId: " + employId);

	}
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByEmailId(emailId)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with emailId: " + emailId));

		return UserDetailsImpl.build(user);
	}
/////////////////create plan/////////////////////////
	public  ResponseEntity<MessageResponse> createPlan(CompensationRequest plan) {
	  CompensationEntity user = new CompensationEntity(plan.getPartnerName(),plan.getCompensationPlan(),plan.getIncomeType(),plan.getMin(),plan.getMax()
			  ,plan.getPercentagecompensation(),plan.getValidFrom(),plan.getValidTo());
	  comepnsationRepository.save(user);
	return ResponseEntity.ok(new com.capstone.compensation.errorresponse.MessageResponse("Compensation Plan Created  successfully!"));
	  
		
	}
	
	@Transactional
	public  ResponseEntity<MessageResponse> deletePlan(Long planId) {
		  if(planId > 0) {
			  comepnsationRepository.deleteByplanId(planId); 
		  }
		  else {
			  return ResponseEntity.ok(new com.capstone.compensation.errorresponse.MessageResponse("cant find the id "+ planId));
		  }
		return ResponseEntity.ok(new com.capstone.compensation.errorresponse.MessageResponse(" successfully! delete the plan"));
		  }
	public List<CompensationEntity> fetchCompensationDetails(){
		return comepnsationRepository.fetchCompensationDetails();
	}
}


