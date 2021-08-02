<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inbox</title>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link href="<c:url value="/css/inboxStyle.css" />" rel="stylesheet"></link>
<link href="<c:url value="/css/style.css" />" rel="stylesheet"></link>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" />
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	  $("#hideOverlay").click(function(){
	    $(".overlay").hide();
	  });
	  $("#showOverlay").click(function(){
	    $(".overlay").show();
	  });
	});
</script>	
	
</head>
<body>
	
	<!--NAVBAR STARTS HERE -->
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
	<!--NAVBAR ENDS HERE -->

	<div class="container">
		<div class="row">
			<!-- BEGIN INBOX -->
			<div class="col-md-12">
				<div class="grid email">
					<div class="grid-body">
						<div class="row">
							<!-- BEGIN INBOX MENU -->
							<div class="col-md-3">
								<h2 class="grid-title">
									<i class="fa fa-inbox"></i> Inbox
								</h2>
								<a class="btn btn-block btn-primary" id = "showOverlay"><i class="fa fa-pencil"></i>&nbsp;&nbsp;NEW
									MESSAGE</a>

								<hr>

								<div>
									<ul class="nav nav-pills nav-stacked">
										<li class="header">Folders</li>
										<li class="active"><a href="showEmails"><i
												class="fa fa-inbox"></i> Inbox (${inboxList.size() }) </a></li>
										<li><a href="<c:url value='/showStarred'/>"><i
												class="fa fa-star"></i> Starred</a></li>
										<li><a href="#"><i class="fa fa-bookmark"></i>
												Important</a></li>
										<li><a href="#"><i class="fa fa-mail-forward"></i>
												Sent</a></li>
										<li><a href="#"><i class="fa fa-pencil-square-o"></i>
												Drafts</a></li>
										<li><a href="#"><i class="fa fa-folder"></i> Spam
												(217)</a></li>
									</ul>
								</div>
							</div>
							<!-- END INBOX MENU -->

							<!-- BEGIN INBOX CONTENT -->
							<div class="col-md-9">
								<div class="row">
									<div class="col-sm-6">
										<label style="margin-right: 8px;" class=""> <!-- 									<div class="icheckbox_square-blue" style="position: relative;"><input type="checkbox" id="check-all" class="icheck" style="position: absolute; top: -20%; left: -20%; display: block; width: 140%; height: 140%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"><ins class="iCheck-helper" style="position: absolute; top: -20%; left: -20%; display: block; width: 140%; height: 140%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins></div> -->
										</label>
									</div>

									<div class="col-md-6 search-form">
										<form action="searchEmail" class="text-right" method="get">
											<div class="input-group">
												<input type="text" class="form-control input-sm"
													placeholder="Search" name="searchString"> <span
													class="input-group-btn">
													<button type="submit" name="search"
														class="btn_ btn-primary btn-sm search">
														<i class="fa fa-search"></i>
													</button>
												</span>
											</div>
										</form>
									</div>
								</div>

								<div class="table table-responsive">
									<table class="table table-hover">
										<thead>
											<tr>
												<th style="width: 2%;"></th>
												<th style="width: 20%;"></th>
												<th style="width: 50%;"></th>
												<th style="width: 10%;"></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="email" items="${inboxList}">
												<tr>
													<c:if test="${email.starred.equals('true')}">
														<td class="action"><i class="fa fa-star"></i></td>
													</c:if>
													<c:if test="${email.starred.equals('false')}">
														<td class="action"><i class="fa fa-star-o"></i></td>
													</c:if>
													<td class="name"><a href="#">${ email.fromEmail }</a></td>
													<td class="subject" style="word-break: break-all;"><a
														href="<c:url value='/readEmail/${email.emailUUID}'/>">${ email.subject}</a></td>
													<td class="time">${ email.sentDate }</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>

								<ul class="pagination">
									<li class="disabled"><a href="#">«</a></li>
									<li class="active"><a href="#">1</a></li>
									<li><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<li><a href="#">4</a></li>
									<li><a href="#">5</a></li>
									<li><a href="#">»</a></li>
								</ul>
							</div>
							<!-- END INBOX CONTENT -->

						</div>
					</div>
				</div>
			</div>
			<!-- END INBOX -->
		</div>
	</div>
	<!-- Start Compose Email -->
	<div class="overlay" style="display:none;">
		<div class="container" style="background-color: white; padding: 15px">
			<div class="row bg-primary" style="margin: 0; margin-bottom: 30px;">
				<div class="container col-sm-12 flex">
					<div>
						<h4>
							<b>Compose Mail</b>
						</h4>
					</div>
					<div class = "push" id = "hideOverlay" style="cursor: pointer;">
						<i class="fa fa-times" style="object-align: right;"></i>
					</div>
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

					<label for="files" class="btn btn-success" style="margin: 0 20px;">
						Attach Files </label> <input type="file"
						class="form-control-file col-sm-3" id="files" name="files"
						multiple="multiple" value="Atach"
						style="opacity: 0; position: absolute; z-index: -1;" />
				</div>
				<div class="form-group">
					<label for="encrypted">Encrypt :</label> <input type="checkbox"
						name="encrypted" id="encrypted">
				</div>
			</form>
		</div>
	</div>
</body>
</html>