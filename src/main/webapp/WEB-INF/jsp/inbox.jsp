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

	<div class="container">

		<div class="container" style="margin: 0px;">
			<div class="container col-sm-12 bg-primary" style="padding: 10px;">
				<h4>
					<b>Primary Inbox</b>
				</h4>
			</div>
		</div>

		<div class="container">
			<table class="table table-hover" style="margin-top: 50px;">
				<tr class="info">
					<td>
						<div class="container">
							<div class="conatiner col-sm-3" id="mailSubject"
								style="overflow: hidden;">
								<b>From</b>
							</div>
							<div class="container-fluid" id="mailSubject">
								<p>
									<b>Subject</b>
								</p>
							</div>
						</div>
					</td>
				</tr>

				<c:forEach var="email" items="${inboxList}">
					<tr>
						<td>
							<div class="container">
								<div class="col-sm-3" id="mailSubject" style="overflow: hidden;">
									<b>${email.fromEmail}</b>
								</div>
								<div class="container-fluid" id="mailSubject">
									<p>
										<b>${email.subject}</b> -${email.content}
									</p>
								</div>
								<div>
									${email.sentDate}
									${email.attachments}
								</div>
							</div>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</div>
</body>
</html>