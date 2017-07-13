package com.cts.dao;

import java.util.List;

import com.cts.vo.TransactionVo;


public interface ViewTransactionDAO {
	public List<TransactionVo> retrieveTransactionDetails(Long transactionId,Long accountNumber);

}
