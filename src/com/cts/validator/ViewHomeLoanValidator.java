package com.cts.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cts.vo.ApplyHomeLoanVo;

@Component
public class ViewHomeLoanValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return ApplyHomeLoanVo.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {

		ApplyHomeLoanVo applyHomeLoanVo = (ApplyHomeLoanVo) arg0;
		
		System.out.println("validator");
		if (applyHomeLoanVo.getHomeLoanAccountNumber().isEmpty() && applyHomeLoanVo.getHomeLoanId().isEmpty()) {
			ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "homeLoanAccountNumber",
					"required.search");
		}

		
		if (!(applyHomeLoanVo.getHomeLoanAccountNumber().isEmpty())) {

			if (!(applyHomeLoanVo.getHomeLoanAccountNumber())
					.matches("[0-9]{16}")) {
				arg1.rejectValue("homeLoanAccountNumber", "required.ValidAccountNumber");
			}
		}
		if (!(applyHomeLoanVo.getHomeLoanId().isEmpty())) {

			if (!(applyHomeLoanVo.getHomeLoanId())
					.matches("(HL-)[0-9]{3}")) {
				arg1.rejectValue("homeLoanId", "required.loanId");
			}
		}
		
		
	}
	}
		
