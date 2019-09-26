<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SSN Registration</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>jQuery UI Datepicker - Default functionality</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!-- <link rel="stylesheet" href="/resources/demos/style.css"> -->

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
				dob : 'required',
				phno : 'required',
				photo : 'required'

			},
			messages : {
				firstName : 'Please enter your firstname',
				lastName : 'Please enter your lastname',
				gender : 'Please select gender',
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
			"kumar", "chotopadhya", "bangopadhya", "mishra", "banrjee", "mukharjee"];
	$("#lastName").autocomplete({
		source : availableTags
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
<script type="text/javascript">
document.getElementById("myForm").reset();
</script>
</head>
<body background="images/default.jpg">
	<h1 align="center">SSN ENROLLMENT</h1>
	<h2 align="center" style="color: red">${msg}</h2>
	<h3 style="text-align: center;">${successmessage}</h3>
	<form:form method="post" modelAttribute="ssnModel" action="enroll"
		enctype="multipart/form-data" id="myForm">
		<table align="center">
			<tr>
				<!-- model class variable name should same as in form tag -->

				<td><form:label path="firstName" for="firstName">FirstName</form:label></td>

				<td><form:input path="firstName" name="firstName"
						id="firstName" /></td>
			</tr>
			<tr>

				<td><form:label path="lastName">LastName</form:label></td>

				<td><form:input path="lastName" name="lastName" id="lastName" /></td>

			</tr>
			<tr>
				<td>Gender :</td>

				<td><form:radiobuttons path="gender" items="${genders}"
						id="gender"></form:radiobuttons></td>

			</tr>


			<tr>

				<td><form:label path="dob">Date Of Birth</form:label></td>

				<td><form:input type="text" path="dob" id="datepicker" /></td>

			</tr>
			<tr>

				<td><form:label path="phno">Phone no</form:label></td>

				<td><form:input type="text" path="phno" maxlength="10"
						id="phno" /></td>
				<td>
			</tr>
			<tr>
				<td>State</td>
				<td><form:select path="state">
						<form:option value="NONE" label="---Select---"/>
						<form:options items="${statelist}"/>
					</form:select></td>
			</tr>
			<tr>	

				<td><form:label path="photo">Photo</form:label></td>

				<td><form:input type="file" path="photo" id="photo" /></td>

			</tr>
			<tr></tr>
			<tr>
				<td></td>
				<td><form:button id="enroll" name="enroll" value="submit">Enroll</form:button>
				
		<form:button type="reset" id="myForm" path=" Reset" value="reset">Reset</form:button></td></tr>
		</table>
	</form:form>
	<p style="text-align:center;"><a href="/ssndetailsdispaly" style="">CLICK HERE TO GET SSN DETAILS</a></p>
</body>
</html>