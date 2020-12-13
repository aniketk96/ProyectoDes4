<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%String name=(String)session.getAttribute("uname");
if(name!=null){%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar Cajera</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/registrarC" method="post">
<h4>Usuario</h4>
<input type="text" name="usuario"><br>
<h4>Pass</h4>
<input type="text" name="pass"><br>
<br>
<input type="submit" value="Registrar">
</form>
</body>
</html>
<%}else{response.sendRedirect(request.getContextPath()+"/login.jsp");
}%>