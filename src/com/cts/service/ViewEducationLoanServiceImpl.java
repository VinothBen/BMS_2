package com.cts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dao.ViewEducationLoanDaoImpl;
import com.cts.vo.ApplyEducationLoanVo;

@Service
public class ViewEducationLoanServiceImpl implements ViewEducationLoanService{


	@Autowired(required = true)
	private ViewEducationLoanDaoImpl vieweducationLoanDaoImpl;
	
	@Override
	public List<ApplyEducationLoanVo> retrieveEducationLoanDetails(String educationLoanId, String eduLoanAccountNumber) {
		List<ApplyEducationLoanVo> list = new ArrayList<ApplyEducationLoanVo>();
		list = vieweducationLoanDaoImpl.retrieveEducationLoanDetails(educationLoanId,
				eduLoanAccountNumber);
		return list;
	}

}


