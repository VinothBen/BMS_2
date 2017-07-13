package com.cts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dao.ViewHomeLoanDaoImpl;
import com.cts.vo.ApplyHomeLoanVo;




@Service
public class ViewHomeLoanServiceImpl implements ViewHomeLoanService{


	@Autowired(required = true)
	private ViewHomeLoanDaoImpl viewHomeLoanDaoImpl;
	
	@Override
	public List<ApplyHomeLoanVo> retrieveHomeLoanDetails(String homeLoanId, String homeLoanAccountNumber) {
		List<ApplyHomeLoanVo> list = new ArrayList<ApplyHomeLoanVo>();
		list = viewHomeLoanDaoImpl.retrieveHomeLoanDetails(homeLoanId,
				homeLoanAccountNumber);
		return list;
	}

}

	

