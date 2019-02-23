<jsp:include page="layout/Header.jsp" />
<table border="2" align="center">
	<tr>
		<td colspan="2" align="center">ResetPassword</td>
	</tr>

	<tr>
		<td>CurrentPassword</td>
		<td><input type="text" name="currentPassword"></td>
	</tr>

	<tr>
		<td>NewPassword</td>
		<td><input type="text" name="newPassword"></td>
	</tr>

	<tr>
		<td>ConfirmNewPassword</td>
		<td><input type="text" name="confirmNewPassword"></td>
	</tr>
	<tr>
	<td colspan="2" align="center"><input type="button"
		value="ResetPassword"
		onclick="javascript:submitForm('ResetPasswordPost.jsp');" /></td>
</table>
<jsp:include page="layout/Footer.jsp" />