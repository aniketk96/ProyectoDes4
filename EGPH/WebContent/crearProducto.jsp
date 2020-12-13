<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear Producto</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/crearPro" method="post">
<h5>Nombre del Producto:</h5>
<input type="text" name="nombre"><br>
<h5>Precio:</h5>
<input type="text" name="precio"><br>
<h5>Cantidad:</h5>
<input type="text" name="cantidad"><br><br>
<input type="submit"  value="Registrar!">
</form>
</body>
</html>