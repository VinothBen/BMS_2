<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get EducationLoan Details</title>
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
			<spring:message code="label.edusearchheading" />
		</h1>
		<form:form commandName="geteducationloan" action="vieweduloan"
			modelAttribute="geteducationloan" method="GET">
			<table>
				<tr>
					<td><spring:message code="label.loanaccountNumber" /></td>
					<td><form:input path="eduLoanAccountNumber" readonly="false"
							disabled="false" /></td>
					<td><form:errors path="eduLoanAccountNumber" cssClass="error"></form:errors>
					</td>
				</tr>
				<tr>
					<td><spring:message code="label.LoanId" /></td>
					<td><form:input path="educationLoanId" readonly="false"
							disabled="false" /></td>
					<td><form:errors path="educationLoanId" cssClass="error"></form:errors>
					</td>
				</tr>

				<tr>
					<td colspan="1"><input type="submit"
						value="<spring:message code="label.search"/>" /></td>
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
