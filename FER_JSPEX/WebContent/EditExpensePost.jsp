<%@page import="com.rs.fer.bean.Expense"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<%
FERService ferService = new FERServiceImpl();
Expense expense=(Expense)session.getAttribute("expense");
expense.setExpenseType(request.getParameter("expenseType"));
expense.setDate(request.getParameter("date"));
expense.setPrice(Integer.parseInt(request.getParameter("price")));
expense.setNumberOfItems(Integer.parseInt(request.getParameter("numberOfItems")));
expense.setTotal(Integer.parseInt(request.getParameter("total")));
expense.setByWhom(request.getParameter("byWhom"));

boolean editExpense=ferService.editExpense(expense);
%>
<jsp:include page="layout/Header.jsp" />
<%=editExpense?"Expense edited successfully":"Failed to edit expense" %>
<jsp:include page="layout/Footer.jsp" />
