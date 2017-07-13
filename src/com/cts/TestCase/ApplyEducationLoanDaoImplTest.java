package com.cts.TestCase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cts.entity.ApplyEducationLoan;

@ContextConfiguration(locations = "classpath:spring-dispatcher-servlet-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)

public class ApplyEducationLoanDaoImplTest {

	private SessionFactory session;
	
	@Autowired(required = true)
	public void setSessionFactory(SessionFactory session) {
		this.session = session;
	}


	@Test
	public void testInsertEducationLoanDetails() {
		Session s = session.openSession();
		
		ApplyEducationLoan applyeducationLoan = (ApplyEducationLoan) s.get(ApplyEducationLoan.class, "EL-04000");
		if (applyeducationLoan != null)
			Assert.assertEquals(16, applyeducationLoan.getEduLoanAccountNumber().length());	
		s.close();


	}

}
