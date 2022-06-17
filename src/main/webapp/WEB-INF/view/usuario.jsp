<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
    Document   : usuario
    Created on : 13-may-2022, 12:55:07
    Author     : ruben
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario</title>
    </head>
    <body>
        <h1>Introduce los datos</h1>
        <form:form action="/administrador/nuevoUs" method = "post" modelAttribute="usuario">
            <form:hidden path="id"/>
            Nombre : <form:input path="nombre"/><br>
            Apellidos : <form:input path="apellidos"/><br>
            Domicilio : <form:input path="domicilio"/><br>
            Ciudad : <form:input path="ciudad"/><br>
            Edad : <form:input path="edad"/><br>
            Sexo : <form:radiobutton path="sexo" value="M"/>Hombre <form:radiobutton path="sexo" value="F"/>Mujer<br>
            Contraseña : <form:input path="contraseña"/><br>
            <button type="submit">Enviar</button>
        </form:form><br>
        <a href = "/administrador">Salir</a>
    </body>
</html>
