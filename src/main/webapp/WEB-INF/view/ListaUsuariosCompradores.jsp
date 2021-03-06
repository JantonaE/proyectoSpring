<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="es.grupo2.proyectospring.dto.ListaDTO" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Jesús Antona Espejo
  Date: 11/06/2022
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Listas de Usuarios Compradores</title>
</head>
<body>
<h1>Listas de Usuarios Compradores</h1>
<table border="1">
    <tr>
        <td>ID LISTA</td>
        <td>DESCRIPCIÓN</td>
        <td>ID MARKETING</td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
            <%
            int idUsuario = (int) request.getAttribute("idUsuario");
            List<ListaDTO> lista = (List)request.getAttribute("listas");
            for (ListaDTO lu: lista) {
            %>
    <tr>
        <td><%= lu.getIdLista() %></td>
        <td><%= lu.getDescripcion() %></td>
        <td><%= lu.getMarketingId() %></td>
        <td><a href="/marketing/editar/<%= lu.getIdLista() %>/<%= idUsuario %>">Editar</a></td></td>
        <td><a href="/marketing/borrar/<%= lu.getIdLista() %>/<%= idUsuario %>">Borrar</a></td>
        <td><a href="/marketing/mensaje/<%= lu.getIdLista() %>/<%= idUsuario %>">Enviar Mensaje</a></td>
    </tr>
    <%
        }
    %>
</table>

<br>
<form:form action="/marketing/crear" method="post">
    <input type="hidden" name="marketingId" value="<%= idUsuario %>">
    Descripción: <input type="text" name="descripcion" size="30"> <br>
    <input type="submit"  value="Crear Lista"></form:form>

<a href="/bandeja/<%= idUsuario %>/marketing">Bandeja Mensajes</a>

</body>
</html>

