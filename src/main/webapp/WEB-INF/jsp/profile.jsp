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
				<li><a href="showInbox">Inbox</a></li>
				<li><a href="showMailer">Send Mail</a></li>
				<li><a href="showLogs">Show Logs</a></li>
				<li class="active"><a href="showProfile">Profile</a></li>
				<c:if test="${ isAdmin }">
					<li><a href="viewUser">ViewUsers</a></li>
				</c:if>
				<li><a href="signout">Sign Out</a></li>
			</ul>
		</div>
	</nav>
	
	
	<div class="container">
		<div class="row">
			<div class="col-sm-2">
				<b>Name</b>
			</div>
			<div class="col-sm-10">${userModel.getFirstName()}
				${userModel.getLastName()}</div>
		</div>

		<div class="row">
			<div class="col-sm-2">
				<b>Phone Number</b>
			</div>
			<div class="col-sm-10">${userModel.getPhoneNumber()}</div>
		</div>

		<div class="row">
			<div class="col-sm-2">
				<b>Gender</b>
			</div>
			<div class="col-sm-10">${userModel.getGender()}</div>
		</div>

		<div class="row">
			<div class="col-sm-2">
				<b>Email</b>
			</div>
			<div class="col-sm-10">${credModel.getUserEmail()}</div>
		</div>

		<div class="row">
			<div class="col-sm-2">
				<b>isAdmin</b>
			</div>
			<div class="col-sm-10">${isAdmin}</div>
		</div>
	</div>


</body>
</html>