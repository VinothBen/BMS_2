package com.cts.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.ws.rs.FormParam;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cts.service.ViewTransactionService;
import com.cts.validator.ValidatorTransactionSearch;
import com.cts.vo.TransactionVo;

@RestController
public class ViewTransactionController {

	private static final Logger LOGGER = Logger
			.getLogger(ViewTransactionController.class);
	private static final String START = "start";
	private static final String END = "end";

	@Autowired(required = true)
	private ViewTransactionService viewTransactionService;

	public void setViewTransactionService(
			ViewTransactionService viewTransactionService) {
		this.viewTransactionService = viewTransactionService;
	}

	@Autowired(required = true)
	private ValidatorTransactionSearch validatorTransactionSearch;

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		binder.setValidator(validatorTransactionSearch);
	}

	@RequestMapping(value = "view", method = RequestMethod.GET, headers = "Accept=application/json")
	public ModelAndView searchUserTransaction(
			@FormParam("TransactionId") String transactionId,
			@FormParam("accountNumber") String accountNumber,
			@Valid @ModelAttribute("transactionsearch") TransactionVo transactionvo,
			BindingResult result, Map<String, Object> map) {
		
		ModelAndView model = new ModelAndView();
		if (result.hasErrors()) {
			LOGGER.info("Transaction search has form binding error!!");
			model.setViewName("transactionsearch");

		} else {
			try {
				LOGGER.info(START);
				LOGGER.info("Transaction Search Controller Intantiated!");
				List<TransactionVo> transactionViewList = viewTransactionService
						.retrieveTransactionDetails(
								transactionvo.getTransactionId(),
								transactionvo.getAccountNumber());
				if (!(transactionViewList.isEmpty())) {
					model.addObject("transactionList", transactionViewList);
					model.setViewName("transactionview");
				} else {
					model.addObject("msg", "No Data Found!");
					model.setViewName("transactionsearch");
				}
			} catch (Exception e) {
				LOGGER.info("Transaction service  method throws exception!");
				e.printStackTrace();
			} finally {
				LOGGER.info(END);
			}
		}
		return model;
	}

}
