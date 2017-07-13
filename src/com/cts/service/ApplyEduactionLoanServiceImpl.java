package com.cts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dao.ApplyEducationLoanDao;
import com.cts.exception.BankManagementException;
import com.cts.vo.ApplyEducationLoanVo;

@Service
public class ApplyEduactionLoanServiceImpl implements ApplyEducationLoanService {

	@Autowired(required =true)
	private ApplyEducationLoanDao applyEducationLoanDao;
	
	public void setApplyEducationLoanDao(ApplyEducationLoanDao applyEducationLoanDao) {
		this.applyEducationLoanDao = applyEducationLoanDao;
	}


	@Override
	public StringBuffer insertEducationLoanDetails(ApplyEducationLoanVo applyEducationLoanVo) throws BankManagementException {	
		   StringBuffer sb=applyEducationLoanDao.insertEducationLoanDetails(applyEducationLoanVo);
		return sb;
	}

}
