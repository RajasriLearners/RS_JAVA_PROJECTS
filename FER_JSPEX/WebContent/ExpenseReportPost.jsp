<%@page import="com.rs.fer.bean.Expense"%>
<%@page import="java.util.List"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<%FERService ferService = new FERServiceImpl();
session  = request.getSession();
String expenseType=request.getParameter("expenseType");
String fromDate=request.getParameter("fromDate");
String toDate=request.getParameter("toDate");
List<Expense> expenses=ferService.getExpenseReport(expenseType, fromDate, toDate, Integer.parseInt(session.getAttribute("userId").toString()));
%>
<jsp:include page="layout/Header.jsp" />
<%
if(expenses!=null){
%>
<table border='1' align='center'>

	<tr>
		<td>ExpenseType</td>
		<td>Date</td>
		<td>Price</td>
		<td>No of items</td>
		<td>Total</td>
		<td>By whom</td>
		<td>Action</td>
	</tr>
	<%
		for (Expense expense : expenses) {
	%>
	<tr>
		<td><%=expense.getExpenseType()%></td>
		<td><%=expense.getDate()%></td>
		<td><%=expense.getPrice()%></td>
		<td><%=expense.getNumberOfItems()%></td>
		<td><%=expense.getTotal()%></td>
		<td><%=expense.getByWhom()%></td>
		<td><input type="button" value="Edit"
			onclick="javascript: submitForm('EditExpenseDropdown.jsp');"></td>
		<td><input type="button" value="Delete"
			onclick="javascript: submitForm('DeleteExpense.jsp');"></td>
	</tr>
	<%
		}
%>
</table>
<%
}else {
	out.println("No expense found");
}
%>
