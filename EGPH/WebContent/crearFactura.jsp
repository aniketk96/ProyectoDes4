<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear Factura</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/crearFactura" method="post">
<input type="hidden" name="id_cajera" value="<%=session.getAttribute("cid")%>">
<input type="hidden" name="nombre_cajera" value="<%=session.getAttribute("cname")%>">
<h5>Nombre del Cliente</h5>
<Input type="text" name="cliente"><br>
<h5>Codigo de Producto</h5>
<input type="text" name="cod"><br>
<h5>Nombre del Producto</h5>
<input type="text" name="producto"><br>
<h5>Cantidad</h5>
<input type="text" name="cantidad"><br>
<h5>Precio</h5>
<input type="text" name="precio"><br>
<br><br>
<input type="submit" value="Crear">
</form>
</body>
</html>