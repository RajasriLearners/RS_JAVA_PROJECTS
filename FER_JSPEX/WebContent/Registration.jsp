<html>

<head>
	<script type="text/javascript">
		function validateForm() {
			var form = document.RegistrationForm; // document.forms[0];
			
			var errorMessages = "";
			if(form.firstName.value == '') {
				errorMessages = "Please enter First Name<br>";
			}
			if(form.lastName.value == '') {
				errorMessages += "Please enter Last Name<br>";
			}
			if(form.email.value == '') {
				errorMessages += "Please enter E-Mail<br>";
			}
			if(form.userName.value == '') {
				errorMessages += "Please enter Username<br>";
			}
			if(form.password.value == '') {
				errorMessages += "Please enter Password<br>";
			}
			if(form.mobile.value == '') {
				errorMessages += "Please enter Mobile<br>";
			}
			
			var errorTrId = document.getElementById('errorTrId');
			var errorTdId = document.getElementById('errorTdId');
			
			if(errorMessages != '') {
				//alert(errorMessages);
				errorTdId.innerHTML = errorMessages;
				errorTrId.style.display = '';
			} else {
				errorTrId.style.display = 'none';
				form.submit();
			}
		}
	</script>
</head>

<body>
	<form action="RegistrationPost.jsp" method="post" name="RegistrationForm">
		<table border="2" align="center">
			<tr>
				<td colspan="2" align="center">Registration</td>
			</tr>
			
			<tr id="errorTrId" style='display:none'>
				<td colspan="2" id="errorTdId"></td>
			</tr>
			
			<tr>
				<td>FirstName<font color="red">*</font></td>
				<td><input type="text" name="firstName"></td>
			</tr>
			
			<tr>
				<td>MiddleName</td>
				<td><input type="text" name="middleName<"></td>
			</tr>
			
			<tr>
				<td>LastName<font color="red">*</font></td>
				<td><input type="text" name="lastName"></td>
			</tr>
			
			<tr>
				<td>E-Mail<font color="red">*</font></td>
				<td><input type="text" name="email"></td>
			</tr>
			
			<tr>
				<td>Username<font color="red">*</font></td>
				<td><input type="text" name="userName"></td>
			</tr>
			
			<tr>
				<td>Password<font color="red">*</font></td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>Mobile<font color="red">*</font></td>
				<td><input type="text" name="mobile"></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="Registration" onclick="validateForm();">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>