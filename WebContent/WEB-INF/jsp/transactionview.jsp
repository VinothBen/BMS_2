<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
			<spring:message code="label.transactions" />
		</h1>
		<table border="1">
			<tr>
				<th width="150"><spring:message code="label.accountNumber" /></th>
				<th width="150"><spring:message code="lable.transactionId" /></th>
				<th width="100"><spring:message code="label.transactionType" /></th>
				<th width="100"><spring:message code="label.Description" /></th>
				<th width="100"><spring:message code="label.transactionAmount" /></th>
			</tr>
			<c:forEach items="${transactionList}" var="list">
				<tr>
					<td>${list.getAccountNumber()}</td>
					<td>${list.getTransactionId()}</td>
					<td>${list.getTransactionType()}</td>
					<td>${list.getDescription()}</td>
					<td>${list.getBalance()}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</body>
</html>