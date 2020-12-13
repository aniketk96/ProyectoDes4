<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%String name=(String)session.getAttribute("cname");
if(name!=null){%>
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
<form action="<%=request.getContextPath()%>/getFacturas">
<input type="submit" value="Ver Facturas!">
</form>
<form action="<%=request.getContextPath()%>/modificarFacturas.jsp">
<input type="submit" value="Modificar Facturas!">
</form>
<a href="<%=request.getContextPath()%>/logoutCajera.jsp">Logout</a>
</body>
</html>
<%}else{response.sendRedirect(request.getContextPath()+"/loginCajera.jsp");
}%>