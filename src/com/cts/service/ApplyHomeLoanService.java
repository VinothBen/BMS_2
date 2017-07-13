package com.cts.service;
import com.cts.exception.BankManagementException;
import com.cts.vo.ApplyHomeLoanVo;

public interface ApplyHomeLoanService {

public StringBuffer insertHomeLoanDetails(ApplyHomeLoanVo homeLoanVo) throws BankManagementException;

}
