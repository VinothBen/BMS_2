package com.cts.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cts.vo.TransactionVo;

@Component
public class ValidatorTransactionSearch implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return TransactionVo.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {

		TransactionVo transactionVo = (TransactionVo) arg0;

		if (transactionVo.getAccountNumber() == null
				&& !(transactionVo.getTransactionId() == null)) {

			if (!(Long.toString(transactionVo.getTransactionId())
					.matches("[0-9]{10}"))) {
				arg1.rejectValue("TransactionId", "required.TransactionId");
			}
		}

		else if (transactionVo.getTransactionId() == null
				&& !(transactionVo.getAccountNumber() == null)) {

			if (!(Long.toString(transactionVo.getAccountNumber())
					.matches("[0-9]{16}"))) {
				arg1.rejectValue("accountNumber", "required.ValidAccountNumber");
			}
		}

		else if ((transactionVo.getAccountNumber() == null)
				&& (transactionVo.getTransactionId() == null)) {

			ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "accountNumber",
					"required.ValidAccountNumber");
			ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "TransactionId",
					"required.TransactionId");
		}

	}
}
