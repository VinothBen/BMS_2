package com.cts.validator;




import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cts.vo.ApplyEducationLoanVo;

@Component
public class ValidatorImplEduLoan implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return ApplyEducationLoanVo.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		ApplyEducationLoanVo applyEducationLoanVo = (ApplyEducationLoanVo) arg0;

		if (applyEducationLoanVo.getAccountNumber()==(null)) {
			ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "accountNumber",
					"required.ValidAccountNumber");
		}

		else {

			if (!(Long.toString(applyEducationLoanVo.getAccountNumber())
					.matches("[0-9]{16}"))) {
				arg1.rejectValue("accountNumber", "required.ValidAccountNumber");
			}
		}

		if (applyEducationLoanVo.getEduLoanDuration()==0) {
			

			arg1.rejectValue("eduLoanDuration", "required.Loan_Duration");
		}
					

	ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "eduLoanAmount",
				"required.Loan_Amount");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "eduLoanApplyDate",
				"required.Loan_Apply_Date");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "fatherAnnualIncome",
				"required.Father_Annual_Income");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "fatherName",
				"required.Father_Name");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "courseFee",
				"required.Course_fee");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "courseName",
				"required.Course_Name");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "idCardNumber",
				"required.id_card_number");
	
		
	}
} 