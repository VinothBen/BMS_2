package com.cts.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cts.vo.TransactionVo;

import java.lang.Long;

@Component
public class ValidatorImpl implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return TransactionVo.class.isAssignableFrom(arg0);

	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		TransactionVo transactionVo = (TransactionVo) arg0;

		if (transactionVo.getAccountNumber() == null) {
			ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "accountNumber",
					"required.ValidAccountNumber");
		}
		if (transactionVo.getDescription().length() == 0) {
			arg1.rejectValue("Description", "required.Description");
		}
		if (transactionVo.getTransactionType().equals("----")) {
			arg1.rejectValue("transactionType", "required.TransactionType");
		}
		if (transactionVo.getTransactionAmount() == null) {
			ValidationUtils.rejectIfEmptyOrWhitespace(arg1,
					"transactionAmount", "required.ValidAmount");
		}

		else {

			if (!(Long.toString(transactionVo.getAccountNumber())
					.matches("[0-9]{16}"))) {
				arg1.rejectValue("accountNumber", "required.ValidAccountNumber");
			}
			if (!(Long.toString(transactionVo.getTransactionAmount())
					.matches("[0-9]{1,}"))) {
				arg1.rejectValue("transactionAmount", "required.ValidAmount");

			}
		}
	}

}
