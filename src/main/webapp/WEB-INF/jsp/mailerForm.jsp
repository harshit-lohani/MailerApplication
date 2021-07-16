<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Mail - Mailer Application</title>
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
				<li class="active"><a href="showMailer">Send Mail</a></li>
				<li><a href="showLogs">Show Logs</a></li>
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
		<form action="mailProcessWithAttachment" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label for="toEmail">Recipient's Email :</label> <input type="email"
					class="form-control" id="toEmail" placeholder="Enter Email"
					name="toEmail">
			</div>

			<div class="form-group">
				<label for="ccEmail">CC :</label> <input type="email"
					class="form-control" id="ccEmail" placeholder="Enter Email"
					name="ccEmail">
			</div>

			<div class="form-group">
				<label for="bccEmail">bcc :</label> <input type="email"
					class="form-control" id="bccEmail" placeholder="Enter Email"
					name="bccEmail">
			</div>

			<div class="form-group">
				<label for="subject">Subject :</label> <input type="text"
					class="form-control" id="subject" placeholder="Enter Subject"
					name="subject">
			</div>
			<div class="form-group">
				<label for="body">Body :</label>
				<textarea class="form-control form-control" rows="10" id="body"
					placeholder="Enter Body" name="body"></textarea>
			</div>
			<div class="form-group">
				<label for="attach">Add File :</label> <input type="file"
					class="form-control" id="file" name="file">
			</div>

			<input type='submit' class="btn btn-default">

		</form>

		<br>

		<h3>${ message }</h3>
	</div>
</body>
</html>