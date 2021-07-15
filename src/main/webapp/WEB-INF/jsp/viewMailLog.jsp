<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logs - Mailer Application</title>
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
				<li class="active"><a href="showLogs">Show Logs</a></li>
				<li><a href="showProfile">Profile</a></li>
				<c:if test="${ isAdmin }">
					<li><a href="viewUser">ViewUsers</a></li>
				</c:if>
				<li><a href="signout">Sign Out</a></li>
			</ul>
		</div>
	</nav>


	<div class="container">
		<h1>Email Logs</h1>
		<p>Check all the mails you sent here!</p>

		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Id#</th>
					<th scope="col">From</th>
					<th scope="col">To</th>
					<th scope="col">Subject</th>
					<th scope="col">Send Time</th>
					<th scope="col">Status</th>
					<th scope="col">Show</th>
					<th scope="col">Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="maillog" items="${mailLogList}">
					<tr>
						<td scope="row">${ maillog.id }</td>
						<td>${ maillog.email }</td>
						<td>${ maillog.toEmail }</td>
						<td>${ maillog.subject }</td>
						<td>${ maillog.sendTime }</td>
						<td>${ maillog.status }</td>
						<td><a href="<c:url value='/edit/${maillog.id}'/>">Show</a></td>
						<td><a href="<c:url value='/deleteLog/${maillog.id}'/>" onclick="return confirm('Are you sure you want to delete?')">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>