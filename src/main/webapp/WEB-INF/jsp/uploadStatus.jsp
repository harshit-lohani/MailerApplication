<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
  <tr>
    <td>Upload status: ${message}</td>
  </tr>
  <tr>
    <td>File Name: ${file.getOriginalFilename()}</td>
  </tr>
  <tr>
    <td>File Size: ${file.getSize()}</td>
  </tr>
  <tr>
    <td>File Type: ${file.getContentType()}</td>
  </tr>
</table>
</body>
</html> 