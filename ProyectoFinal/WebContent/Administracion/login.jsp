<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/loginProcess"  method="post">
<input type="text" name="usuario"/><br>
<input type="password" name="pass"/><br>
<input type="submit" value="Entrar!"/>
</form>
</body>
</html>