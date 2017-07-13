package com.cts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dao.ViewTransactionDAOImpl;
import com.cts.vo.TransactionVo;

@Service
public class ViewTransactionServiceImpl implements ViewTransactionService {

	@Autowired(required = true)
	private ViewTransactionDAOImpl transactionDAOImpl;

	@Override
	public List<TransactionVo> retrieveTransactionDetails(Long transactionId,
			Long accountNumber) {
		List<TransactionVo> list = new ArrayList<TransactionVo>();
		list = transactionDAOImpl.retrieveTransactionDetails(transactionId,
				accountNumber);
		return list;
	}

}
