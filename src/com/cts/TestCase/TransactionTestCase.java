package com.cts.TestCase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cts.entity.TransactionDetails;
import com.cts.exception.BankManagementException;

@ContextConfiguration(locations = "classpath:spring-dispatcher-servlet-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TransactionTestCase {
    
	
	private SessionFactory session;
	
	@Autowired(required = true)
	public void setSessionFactory(SessionFactory session) {
		this.session = session;
	}

	
	@Test
	@Transactional
	@Rollback
	public void testTransaction() throws BankManagementException {
		Session s = session.openSession();
		TransactionDetails transactionDetails = null;
		try {
		  transactionDetails = (TransactionDetails) s.load(TransactionDetails.class , 1000000251l);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Long transactionAmount = 20000l;
		Assert.assertEquals(transactionAmount, Long.valueOf(transactionDetails.getTransactionAmount()));
	   s.close();
	}

}
