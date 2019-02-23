<%@page import="com.rs.fer.bean.PersonalInfo"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<jsp:include page="layout/Header.jsp" />

<%FERService ferService = new FERServiceImpl();
session=request.getSession();
	PersonalInfo personalInfo=ferService.getPersonalInfo(Integer.parseInt(session.getAttribute("userId").toString()));
	
	personalInfo.getUser().setFirstName(request.getParameter("firstName"));
	personalInfo.getUser().setFirstName(request.getParameter("lastName"));
	personalInfo.getUser().setFirstName(request.getParameter("middleName"));
	%>
	<table border="1" align="center">
	<tr>
		<td colspan="2" align="center">Contact Info</td>
	</tr>
	<tr>
		<td>Mobile Number</td>
		<td><input type="text" name="mobile"
			value="<%=personalInfo.getUser().getMobile()%>"></td>
	</tr>
	<tr>
		<td>Email</td>
		<td><input type="text" name="email"
			value="<%=personalInfo.getUser().getEmail()%>"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<input type="button" value="Next" onclick="submitForm('UpdateAddressInfo.jsp')">
		</td>
	</tr>
</table>
<jsp:include page="layout/Footer.jsp" />