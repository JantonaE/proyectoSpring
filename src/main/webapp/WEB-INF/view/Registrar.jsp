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
<form:form action="registrarCompleted" method="post" modelAttribute="usuario">
  <p>
  <table>
    <tr>
      <td>Nombre:</td>
      <td><form:input path="nombre" ></form:input></td>
    </tr>
    <tr>
      <td>Apellidos:</td>
      <td><form:input path="apellidos" ></form:input></td>
    </tr>
    <tr>
      <td>Domicilio:</td>
      <td><form:input path="domicilio" ></form:input></td>
    </tr>
    <tr>
      <td>Ciudad:</td>
      <td><form:input path="ciudad"></form:input></tr></td>
    </tr>

    <tr>
      <td>Edad:</td>
      <td><form:input path="edad" ></form:input></td>
    </tr>

    <tr>
      <td>Sexo:</td>
      <td>
        <form:select path="sexo" id="sexo" name="sexo">
            <option disabled selected="Seleccione sexo..."></option>
            <option>M</option>
            <option>F</option>
        </form:select>
      </td>
    </tr>

  <form:form action="compradorCategoria" method="post" modelAttribute="comprador">
    <tr>
      <td>Categoría preferida:</td>
      <td>

          <form:select path="categoria" id="categoria" name="categoriaPreferida">
            <option disabled selected="Seleccione categoría..."></option>
            <option>Ocio</option>
            <option>Ropa</option>
            <option>Tecnología</option>
            <option>Decoración</option>
          </form:select>

      </td>
    </tr>
  </form:form>
    <td>Contraseña:</td>
    <td><form:input path="contraseña"></form:input></td>
    <td>La contraseña debe contener como mínimo 8 carácteres, almenos una mayúscula, minúscula y un número.</td>

    </tr>
    <td></td>
  <td><form:button>Registrar</form:button>></td>
    </tr>
  </table>
  </p>
</form:form>

</body>
</html>
