<%@ page import="es.grupo2.proyectospring.dto.UsuarioDTO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ruben
  Date: 16/06/2022
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nuevo analista</title>
</head>
<body>
<h1>Elige el usuario que será analista</h1>
<%
    List<UsuarioDTO> marketing = (List)request.getAttribute("listaAn");
    if (marketing == null || marketing.isEmpty() ) {
%>
<h2>No hay usuarios</h2>
<%
} else {
%>
<table border="1">
    <tr>
        <th>NOMBRE</th>
        <th>APELLIDOS</th>
        <th>DOMICILIO</th>
        <th>CIUDAD</th>
        <th>EDAD</th>
        <th>SEXO</th>
    </tr>
    <%
        for (UsuarioDTO usuario: marketing) {
    %>
    <tr>
        <td><%= usuario.getNombre()%></td>
        <td><%= usuario.getApellidos() %></td>
        <td><%= usuario.getDomicilio() %></td>
        <td><%= usuario.getCiudad() %></td>
        <td><%= usuario.getEdad() %></td>
        <td><%= usuario.getSexo() %></td>
        <td><a href="nuevoAn/<%= usuario.getId() %>">Nuevo analista</a></td>
    </tr>

    <%
        }
    %>
</table>
<%
    }
%>

</body>
</html>
