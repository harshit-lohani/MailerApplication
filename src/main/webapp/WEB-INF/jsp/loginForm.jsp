<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login to Mailer Application</title>
<title>New Mail - Mailer Application</title>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/css/style.css" />" rel="stylesheet"></link>
</head>

<body>

	<nav class="navbar navbar-default">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Mailer Application</a>
			</div>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="showIndex">Home</a></li>
				<li><a href="userForm">Register</a></li>
				<li class="active"><a href="showLogin">Login</a></li>
			</ul>
		</div>
	</nav>


	<div class="container" style="padding: 50px 0">

		<div class="container col-sm-6" id="image-container">
			<div class="container col-sm-12">
				<img src="https://i.imgur.com/LBSyfEN.png" title="source: imgur.com"
					width="100%" />
			</div>
			<h1 class="text-center">Welcome back to Mailer Service</h1>
			<h5 class="text-center">Your one stop destination for all your
				mailing needs</h5>
		</div>

		<div class="container col-sm-6" id="form-container">
			<div class="container col-sm-12" style="margin:15px 0">
				<h2>LOGIN</h2>
			</div>
			<form:form method="post" action="userLogin" style="margin-top: 50px;">
				<div class="form-group col-sm-12">
					<label for="email">Email ID :</label>
					<form:input path="userEmail" type="email" class="form-control"
						id="userEmail" placeholder="Enter Email" name="userEmail" required="true"/>
				</div>

				<div class="form-group col-sm-12">
					<label for="password">Password :</label>
					<form:input path="password" type="password" class="form-control"
						placeholder="Enter Password" required="true"/>
				</div>

				<div class="form-group col-sm-12">
					<input type="submit" value="LOGIN"
						class="btn btn-primary btn-lg col-sm-12" style="margin: 15px 0"/>
				</div>

				<div class="container col-sm-12">
					<p>
						New User? <a href="userForm" class="linkText"> Sign Up here</a>
					</p>
				</div>
			</form:form>
			${message }
		</div>
	</div>



</body>
</html>
