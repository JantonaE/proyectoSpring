<%@ page import="es.grupo2.proyectospring.dto.ListaVentaDTO" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: asalas
  Date: 11/06/2022
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Añadir nuevo Producto a la venta</title>
</head>
<body>
    <form:form action="/vendedor/guardar" method="post"  modelAttribute="listaVentaDTO">
        <form:hidden path="vendedorId"/>
        Producto:
        <form:select path="producto">
            <form:options items="${productos}" itemLabel="titulo" itemValue="id" />
        </form:select>
        Comprador: <form:select path="compradorId">
            <form:options items="${compradores}" itemLabel="usuario.nombre" itemValue="usuarioId"/>
        </form:select>
        PrecioPuja: <form:input path="preciopuja" />
        Fecha: <form:input path="fecha" />
        <form:button>Enviar</form:button>
    </form:form>

</body>
</html>
