<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.rs.fer.bean.Expense"%>

<%
	session = request.getSession();
%>
<jsp:include page="layout/Header.jsp" />
<%
	FERServiceImpl ferService = new FERServiceImpl();
	Expense expense = new Expense();

	ArrayList<Expense> expenses = (ArrayList<Expense>) ferService
			.getExpenses(Integer.parseInt(session.getAttribute("userId").toString()));
%>
ExpenseId:
<select name="expenseId">
	<%
		if (expenses != null && !expenses.isEmpty()) {
			Iterator<Expense> iterator = expenses.iterator();
			while (iterator.hasNext()) {
				expense = iterator.next();
				String option = "" + expense.getExpenseId();
	%>
	<option value=<%=expense.getExpenseId()%>> <%=expense.getExpenseType()%> <%=expense.getDate()%>  <%=expense.getPrice()%> <%=expense.getTotal()%><%=expense.getByWhom()%>
		<%
			}

			} else {
				out.println("No expenses were found...");
			}
		%>
	
</select>
<br>
<input type="button" value="Delete Expense"
	onclick="submitForm('DeleteExpensePost.jsp')">
<jsp:include page="layout/Footer.jsp" />



