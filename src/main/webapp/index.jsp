<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body style="background-image: url(imagenes/ViaLactea.jpg); background-attachment:fixed; background-repeat: no-repeat; background-size: cover;">
<header>
<img src="imagenes/Logo.png" style="width: 200px; float:left;" />
<h1 style="color: white; text-align: right;">Plataforma Digital para aprendices de la Universidad Nacional Intergaláctica de la Vía Láctea (UNIVL)</h1>
</header>

<hr style="clear: left;" />

<h2 style="color: white;"> Iniciar sesión </h2>

<form action="login" method="post">
<table>
	<tr>
		<td><label style="color: white;">Usuario</label></td>
		<td><input type="text" name="usuario"></td>
	</tr>
	
	<tr>
		<td><label style="color: white;">Password</label></td>
		<td><input type="password" name="password"></td>
	</tr>
	
	<tr>
		<td></td>
		<td><button type="submit"> Entrar </button></td>
	</tr>
</table>
</form>

<table>

	<tr>
		<td><strong style="color: white;"><c:out value="${respuesta}" /></strong></td>
		<td><strong><%-- ${respuesta} --%></strong></td>
	</tr>

	<tr>
		<td><a href="creaCuenta.jsp">Crea cuenta nueva</a></td>
		<td><a href="recuperar.jsp">Recuperar Contraseña</a></td>
	</tr>
	
	<tr>
		<td><a href="#">Entrar con cuenta de Facebook</a></td>
		<td><a href="#">Entrar con cuenta de Google</a></td>
	</tr>
</table>

</body>
</html>