<%@page import="com.rs.fer.bean.PersonalInfo"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>

<%FERServiceImpl ferService = new FERServiceImpl();
session=request.getSession();
	PersonalInfo personalInfo=ferService.getPersonalInfo(Integer.parseInt(session.getAttribute("userId").toString()));
	boolean isUpdated=ferService.updatePersonalInfo(personalInfo.getUser(),personalInfo.getAddress());
	%>
<jsp:include page="layout/Header.jsp" />
<%=isUpdated?"Updated successfully":"Updated failed" %>
<jsp:include page="layout/Footer.jsp" />