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
		<div class="row bg-primary" style="margin: 0; margin-bottom: 30px;">
			<div class="container" style="margin: 10px 10px;">
				<h4>
					<b>Compose Mail</b>
				</h4>
			</div>
		</div>
		<form action="mailProcessWithAttachment" method="post"
			enctype="multipart/form-data">
			<label for="recipients">Recipients :</label>
			<div class="recipients" style="margin-bottom: 15px;">
				<div class="input-group">
					<span class="input-group-addon">TO:</span> <input type="email"
						class="form-control" id="toEmail" name="toEmail">
				</div>

				<div class="input-group">
					<span class="input-group-addon">CC:</span> <input type="email"
						class="form-control" id="ccEmail" name="ccEmail">
				</div>

				<div class="input-group">
					<span class="input-group-addon">BCC</span> <input type="email"
						class="form-control" id="bccEmail" name="bccEmail">
				</div>
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

				<input type='submit' class="btn btn-primary col-sm-1" value="SEND">

				<label for="files" class="btn btn-success" style="margin: 0 20px;"> Attach Files </label> <input
					type="file" class="form-control-file col-sm-3" id="files"
					name="files" multiple="multiple" value="Atach"
					style="opacity: 0; position: absolute; z-index: -1;" />
			</div>
			<div class="form-group">
				<label for="encrypted">Encrypt :</label>
				<input type="checkbox" name="encrypted" id="encrypted">
			</div>
		</form>
		<br>
		<c:if test="${not empty mailStatus}">
			<c:if test="${mailStatus}">
				<script>
					alert("Mail Sent!");
				</script>
			</c:if>
			<c:if test="${!mailStatus}">
				<script>
					alert("Mail not sent!");
				</script>
			</c:if>
		</c:if>
	</div>
</body>
</html>