package com.cts.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.entity.TransactionDetails;
import com.cts.entity.UserDetails;
import com.cts.exception.BankManagementException;
import com.cts.vo.TransactionVo;

@Repository
public class PerformTransactionDAOImpl implements PerformTransactionDAO {

	private SessionFactory sessionFactory;

	@Autowired(required = true)
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public String updateTransactionDetails(TransactionVo transactionvo)
			throws BankManagementException {
		Session s = sessionFactory.openSession();

		Long balance = 0l;
		int var = 0;
		int count = 0;

		TransactionDetails transactionDetails = new TransactionDetails();

		List<?> checkList = s.createQuery("from UserDetails").list();

		for (UserDetails user : (List<UserDetails>) checkList) {
			if (String.valueOf(user.getAccountNumber()).equals(
					String.valueOf(transactionvo.getAccountNumber()))) {
				count++;
			}
		}

		if (count == 1) {

			UserDetails userDetails = (UserDetails) s.load(UserDetails.class,
					transactionvo.getAccountNumber());
			userDetails.setAccountNumber(transactionvo.getAccountNumber());

			Integer Temp2 = (int) Math.ceil(Math.random() * 1000);
			String Temp3 = ("1000000").concat(Integer.toString(Temp2));
			Long Temp4 = Long.parseLong(Temp3);
			transactionDetails.setTransaction_id(Temp4);

			transactionDetails.setUser(userDetails);
			transactionDetails.setDescription(transactionvo.getDescription());
			transactionDetails.setTransactionAmount(transactionvo
					.getTransactionAmount());
			transactionDetails.setTransactionType(transactionvo
					.getTransactionType());
			s.save(transactionDetails);

			if (transactionvo.getTransactionAmount() > userDetails
					.getAccountBalance()) {
				var = 1;

				throw new BankManagementException("Insufficient Balance!!");

			}

			if (userDetails.getAccountType().equalsIgnoreCase("Savings")
					&& userDetails.getAccountBalance() <= 5000) {
				var = 1;
				throw new BankManagementException(
						"Savings Account should maintain minimum Rs.5000");
			}

			else if (var == 0) {

				if (transactionvo.getTransactionType().equalsIgnoreCase(
						"WithDrawal")) {
					balance = (userDetails.getAccountBalance() - transactionvo
							.getTransactionAmount());
					userDetails.setAccountBalance(balance);

				} else if (transactionvo.getTransactionType().equalsIgnoreCase(
						"Deposit")) {
					balance = (userDetails.getAccountBalance() + transactionvo
							.getTransactionAmount());
					userDetails.setAccountBalance(balance);
				}
			}
			s.flush();
			s.close();
			return (String.valueOf(balance));

		} else {
			throw new BankManagementException("User does not exist!!");
		}

	}

}
