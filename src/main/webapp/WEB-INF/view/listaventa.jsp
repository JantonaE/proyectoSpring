<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="es.grupo2.proyectospring.dto.ListaDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="es.grupo2.proyectospring.entity.ListaVenta" %>
<%@ page import="es.grupo2.proyectospring.dto.ListaVentaDTO" %><%--
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
        List<ListaVentaDTO> listaVentaDTOS = (List<ListaVentaDTO>) request.getAttribute("listaventa");
        int vendedor = (int) request.getAttribute("vendedor");
    %>

    <form method="post" action="/vendedor/filtrar">
        <input type="hidden" value="<%=vendedor%>" name="vendedor" >>
        Nombre del Producto: <input type="text" name="producto" value="" />
        Nombre del Comprador: <input type="text" name="comprador" value="" />
        Precio Máximo: <input type="number" name="precio" value="0" >
        <input type="submit" value="Filtrar" />
    </form>
    <table>
        <tr>
            <td>Vendedor</td>
            <td>Producto</td>
            <td>Comprador</td>
            <td>Fecha</td>
            <td>Precio</td>
        </tr>

        <%
            for(ListaVentaDTO lv: listaVentaDTOS){
        %>

        <tr>
            <td><%= lv.getVendedor().getUsuario().getNombre()%></td>
            <td><%= lv.getProducto1().getTitulo()%></td>
            <%
                if(lv.getComprador()!= null){
            %>
            <td><%= lv.getComprador().getUsuario().getNombre()%></td>

            <%
                }else{
            %>
            <td>Aun sin comprador</td>
            <%
                }
            %>
            <td><%= lv.getFecha()%></td>
            <td><%= lv.getPreciopuja()%></td>
            <td><a href="/vendedor/<%= lv.getVendedorId() %>/<%=lv.getProducto()%>/edit">editar</a> </td>
        </tr>
        <%
            }
        %>
    </table>


    <a href="/vendedor/<%=vendedor%>/nuevo">CREAR NUEVA VENTA</a>


</body>