package com.cts.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.entity.ApplyEducationLoan;
import com.cts.entity.UserDetails;
import com.cts.exception.BankManagementException;
import com.cts.vo.ApplyEducationLoanVo;
@Repository
public class ApplyEducationLoanDaoImpl implements ApplyEducationLoanDao {

	private SessionFactory sessionFactory;
  
	@Autowired(required = true)
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public StringBuffer insertEducationLoanDetails(
			ApplyEducationLoanVo applyEducationLoanVo) throws BankManagementException{
	
			int count = 0;
			Session s = sessionFactory.openSession();
			StringBuffer sbb = new StringBuffer("Loan applied successfully.");

			@SuppressWarnings("rawtypes")
			List checkList = s.createQuery("from UserDetails").list();
			
			
			for (UserDetails user : (List<UserDetails>) checkList) {
				if (String.valueOf(user.getAccountNumber()).equals(
						String.valueOf(applyEducationLoanVo.getAccountNumber()))) {
					count++;
				}
				}
			

			if (count == 1) {

			
	
		ApplyEducationLoan applyEducationLoan=new ApplyEducationLoan();
		
		UserDetails userDetails=(UserDetails)s.get(UserDetails.class,applyEducationLoanVo.getAccountNumber());
		userDetails.setAccountNumber(applyEducationLoanVo.getAccountNumber());
		
		applyEducationLoan.setUser(userDetails);
		
       	Integer Temp2=(int) Math.ceil(Math.random() *1000);
   	    String Temp3=("1000000000000").concat(Integer.toString(Temp2));
		
   	    applyEducationLoan.setEduLoanAccountNumber(Temp3);
   	    
   	    String sd=String.valueOf(userDetails.getAccountNumber());
		
		applyEducationLoan.setEducationLoanId("EL-"+sd.substring(11,16));
   	    applyEducationLoan.setEduLoanAmount(applyEducationLoanVo.getEduLoanAmount());
   	    applyEducationLoan.setEduLoanApplyDate(applyEducationLoanVo.getEduLoanApplyDate());
   	    applyEducationLoan.setEduLoanDuration(applyEducationLoanVo.getEduLoanDuration());
   	    applyEducationLoan.setCourseName(applyEducationLoanVo.getCourseName());
   	    applyEducationLoan.setCourseFee(applyEducationLoanVo.getCourseFee());
   	    applyEducationLoan.setFatherName(applyEducationLoanVo.getFatherName());
   	    applyEducationLoan.setFatherAnnualIncome(applyEducationLoanVo.getFatherAnnualIncome());
   	    applyEducationLoan.setIdCardNumber(applyEducationLoanVo.getIdCardNumber());
   	    
		s.save(applyEducationLoan);
		sbb.append(" Your Loan Account number is "
				+ String.valueOf(applyEducationLoan.getEduLoanAccountNumber()));

		s.flush();
	    s.close();
		return sbb;
	 
	}
			
	else {
		throw new BankManagementException("User does not exist!!");

	}

}
	
	
}



