package com.cts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.dao.PerformTransactionDAO;
import com.cts.exception.BankManagementException;
import com.cts.vo.TransactionVo;

@Service
public class PerformTransactionServiceImpl implements PerformTransactionService {

	@Autowired(required = true)
	private PerformTransactionDAO performTransactionDAO;

	public void setTransactionDao(PerformTransactionDAO performTransactionDAO) {
		this.performTransactionDAO = performTransactionDAO;
	}

	@Transactional
	public String updateTransactionDetails(TransactionVo transactionvo)
			throws BankManagementException {
		String balance = performTransactionDAO.updateTransactionDetails(transactionvo);
		return balance;
	}
}
