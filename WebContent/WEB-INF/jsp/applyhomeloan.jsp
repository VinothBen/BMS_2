<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ApplyHomeLoan</title>
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
			<spring:message code="label.applyhomeloanheading" />
		</h1>
		<form:form commandName="applyhomeloan" action="applyhomeloan/add"
			modelAttribute="applyhomeloan" method="POST">
			<table>
				<tr>
					<td><spring:message code="label.accountNumber" /></td>
					<td><form:input path="accountNumber" readonly="false"
							disabled="false" /></td>
					<td><form:errors path="accountNumber" cssClass="error"></form:errors>
					</td>
				</tr>
				<tr>
					<td><spring:message code="label.Loan_Amount" /></td>
					<td><form:input path="loanAmount" readonly="false"
							disabled="false" /></td>
					<td><form:errors path="loanAmount" cssClass="error"></form:errors>
					</td>
				</tr>
				<tr>
					<td><spring:message code="label.Loan_Apply_Date" /></td>
					<td><form:input path="loanApplyDate" readonly="true"
							disabled="false" pattern="MM/dd/YYYY" value="${applyDate}" /></td>

					<td><form:errors path="loanApplyDate" cssClass="error"></form:errors>
					</td>
				</tr>
				<tr>
					<td><spring:message code="label.Loan_Duration" /></td>
					<td><form:select path="loanDuration">
							<form:option value="0" label="0" />
							<form:options items="${LoanDurationList}" />
						</form:select></td>
					<td><form:errors path="loanDuration" cssClass="error"></form:errors>
					</td>

				</tr>

				<tr>
					<td><spring:message code="label.Annual_Income" /></td>
					<td><form:input path="annualIncome" readonly="false"
							disabled="false" /></td>
					<td><form:errors path="annualIncome" cssClass="error"></form:errors>
					</td>

				</tr>
				<tr>
					<td><spring:message code="label.Company_Name" /></td>
					<td><form:input path="companyName" readonly="false"
							disabled="false" /></td>
					<td><form:errors path="companyName" cssClass="error"></form:errors>
					</td>

				</tr>
				<tr>
					<td><spring:message code="label.Designation" /></td>
					<td><form:input path="designation" readonly="false"
							disabled="false" /></td>
					<td><form:errors path="designation" cssClass="error"></form:errors>
					</td>

				</tr>
				<tr>
					<td><spring:message code="label.Total_Experience" /></td>
					<td><form:input path="totalExperience" readonly="false"
							disabled="false" /></td>
					<td><form:errors path="totalExperience" cssClass="error"></form:errors>
					</td>

				</tr>
				<tr>
					<td><spring:message code="label.Experience_Current_company" /></td>
					<td><form:input path="experienceCurrentcompany"
							readonly="false" disabled="false" /></td>
					<td><form:errors path="experienceCurrentcompany"
							cssClass="error"></form:errors></td>

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