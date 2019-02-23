
<jsp:include page="layout/Header.jsp" />
<table border="2" align="center">
	<tr>
		<td colspan="2" align="center">ExpenseReport</td>
	</tr>

	<tr>
		<td>ExpenseType</td>
		<td><input type="text" name="expenseType"></td>
	</tr>

	<tr>
		<td>FromDate</td>
		<td><input type="text" name="fromDate"></td>
	</tr>

	<tr>
		<td>ToDate</td>
		<td><input type="text" name="toDate"></td>
	</tr>
	<td colspan="2" align="center"><input type="button"
		value="GetReport"
		onclick="javascript:submitForm('ExpenseReportPost.jsp');" /></td>
</table>
<jsp:include page="layout/Footer.jsp" />