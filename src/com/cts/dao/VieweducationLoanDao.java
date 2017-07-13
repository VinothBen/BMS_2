package com.cts.dao;

import java.util.List;

import com.cts.vo.ApplyEducationLoanVo;

public interface VieweducationLoanDao {

	public List<ApplyEducationLoanVo> retrieveEducationLoanDetails(String educationLoanId, String eduLoanAccountNumber);
}
