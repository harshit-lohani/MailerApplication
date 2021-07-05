<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>


<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
	<h1>User List</h1>	

	<table width="70%" border="2" cellpadding="2">
		<tr>
			<th>Id</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>gender</th>
			<th>phone number</th>
			<th>email</th>
			<th>password</th>
		</tr>

		<c:forEach var="user" items="${list}">
			<tr>
				<td>${ user.id }</td>
				<td>${ user.getFirstName() }</td>
				<td>${ user.getLastName() }</td>
				<td>${ user.getGender() }</td>
				<td>${ user.getPhoneNumber() }</td>
				<td>${ user.getEmail() }</td>
				<td>${ user.getPassword() }</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="userForm">Add New User</a>
</body>
</html>