package com.capstone.compensation.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@Table(name = "compensation_Table")
@JsonDeserialize(as = UserEntity.class)
public class CompensationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "plan_Id")
	private Long planId;
	@Column(name = "partner_Name")
	private String partnerName;
	@Column(name = "compensation_Plan")
	private String compensationPlan;
	@Column(name = "income_Type")
	private String incomeType;
	@Column(name = "percentagecompensation")
	private Double percentagecompensation;
	@Column(name = "min")
	private Double min;
	@Column(name = "max")
	private Double max;
	@Column(name = "validTo")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date validTo;
	@Column(name = "validFrom")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date validFrom;

	public Long getPlanId() {
		return planId;
	}

	public void setPlanId(Long planId) {
		this.planId = planId;
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

	public CompensationEntity() {
		super();
	}

	public CompensationEntity(String partnerName, String compensationPlan, String incomeType, Double min, Double max,
			Double percentagecompensation, Date validTo, Date validFrom) {
		super();
		this.partnerName = partnerName;
		this.compensationPlan = compensationPlan;
		this.incomeType = incomeType;
		this.min = min;
		this.max = max;
		this.percentagecompensation = percentagecompensation;
		this.validTo = validTo;
		this.validFrom = validFrom;

	}

	public CompensationEntity(Long planId, String partnerName, String compensationPlan, String incomeType, Double min,
			Double max, Double percentagecompensation, Date validTo, Date validFrom) {
		this(partnerName, compensationPlan, incomeType, min, max, percentagecompensation, validTo, validFrom);
		this.planId = planId;
	}

	@Override
	public String toString() {
		return "CompensationEntity [planId=" + planId + "]";
	}

}
