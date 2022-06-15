<%@ page import="es.grupo2.proyectospring.entity.Usuario" %>
<%@ page import="es.grupo2.proyectospring.dto.UsuarioDTO" %>
<%@ page import="java.util.List" %><%--
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
    <title>Listado de clientes</title>
</head>
<body>
<%


    String idanalista = (String)request.getAttribute("idanalista");
%>

<table border="1">
    <tr>
        <th>NOMBRE</th>
        <th>APELLIDOS</th>
        <th>DOMICILIO</th>
        <th>CIUDAD</th>
        <th>EDAD</th>
        <th>SEXO</th>
        <th>INGRESOS TOTALES</th>
        <th>NUMERO VENTAS</th>
    </tr>
    <%
        List<UsuarioDTO> usuarios = (List<UsuarioDTO>)request.getAttribute("usuarios");
        List<Double> ingresos = (List<Double>)request.getAttribute("ingresos");
        List<Integer> ventas = (List<Integer>)request.getAttribute("ventas");
        for (int i = 0; i<usuarios.size(); i++){
    %>
    <tr>
        <td><%= usuarios.get(i).getNombre() %></td>
        <td><%= usuarios.get(i).getApellidos() %></td>
        <td><%= usuarios.get(i).getDomicilio() %></td>
        <td><%= usuarios.get(i).getCiudad() %></td>
        <td><%= usuarios.get(i).getEdad() %></td>
        <td><%= usuarios.get(i).getSexo() %></td>
        <td><%= String.format("%.2f", ingresos.get(i)) %>€</td>
        <td><%= ventas.get(i) %></td>
    </tr>
    <%
        }
    %>
</table>
<br>
<a href="/analista/<%=idanalista %>">Volver</a>
</body>
</html>
