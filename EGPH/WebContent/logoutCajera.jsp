<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String name=(String)session.getAttribute("cname");
if(name!=null){
	session.invalidate();
	response.sendRedirect(request.getContextPath()+"/loginCajera.jsp");
}

%>