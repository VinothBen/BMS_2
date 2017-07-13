package com.cts.service;

import com.cts.exception.BankManagementException;
import com.cts.vo.TransactionVo;

public interface PerformTransactionService {
	public String updateTransactionDetails(TransactionVo transactionvo)
			throws BankManagementException;
}
