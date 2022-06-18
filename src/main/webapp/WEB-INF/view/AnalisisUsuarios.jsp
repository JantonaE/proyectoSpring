<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="es.grupo2.proyectospring.entity.Usuario" %>
<%@ page import="es.grupo2.proyectospring.dto.UsuarioDTO" %>
<%@ page import="es.grupo2.proyectospring.dto.BusquedaDTO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Antonio Sepúlveda Zorrilla
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
<h1>Información del análisis</h1>
<a href="/analista/<%=((BusquedaDTO)request.getAttribute("busqueda")).getIdAnalista()%>">Volver</a>
<h2>Filtrado</h2>
<form:form method="post" modelAttribute="busqueda">
<form:hidden path="idAnalisis"></form:hidden>
<form:hidden path="idAnalista"></form:hidden>
Nombre: <form:input path="nombre"></form:input> </nbsp>
Apellidos:<form:input path="apellidos"></form:input> </br>
Domicilio: <form:input path="domicilio"></form:input> </nbsp>
Ciudad: <form:input path="ciudad"></form:input> </br>
Edad: <form:input path="edad"></form:input> </nbsp> </br>
Sexo: <form:select path="sexo">
        <form:option value="-" label="-"></form:option>
        <form:option value="M" label="M"></form:option>
        <form:option value="F" label="F"></form:option>
        </form:select>
Orden:
    <form:select path="orden">
        <form:option value="-" label="-"></form:option>
        <form:option value="apellidosASC" label="apellidosASC"></form:option>
        <form:option value="apellidosDESC" label="apellidosDESC"></form:option>
    </form:select>

<input type="submit" value="Filtrar" formaction="/analisis/filtrar"/> </br></br>

Nombre analisis:
<form:input path="nombreBusqueda"></form:input> </nbsp>
<input type="submit" value="Nuevo analisis" formaction="/analisis/guardar"/>
<input type="submit" value="Actualizar" formaction="/analisis/actualizar"
        <% if (((BusquedaDTO) request.getAttribute("busqueda")).getIdAnalisis().equals("")) { %>
            disabled
        <%
            }
        %>
/>
</form:form>

<h1>Listado de clientes</h1>
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
        List<UsuarioDTO> usuarios = (List<UsuarioDTO>) request.getAttribute("usuarios");
        List<Double> ingresos = (List<Double>) request.getAttribute("ingresos");
        List<Integer> ventas = (List<Integer>) request.getAttribute("ventas");
        for (int i = 0; i < usuarios.size(); i++) {
    %>
    <tr>
        <td><%= usuarios.get(i).getNombre() %>
        </td>
        <td><%= usuarios.get(i).getApellidos() %>
        </td>
        <td><%= usuarios.get(i).getDomicilio() %>
        </td>
        <td><%= usuarios.get(i).getCiudad() %>
        </td>
        <td><%= usuarios.get(i).getEdad() %>
        </td>
        <td><%= usuarios.get(i).getSexo() %>
        </td>
        <td><%= String.format("%.2f", ingresos.get(i)) %>€</td>
        <td><%= ventas.get(i) %>
        </td>
    </tr>
    <%
        }
    %>
</table>
<br>

</body>
</html>