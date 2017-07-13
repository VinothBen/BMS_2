package com.cts.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cts.exception.BankManagementException;
import com.cts.service.ApplyEducationLoanService;
import com.cts.validator.ValidatorImplEduLoan;
import com.cts.vo.ApplyEducationLoanVo;

@Controller
public class ApplyEducationLoanController {

	private static final Logger LOGGER = Logger.getLogger(ApplyEducationLoanController.class);
	private static final String START ="start";
	private static final String END = "end";
	
	private ApplyEducationLoanService applyEducationLoanService;

	@Autowired(required = true)
	public void setApplyEducationLoanService(
			ApplyEducationLoanService applyEducationLoanService) {
		this.applyEducationLoanService = applyEducationLoanService;
	}

	
	
	
	@RequestMapping("/indexinieduloan")
	public ModelAndView listBooks() {

		ModelAndView model = new ModelAndView();
		model.addObject("applyeducationloan", new ApplyEducationLoanVo());
		model.setViewName("applyeducationloan");
		return model;
	}

	 @Autowired(required = true)
	 private ValidatorImplEduLoan validatorImplEduLoan;
	
	 @InitBinder
	 public void initBinder(WebDataBinder binder){
	
	 binder.setValidator(validatorImplEduLoan);
	
	 }

	 @RequestMapping("vieweducationloan")
		public ModelAndView InitEduLoanView() {
			ModelAndView model = new ModelAndView();
			model.addObject("geteducationloan", new ApplyEducationLoanVo());
			model.setViewName("educationloansearch");
			return model;
		}

	 
	@ModelAttribute("applyDate")
	public String getapply_Date() {
		DateFormat df = new SimpleDateFormat("MM/dd/YYYY");
		Date dateobj = new Date();
		return df.format(dateobj);
	}

	@RequestMapping(value = "applyeducationloan/add", method = RequestMethod.POST)
	public ModelAndView initiateEducationLoan(@Valid
			@ModelAttribute("applyeducationloan") ApplyEducationLoanVo applyEducationLoanVo,
			BindingResult result, Map<String, Object> map) {
		ModelAndView model = new ModelAndView();
		
		LOGGER.info(START);
        LOGGER.info("ApplyEducationLoan Controller Strated");


		if (result.hasErrors()) {
			
			 LOGGER.info("Apply EducationLoan has result binding error");
			 
			model.setViewName("applyeducationloan");
		}
		else {
			try {
				LOGGER.info("ApplyEducationLoan Service called");
				StringBuffer  msg = applyEducationLoanService
						.insertEducationLoanDetails(applyEducationLoanVo);
				model.addObject("msg", msg);
				model.setViewName("applyeducationloan");
			} catch (BankManagementException e) {
				LOGGER.info("Apply Education Loan has exception");
				model.addObject("msg",e.getmsg());
				model.setViewName("applyeducationloan");

				e.printStackTrace();
			}
			
		}
		 LOGGER.info(END);
		return model;
	}

	@ModelAttribute("applyedulist")
	public Map<String, String> getEdu_Loan_Duration() {
		Map<String, String> EduLoanDurationList = new HashMap<String, String>();
		EduLoanDurationList.put("5", "5");
		EduLoanDurationList.put("10", "10");
		return EduLoanDurationList;

	}
}
