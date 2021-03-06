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
<link href="<c:url value="/css/readEmailStyle.css" />" rel="stylesheet"></link>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" />
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
</head>
<body>
	<div class="container">
		<div class="row inbox-wrapper">
			<div class="container">
				<div class="card">
					<div class="card-body">
						<div class="row">
							<div class="col-lg-12 email-content">
								<div class="email-head">
									<div class="email-head-subject">
										<div
											class="title d-flex align-items-center justify-content-between">
											<div class="d-flex align-items-center">
												<a class="active" href="#"><span class="icon"><svg
															xmlns="http://www.w3.org/2000/svg" width="24" height="24"
															viewBox="0 0 24 24" fill="none" stroke="currentColor"
															stroke-width="2" stroke-linecap="round"
															stroke-linejoin="round"
															class="feather feather-star text-primary-muted">
															<polygon
																points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2"></polygon></svg></span></a>
												<span>${email.subject}</span>
											</div>
											<div class="icons">
												<a href="#" class="icon"><svg
														xmlns="http://www.w3.org/2000/svg" width="24" height="24"
														viewBox="0 0 24 24" fill="none" stroke="currentColor"
														stroke-width="2" stroke-linecap="round"
														stroke-linejoin="round"
														class="feather feather-share text-muted hover-primary-muted"
														data-toggle="tooltip" title=""
														data-original-title="Forward">
														<path d="M4 12v8a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2v-8"></path>
														<polyline points="16 6 12 2 8 6"></polyline>
														<line x1="12" y1="2" x2="12" y2="15"></line></svg></a> <a href="#"
													class="icon"><svg xmlns="http://www.w3.org/2000/svg"
														width="24" height="24" viewBox="0 0 24 24" fill="none"
														stroke="currentColor" stroke-width="2"
														stroke-linecap="round" stroke-linejoin="round"
														class="feather feather-printer text-muted"
														data-toggle="tooltip" title="" data-original-title="Print">
														<polyline points="6 9 6 2 18 2 18 9"></polyline>
														<path
															d="M6 18H4a2 2 0 0 1-2-2v-5a2 2 0 0 1 2-2h16a2 2 0 0 1 2 2v5a2 2 0 0 1-2 2h-2"></path>
														<rect x="6" y="14" width="12" height="8"></rect></svg></a> <a
													href="#" class="icon"><svg
														xmlns="http://www.w3.org/2000/svg" width="24" height="24"
														viewBox="0 0 24 24" fill="none" stroke="currentColor"
														stroke-width="2" stroke-linecap="round"
														stroke-linejoin="round"
														class="feather feather-trash text-muted"
														data-toggle="tooltip" title=""
														data-original-title="Delete">
														<polyline points="3 6 5 6 21 6"></polyline>
														<path
															d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"></path></svg>
												</a>
											</div>
										</div>
									</div>
									<div
										class="email-head-sender d-flex align-items-center justify-content-between flex-wrap">
										<div class="d-flex align-items-center">
											<div class="avatar">
												<img
													src="https://bootdey.com/img/Content/avatar/avatar1.png"
													alt="Avatar" class="rounded-circle user-avatar-md">
											</div>
											<div class="sender d-flex align-items-center">
												<a href="#">${email.fromEmail}</a> <span>to</span><a href="#">me</a>
												<div class="actions dropdown">
													<a class="icon" href="#" data-toggle="dropdown"><svg
															xmlns="http://www.w3.org/2000/svg" width="24" height="24"
															viewBox="0 0 24 24" fill="none" stroke="currentColor"
															stroke-width="2" stroke-linecap="round"
															stroke-linejoin="round"
															class="feather feather-chevron-down">
															<polyline points="6 9 12 15 18 9"></polyline></svg></a>
													<div class="dropdown-menu" role="menu">
														<a class="dropdown-item" href="#">Mark as read</a> <a
															class="dropdown-item" href="#">Mark as unread</a> <a
															class="dropdown-item" href="#">Spam</a>
														<div class="dropdown-divider"></div>
														<a class="dropdown-item text-danger" href="#">Delete</a>
													</div>
												</div>
											</div>
										</div>
										<div class="date">Nov 20, 11:20</div>
									</div>
								</div>
								<div class="email-body">
									<p>
										${email.content }
									</p>
								</div>
								<div class="email-attachments">
									<div class="title">
										Attachments <span>(3 files, 12,44 KB)</span>
									</div>
									<ul>
										<li><a href="#"><svg
													xmlns="http://www.w3.org/2000/svg" width="24" height="24"
													viewBox="0 0 24 24" fill="none" stroke="currentColor"
													stroke-width="2" stroke-linecap="round"
													stroke-linejoin="round" class="feather feather-file">
													<path
														d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path>
													<polyline points="13 2 13 9 20 9"></polyline></svg> Reference.zip
												<span class="text-muted tx-11">(5.10 MB)</span></a></li>
										<li><a href="#"><svg
													xmlns="http://www.w3.org/2000/svg" width="24" height="24"
													viewBox="0 0 24 24" fill="none" stroke="currentColor"
													stroke-width="2" stroke-linecap="round"
													stroke-linejoin="round" class="feather feather-file">
													<path
														d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path>
													<polyline points="13 2 13 9 20 9"></polyline></svg>
												Instructions.zip <span class="text-muted tx-11">(3.15
													MB)</span></a></li>
										<li><a href="#"><svg
													xmlns="http://www.w3.org/2000/svg" width="24" height="24"
													viewBox="0 0 24 24" fill="none" stroke="currentColor"
													stroke-width="2" stroke-linecap="round"
													stroke-linejoin="round" class="feather feather-file">
													<path
														d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path>
													<polyline points="13 2 13 9 20 9"></polyline></svg> Team-list.pdf
												<span class="text-muted tx-11">(4.5 MB)</span></a></li>
									</ul>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>



</body>
</html>