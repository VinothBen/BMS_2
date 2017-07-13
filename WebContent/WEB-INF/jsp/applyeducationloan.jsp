<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ApplyEducationLoan</title>
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
			<spring:message code="label.applyeduloanheading" />
		</h1>
		<form:form commandName="applyeducationloan"
			action="applyeducationloan/add" modelAttribute="applyeducationloan"
			method="POST">
			<table>

				<tr>
					<td><spring:message code="label.accountNumber" /></td>
					<td><form:input path="accountNumber" /></td>
					<td><form:errors path="accountNumber" cssClass="error"></form:errors>
					</td>
				</tr>

				<tr>
					<td><spring:message code="label.eduLoanAmount" /></td>
					<td><form:input path="eduLoanAmount" /></td>
					<td><form:errors path="eduLoanAmount" cssClass="error"></form:errors>
					</td>
				</tr>

				<tr>
					<td><spring:message code="label.eduLoanApplyDate" /></td>
					<td><form:input path="eduLoanApplyDate" readonly="true"
							disabled="false" pattern="MM/dd/YYYY" value="${applyDate}" /></td>
					<td><form:errors path="eduLoanApplyDate" cssClass="error"></form:errors>
					</td>
				</tr>

				<tr>
					<td><spring:message code="label.eduLoanDuration" /></td>
					<td><form:select path="eduLoanDuration">
							<form:option value="0" label="0" />
							<form:options items="${applyedulist}" />
						</form:select></td>
					<td><form:errors path="eduLoanDuration" cssClass="error"></form:errors>
					</td>
				</tr>

				<tr>
					<td><spring:message code="label.fatherAnnualIncome" /></td>
					<td><form:input path="fatherAnnualIncome" /></td>
					<td><form:errors path="fatherAnnualIncome" cssClass="error"></form:errors>
					</td>
				</tr>


				<tr>
					<td><spring:message code="label.fatherName" /></td>
					<td><form:input path="fatherName" /></td>
					<td><form:errors path="fatherName" cssClass="error"></form:errors>
					</td>
				</tr>


				<tr>
					<td><spring:message code="label.courseFee" /></td>
					<td><form:input path="courseFee" /></td>
					<td><form:errors path="courseFee" cssClass="error"></form:errors>
					</td>
				</tr>

				<tr>
					<td><spring:message code="label.coursename" /></td>
					<td><form:input path="courseName" /></td>
					<td><form:errors path="courseName" cssClass="error"></form:errors>
					</td>
				</tr>

				<tr>
					<td><spring:message code="label.idCardNumber" /></td>
					<td><form:input path="idCardNumber" /></td>
					<td><form:errors path="idCardNumber" cssClass="error"></form:errors>
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