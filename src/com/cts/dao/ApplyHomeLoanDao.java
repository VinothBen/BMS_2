package com.cts.dao;

import com.cts.exception.BankManagementException;
import com.cts.vo.ApplyHomeLoanVo;

public interface ApplyHomeLoanDao {
	public StringBuffer insertHomeLoanDetails(ApplyHomeLoanVo homeLoanVo)  throws BankManagementException;
	
}
