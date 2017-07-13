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

import com.cts.service.ViewHomeLoanService;
import com.cts.validator.ViewHomeLoanValidator;
import com.cts.vo.ApplyHomeLoanVo;

@RestController
public class ViewHomeLoancontroller {
	
	private static final Logger LOGGER = Logger
			.getLogger(ViewHomeLoancontroller.class);
	private static final String START = "start";
	private static final String END = "end";

	@Autowired(required = true)
	private ViewHomeLoanService viewHomeLoanService;

	public void setViewHomeLoanService(ViewHomeLoanService viewHomeLoanService) {
		this.viewHomeLoanService = viewHomeLoanService;
	}

	@Autowired(required = true)
	private ViewHomeLoanValidator viewHomeLoanValidator;

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		binder.setValidator(viewHomeLoanValidator);
	}

	@RequestMapping(value = "viewhomeloandetails", method = RequestMethod.GET, headers = "Accept=application/json")
	public ModelAndView searchHomeLoanDetails(
			
			@FormParam("homeLoanId") String homeLoanId,
			@FormParam("homeLoanAccountNumber") String homeLoanAccountNumber,
			@Valid @ModelAttribute("gethomeloan") ApplyHomeLoanVo applyHomeLoanVo,
			BindingResult result, Map<String, Object> map) {
		ModelAndView model = new ModelAndView();
System.out.println("aaa");
		if (result.hasErrors()) {
			LOGGER.info("Get HomeLoan has form binding error!!");
			model.setViewName("homeloansearch");

		} else {
			try {
				LOGGER.info(START);
				LOGGER.info("HomeLoan Search Controller Intantiated!");
				List<ApplyHomeLoanVo> retrieveHomeLoanDetails = viewHomeLoanService.retrieveHomeLoanDetails(applyHomeLoanVo.getHomeLoanId(),
								applyHomeLoanVo.getHomeLoanAccountNumber());
				if (!(retrieveHomeLoanDetails.isEmpty())) {
					model.addObject("homeloanList", retrieveHomeLoanDetails);
					model.setViewName("homeloandetailsview");
				} else {
					model.addObject("msg", "No Records Found!");
					model.setViewName("homeloansearch");
				}
			} catch (Exception e) {
				LOGGER.info("View HomeLoan service  method throws exception!");
				e.printStackTrace();
			} 
			 finally {
					LOGGER.info(END);
				}
		}
		return model;
	}

}