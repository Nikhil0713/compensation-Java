package com.capstone.compensation.validation;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.capstone.compensation.entity.CompensationEntity;
import com.capstone.compensation.model.CompensationRequest;
import com.capstone.compensation.repository.UserComepnsationRepository;

@Component
public class CompensationValidation {
 
	 
	    

		@Autowired
	UserComepnsationRepository comepnsationRepository;
	
	public boolean  compensationPlanValidation(CompensationRequest  plan)
	{
		boolean isValidCompensation = false;
		
		List<CompensationEntity> values= comepnsationRepository.fetchCompensationDetails();
		
		for (CompensationEntity compensationEntity : values) {
			
			if((compensationEntity.getMax().equals(plan.getMax()))&& 
					(compensationEntity.getMin().equals(plan.getMin()))&&
							(compensationEntity.getPercentagecompensation().equals(plan.getPercentagecompensation()))) {
				
				isValidCompensation = true;
				
		
			}
			
		}
		
		return isValidCompensation;
	}
	public boolean  compensationPlanValidationdate(CompensationRequest  plan) throws ParseException
	{
	       boolean isValidCompensation = false;
	       Date todayDate = new Date(System.currentTimeMillis());	 
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		   // Date todayDate= formatter.parse(todayDate1.toString());
		   Date fromDate =formatter.parse(plan.getValidFrom().toString());
		
		   Date toDate =formatter.parse(plan.getValidTo().toString());
		   
		// Date date = new Date(); 
		 
		   if((fromDate.compareTo(toDate)>0) || (todayDate.after(fromDate)) || (toDate.compareTo(fromDate)==0)) {
			   isValidCompensation =true;
		   }
//		   else if(fromDate.after(todayDate)) {
//			   isValidCompensation = false;
//		   }
		   
		   else  {
			   isValidCompensation = false;
		   }	
		 
		  
		return isValidCompensation;

		
		}

}
