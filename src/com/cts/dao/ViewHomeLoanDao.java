package com.cts.dao;

import java.util.List;

import com.cts.vo.ApplyHomeLoanVo;

public interface ViewHomeLoanDao {
		
		public List<ApplyHomeLoanVo> retrieveHomeLoanDetails(String homeLoanId, String homeLoanAccountNumber);
	}
