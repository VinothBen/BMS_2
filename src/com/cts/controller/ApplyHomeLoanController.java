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
import com.cts.service.ApplyHomeLoanService;
import com.cts.validator.ValidatorImplHomeLoan;
import com.cts.vo.ApplyHomeLoanVo;

@Controller
public class ApplyHomeLoanController {

	private static final Logger LOGGER = Logger.getLogger(ApplyHomeLoanController.class);
	private static final String START ="start";
	private static final String END = "end";
	
	public ApplyHomeLoanService applyHomeLoanService;

	@Autowired(required = true)
	public void setApplyHomeLoanService(
			ApplyHomeLoanService applyHomeLoanService) {
		this.applyHomeLoanService = applyHomeLoanService;
	}

	 @Autowired(required = true)
	 private ValidatorImplHomeLoan validatorImplHomeLoan;
	
	 @InitBinder
	 public void initBinder(WebDataBinder binder){
	
	 binder.setValidator(validatorImplHomeLoan);
	 }
	



	@RequestMapping("/indexinithomeloan")
	public ModelAndView listBooks() {

		ModelAndView model = new ModelAndView();
		model.addObject("applyhomeloan", new ApplyHomeLoanVo());
		model.setViewName("applyhomeloan");
		return model;
	}
	
	
	
	@RequestMapping(value = "applyhomeloan/add", method = RequestMethod.POST)
	public ModelAndView initiateHomeLoan(@Valid
			@ModelAttribute("applyhomeloan") ApplyHomeLoanVo HomeLoanvo,
			BindingResult result, Map<String, Object> map) {
		ModelAndView model = new ModelAndView();
		
		LOGGER.info(START);
        LOGGER.info("ApplyHomeLoan Controller Strated");
		
		
		if (result.hasErrors()) {

			 LOGGER.info("Apply HomeLoan has result binding error");
			
			model.setViewName("applyhomeloan");
		} else {
			try {
				LOGGER.info("ApplyHomeLoan Service called");
				StringBuffer msg = applyHomeLoanService.insertHomeLoanDetails(HomeLoanvo);
				model.addObject("msg", msg);
				model.setViewName("applyhomeloan");
			} catch (BankManagementException e) {
				LOGGER.info("Apply EducationLoan has exception");
				model.addObject("msg",e.getmsg());
				model.setViewName("applyhomeloan");
				e.printStackTrace();
				
			}
		}

		 LOGGER.info(END);
		return model;
	}
	
	@RequestMapping("viewhomeloan")
	public ModelAndView InitHomeLoanView() {
		ModelAndView model = new ModelAndView();
		model.addObject("gethomeloan", new ApplyHomeLoanVo());
		model.setViewName("homeloansearch");
		return model;
	}
	

	@ModelAttribute("applyDate")
	public String getapply_Date() {
		DateFormat df = new SimpleDateFormat("MM/dd/YYYY");
		Date dateobj = new Date();
		return df.format(dateobj);
	}

	@ModelAttribute("LoanDurationList")
	public Map<Integer, Integer> getLoan_Duration() {
		Map<Integer, Integer> LoanDurationList = new HashMap<Integer, Integer>();
		LoanDurationList.put(5, 5);
		LoanDurationList.put(10, 10);
		LoanDurationList.put(15, 15);
		LoanDurationList.put(20, 20);
		
		return LoanDurationList;
	}

}
