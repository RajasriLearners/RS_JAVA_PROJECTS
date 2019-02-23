<%@page import="com.rs.fer.bean.PersonalInfo"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<jsp:include page="layout/Header.jsp" />
<%FERServiceImpl ferService = new FERServiceImpl();
session=request.getSession();
	PersonalInfo personalInfo=ferService.getPersonalInfo(Integer.parseInt(session.getAttribute("userId").toString()));
	personalInfo.getUser().setMobile(Integer.parseInt(request.getParameter("mobile")));
	personalInfo.getUser().setEmail(request.getParameter("email"));
	%>
	<table border="1" align="center">
	<tr>
		<td colspan="2" align="center">Address Info</td>
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
			onclick="submitForm('UpdateReviewInfo.jsp')"></td>
	</tr>
</table>
<jsp:include page="layout/Footer.jsp" />
	