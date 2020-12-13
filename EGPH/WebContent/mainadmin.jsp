<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%String name=(String)session.getAttribute("uname");
if(name!=null){%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
hola <%=name %>
<br>
<form action="<%=request.getContextPath() %>/registrarCajera.jsp">
<input type="submit" value="Registrar Cajera">
</form>
<form action="<%=request.getContextPath() %>/registrarInventario.jsp">
<input type="submit" value="Registrar Inventario">
</form>
<form action="<%=request.getContextPath()%>/crearFactura.jsp">
<input type="submit" value="Crear Factura!">
</form>
<form action="<%=request.getContextPath()%>/getFacturas">
<input type="submit" value="Ver Facturas!">
</form>
<form action="<%=request.getContextPath()%>/modificarFacturas.jsp">
<input type="submit" value="Modificar Facturas!">
</form>
<form action="<%=request.getContextPath()%>/crearProducto.jsp">
<input type="submit" value="Crar Producto!">
</form>
<form action="<%=request.getContextPath()%>/getProductos">
<input type="submit" value="Ver Producto">
</form>
<form action="<%=request.getContextPath()%>/addProductos.jsp">
<input type="submit" value="Agragar Cantidades">
</form>
<a href="<%=request.getContextPath()%>/logoutAdmin.jsp">Logout</a>
</body>
</html>
<%}else{response.sendRedirect(request.getContextPath()+"/login.jsp");
}%>