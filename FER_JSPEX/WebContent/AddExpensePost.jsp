<%@page import="com.rs.fer.bean.Expense"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<%
FERServiceImpl ferService = new FERServiceImpl();
Expense expense = new Expense();

//expense.setExpenseId(Integer.parseInt(request.getParameter("expenseId")));
expense.setExpenseType(request.getParameter("expenseType"));
expense.setDate(request.getParameter("date"));
expense.setPrice(Integer.parseInt(request.getParameter("price")));
expense.setNumberOfItems(Integer.parseInt(request.getParameter("numberOfItems")));
expense.setTotal(Integer.parseInt(request.getParameter("total")));
expense.setByWhom(request.getParameter("byWhom"));

expense.setUserId(Integer.parseInt(session.getAttribute("userId").toString()));

boolean expenseFlag = ferService.addExpense(expense); 
%>
<jsp:include page="layout/Header.jsp" />
		<%=expenseFlag ? "expense added succesfully...." : "added expense failure" %>
		<jsp:include page="layout/Footer.jsp" />
