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
<form:form action="registrarCompleted" method="post" modelAttribute="Usuario">
  <p>
  <table>
    <tr>
      <td><form:label for="nombre">Nombre:</form:label></td>
      <td><form:input path="nombre" type="text" name="nombre" id="nombre" title='Introduce
    tu nombre' autocomplete="given-name" required="required" placeholder="Javier" ></form:input></td>
    </tr>
    <tr>
      <td><form:label for="apellidos">Apellidos:</form:label></td>
      <td><form:input path="apellidos" type="text" name="apellidos" id="apellidos" title='Introduce
    tus apellidos' autocomplete="family-name" required="required" placeholder="Martín Sendra"></form:input></td>
    </tr>
    <tr>
      <td><form:label for="domicilio">Domicilio:</form:label></td>
      <td><form:input path="domicilio" type="text" name="domicilio" id="domicilio" title='Introduce
    tu domicilio' autocomplete="address-line1" required="required" placeholder="Urb Flores"></form:input></td>
    </tr>
    <tr>
      <td><form:label for="ciudad">Ciudad:</form:label></td>
      <td><form:input path="ciudad" type="text" name="ciudad" id="ciudad" title='Introduce
    tu ciudad' required="required" placeholder="Málaga" ></form:input></tr></td>
    </tr>

    <tr>
      <td><form:label for="edad">Edad:</form:label></td>
      <td><form:input path="edad" type="numer" name="edad" id="edad" title='Introduce
    tu edad' required="required" placeholder="21"></form:input></td>
    </tr>

    <tr>
      <td><form:label for="sexo">Sexo:</form:label></td>
      <td>
        <form:select path="sexo" id="sexo" name="sexo">
            <option disabled selected="Seleccione sexo..."></option>
            <option>M</option>
            <option>F</option>
        </form:select>
      </td>
    </tr>

    <tr>
      <td><label for="categoria">Categoría preferida:</label></td>
      <td>

          <form:select path="categoria" id="categoria" name="categoria">
            <option disabled selected="Seleccione categoría..."></option>
            <option>Ocio</option>
            <option>Ropa</option>
            <option>Tecnología</option>
            <option>Decoración</option>
          </form:select>

      </td>
    </tr>

    <td><label for="password">Contraseña:</label></td>
    <td><input path="contraseña" type="password" name="password" id="password" title='Introduce
    tu contraseña' autocomplete="new-password" required="required"
               pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"/></td>
    <td><label for="info">La contraseña debe contener como mínimo 8 carácteres, almenos una mayúscula, minúscula y un número.</label></td>

    </tr>
    <td><input type="button" value="Cancelar" /></td>
    <td><input type="submit" value="Registrar" /></td>
    </tr>
  </table>
  </p>
</form:form>

</body>
</html>
