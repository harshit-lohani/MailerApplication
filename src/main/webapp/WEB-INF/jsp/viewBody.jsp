<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Mail</title>
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
		<h1>Compose your Mail</h1>
		<form>
			<div class="form-group">
				<label for="toEmail">Recipient's Email :</label> <input type="email"
					class="form-control" id="toEmail" name="toEmail"
					value="${mailLog.toEmail}" disabled>
			</div>

			<div class="form-group">
				<label for="ccEmail">CC :</label> <input type="email"
					class="form-control" id="ccEmail" placeholder="Null" name="ccEmail"
					disabled>
			</div>

			<div class="form-group">
				s <label for="bccEmail">BCC :</label> <input type="email"
					class="form-control" id="bccEmail" placeholder="Null"
					name="bccEmail" disabled>
			</div>

			<div class="form-group">
				<label for="subject">Subject :</label> <input type="text"
					class="form-control" id="subject" placeholder="No Subject"
					value="${ mailLog.subject }" name="subject" disabled>
			</div>
			<div class="form-group">
				<label for="body">Body :</label>
				<textarea class="form-control form-control" rows="10" id="body"
					placeholder="No Body" name="body" disabled>${ mailLog.body }</textarea>
			</div>

			<a href="<c:url value='/showLogs'/>" class="btn btn-default">Close</a>
		</form>

		<br>
	</div>
</body>
</html>