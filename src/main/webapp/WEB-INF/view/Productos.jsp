<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="es.grupo2.proyectospring.dto.ListaVentaDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="es.grupo2.proyectospring.dto.ProductoDTO" %>
<%@ page import="es.grupo2.proyectospring.entity.Producto" %>
<%@ page import="es.grupo2.proyectospring.entity.Comprador" %>
<%@ page import="es.grupo2.proyectospring.dto.CompradorDTO" %>
<%@ page import="es.grupo2.proyectospring.entity.ListaVenta" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: javie
  Date: 12/06/2022
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Productos</title>
</head>
<body>

    <%

        List<ListaVentaDTO> listaVenta= (List) request.getAttribute("listaVentaDTO");
        Boolean filtro= (Boolean) request.getAttribute("filtro");
        CompradorDTO comprador= (CompradorDTO) request.getAttribute("comprador");

    %>

    <%
        if (listaVenta == null || listaVenta.isEmpty() ) {
    %>
    <h2>No hay productos</h2>
    <%
    } else {
    %>
    <form method="post" action="/Filtrar/<%=comprador.getUsuarioId()%>">
        <label>Título:</label>
        <input type="text" id="tituloF" name="tituloF">
        <label>Descripción:</label>
        <input type="text" id="descF" name="descF">
        <label>Precio actual:</label>
        <input type="text" id="precioF" name="precioF">
        <label>Categoría:</label>
        <select id="categoriaF" name="categoriaF">
            <option disabled selected="Seleccione categoría..."></option>
            <option>Ocio</option>
            <option>Deportes</option>
            <option>Ropa</option>
            <option>Muebles</option>
            <option>Otros</option>
            <option> </option>
        </select>
        <input type="submit" value="Filtrar">
    </form>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Título</th>
            <th>Descripción</th>
            <th>Precio Salida</th>
            <th>Foto</th>
            <th>Categoría</th>
            <th>Precio actual</th>
        </tr>
        <%


            for (ListaVentaDTO lv: listaVenta) {
                // for(ListaVentaDTO l :listaVenta){
                int categoria=lv.getProducto1().getCategoriaProducto();
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
            <td><%= lv.getProducto1().getId() %></td>
            <td><%= lv.getProducto1().getTitulo() %></td>
            <td><%= lv.getProducto1().getDescripcion() %></td>
            <td><%= lv.getProducto1().getPrecioSalida() %></td>
            <td><img src="<%=lv.getProducto1().getUrlFoto()%>" class="img-thumbnail" width="100" height="100"></td>
            <td><%= res.toString()%></td>
            <td><%= lv.getPreciopuja() %></td>
            <%

                boolean checkFavorito= false;
                List<ProductoDTO> favoritos = (List) request.getAttribute("favoritos");
                List<Producto> check=new ArrayList<>();
                for(ProductoDTO productoDTO:favoritos){
                    check.add(productoDTO.toNormal());
                }

                if(check.contains(lv.getProducto1())){
                    checkFavorito=true;
                }


            %>

            <form  method="POST" action="/Puja/comprador/<%=comprador.getUsuarioId() %>/Productoid/<%=lv.getProducto1().getId() %>/<%=filtro%>">
                <td><input type="text" id="puja" name="puja"> </td>
                <td><input type="submit" value="Pujar"></td>

            </form>
            <%
                if(!checkFavorito){
            %>
            <td><a href="/AnadirFavorito/comprador/<%=comprador.getUsuarioId()%>/Productoid/<%= lv.getProducto1().getId() %>/<%=filtro%>">Favorito</a></td>
            <%
                }
            %>
        </tr>

        <%


            }
        %>
    </table>

    <form method="POST" action="/Favoritos/<%=comprador.getUsuarioId()%>/<%=filtro%>">
        <input type="submit" value="Favoritos" >
    </form>
<%
    String ruta="comprador/"+comprador.getUsuarioId()+"/"+filtro;
%>
    <form method="POST" action="/bandeja/<%=comprador.getUsuarioId()%>/<%=ruta%>">
        <input type="submit" value="Mensajes" >
    </form>

    <form method="POST" action="/inicioSesion">
        <input type="submit" value="Salir" >
    </form>
    <%
        }
    %>


</body>
</html>
