<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
				<li class="active"><a href="showIndex">Home</a></li>
				<li><a href="userForm">Register</a></li>
				<li><a href="showLogin">Login</a></li>
			</ul>
		</div>
	</nav>

	<div>
		<div class="container">
			<div class="container col-sm-4" style="padding-top: 100px;">
				<h1 style="margin: 25px 0;">Mailer Application</h1>

				<p style="margin: 25px 0;">Login or Register to proceed to the
					Mailer Application. The application is made with Spring Web MVC and
					JdbcTemplate. The UI is made with bootstrap</p>
				<a class="btn btn-primary btn-lg" href="userForm"
					style="margin: 15px 0;">Get Started</a>
			</div>

			<div class="container col-sm-6 col-md-offset-2" style="padding: 15px 0;">
				<a href="https://imgur.com/HbKfMeI"><img
					src="https://i.imgur.com/HbKfMeI.png" title="source: imgur.com"
					width="100%" /></a>
			</div>

		</div>
	</div>
</body>
</html>