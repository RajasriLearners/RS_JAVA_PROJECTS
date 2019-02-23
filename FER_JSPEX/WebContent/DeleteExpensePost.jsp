<%@page import="com.rs.fer.bean.Expense"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<% FERService ferService = new FERServiceImpl();
session=request.getSession();
Expense expense = new Expense();
int expenseId=Integer.parseInt(request.getParameter("expenseId"));
	boolean deleteExpenseFlag=ferService.deleteExpense(expenseId);
	%>
	<jsp:include page="layout/Header.jsp" />
<%=deleteExpenseFlag?"Expense deleted successfully":"Failed to deleted expense" %>
<jsp:include page="layout/Footer.jsp" />
	