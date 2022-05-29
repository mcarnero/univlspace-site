<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recuperar password</title>
</head>
<body style="background-image: url(imagenes/ViaLactea.jpg); background-attachment:fixed; background-repeat: no-repeat; background-size: cover;">
<header>
<img src="imagenes/Logo.png" style="width: 200px; float:left;" />
<h1 style="color: white; text-align: right;">Plataforma Digital para aprendices de la Universidad Nacional Intergal�ctica de la V�a L�ctea (UNIVL)</h1>
</header>

<hr style="clear: left;" />

<h2 style="color: white;">Recuperar contrase�a</h2>

<p style="color: white;">Si olvid� la contrase�a, aqu� puede recuperarla. Se enviar� un e-mail con instrucciones.</p>

<form action="solicitarPassword" method="post">
<table>
	<tr>
		<td><label style="color: white;">E-mail</label></td>
		<td><input type="text" name="email"></td>
	</tr>
	
	<tr>
		<td></td>
		<td><button type="submit"> Recuperar </button></td>
</table>
</form>

<strong style="color: white;">${respuesta}</strong>

</body>
</html>