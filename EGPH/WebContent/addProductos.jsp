<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%String name=(String)session.getAttribute("iname");
if(name!=null){%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agregar Cantidades</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/actualizarCantidad" method="post">
<h5>Codigo de producto:</h5>
<input type="text" name="cod"><br>
<h5>Cantidades;</h5>
<input type="text" name="cantidad"><br>
<input type="submit" value="Actualizar">
</form>
</body>
</html>
<%}else{response.sendRedirect(request.getContextPath()+"/loginInventario.jsp");
}%>