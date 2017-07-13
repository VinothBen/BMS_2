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

import com.cts.dao.ViewHomeLoanDaoImpl;
import com.cts.vo.ApplyHomeLoanVo;
@ContextConfiguration(locations = "classpath:spring-dispatcher-servlet-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ViewHomeLoanDaoImplTest {

@Autowired(required=true)
public ViewHomeLoanDaoImpl ViewHomeLoanDao;


	@Test
	@Transactional
	@Rollback(true)
	public void testRetrieveHomeLoanDetails() {
		String a="";
		String b="1000000000000509";
		List<ApplyHomeLoanVo> list = ViewHomeLoanDao.retrieveHomeLoanDetails( "HL-000","1000000000000509");
		for(ApplyHomeLoanVo ApplyHomeLoanVo:list)
		{
		a=ApplyHomeLoanVo.getHomeLoanAccountNumber();
		}
		Assert.assertTrue(a.equals(b));
		
		
	}
	}






