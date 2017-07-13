package com.cts.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dao.ApplyHomeLoanDao;
import com.cts.exception.BankManagementException;
import com.cts.vo.ApplyHomeLoanVo;

@Service
public class ApplyHomeLoanServiceImpl implements ApplyHomeLoanService{
   
	@Autowired(required =true)
	private ApplyHomeLoanDao applyHomeLoanDao;
	
	public void setApplyHomeLoanDao(ApplyHomeLoanDao applyHomeLoanDao) {
		this.applyHomeLoanDao = applyHomeLoanDao;
	}
	
	@Override
	public StringBuffer insertHomeLoanDetails(ApplyHomeLoanVo homeLoanVo)  throws BankManagementException{
		StringBuffer sb=applyHomeLoanDao.insertHomeLoanDetails(homeLoanVo);
		return sb;
		
	}


}
