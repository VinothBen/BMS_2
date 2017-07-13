package com.cts.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.entity.ApplyHomeLoan;
import com.cts.entity.UserDetails;
import com.cts.exception.BankManagementException;
import com.cts.vo.ApplyHomeLoanVo;


@Repository
public class ApplyHomeLoanDaoImpl implements ApplyHomeLoanDao {


	private SessionFactory sessionFactory;

	@Autowired(required = true)
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public StringBuffer insertHomeLoanDetails(ApplyHomeLoanVo homeLoanVo)
			throws BankManagementException {
		int count = 0;
		
		Session s = sessionFactory.openSession();
		StringBuffer sb = new StringBuffer("Loan applied successfully.");

		@SuppressWarnings("rawtypes")
		List checkList = s.createQuery("from UserDetails").list();
		
		
		for (UserDetails user : (List<UserDetails>) checkList) {
			if (String.valueOf(user.getAccountNumber()).equals(
					String.valueOf(homeLoanVo.getAccountNumber()))) {
				count++;
			}
		}

		if (count == 1) {

			
			ApplyHomeLoan applyHomeLoan = new ApplyHomeLoan();

			UserDetails userDetails = (UserDetails) s.get(UserDetails.class,
					homeLoanVo.getAccountNumber());
			userDetails.setAccountNumber(homeLoanVo.getAccountNumber());

			applyHomeLoan.setUser(userDetails);

			Long minimumAmount = (long) (homeLoanVo.getLoanAmount() / 10);

			

			if (homeLoanVo.getAnnualIncome() >= minimumAmount)

			{

				
				Integer Temp2 = (int) Math.ceil(Math.random() * 1000);
				String Temp3 = ("1000000000000").concat(Integer.toString(Temp2));

				applyHomeLoan.setHomeLoanAccountNumber(Temp3);

				String sd = String.valueOf(userDetails.getAccountNumber());

				applyHomeLoan.setHomeLoanId("HL-" + sd.substring(13, 16));

				applyHomeLoan.setLoanApplyDate(homeLoanVo.getLoanApplyDate());
				applyHomeLoan.setLoanAmount(homeLoanVo.getLoanAmount());
				applyHomeLoan.setLoanDuration(homeLoanVo.getLoanDuration());
				applyHomeLoan.setAnnualIncome(homeLoanVo.getAnnualIncome());
				applyHomeLoan.setCompanyName(homeLoanVo.getCompanyName());
				applyHomeLoan.setDesignation(homeLoanVo.getDesignation());
				applyHomeLoan.setTotalExperience(homeLoanVo
						.getTotalExperience());
				applyHomeLoan.setExperienceCurrentcompany(homeLoanVo
						.getExperienceCurrentcompany());
				s.save(applyHomeLoan);

				sb.append(" Your Loan Account number is "
						+ applyHomeLoan.getHomeLoanAccountNumber());

				s.flush();
				s.close();

				return sb;
			} 
			else {
				throw new BankManagementException("Loan cannot be processed!!");
			}

		} else {
			throw new BankManagementException("User does not exist!!");

		}

	}
}


