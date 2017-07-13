package com.cts.dao;

import com.cts.exception.BankManagementException;
import com.cts.vo.TransactionVo;



public interface PerformTransactionDAO {

	public String updateTransactionDetails(TransactionVo transactionvo)
			throws BankManagementException;
}
