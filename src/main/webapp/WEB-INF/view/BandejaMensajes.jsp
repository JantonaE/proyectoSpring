
<%--
    Document   : BandejaMensajes
    Created on : 16-abr-2022, 15:34:12
    Author     : Jesús Antona Espejo
--%>
<%@page import="es.grupo2.proyectospring.*"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="java.util.List"%>
<%@ page import="es.grupo2.proyectospring.entity.VistaMensaje" %>
<%@ page import="es.grupo2.proyectospring.entity.Mensaje" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Bandeja de Mensajes</title>
</head>
<body>
<%
  List<Mensaje> lista = (List<Mensaje>)request.getAttribute("mensajes");
%>
<h1> Bandeja de Mensajes <%= lista.get(0).getDestinatarioId() %></h1>
<table border="1">
  <tr>
    <td>ID EMISOR</td>
    <td>ASUNTO</td>
    <td>LEIDO</td>
    <td>CUERPO</td>
  </tr>
  <tr>
      <%

            for (Mensaje m: lista) {
            %>
  <tr>
    <td><%= m.getEmisorId() %></td>

    <td><%= m.getAsunto() %></td>
    <%
      if(m.getLeido().equals("0")){
    %>
    <td>No leido</td>
    <%
    }else{
    %>
    <td>Leido</td>
    <%
      }
    %>
    <td><%= m.getCuerpo() %></td>
  </tr>
  <%
    }
  %>
</table>
<br>
<br>
<a href="index.html">Volver</a>

</body>
</html>
