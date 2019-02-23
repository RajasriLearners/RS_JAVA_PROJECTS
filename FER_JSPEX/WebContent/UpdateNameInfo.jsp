<%@page import="com.rs.fer.bean.PersonalInfo"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<jsp:include page="layout/Header.jsp" />
<%FERServiceImpl ferService = new FERServiceImpl();
session=request.getSession();
	PersonalInfo personalInfo=ferService.getPersonalInfo(Integer.parseInt(session.getAttribute("userId").toString()));
	session.setAttribute("personalInfo", personalInfo);
	%>
	<table border="1" align="center">
	<tr>
		<td colspan="2" align="center">Name Info</td>
	</tr>
	<tr>
		<td>First Name</td>
		<td><input type="text" name="firstName" value="<%= personalInfo.getUser().getFirstName()%>"></td>
	</tr>
	<tr>
		<td>Last Name</td>
		<td><input type="text" name="lastName" value="<%= personalInfo.getUser().getLastName()%>"></td>
	</tr>
	<tr>
		<td>Middle Name</td>
		<td><input type="text" name="middleName" value="<%= personalInfo.getUser().getMiddleName()%>"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<input type="button" value="Next" onclick="submitForm('UpdateContactInfo.jsp')">
		</td>
	</tr>
</table>

<jsp:include page="layout/Footer.jsp" />
		