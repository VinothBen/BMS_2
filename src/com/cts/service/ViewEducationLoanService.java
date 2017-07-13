package com.cts.service;

import java.util.List;

import com.cts.vo.ApplyEducationLoanVo;

public interface ViewEducationLoanService {
	
public List<ApplyEducationLoanVo>retrieveEducationLoanDetails(String educationLoanId, String eduLoanAccountNumber);

}
