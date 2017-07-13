package com.cts.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.entity.ApplyHomeLoan;
import com.cts.vo.ApplyHomeLoanVo;

@Repository
public class ViewHomeLoanDaoImpl implements ViewHomeLoanDao {


	private SessionFactory sessionFactory;

	@Autowired(required = true)
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings({ "unchecked" })
	@Override
	
	public List<ApplyHomeLoanVo> retrieveHomeLoanDetails(String homeLoanId, String homeLoanAccountNumber) {
	
		Session s = sessionFactory.openSession();
		List<ApplyHomeLoan> checkList = new ArrayList<ApplyHomeLoan>();
		List<ApplyHomeLoanVo> checkList2 = new ArrayList<ApplyHomeLoanVo>();		
		try {
			
	if(homeLoanId!="" || homeLoanAccountNumber!=""){
				checkList = s.createQuery("from ApplyHomeLoan where HOME_LOAN_ID="+"'"+homeLoanId+"'").list();
			
	}			
			for (ApplyHomeLoan applyHomeLoan : checkList) {
				
				ApplyHomeLoanVo homeLoanVo = new ApplyHomeLoanVo();
				
				homeLoanVo.setHomeLoanAccountNumber(applyHomeLoan.getHomeLoanAccountNumber());
			 
				homeLoanVo.setAccountHolderName(applyHomeLoan.getUser().getAccountHolderName());
				
				homeLoanVo.setHomeLoanId(applyHomeLoan
						.getHomeLoanId());
				homeLoanVo.setLoanAmount( applyHomeLoan
						.getLoanAmount());
				homeLoanVo.setDesignation( applyHomeLoan
						.getDesignation());
				homeLoanVo.setCompanyName( applyHomeLoan.getCompanyName());
				
				checkList2.add(homeLoanVo);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			s.flush();
			s.close();
		}
		return checkList2;
	}
}


