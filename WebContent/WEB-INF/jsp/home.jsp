<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="label.appName"/></title>
</head>
<body>
	<div align="center">
		<h1><spring:message code="label.appName"/></h1>
		
		<a href="indexinit"><h3><spring:message code="label.performTransaction"/></h3></a> 
		
		<a href="viewtransaction"><h3><spring:message code="label.viewTransaction"/></h3></a>
		
		 <a href="indexinithomeloan"><h3><spring:message code="label.applyHomeLoan"/></h3></a>
		 
		 <a href="viewhomeloan"><h3><spring:message code="label.viewHomeLoandetails"/></h3></a>
		 
		 <a href="indexinieduloan"><h3><spring:message code="label.applyEducationLoan"/></h3></a>
		 
		 <a href="vieweducationloan"><h3><spring:message code="label.viewEducationLoandetails"/></h3></a>
		  
	</div>
</body>
</html>