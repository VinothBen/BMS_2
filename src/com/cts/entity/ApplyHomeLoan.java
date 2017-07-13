package com.cts.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "homeloandetails")
public class ApplyHomeLoan {

	@Id
	@Column(name = "HOME_LOAN_ID")
	private String homeLoanId;

	@ManyToOne(cascade = CascadeType.ALL, targetEntity = UserDetails.class)
	@JoinColumn(name = "ACCOUNT_NUMBER")
	private UserDetails user;

	@Column(name = "HOME_LOAN_ACCOUNT_NUMBER")
	private String homeLoanAccountNumber;

	@Column(name = "LOAN_AMOUNT")
	private Long loanAmount;

	@Column(name = "LOAN_APPLY_DATE")
	@DateTimeFormat(pattern = "mm/dd/YYYY")
	private Date loanApplyDate;

	@Column(name = "LOAN_DURATION")
	private int loanDuration;

	@Column(name = "ANNUAL_INCOME")
	private Long annualIncome;

	@Column(name = "COMP_NAME")
	private String companyName;

	@Column(name = "DESIGNATION")
	private String designation;

	@Column(name = "TOTAL_EXP")
	private int totalExperience;

	@Column(name = "EXP_CURRENT_COMP")
	private int experienceCurrentcompany;

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
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
