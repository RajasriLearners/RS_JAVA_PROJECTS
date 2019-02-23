<%@page import="com.rs.fer.bean.User"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<jsp:include page="layout/Header.jsp" />
<%
FERService ferService = new FERServiceImpl();
User user=new User();
String currentPassword = request.getParameter("currentPassword");
String newPassword = request.getParameter("newPassword");
String confirmPassword = request.getParameter("confirmNewPassword");
if (confirmPassword.equals(newPassword)) {
boolean resetPasswordFlag = ferService.resetPassword(Integer.parseInt(session.getAttribute("userId").toString()), currentPassword, newPassword);
%>
<%=resetPasswordFlag ? "Password Reset done successfully" : "Reset password failure" %>
<%
}
%>
<jsp:include page="layout/Footer.jsp" />