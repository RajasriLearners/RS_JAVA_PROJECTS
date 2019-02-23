<html>
<head>
<script>
	function submitForm(userAction) {
		var form = document.DashboardForm;
		form.action = userAction;
		form.submit();
	}
</script>
</head>
<body>
	<form name="DashboardForm" action="" method="post">
		<table border="2" align="center" width="700px" height="500px">
			<tr height="50px">
				<td colspan="2" align="center">Family Expense Report User: ${userName}
				</td>
</tr>

<tr>
	<td width="150px"><a
		href="javascript: submitForm('AddExpense.jsp')">Add Expense</a><br>
		
		<a href="javascript: submitForm('EditExpenseDropdown.jsp')">Edit Expense</a><br>
	
		 <a href="javascript: submitForm('DeleteExpense.jsp')">Delete Expense</a><br> <a
		href="javascript: submitForm('ExpenseReport.jsp')"> Expense Report</a><br> <a
		href="javascript: submitForm('ResetPassword.jsp')">Reset Password</a><br> <a
		href="javascript:submitForm('UpdateNameInfo.jsp')">Update Personal</a><br></td>

	<td>