package com.cts.TestCase;

import java.util.List;



import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cts.dao.ViewTransactionDAOImpl;
import com.cts.vo.TransactionVo;

@ContextConfiguration(locations = "classpath:spring-dispatcher-servlet-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ViewTransactionTest {
   
	
	private ViewTransactionDAOImpl transactionDAOImpl;

	@Autowired(required = true)
	public void setTransactionDAOImpl(ViewTransactionDAOImpl transactionDAOImpl) {
		this.transactionDAOImpl = transactionDAOImpl;
	}

	@Test
	@Transactional
	@Rollback
	public void testRetrieveTransactionDetails() {
		
		List<TransactionVo> list=transactionDAOImpl.retrieveTransactionDetails(1000000251l,null);
		Long accountNumber = 0l;
		for(TransactionVo transactionVo:list){
		 accountNumber=transactionVo.getAccountNumber();
		}
		Long accountNumberTest = 1000200030004000l;
		Assert.assertEquals(accountNumberTest,Long.valueOf(accountNumber));
	}

}
