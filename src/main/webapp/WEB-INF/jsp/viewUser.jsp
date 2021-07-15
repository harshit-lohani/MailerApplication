<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>


<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Users</title>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Mailer Application</a>
			</div>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="showHomepage">Home</a></li>
				<li><a href="showInbox">Inbox</a></li>
				<li><a href="showMailer">Send Mail</a></li>
				<li><a href="showLogs">Show Logs</a></li>
				<li><a href="showProfile">Profile</a></li>
				<c:if test="${ isAdmin }">
					<li class="active"><a href="viewUser">ViewUsers</a></li>
				</c:if>
				<li><a href="signout">Sign Out</a></li>
			</ul>
		</div>
	</nav>


	<div class="container">
		<h1>View Users</h1>
		<p>Show all users that are available!</p>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="row">Id</th>
					<th scope="row">FirstName</th>
					<th scope="row">LastName</th>
					<th scope="row">Gender</th>
					<th scope="row">Phone number</th>
					<th scope="row">Email</th>
					<th scope="row">Password</th>
					<th scope="row">Role</th>
					<th scope="row">Remove<br></th>
				</tr>
			</thead>

			<c:forEach var="user" items="${list}">
				<tr>
					<td>${ user.id }</td>
					<td>${ user.getFirstName() }</td>
					<td>${ user.getLastName() }</td>
					<td>${ user.getGender() }</td>
					<td>${ user.getPhoneNumber() }</td>
					<td>${ user.getEmail() }</td>
					<td>${ user.getPassword() }</td>
					<td>${ user.getRole() }</td>
					<td><a href="<c:url value='/delete/${user.id}'/>" onclick="return confirm('Are you sure you want to delete?')">Remove</a></td>
				</tr>
			</c:forEach>
		</table>
		<br />
		
		${message}
	</div>
</body>
</html>