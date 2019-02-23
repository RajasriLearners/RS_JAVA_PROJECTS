<%@page import="com.rs.fer.bean.PersonalInfo"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<jsp:include page="layout/Header.jsp" />
<%FERServiceImpl ferService = new FERServiceImpl();
session=request.getSession();
	PersonalInfo personalInfo=ferService.getPersonalInfo(Integer.parseInt(session.getAttribute("userId").toString()));
	personalInfo.getAddress().setAddressLine1(request.getParameter("addressLine1"));
	personalInfo.getAddress().setAddressLine2(request.getParameter("addressLine2"));
	personalInfo.getAddress().setStreet(request.getParameter("street"));
	personalInfo.getAddress().setCity(request.getParameter("city"));
	personalInfo.getAddress().setState(request.getParameter("state"));
	personalInfo.getAddress().setZip(Integer.parseInt(request.getParameter("zip")));
	%>
	<table border="1" align="center">
	<tr>
		<td colspan="2" align="center">Review</td>
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
		<td>Mobile Number</td>
		<td><input type="text" name="mobileNumber"
			value="<%=personalInfo.getUser().getMobile()%>"></td>
	</tr>
	<tr>
		<td>Email</td>
		<td><input type="text" name="email"
			value="<%=personalInfo.getUser().getEmail()%>"></td>
	</tr>
	<tr>
		<td>Address Line1</td>
		<td><input type="text" name="addressLine1"
			value="<%=personalInfo.getAddress().getAddressLine1()%>"></td>
	</tr>
	<tr>
		<td>Address Line2</td>
		<td><input type="text" name="addressLine2"
			value="<%=personalInfo.getAddress().getAddressLine2()%>"></td>
	</tr>
	<tr>
		<td>Street</td>
		<td><input type="text" name="street"
			value="<%=personalInfo.getAddress().getStreet()%>"></td>
	</tr>
	<tr>
		<td>City</td>
		<td><input type="text" name="city"
			value="<%=personalInfo.getAddress().getCity()%>"></td>
	</tr>
	<tr>
		<td>State</td>
		<td><input type="text" name="state"
			value="<%=personalInfo.getAddress().getState()%>"></td>
	</tr>
	<tr>
		<td>Zip</td>
		<td><input type="text" name="zip"
			value="<%=personalInfo.getAddress().getZip()%>"></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="button" value="Next"
			onclick="submitForm('UpdateInfo.jsp')"></td>
	</tr>
</table>

<jsp:include page="layout/Footer.jsp" />
	 