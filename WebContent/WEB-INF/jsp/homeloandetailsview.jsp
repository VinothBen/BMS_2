<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Loan Details</title>
</head>
<body>
	<form action="index.jsp">
		<div align="right">
			<button>
				<spring:message code="label.home" />
			</button>
		</div>
	</form>
	<div align="center">
		<h1 style="color: blue;">
			<spring:message code="label.homeLoanDetails" />
		</h1>
		<table border="1">
			<tr>
				<th width="150"><spring:message code="label.loanaccountNumber" /></th>
				<th width="100"><spring:message code="label.accountHolderName" /></th>
				<th width="150"><spring:message code="label.LoanId" /></th>
				<th width="100"><spring:message code="label.Loan_Amount" /></th>
				<th width="100"><spring:message code="label.Designation" /></th>
				<th width="100"><spring:message code="label.Company_Name" /></th>
			</tr>
			<c:forEach items="${homeloanList}" var="list">
				<tr>
					<td>${list.getHomeLoanAccountNumber()}</td>
					<td>${list.getAccountHolderName()}</td>
					<td>${list.getHomeLoanId()}</td>
					<td>${list.getLoanAmount()}</td>
					<td>${list.getDesignation()}</td>
					<td>${list.getCompanyName()}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</body>
</html>