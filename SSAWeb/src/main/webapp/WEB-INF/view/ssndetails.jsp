<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ssndetails</title>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
<script type="text/javascript">

$(document).ready( function () {
    $('#example').DataTable( {
    "pagingType": "full_numbers",
    });
} );
</script>
</head>
<body>
	<table id="example" class="display" border="1">
			<tr>
			    <th>slno</th>
			    <th>ssn</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>gender</th>
				<th>Phone no</th>     
			</tr>
		<c:forEach items="${ssnDetails}" var="Ssnmodel" varStatus="index">
			<tr>
			<td><c:out value="${index.count}"/>
			<td>${Ssnmodel.ssn}</td>
			<td>${Ssnmodel.firstName}</td>
			<td>${Ssnmodel.lastName}</td>
			<td>${Ssnmodel.gender}</td>
			<td>${Ssnmodel.phno}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>	