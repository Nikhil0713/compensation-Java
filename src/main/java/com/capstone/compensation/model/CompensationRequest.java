package com.capstone.compensation.model;

import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CompensationRequest {
	
	

		@NotBlank
	    @Size(min = 3, max = 20)
		private String partnerName;
	    @NotBlank
	    @Size(min = 3, max = 20)
		private String compensationPlan;
	    
	   private String incomeType;
	    @NotBlank
		private  Double percentagecompensation;
	    @NotBlank
		private  Double min;
	    @NotBlank
		private  Double max;
	    @NotBlank
		private Date validTo;
	    @NotBlank
		private Date validFrom;
	    
	    
		public Double getPercentagecompensation() {
			return percentagecompensation;
		}

		public void setPercentagecompensation(Double percentagecompensation) {
			this.percentagecompensation = percentagecompensation;
		}

		public Double getMin() {
			return min;
		}

		public void setMin(Double min) {
			this.min = min;
		}

		public Double getMax() {
			return max;
		}

		public void setMax(Double max) {
			this.max = max;
		}

		

		public String getPartnerName() {
			return partnerName;
		}

		public void setPartnerName(String partnerName) {
			this.partnerName = partnerName;
		}

		public String getCompensationPlan() {
			return compensationPlan;
		}

		public void setCompensationPlan(String compensationPlan) {
			this.compensationPlan = compensationPlan;
		}
		public String getIncomeType() {
			return incomeType;
		}

		public void setIncomeType(String incomeType) {
			this.incomeType = incomeType;
		}

		public Date getValidTo() {
			return validTo;
		}

		public void setValidTo(Date validTo) {
			this.validTo = validTo;
		}

		public Date getValidFrom() {
			return validFrom;
		}

		public void setValidFrom(Date validFrom) {
			this.validFrom = validFrom;
		}



		public CompensationRequest() {
			super();
		}

				

	}



