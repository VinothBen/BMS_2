package com.cts.service;

import java.util.List;

import com.cts.vo.ApplyHomeLoanVo;

public interface ViewHomeLoanService {
	public List<ApplyHomeLoanVo> retrieveHomeLoanDetails(String homeLoanId, String homeLoanAccountNumber);
}
