<%@ page import="es.grupo2.proyectospring.dto.ProductoDTO" %>
<%@ page import="es.grupo2.proyectospring.dto.CompradorDTO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: javie
  Date: 12/06/2022
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Favoritos</title>
</head>
<body>
<h1>Listado de favoritos</h1>

<%
    CompradorDTO c = (CompradorDTO)request.getAttribute("comprador");

    List<ProductoDTO> favoritos = (List) request.getAttribute("favoritos");
    if (favoritos == null || favoritos.isEmpty() ) {
%>
<h2>No hay favoritos</h2>
<form method="POST" action="/comprador/<%=c.getUsuarioId()%>">
    <input type="submit" value="Atrás">
</form>
<%
} else {
%>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Título</th>
        <th>Descripción</th>
        <th>Precio Salida</th>
        <th>Foto</th>
        <th>Categoría</th>
    </tr>
    <%
        for (ProductoDTO p: favoritos) {

            int categoria=p.getCategoriaProducto();
            String res;
            if(categoria==1){
                res="Ocio";
            }else if(categoria==2){
                res="Deportes";
            }else if(categoria==3){
                res="Ropa";
            }else if(categoria==4){
                res="Muebles";
            }else{
                res="Otros";
            }
    %>
    <tr>
        <td><%= p.getId() %></td>
        <td><%= p.getTitulo() %></td>
        <td><%= p.getDescripcion() %></td>
        <td><%= p.getPrecioSalida() %></td>
        <td><img src="<%=p.getUrlFoto()%>" class="img-thumbnail" width="100" height="100"></td>
        <td><%= res.toString() %></td>

        <td><a href="EliminarFavorito/comprador/<%=c.getUsuarioId()%>/Productoid/<%= p.getId() %>">Eliminar</a></td>

    </tr>

    <%
        }
    %>
</table>
<form method="POST" action="/comprador/<%=c.getUsuarioId()%>">
    <input type="submit" value="Atrás">
</form>
<%
    }
%>
</body>
</html>
