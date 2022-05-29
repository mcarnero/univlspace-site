<%@ page isELIgnored="false" %>
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

<div style="float: left; padding-bottom: 5px;">
<a style="color: white;" href="home.jsp">Inicio</a> |
<a style="color: white;" href="calificaciones.jsp">Calificaciones</a> |
<a style="color: white;" href="horarios.jsp">Horarios</a> |
<a style="color: white;" href="contacto.jsp">Contacto</a> |
<a style="color: white;" href="acerca.jsp">Acerca de Nosotros</a>
</div>

<div style="float: right; padding-bottom: 5px;">
<a style="color: white;" href=${pageContext.request.contextPath}/logout>Cerrar Sesión</a>
</div>

<hr style="clear: left;" />

<h2 style="color: white;">Información sobre la plataforma </h2>

</body>
</html>