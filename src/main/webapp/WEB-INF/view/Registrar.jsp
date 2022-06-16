<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: javie
  Date: 12/06/2022
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title> Formulario</title>
</head>

<body>

<h1>Registro</h1>
<h2>Introduzca sus datos personales</h2>
<form action="/registrarCompleted" method="post">
  <p>
  <table>
    <tr>
      <td><label for="nombre">Nombre:</label></td>
      <td><input type="text" name="nombre" id="nombre" title='Introduce
    tu nombre' autocomplete="given-name" required="required" placeholder="Javier" /></tr></td>
    </tr>
    <tr>
      <td><label for="apellidos">Apellidos:</label></td>
      <td><input type="text" name="apellidos" id="apellidos" title='Introduce
    tus apellidos' autocomplete="family-name" required="required" placeholder="Martín Sendra"/></td>
    </tr>
    <tr>
      <td><label for="domicilio">Domicilio:</label></td>
      <td><input type="text" name="domicilio" id="domicilio" title='Introduce
    tu domicilio' autocomplete="address-line1" required="required" placeholder="Urb Flores"/></td>
    </tr>
    <tr>
      <td><label for="ciudad">Ciudad:</label></td>
      <td><input type="text" name="ciudad" id="ciudad" title='Introduce
    tu ciudad' required="required" placeholder="Málaga" /></tr></td>
    </tr>

    <tr>
      <td><label for="edad">Edad:</label></td>
      <td><input type="numer" name="edad" id="edad" title='Introduce
    tu edad' required="required" placeholder="21"/></td>
    </tr>

    <tr>
      <td><label for="sexo">Sexo:</label></td>
      <td>

          <select id="sexo" name="sexo">
            <option disabled selected="Seleccione sexo..."></option>
            <option>M</option>
            <option>F</option>
          </select>

      </td>
    </tr>

    <tr>
      <td><label>Categoría preferida:</label></td>
      <td>

          <select id="cat" name="cat">
            <option disabled selected="Seleccione categoría..."></option>
            <option>Ocio</option>
            <option>Ropa</option>
            <option>Tecnología</option>
            <option>Decoración</option>
          </select>

      </td>
    </tr>

    <td><label for="password">Contraseña:</label></td>
    <td><input type="password" name="password" id="password" title='Introduce
    tu contraseña' autocomplete="new-password" required="required"
               pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"/></td>
    <td><label>La contraseña debe contener como mínimo 8 carácteres, almenos una mayúscula, minúscula y un número.</label></td>

    </tr>
  <form method="post" action="/inicioSesion">
    <td><input type="submit" value="Cancelar" /></td>
  </form>
    <td><input type="submit" value="Registrar" /></td>
    </tr>
  </table>
  </p>
</form>
</body>
</html>
