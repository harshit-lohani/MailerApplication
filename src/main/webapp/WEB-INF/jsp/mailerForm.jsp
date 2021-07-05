<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mailer Service</title>
<link href="<c:url value="/css/style.css" />" rel="stylesheet"></link>
</head>
<body>
	<div>
		<div>
			<h1 style ="padding: 20px">Welcome to Mailer Service</h1>
		</div>
		<form action = "mailProcess" method="post">
			<table>
				<tr>
					<td>Recipient's Email :</td>
					<td> <input type = "text" name = "toEmail"> </td>
				</tr>
				<tr>
					<td>Subject : </td>
					<td> <input type = "text" name = "subject"> </td>
				</tr>
				<tr>
					<td>Body : </td>
					<td> <textarea name = "body"> </textarea> </td>
				</tr>
			</table>
			<input type='submit'>
		</form>

		<br>
		
		<h3>${ message }</h3>
	
	</div>
</body>
</html>