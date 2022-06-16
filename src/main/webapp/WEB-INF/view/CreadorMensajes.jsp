<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="es.grupo2.proyectospring.dto.ListaDTO" %>
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
    <title>Creador Mensajes</title>
</head>
<%
    int idUsuario = (int) request.getAttribute("idUsuario");
    ListaDTO lista = (ListaDTO) request.getAttribute("lista");
    long idmarketing = lista.getMarketingId();
%>
<body>
<h1>Enviar Mensaje <%= lista.getIdLista() %></h1>
<form:form action="/marketing/enviar" method="post">
    <input type="hidden" name="idUsuario" value="<%= idUsuario %>">
    <input type="hidden" name="listaId" value="<%= lista.getIdLista() %>">
    <input type="hidden" name="emisor" value="<%= lista.getMarketingId() %>">
    Titulo: <input type="text" name="titulo" size="20">
    <br>
    Cuerpo: <input type="text" name="contenido" size="90">
    <br>
    <input type="submit"  value="Mandar mensaje">
</form:form>

<br>
<a href="/marketing/<%= idUsuario %>">Volver</a>
</body>
</html>
