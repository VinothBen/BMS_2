package com.cts.TestCase;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cts.dao.ViewEducationLoanDaoImpl;
import com.cts.vo.ApplyEducationLoanVo;

@ContextConfiguration(locations = "classpath:spring-dispatcher-servlet-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)

public class ViewEducationLoanDaoImplTest {

	@Autowired(required=true)
	public ViewEducationLoanDaoImpl view;

	@Test
	public void testRetrieveEducationLoanDetails() {
		String a="";
		String b="1000000000000986";
		List<ApplyEducationLoanVo> list = view.retrieveEducationLoanDetails("EL-04000", "1000000000000986");
		for(ApplyEducationLoanVo ApplyEducationLoanVo:list)
		{
			a=ApplyEducationLoanVo.getEduLoanAccountNumber();
		}
		Assert.assertTrue(a.equals(b));
	}
}
