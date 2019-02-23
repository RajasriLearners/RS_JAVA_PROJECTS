<%@page import="com.rs.fer.bean.Expense"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<jsp:include page="layout/Header.jsp" />
<%FERServiceImpl ferService = new FERServiceImpl();
Expense expense = ferService.getExpense(Integer.parseInt(request.getParameter("expenseId")));
session.setAttribute("expense", expense);
%>
<table border="1" align="center">
<tr>
	<td colspan="2" align="center">Edit Expense</td>
</tr>
<tr>
	<td>Expense Type</td>
	<td><input type="text" name="expenseType"
		value="<%=expense.getExpenseType()%>"></td>
</tr>
<tr>
	<td>Date</td>
	<td><input type="text" name="date"
		value="<%=expense.getDate()%>"></td>
</tr>
<tr>
	<td>Price</td>
	<td><input type="text" name="price"
		value="<%=expense.getPrice()%>"></td>
</tr>
<tr>
	<td>Number of items</td>
	<td><input type="text" name="numberOfItems"
		value="<%=expense.getNumberOfItems()%>"></td>
</tr>
<tr>
	<td>Total</td>
	<td><input type="text" name="total"
		value="<%=expense.getTotal()%>"></td>
</tr>
<tr>
	<td>By whom</td>
	<td><input type="text" name="byWhom"
		value="<%=expense.getByWhom()%>"></td>
</tr>
<tr>
	<td colspan='2' align='center'><input type='button'
		value='Edit Expense' onclick="submitForm('EditExpensePost.jsp')"></td>

</tr>
</table>
<jsp:include page="layout/Footer.jsp" />


 