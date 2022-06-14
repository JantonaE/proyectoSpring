<%--
  Created by IntelliJ IDEA.
  User: javie
  Date: 14/06/2022
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inicio Sesión</title>
</head>
<body>
<h1>Inicio Sesión</h1>

<form method="POST" action="/inicioSesion">
    <table>
        <tr>
            <td><label>Usuario:</label></td>
            <td><input type="text" name="usuario" id="usuario" title='Introduce
                               tu usuario'required="required" /></tr></td>
        </tr>
        <tr>

            <td><label>Contraseña:</label></td>
            <td><input type="password" name="password" id="password" title='Introduce
                               tu contraseña' autocomplete="new-password" required="required"/></td>


        </tr>
        <tr>
            <td><input type="submit" value="Iniciar Sesión" /></td>
        </tr>
    </table>
    </p>
</form>
<form method="POST" action="/registrar">
    <table>
        <tr>
            <td>¿Aún no estás registrado?</td>
            <td><input type="submit" value="Registrar" /></td>
        </tr>
    </table>
</form>
</body>
</html>
