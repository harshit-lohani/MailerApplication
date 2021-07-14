<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
				<li class="active"><a href="showInbox">Inbox</a></li>
				<li><a href="showMailer">Send Mail</a></li>
				<li><a href="showLogs">Show Logs</a></li>
				<li><a href="showProfile">Profile</a></li>
				<c:if test="${ isAdmin }">
					<li><a href="viewUser">View Users</a></li>
				</c:if>
				<li><a href="signout">Sign Out</a></li>
			</ul>
		</div>
	</nav>
	
	<div class = "container">

	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="row">Email Number</th>
				<th scope="row">From</th>
				<th scope="row">Subject</th>
				<th scope="row">Content</th>
				
			</tr>
		</thead>

		<c:forEach var="email" items="${emailList}">
			<tr>
				<td>${ email.emailNumber}</td>
				<td>${ email.from }</td>
				<td>${ email.subject }</td>
				<td>${ email.content }</td>
			</tr>
		</c:forEach>
	</table>
	
	</div>
</body>
</html>