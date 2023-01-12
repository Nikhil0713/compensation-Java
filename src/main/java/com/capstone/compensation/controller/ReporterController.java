package com.capstone.compensation.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capstone.compensation.entity.CompensationEntity;
import com.capstone.compensation.repository.UserComepnsationRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class ReporterController {
	

	@Autowired(required = true)
	private UserComepnsationRepository comepnsationRepository;
	
	@GetMapping("/viewplan")
	public List<CompensationEntity> fetchCompensationDetails(){
		return comepnsationRepository.fetchCompensationDetails();
	}

}
