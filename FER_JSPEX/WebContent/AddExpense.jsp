<jsp:include page="layout/Header.jsp" />
		
<table border="2" align="center">
	<tr>
		<td colspan="2" align="center">Add Expense</td>
	</tr>

	<tr>
		<td>ExpenseType</td>
		<td><input type="text" name="expenseType"></td>
	</tr>

	<tr>
		<td>Date</td>
		<td><input type="text" name="date"></td>
	</tr>

	<tr>
		<td>Price</td>
		<td><input type="text" name="price"></td>
	</tr>

	<tr>
		<td>NumberOfItems</td>
		<td><input type="text" name="numberOfItems"></td>
	</tr>

	<tr>
		<td>Total</td>
		<td><input type="text" name="total"></td>
	</tr>

	<tr>
		<td>ByWhom</td>
		<td><input type="text" name="byWhom"></td>
	</tr>

	<tr>
		<td colspan="2" align="center"><input type="button" value="save"
			onclick="javascript: submitForm('AddExpensePost.jsp');" ></td>
	</tr>
</table>

<jsp:include page="layout/Footer.jsp" />
