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
			<spring:message code="label.performTransaction" />
		</h1>
		<form:form commandName="transaction" action="transaction/add"
			modelAttribute="transaction" method="POST">
			<table>
				<tr>
					<td><spring:message code="label.accountNumber" /></td>
					<td><form:input path="accountNumber" readonly="false"
							disabled="false" /></td>
					<td><form:errors path="accountNumber" cssClass="error"></form:errors>
					</td>
				</tr>
				<tr>
					<td><spring:message code="label.transactionType" /></td>
					<td><form:select path="transactionType">
							<form:option value="----" label="----" />
							<form:options items="${transactionList}" />
						</form:select></td>
					<td><form:errors path="transactionType" cssClass="error"></form:errors>
					</td>

				</tr>
				<tr>
					<td><spring:message code="label.Description" /></td>
					<td><form:textarea path="Description" rows="2" cols="14" /></td>
					<td><form:errors path="Description" cssClass="error" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.transactionAmount" /></td>
					<td><form:input path="transactionAmount" readonly="false"
							disabled="false" /></td>
					<td><form:errors path="transactionAmount" cssClass="error"></form:errors>
					</td>

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