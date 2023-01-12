package com.capstone.compensation.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capstone.comensation.utility.UserManagmentException;
import com.capstone.compensation.errorresponse.MessageResponse;
import com.capstone.compensation.model.CompensationRequest;
import com.capstone.compensation.service.UserService;
import com.capstone.compensation.validation.CompensationValidation;
import com.capstone.compensation.validation.UserValidation;



@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class CompensationtionController {
    @Autowired
	private UserService userService;
    
    
	@Autowired
	private CompensationValidation compensationValidation;
	
 
	////////////////////////////////////////////////////create plan ///////////////////////
    
	@PostMapping("/createplan")
	public ResponseEntity<?> createPlan( @RequestBody CompensationRequest  plan) throws UserManagmentException {
		
		try {
			if(compensationValidation.compensationPlanValidation(plan))
			{
				return ResponseEntity.badRequest().body(new MessageResponse("Error:Min,Max and Percentage input values can't be same "));
				
			}
			if(compensationValidation.compensationPlanValidationdate(plan))
			{
				return ResponseEntity.badRequest().body(new MessageResponse("Error:ValidFrom date should be freater than Today date and ValidTo date should be greater than validFrom date "));
			}
			
			
			else {
			//ResponseEntity<com.capstone.compensation.errorresponse.MessageResponse> responseEntity = userService.createPlan(plan);
			return ResponseEntity.ok(new com.capstone.compensation.errorresponse.MessageResponse("Compensation Plan Created  successfully!"));
			}
			
		} catch (Exception e) {
			throw new UserManagmentException("cant create plan---> error", e);
		}
	}
	
///////////////// Delete Plan //////////////////////
      @DeleteMapping( value ="/deleteplan/{planId}")
      public ResponseEntity<?>  deletePlan(@PathVariable Long planId) throws UserManagmentException{
    	 // return  compensationValidations.authenticateCompensationPlan(planId);
    	  System.out.println("in the deleteing plan");
    	  try {
    		  System.out.println("entered into the try block");
    	  ResponseEntity<MessageResponse> responseEntity = userService.deletePlan(planId);
    			  	if (responseEntity != null)
    						return ResponseEntity.status(200).body(responseEntity);
    		   			else
    						throw new UserManagmentException(" cannot delete the plan--->");
    				} catch (Exception e) {
    					throw new UserManagmentException("deleting plan is failed ---> error", e);
    				}
      }
      
//////////////////////get plan by email/////////////////////      
      
      
      
      
}

       
     

