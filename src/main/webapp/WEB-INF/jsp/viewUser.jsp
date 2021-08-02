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
<link href="<c:url value="/css/style.css" />" rel="stylesheet"></link>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

	<nav class="navbar navbar-default">
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
		<div class="row bg-primary" style="margin: 10px 0;">
			<div class="container" style="margin: 10px 10px;">
				<h4>
					<b>View Users</b>
				</h4>
			</div>
		</div>
		<table class="table" style="margin-top: 10px;">
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
					<th scope="row">Remove</th>
					<th scope="row">Change Role</th>
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
					
					<c:if test="${user.role.equals('user')}">
						<td>User</td>
					</c:if>
					<c:if test="${user.role.equals('admin')}">
						<td class="success">Admin</td>
					</c:if>
					
					<td><a href="<c:url value='/delete/${user.id}'/>"
						onclick="return confirm('Are you sure you want to delete?')">Remove</a></td>
					
					<c:if test="${user.role.equals('user')}">
					<td class ="gray"><a href="<c:url value='/makeAdmin/${user.id}'/>"
						onclick="return confirm('Are you sure you want to change role?')">Make Admin</a></td>
					</c:if>
					<c:if test="${user.role.equals('admin')}">
					<td><a href="<c:url value='/makeUser/${user.id}'/>"
						onclick="return confirm('Are you sure you want to change role?')">Make user</a></td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
		<br /> ${message}
	</div>
</body>
</html>