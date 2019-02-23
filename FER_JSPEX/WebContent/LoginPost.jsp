
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<%
	FERService ferService = new FERServiceImpl();

	int userId = ferService.login(request.getParameter("userName"), request.getParameter("password"));

	String forwardpath = "";
	if (userId > 0) {
		session.setAttribute("userName", request.getParameter("userName"));
		session.setAttribute("userId", userId);
%>
		<jsp:include page="layout/Header.jsp" />
		Welcome to the user: ${userName}
		<jsp:include page="layout/Footer.jsp" />
<%	} else {
		out.println("login failed.....pleasecheck");
		forwardpath = "Login.jsp";
%>
		<jsp:include page="<%=forwardpath%>"/>
<%	
	}
%>