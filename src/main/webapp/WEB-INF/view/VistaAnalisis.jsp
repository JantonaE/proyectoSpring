<%@ page import="es.grupo2.proyectospring.entity.Usuario" %>
<%@ page import="java.util.List" %>
<%@ page import="es.grupo2.proyectospring.dto.AnalistaDTO" %>
<%@ page import="es.grupo2.proyectospring.dto.AnalisisDTO" %><%--
  Created by IntelliJ IDEA.
  User: anton
  Date: 10/06/2022
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Listado de análisis</title>
</head>
<body>
<h1>Listado de análisis</h1>
<%
    List<AnalisisDTO> analisis = (List<AnalisisDTO>) request.getAttribute("analisis");
    AnalistaDTO analista = (AnalistaDTO)request.getAttribute("analista");
    if(analisis.isEmpty()){
%>

<br>
<h2>No hay analisis creados</h2>

<%
}else{
%>
<table border="1">
    <tr>
        <th>NOMBRE</th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    <%
        for (int i = 0; i<analisis.size(); i++){
    %>
    <tr>
        <td><%= analisis.get(i).getNombre() %></td>
        <td><a href="/analista/<%=analista.getUsuarioId()%>/ver/<%=analisis.get(i).getId()%>">Ver/Editar</a></td>
        <td><a href="/analista/<%=analista.getUsuarioId()%>/copiar/<%=analisis.get(i).getId()%>">Copiar</a></td>
        <td><a href="/analista/<%=analista.getUsuarioId()%>/borrar/<%=analisis.get(i).getId()%>">Borrar</a></td>
    </tr>
    <%
        }
    %>

</table>

<%
    }
%>

<br>
<a href="/analista/<%=analista.getUsuarioId()%>/nuevo">Nuevo análisis</a>

</body>
</html>
