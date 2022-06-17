<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="es.grupo2.proyectospring.dto.CategoriaDTO" %><%--
    Document   : categoria
    Created on : 13-may-2022, 13:16:27
    Author     : ruben
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categoria</title>
    </head>
    <body>
        <h1>Categoria</h1>
        <form:form action="/administrador/nuevoCa" method = "post" modelAttribute="categoria">
            <form:hidden path="id"/>
            Titulo: <form:input path="titulo"/> <br>
            Descripcion: <form:input path="descripcion"/> <br>
            <button type="submit">Guardar</button>
        </form:form>
        <a href = "/administrador">Salir</a>
    </body>
</html>
