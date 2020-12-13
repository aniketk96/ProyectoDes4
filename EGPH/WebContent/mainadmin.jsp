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
</body>
</html>
<%}else{response.sendRedirect(request.getContextPath()+"/login.jsp");
}%>