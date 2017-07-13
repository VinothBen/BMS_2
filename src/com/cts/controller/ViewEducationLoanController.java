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

import com.cts.service.ViewEducationLoanService;
import com.cts.validator.ViewEducationLoanvalidator;
import com.cts.vo.ApplyEducationLoanVo;

@RestController
public class ViewEducationLoanController {
	
	private static final Logger LOGGER = Logger
			.getLogger(ViewEducationLoanController.class);
	private static final String START = "start";
	private static final String END = "end";
	
	
	@Autowired(required = true)
	private ViewEducationLoanService viewEducationLoanService;

	public void setViewEducationLoanService(ViewEducationLoanService viewEducationLoanService) {
		this.viewEducationLoanService = viewEducationLoanService;
	}

	
	@Autowired(required = true)
	private ViewEducationLoanvalidator viewEducationLoanValidator;

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		binder.setValidator(viewEducationLoanValidator);
	}
	
	@RequestMapping(value = "vieweduloan", method = RequestMethod.GET, headers = "Accept=application/json")
	public ModelAndView searchEducationLoanDetails(
			@FormParam("educationLoanId") String educationLoanId,
			@FormParam("eduLoanAccountNumber") String eduLoanAccountNumber,
			@Valid @ModelAttribute("geteducationloan") ApplyEducationLoanVo applyEducationLoanVo,
			BindingResult result, Map<String, Object> map) {
		ModelAndView model = new ModelAndView();

		if (result.hasErrors()) {
			LOGGER.info("Get EducationLoan has form binding error!!");
			model.setViewName("educationloansearch");

		} else {
			try {
				LOGGER.info(START);
				LOGGER.info("EducationLoan Search Controller Intantiated!");
				List<ApplyEducationLoanVo> getEducationLoanViewList = viewEducationLoanService.retrieveEducationLoanDetails(applyEducationLoanVo.getEducationLoanId(),
								applyEducationLoanVo.getEduLoanAccountNumber());
				if (!(getEducationLoanViewList.isEmpty())) {
					model.addObject("educationloanList", getEducationLoanViewList);
					model.setViewName("educationloandetailsview");
				} else {
					model.addObject("msg", "No Records Found!");
					model.setViewName("educationloansearch");
				}
			} catch (Exception e) {
				LOGGER.info("View Education Loan service  method throws exception!");
				e.printStackTrace();
			} 
			 finally {
					LOGGER.info(END);
				}
		}
		return model;
	}

}

