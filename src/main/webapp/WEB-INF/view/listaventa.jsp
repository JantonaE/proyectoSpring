<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="es.grupo2.proyectospring.dto.ListaDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="es.grupo2.proyectospring.entity.ListaVenta" %><%--
  Created by IntelliJ IDEA.
  User: USUARIO
  Date: 09/06/2022
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Listas de Usuarios Compradores</title>
</head>
<body>

    <%
        List<ListaVenta> listaVentaList = (List<ListaVenta>) request.getAttribute("listaventa");
    %>

    <table>
        <tr>
            <td>Vendedor</td>
            <td>Producto</td>
            <td>Comprador</td>
            <td>Fecha</td>
            <td>Precio</td>
        </tr>

        <%
            for(ListaVenta lv: listaVentaList){
        %>

        <tr>
            <td><%= lv.getVendedorId()%></td>
            <td><%= lv.getProducto()%></td>
            <td><%= lv.getCompradorId()%></td>
            <td><%= lv.getFecha()%></td>
            <td><%= lv.getPreciopuja()%></td>
        </tr>
        <%
            }
        %>
    </table>

</body>