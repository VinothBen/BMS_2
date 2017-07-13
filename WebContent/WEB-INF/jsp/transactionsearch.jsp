<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
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
			<spring:message code="label.viewTransaction" />
		</h1>
		<form:form commandName="transactionsearch" action="view"
			modelAttribute="transactionsearch" method="GET">
			<table>
				<tr>
					<td><spring:message code="label.accountNumber" /></td>
					<td><form:input path="accountNumber" readonly="false"
							disabled="false" /></td>
					<td><form:errors path="accountNumber" cssClass="error"></form:errors>
					</td>
				</tr>

				<tr>
					<td><spring:message code="lable.transactionId" /></td>
					<td><form:input path="TransactionId" readonly="false"
							disabled="false" /></td>
					<td><form:errors path="TransactionId" cssClass="error" /></td>
				</tr>

				<tr>
					<td colspan="1"><input type="submit"
						value="<spring:message code="label.perform"/>" /></td>
				</tr>

			</table>
		</form:form>
		<table>
			<tr>
				<td><font color="red">${msg}</font></td>
			</tr>
		</table>
	</div>
</body>
</html>