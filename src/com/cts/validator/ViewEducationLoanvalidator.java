package com.cts.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cts.vo.ApplyEducationLoanVo;

@Component
public class ViewEducationLoanvalidator implements Validator {
	
	
	@Override
	public boolean supports(Class<?> arg0) {
		return ApplyEducationLoanVo.class.isAssignableFrom(arg0);
	}
	
	@Override
	public void validate(Object arg0, Errors arg1) {
		ApplyEducationLoanVo applyEducationLoanVo = (ApplyEducationLoanVo) arg0;
		
		if (applyEducationLoanVo.getEduLoanAccountNumber().isEmpty() && applyEducationLoanVo.getEducationLoanId().isEmpty()) {
			
			ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "eduLoanAccountNumber",
					"required.search");
		}
		
		if (!(applyEducationLoanVo.getEduLoanAccountNumber().isEmpty())) {

			if (!(applyEducationLoanVo.getEduLoanAccountNumber())
					.matches("[0-9]{16}")) {
				arg1.rejectValue("eduLoanAccountNumber", "required.ValidAccountNumber");
			}
		}
		
		if (!(applyEducationLoanVo.getEducationLoanId().isEmpty())) {

			if (!(applyEducationLoanVo.getEducationLoanId())
					.matches("(EL-)[0-9]{5}")) {
				arg1.rejectValue("educationLoanId", "required.loanId");
			}
		}
		
	}
}
