<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%String name=(String)session.getAttribute("cname");
if(name!=null){%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar Factura</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/modificarFactura" method="post">
<input type="hidden" name="id_cajera" value="<%=session.getAttribute("cid")%>">
<input type="hidden" name="nombre_cajera" value="<%=session.getAttribute("cname")%>">
<h5>Codigo de la Factura</h5>
<input type="text" name="id">
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
<%}else{response.sendRedirect(request.getContextPath()+"/loginCajera.jsp");
}%>