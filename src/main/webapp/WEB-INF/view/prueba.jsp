<%@ page import="es.grupo2.proyectospring.entity.Usuario" %><%--
  Created by IntelliJ IDEA.
  User: anton
  Date: 10/06/2022
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Usuario user = (Usuario) request.getAttribute("user");
%>

<h1><%=user.getNombre() %></h1>
</body>
</html>
