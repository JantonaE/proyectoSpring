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

<h1>Listado de usuarios</h1>
<form method="get" action="AnalisisUsuariosServlet">
    <input type="hidden" name="idanalista" value="<%=idanalista %>">
    <input type="hidden" name="id" value="<%=analisis==null?"":analisis.getId() %>">
    Nombre: <input type="text" name="filtroNombre" value=<%=nombre%>>
    <nbsp>
        Apellidos: <input type="text" name="filtroApellido" value=<%=apellidos%>>
        <br>
        Domicilio: <input type="text" name="filtroDomicilio" value=<%=domicilio%>>
        <nbsp>
            Ciudad: <input type="text" name="filtroCiudad" value=<%=ciudad%>>
            <br>
            Edad: <input type="text" name="filtroEdad" value=<%=edad%>>
            <nbsp>
                Sexo:
                <select name="Sexo">
                    <option value="-" <% if(sexo.equals("-")){ %> selected <% } %>>-</option>
                    <option value="M" <% if(sexo.equals("M")){ %> selected <% } %>>M</option>
                    <option value="F" <% if(sexo.equals("F")){ %> selected <% } %>>F</option>
                </select>
                <br>
                Ordenar por:
                <select name="Ordenar">
                    <option value="-" <% if(orden.equals("-")){ %> selected <% } %>>-</option>
                    <option value="apellidosASC" <% if(orden.equals("apellidosASC")){ %> selected <% } %>>APELLIDOS ASC</option>
                    <option value="apellidosDESC" <% if(orden.equals("apellidosDESC")){ %> selected <% } %>>APELLIDOS DESC</option>
                </select>
                <input type="submit" value="Filtrar" />
                <br>
                <br>
                Nombre analisis: <input type="text" name="nombreAnalisis" value="<%=analisis==null?"":analisis.getNombre() %>">
                <input type="submit" value="Nuevo analisis" formaction="GuardarAnalisisServlet"/>
                <input type="submit" value="Actualizar" formaction="ActualizarAnalisisServlet"
                        <% if(analisis==null){ %>
                       disabled
                        <%} %>
                />

</form>

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
