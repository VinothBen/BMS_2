package com.cts.TestCase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.cts.entity.ApplyHomeLoan;

@ContextConfiguration(locations = "classpath:spring-dispatcher-servlet-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)

public class ApplyHomeLoanDaoImplTest {

	private SessionFactory session;
	
	@Autowired(required = true)
	public void setSessionFactory(SessionFactory session) {
		this.session = session;
	}

	
	@Test
	public void testInsertHomeLoanDetails() {
		Session s = session.openSession();
		
				ApplyHomeLoan applyHomeLoan = (ApplyHomeLoan) s.get(ApplyHomeLoan.class, "HL-000");
				if (applyHomeLoan != null)
					Assert.assertEquals(16, applyHomeLoan.getHomeLoanAccountNumber().length());	
				s.close();
	
		}
	}





