package com.cts.controller;

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
import com.cts.service.PerformTransactionService;
import com.cts.service.ViewTransactionService;
import com.cts.validator.ValidatorImpl;
import com.cts.vo.TransactionVo;

@Controller
public class PerformTransactionController {

	private static final Logger LOGGER = Logger.getLogger(PerformTransactionController.class);
	private static final String START ="start";
	private static final String END = "end";
	
	@Autowired(required = true)
	private PerformTransactionService performTransactionService;
	
	@Autowired(required = true)
    private ViewTransactionService viewTransactionService;
	
	public void setViewTransactionService(
			ViewTransactionService viewTransactionService) {
		this.viewTransactionService = viewTransactionService;
	}

	public void setTransactionService(PerformTransactionService performTransactionService) {
		this.performTransactionService = performTransactionService;
	}

	@Autowired(required = true)
	private ValidatorImpl validatorImpl;

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		binder.setValidator(validatorImpl);
	}

	@RequestMapping(value = "/transaction/add", method = RequestMethod.POST)
	public ModelAndView initiateTransaction(
			@Valid @ModelAttribute("transaction") TransactionVo transactionvo,
			BindingResult result, Map<String, Object> map) {

		ModelAndView model = new ModelAndView();
        LOGGER.info(START);
        LOGGER.info("Transaction Controller Strated");
		
        
        if (result.hasErrors()) {
               LOGGER.info("Apply Transaction has result binding error");
			model.setViewName("transaction");
		} else {

			try {
				LOGGER.info("TransactionService called");
				String balance = performTransactionService
						.updateTransactionDetails(transactionvo);
				model.addObject("msg","Your Balance:"+balance);
				model.setViewName("transaction");
			} catch (BankManagementException e) {
				LOGGER.info("Apply Transaction has exception");
				model.addObject("msg", e.getmsg());
				model.setViewName("transaction");
			}
		}
      LOGGER.info(END);
		return model;
	}

	@RequestMapping("/indexinit")
	public ModelAndView initView() {

		ModelAndView model = new ModelAndView();
		model.addObject("transaction", new TransactionVo());
		model.setViewName("transaction");
		return model;
	}
	@RequestMapping("/home")
	public ModelAndView initHome() {

		ModelAndView model = new ModelAndView();
		model.setViewName("home");
		return model;
	}
	@RequestMapping("/viewtransaction")
	public ModelAndView InitTransactionView() {
		ModelAndView model = new ModelAndView();
		model.addObject("transactionsearch", new TransactionVo());
		model.setViewName("transactionsearch");
		return model;
	}
	
	@ModelAttribute("transactionList")
	public Map<String, String> getTransactionList() {
		Map<String, String> transactionList = new HashMap<String, String>();
		transactionList.put("Deposit", "Deposit");
		transactionList.put("WithDrawal", "WithDrawal");
		return transactionList;
	}

}
