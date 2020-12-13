<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Inventario</title>
</head>
<body>
login Inventario
<form action="<%=request.getContextPath()%>/Invlogin" method="post">
<h4>Usuario</h4>
<input type="text" name="usuario"><br>
<h4>Pass</h4>
<input type="password" name="pass"><br><br>
<input type="submit" value="Entrar!">
</form>
</body>
</html>