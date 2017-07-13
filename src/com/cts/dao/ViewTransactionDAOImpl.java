package com.cts.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.entity.TransactionDetails;
import com.cts.vo.TransactionVo;

@Repository
public class ViewTransactionDAOImpl implements ViewTransactionDAO {

	private SessionFactory sessionFactory;

	@Autowired(required = true)
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<TransactionVo> retrieveTransactionDetails(Long transactionId,Long accountNumber) {
		Session s = sessionFactory.openSession();
		List<TransactionDetails> checkList = new ArrayList<TransactionDetails>();
		List<TransactionVo> checkList2 = new ArrayList<TransactionVo>();
		
		try {
			if(accountNumber!=null){
				checkList = s.createQuery("from TransactionDetails where account_number="+accountNumber).list();
				
			}
		   if(transactionId!=null){
				checkList = s.createQuery("from TransactionDetails where transaction_id="+transactionId).list();
			}
			for (TransactionDetails transactionDetails : checkList) {
				
				TransactionVo transactionVo = new TransactionVo();
			 
				transactionVo.setAccountNumber(transactionDetails.getUser().getAccountNumber());
				
				transactionVo.setTransactionId(transactionDetails
						.getTransaction_id());
				transactionVo.setTransactionType(transactionDetails
						.getTransactionType());
				transactionVo.setDescription(transactionDetails
						.getDescription());
				transactionVo.setBalance(transactionDetails.getTransactionAmount());
				checkList2.add(transactionVo);
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
