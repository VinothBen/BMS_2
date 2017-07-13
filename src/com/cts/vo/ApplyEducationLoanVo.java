package com.cts.vo;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class ApplyEducationLoanVo {
	
	private Long accountNumber;
	
private String eduLoanAccountNumber;
	
	private Long eduLoanAmount;
	
	private Date eduLoanApplyDate;
	
	private int eduLoanDuration;
	
	private Long fatherAnnualIncome;
	
	private String fatherName;
	
	private Long courseFee;
	
	private String courseName;
	
	private String educationLoanId;
	
	private String accountHolderName;
	
	
	
	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getEducationLoanId() {
		return educationLoanId;
	}

	public void setEducationLoanId(String educationLoanId) {
		this.educationLoanId = educationLoanId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	private Long idCardNumber;
	
	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getEduLoanAccountNumber() {
		return eduLoanAccountNumber;
	}

	public void setEduLoanAccountNumber(String eduLoanAccountNumber) {
		this.eduLoanAccountNumber = eduLoanAccountNumber;
	}

	public Long getEduLoanAmount() {
		return eduLoanAmount;
	}

	public void setEduLoanAmount(Long eduLoanAmount) {
		this.eduLoanAmount = eduLoanAmount;
	}

	public Date getEduLoanApplyDate() {
		return eduLoanApplyDate;
	}

	public void setEduLoanApplyDate(Date eduLoanApplyDate) {
		this.eduLoanApplyDate = eduLoanApplyDate;
	}

	public int getEduLoanDuration() {
		return eduLoanDuration;
	}

	public void setEduLoanDuration(int eduLoanDuration) {
		this.eduLoanDuration = eduLoanDuration;
	}

	public Long getFatherAnnualIncome() {
		return fatherAnnualIncome;
	}

	public void setFatherAnnualIncome(Long fatherAnnualIncome) {
		this.fatherAnnualIncome = fatherAnnualIncome;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public Long getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(Long courseFee) {
		this.courseFee = courseFee;
	}



	public Long getIdCardNumber() {
		return idCardNumber;
	}

	public void setIdCardNumber(Long idCardNumber) {
		this.idCardNumber = idCardNumber;
	}

	
	
	

	
	

}
