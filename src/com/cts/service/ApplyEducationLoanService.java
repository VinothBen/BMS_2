package com.cts.service;

import com.cts.exception.BankManagementException;
import com.cts.vo.ApplyEducationLoanVo;


public interface ApplyEducationLoanService {
	public StringBuffer insertEducationLoanDetails(ApplyEducationLoanVo applyEducationLoanVo)throws BankManagementException;
}
