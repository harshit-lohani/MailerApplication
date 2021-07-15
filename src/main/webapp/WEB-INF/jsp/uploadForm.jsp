<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <form action="uploadFile" method="post" enctype="multipart/form-data">
    <table>
      <tr>
        <td>
          <label>Select a file to upload:</label>
          <input type="file" name="file">
        </td>
      </tr>
      <tr>
        <td><input type="submit" value="Upload File"></td>
      </tr>
    </table>
  </form>
</body>
</html>