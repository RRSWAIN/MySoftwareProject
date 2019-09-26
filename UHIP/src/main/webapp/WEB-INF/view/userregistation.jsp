<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('form[id="myForm"]').validate({
			rules : {
				firstName : 'required',
				lastName : 'required',
				gender : 'required',
				password : 'required',
				dob : 'required',
				phno : 'required',
				photo : 'required'

			},
			messages : {
				firstName : 'Please enter your firstname',
				lastName : 'Please enter your lastname',
				gender : 'Please select gender',
				password : 'password creation is mandatory',
				dob : 'Please enter your dob',
				phno : 'Please Enter your 10 digit Phone  number',
				photo : 'please upload Your photo'
			},
			submitHandler : function(form) {
				form.submit();
			}
		});
		var availableTags = [ "Anil", "Alok", "Anup", "Biswa", "choksy",
				"Chinmaya", "Chandan", "Chand", "Chiku", "Elina", "Farhan",
				"Gajanan", "Himanshu", "Junait", "Jiten", "Lipsa", "Pravash",
				"Pradosh", "Pragyan", "Rashmi ranjan", "Soumya", "Smruti" ];
		$("#firstName").autocomplete({
			source : availableTags
		});
		var availableTags = [ "swain", "pandit", "sahoo", "malik", "chauhan",
				"kumar", "chotopadhya", "bangopadhya", "mishra", "banarjee",
				"mukharjee" ];
		$("#lastName").autocomplete({
			source : availableTags
		});

		 $("#email").blur(function() {
			var enteredEmail = $("#email").val();
			$.ajax({

				url : window.location + "validateEmail",
				data : "email=" + enteredEmail,
				success : function(result) {

					if (result == 'Duplicate') {
						$("#emailMsg").html("Email already registerd.!!");
						$("#email").focus();
						$("#register").prop("disabled", true);
					} else {
						$("#emailMsg").html("");
						$("#register").prop("disabled", false);

					}
				}

			});
		});
		
 	
 $("#datepicker").datepicker({
			changeMonth : true,
			changeYear : true,
			yearRange : "1960:" + new Date(),
			maxDate : new Date(),
			dateFormat : 'dd/mm/yy'

		});
	});
</script>
</head>
<body>
	<h1 align="center">User Account Registration</h1>
	<form:form method="post" modelAttribute="accountModel"
		action="registeruser" id="myForm">
		<table align="center">
			<tr>
				<!-- model class variable name should same as in form tag -->

				<td><form:label path="firstName">FirstName</form:label></td>

				<td><form:input path="firstName" id="firstName" /></td>
			</tr>
			<tr>

				<td><form:label path="lastName">LastName</form:label></td>

				<td><form:input path="lastName" id="lastName" /></td>

			</tr>
			<div>
			
			<tr>

				<td><form:label path="email" >Email</form:label></td>
				
				<td><form:input path="email" id="email"/></td><span id="emailMsg"></span>
                 
                  
			</tr>
			

			<tr>
			
				<td><form:label path="password">Password</form:label></td>

				<td><form:input type="password" path="password" id="password" /></td>

			</tr>


			<tr>

				<td><form:label path="dob">Date Of Birth</form:label></td>

				<td><form:input type="text" path="dob" id="datepicker" /></td>

			</tr>
			<tr>
				<td>Gender :</td>

				<td><form:radiobuttons path="gender" items="${genders}"
						id="gender"></form:radiobuttons></td>

			</tr>


			<tr>

				<td><form:label path="ssn">SSN</form:label></td>

				<td><form:input type="text" path="ssn" id="ssn" /></td>
				<td>
			</tr>
			<tr>
				<td>Role</td>
				<td><form:select path="role">
						<form:option value="selected" label="Admin" />
						<form:options items="${rolelist}" />
					</form:select></td>
			</tr>
			<tr>
				<td><form:button type="reset" id="myForm" path=" Reset"
						value="reset">Reset</form:button></td>
				<td><form:button id="register" name="register" value="submit">Create User</form:button>
				</td>
			</tr>
		</table>
	</form:form>

</body>
</html>