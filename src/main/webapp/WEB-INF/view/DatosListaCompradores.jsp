<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="es.grupo2.proyectospring.entity.ListaUsuarios" %>
<%@ page import="java.util.List" %>
<%@ page import="es.grupo2.proyectospring.dto.ListaDTO" %>
<%@ page import="es.grupo2.proyectospring.dto.UsuarioDTO" %>
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
  <title>Datos Lista Compradores</title>
</head>
<%
  //String idLista = request.getParameter("id");
  List<UsuarioDTO> listaU = (List<UsuarioDTO>) request.getAttribute("usuarios");
  ListaDTO lista = (ListaDTO)request.getAttribute("lista");

%>
<body>
<h1> Usuarios de la lista <%= lista.getDescripcion() %> </h1>
<%
  if(!listaU.isEmpty()){
%>
<table border="1">
  <tr>
    <td>ID USUARIO</td>
    <td>NOMBRE</td>
    <td>APELLIDOS</td>
    <td>CIUDAD</td>
    <td>EDAD</td>
    <td>SEXO</td>
    <td></td>
  </tr>
  <tr>
      <%
             for (UsuarioDTO u: listaU) {
            %>
  <tr>
    <td><%= u.getId() %></td>
    <td><%= u.getNombre() %></td>
    <td><%= u.getApellidos() %></td>
    <td><%= u.getCiudad() %></td>
    <td><%= u.getEdad() %></td>
    <td><%= u.getSexo() %></td>
    <td><a href="/marketing/UsuarioListaBorrar/<%= lista.getIdLista() %>/ <%= u.getId() %>">Borrar</a> </td>
  </tr>
  <%
    }
  }else{
  %>
  <h2> Esta lista no tiene usuarios</h2> <br>
  <%
    }
  %>
</table>
<h2>Añadir usuarios a lista <%= lista.getDescripcion() %></h2>

<form:form action="/marketing/listaUsuariosADD" method="post">
  <input type="hidden" name="idLista" value="<%= lista.getIdLista() %>">
  Ciudad: <input type="text" name="ciudad" value="" /> <br><br>
  Género: <br>
  Hombre <input type="radio" name="sexo" value="M"/> <br>
  Mujer  <input type="radio" name="sexo" value="F"/> <br>

  Edad. Min: <input type="text" name="edadMin" size="4" value="" />       Edad. Max: <input type="text" size="4" name="edadMax" value="" /> <br><br>
  <input type="submit" value="Añadir Usuarios" />
</form:form>


<a href="/marketing/">Volver</a>
</body>

</html>
