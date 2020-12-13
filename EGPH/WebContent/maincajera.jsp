<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenido</title>
</head>
<body>
holaa <%=session.getAttribute("cname") %>
<br>
<br>
<form action="<%=request.getContextPath()%>/crearFactura.jsp">
<input type="submit" value="Crear Factura!">
</form>

</body>
</html>