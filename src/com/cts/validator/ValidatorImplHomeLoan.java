package com.cts.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cts.vo.ApplyHomeLoanVo;

@Component
public class ValidatorImplHomeLoan implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return ApplyHomeLoanVo.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
	
		ApplyHomeLoanVo applyHomeLoanVo = (ApplyHomeLoanVo) arg0;

		if (applyHomeLoanVo.getAccountNumber()==(null)) {
			ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "accountNumber",
					"required.ValidAccountNumber");
		}

		else {

			if (!(Long.toString(applyHomeLoanVo.getAccountNumber())
					.matches("[0-9]{16}"))) {
				arg1.rejectValue("accountNumber", "required.ValidAccountNumber");
			}
		}

		if (applyHomeLoanVo.getLoanDuration()==0) {

			arg1.rejectValue("loanDuration", "required.Loan_Duration");
		}


	ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "loanAmount",
				"required.Loan_Amount");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "loanApplyDate",
				"required.Loan_Apply_Date");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "annualIncome",
				"required.Annual_Income");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "companyName",
				"required.Company_Name");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "designation",
				"required.Designation");
		
		if (applyHomeLoanVo.getTotalExperience()==0) {

			arg1.rejectValue("totalExperience", "required.Total_Experience");
		}
		
		if (applyHomeLoanVo.getExperienceCurrentcompany()==0) {

			arg1.rejectValue("experienceCurrentcompany", "required.Experience_Current_company");
		}
		
	}
} 