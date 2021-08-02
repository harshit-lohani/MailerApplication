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
			<div class="col-lg-3 col-sm-4">
				<div class="card hovercard">
					<div class="cardheader"></div>
					<div class="avatar">
						<img alt=""
							src="<c:url value="/images/profile/${userModel.profilePicture}" />">
					</div>
					<div class="info">
						<div class="title">
							<a target="_blank" href="https://scripteden.com/">${ userModel.firstName }
								${userModel.lastName }</a>
						</div>
						<div class="desc">${ userModel.email }</div>
						<div class="desc">${ userModel.role }</div>
					</div>
					<div class="bottom">
						<div class="container col-sm-12">
							<form action="uploadProfile" method="post" enctype="multipart/form-data">
								<div class="col-sm-6">
									<label for="profilePicture" class="btn btn-primary col-sm-12"> Browse </label>
									<input type="file" accept="image/*" name="profilePicture" id="profilePicture" style="opacity: 0; position: absolute; z-index: -1;"/>
								</div>
								<div class="col-sm-6">
									<input type="submit" value="Upload" class="btn btn-primary" disabled/>
								</div>
							</form>
						</div>
					</div>
				</div>

			</div>
			
			<form:form method="post" action="updateProfile">
			<div class="col-lg-9 col-sm-8">
				<div class="card table-container">
					<div class="row bg-primary">
						<div class="container">
							<h4>
								<b>Profile</b>
							</h4>
						</div>
					</div>
					<div class="row white">
						<div class="col-sm-3">
							<b>Name</b>
						</div>
						<div class = "col-sm-9">
							<input type="text" class=" col-sm-4" style="margin-right: 8px;" value="${userModel.firstName}" required="required" name ="firstName">
							<input type="text" class=" col-sm-4" value="${userModel.lastName}" name="lastName">
						</div>
					</div>

					<div class="row">
						<div class="col-sm-3">
							<b>Phone Number</b>
						</div>
						<div class = "form-inline col-sm-9">
							<input type="text" class=" col-sm-6" value="${userModel.phoneNumber}" name="phoneNumber">
						</div>
					</div>

					<div class="row white">
						<div class="col-sm-3">
							<b>Gender</b>
						</div>
						<div class="col-sm-9">${userModel.getGender()}</div>
					</div>

					<div class="row">
						<div class="col-sm-3">
							<b>Email</b>
						</div>
						<div class="col-sm-9">${credModel.getUserEmail()}</div>
					</div>

					<div class="row">
						<div class="col-sm-3">
							<b>Role</b>
						</div>
						<div class="col-sm-9">${userModel.role}</div>
					</div>

					<div class="row">
						<div class="col-sm-12">
							<form>
								<input type="submit" value="Save" class="btn btn-success">
							</form>
						</div>
					</div>
				</div>
			</div>
			</form:form>
		</div>
	</div>







</body>
</html>