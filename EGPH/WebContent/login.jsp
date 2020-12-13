<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/Alogin" method="post">
<h3>Usuario</h3>
<input type="text" name="usuario"><br>
<h3>Contraseña</h3>
<input type="password" name="pass"><br>
<br>
<br>
<input type="submit" value="Ingresar!">
</form>
</body>
</html>