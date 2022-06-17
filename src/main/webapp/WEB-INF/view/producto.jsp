<%-- 
    Document   : producto
    Created on : 12-may-2022, 17:31:41
    Author     : ruben
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Producto</title>
    </head>
    <body>
        <h1>Producto</h1>
        <form:form action="/administrador/nuevoPr" method = "post" modelAttribute="producto">
            <form:hidden path="id"/>
            Titulo : <form:input path="titulo"/><br>
            Descripcion : <form:input path="descripcion"/><br>
            Precio salida : <form:input path="precioSalida"/><br>
            URL foto : <form:input path="urlFoto"/><br>
            Categoria : <form:input path="categoriaProducto"/><br>
            <button type="submit">Enviar</button>
        </form:form><br>

        <a href = "/administrador">Salir</a>
    </body>
</html>
