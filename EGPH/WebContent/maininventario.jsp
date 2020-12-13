<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%String name=(String)session.getAttribute("iname");
if(name!=null){%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
hola <%=session.getAttribute("iname") %>
<form action="<%=request.getContextPath()%>/crearProducto.jsp">
<input type="submit" value="Crar Producto!">
</form>
<form action="<%=request.getContextPath()%>/getProductos">
<input type="submit" value="Ver Producto">
</form>
<form action="<%=request.getContextPath()%>/addProductos.jsp">
<input type="submit" value="Agragar Cantidades">
</form>
</body>
</html>
<%}else{response.sendRedirect(request.getContextPath()+"/loginInventario.jsp");
}%>