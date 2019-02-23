<%@page import="com.rs.fer.bean.User"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<%
	FERService ferService = new FERServiceImpl();

	User user = new User();
	user.setFirstName(request.getParameter("firstName"));
	user.setMiddleName(request.getParameter("middleName"));
	user.setLastName(request.getParameter("lastName"));
	user.setEmail(request.getParameter("e-Mail"));
	user.setUserName(request.getParameter("userName"));
	user.setPassword(request.getParameter("password"));
	user.setMobile(Integer.parseInt(request.getParameter("mobile")));
    boolean RegistrationFlag = ferService.registration(user);
	
	String forwardpath = "";
	if (RegistrationFlag) {
		out.println("registration is done successfully...!");
		forwardpath = "Login.jsp";
	} else {
		out.println("registraion failed...please check");
		forwardpath = "Registration.jsp";

	}
	
%>
<jsp:include page="<%=forwardpath %>" />

