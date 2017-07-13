package com.cts.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class ApplyHomeLoanVo {

	private Long accountNumber;
	
	private Long loanAmount;

	private Date loanApplyDate;

	private int loanDuration;

	private Long annualIncome;

	private String companyName;

	private String designation;

	private int totalExperience;

	private int experienceCurrentcompany;
	
	private String homeLoanId;
	
	private String homeLoanAccountNumber;
	
	private String accountHolderName;
	
	
	
	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getHomeLoanId() {
		return homeLoanId;
	}

	public void setHomeLoanId(String homeLoanId) {
		this.homeLoanId = homeLoanId;
	}

	public String getHomeLoanAccountNumber() {
		return homeLoanAccountNumber;
	}

	public void setHomeLoanAccountNumber(String homeLoanAccountNumber) {
		this.homeLoanAccountNumber = homeLoanAccountNumber;
	}




	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Long loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Date getLoanApplyDate() {
		return loanApplyDate;
	}

	public void setLoanApplyDate(Date loanApplyDate) {
		this.loanApplyDate = loanApplyDate;
	}

	public int getLoanDuration() {
		return loanDuration;
	}

	public void setLoanDuration(int loanDuration) {
		this.loanDuration = loanDuration;
	}

	public Long getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(Long annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getTotalExperience() {
		return totalExperience;
	}

	public void setTotalExperience(int totalExperience) {
		this.totalExperience = totalExperience;
	}

	public int getExperienceCurrentcompany() {
		return experienceCurrentcompany;
	}

	public void setExperienceCurrentcompany(int experienceCurrentcompany) {
		this.experienceCurrentcompany = experienceCurrentcompany;
	}


	
}
