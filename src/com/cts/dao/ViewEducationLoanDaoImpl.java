package com.cts.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.entity.ApplyEducationLoan;
import com.cts.vo.ApplyEducationLoanVo;

@Repository
public class ViewEducationLoanDaoImpl implements VieweducationLoanDao {

		private SessionFactory sessionFactory;
	  
		@Autowired(required = true)
		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}

		@SuppressWarnings({ "unchecked" })
		@Override
		
		public List<ApplyEducationLoanVo> retrieveEducationLoanDetails(String educationLoanId, String eduLoanAccountNumber) {
			Session s = sessionFactory.openSession();
			List<ApplyEducationLoan> checkList = new ArrayList<ApplyEducationLoan>();
			List<ApplyEducationLoanVo> checkList2 = new ArrayList<ApplyEducationLoanVo>();		
			try {
				
				if(!(eduLoanAccountNumber.length()==0)){
					checkList = s.createQuery("from ApplyEducationLoan where EDU_LOAN_ACCOUNT_NUMBER="+"'"+eduLoanAccountNumber+"'").list();
				}
				else if(!(educationLoanId.length()==0)){
					checkList = s.createQuery("from ApplyEducationLoan where EDUCATION_LOAN_ID="+"'"+educationLoanId+"'").list();
				}
				for (ApplyEducationLoan eduLoan : checkList) {
					
					ApplyEducationLoanVo applyEducationLoanVo=new ApplyEducationLoanVo();
					
					applyEducationLoanVo.setEducationLoanId(eduLoan.getEducationLoanId());
				 
					applyEducationLoanVo.setAccountHolderName(eduLoan.getUser().getAccountHolderName());
					
					applyEducationLoanVo.setEduLoanAmount(eduLoan.getEduLoanAmount());
					applyEducationLoanVo.setCourseName(eduLoan.getCourseName());
					applyEducationLoanVo.setFatherName(eduLoan.getFatherName());
					
					
					checkList2.add(applyEducationLoanVo);
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

