<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar Inventario</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/registrarI" method="post">
<h4>Usuario</h4>
<input type="text" name="usuario"><br>
<h4>Pass</h4>
<input type="text" name="pass"><br>
<br>
<input type="submit" value="Registrar">
</form>
</body>
</html>