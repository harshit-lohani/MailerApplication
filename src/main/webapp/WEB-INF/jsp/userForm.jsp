<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register - Mailer Service</title>
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
				<li><a href="showIndex">Home</a></li>
				<li class="active"><a href="userForm">Register</a></li>
				<li><a href="showLogin">Login</a></li>
			</ul>
		</div>
	</nav>


	<div class="container" style="margin-top: 50px">

		<div class="container col-sm-6">
			<div class="container col-sm-12" style="margin: 30px auto">
				<img src="https://i.imgur.com/hXt7igB.png" title="source: imgur.com"
					width="100%" />
			</div>
			<h1 class="text-center">Welcome to the Mailer service</h1>
			<h5 class="text-center">Your one stop destination for all your
				mailing needs</h5>
		</div>

		<div class="container col-sm-6">
			<form:form method="post" action="save">
				<div class="container col-sm-12" style="margin: 15px 0">
					<h2>SIGN UP</h2>
				</div>

				<div class="form-group col-sm-6">
					<label class="control-label" for="firstName">FirstName :</label>
					<div class="">
						<form:input path="firstName" class="form-control"
							placeholder="First Name" required="true"/>
					</div>
				</div>

				<div class="form-group col-sm-6">
					<label class="control-label" for="lastName">LastName :</label>
					<form:input path="lastName" class="form-control"
						placeholder="Last Name" />
				</div>

				<div class="form-group col-sm-6">
					<label class="control-label" for="gender">Gender</label>
					<form:select path="gender" class="form-control">
						<form:option value="male" label="Male" />
						<form:option value="female" label="Female" />
					</form:select>
				</div>

				<div class="form-group col-sm-6">
					<label class="control-label" for="phoneNumber">Phone Number</label>
					<form:input path="phoneNumber" class="form-control"
						placeholder="Phone Number" />
				</div>

				<div class="form-group col-sm-12">
					<label class="control-label" for="email">Email</label>
					<form:input path="email" class="form-control" type="email"
						placeholder="Email" required="true"/>
				</div>
				<div class="form-group col-sm-12">
					<label class="control-label" for="password">Password</label>
					<form:input path="password" class="form-control" type="password"
						placeholder="Password" required="true"/>
				</div>
				<div class="form-group col-sm-12">
					<input type="submit" value="REGISTER"
						class="btn btn-primary btn-lg col-sm-12 margin-lg" />
				</div>
				<div class="container col-sm-12">
					<p>
						Already a user? <a href="showLogin" class="linkText"> Login
							here</a>
					</p>
				</div>
			</form:form>
		</div>
	</div>

</body>
</html>