package com.cts.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="educationloandetails")
public class ApplyEducationLoan {

	@Id
	@Column(name = "EDUCATION_LOAN_ID")
	private String educationLoanId;

	@ManyToOne(cascade=CascadeType.ALL,targetEntity=UserDetails.class)
	@JoinColumn(name = "ACCOUNT_NUMBER")
	private UserDetails user;
	
	@Column(name = "EDU_LOAN_ACCOUNT_NUMBER")
	private String eduLoanAccountNumber;
	
	@Column(name = "EDU_LOAN_AMOUNT")
	private Long eduLoanAmount;
	
	@Column(name = "EDU_LOAN_APPLY_DATE")
	private Date eduLoanApplyDate;
	
	@Column(name = "EDU_LOAN_DURATION")
	private int eduLoanDuration;
	
	@Column(name = "FATHER_ANNUAL_INCOME")
	private Long fatherAnnualIncome;
	
	@Column(name = "FATHER_NAME")
	private String fatherName;
	
	@Column(name = "COURSE_FEE")
	private Long courseFee;
	
	@Column(name = "COURSE_NAME")
	private String courseName;
	
	@Column(name = "ID_CARD_NUMBER")
	private Long idCardNumber;
	
	public String getEducationLoanId() {
		return educationLoanId;
	}

	public void setEducationLoanId(String educationLoanId) {
		this.educationLoanId = educationLoanId;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
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

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Long getIdCardNumber() {
		return idCardNumber;
	}

	public void setIdCardNumber(Long idCardNumber) {
		this.idCardNumber = idCardNumber;
	}

	
}
