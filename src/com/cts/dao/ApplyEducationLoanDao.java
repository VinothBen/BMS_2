package com.cts.dao;

import com.cts.exception.BankManagementException;
import com.cts.vo.ApplyEducationLoanVo;

public interface ApplyEducationLoanDao {
	public StringBuffer insertEducationLoanDetails(ApplyEducationLoanVo applyEducationLoanVo) throws BankManagementException;
	
}
