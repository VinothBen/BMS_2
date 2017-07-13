package com.cts.service;

import java.util.List;

import com.cts.vo.TransactionVo;

public interface ViewTransactionService {

	public List<TransactionVo> retrieveTransactionDetails(Long transactionId,Long accountNumber);
}
