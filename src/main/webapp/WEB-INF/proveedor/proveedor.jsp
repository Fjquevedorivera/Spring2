<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <form action="/proveedor/insertar" method="POST">
		<label for="name">Nombre: </label>
		<input type="text" name="name" id="name"> <br>
		<label for="last-name">Apellido: </label>
		<input type="text" name="last-name" id="last-name"> <br>
		<label for="email">Email: </label>
		<input type="text" name="email" id="email"> <br>
		<label for="age">Edad: </label>
		<input type="number" name="age" id="age"> <br>
		<input type="submit" value="send">	
    </form>
</body>

</html>
