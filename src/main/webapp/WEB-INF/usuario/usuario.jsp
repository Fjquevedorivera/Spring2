<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<form:form class="form-group" method="POST" action="/usuario/login" modelAttribute="usuario">
			<div class="row">
				<form:label class="col-2 col-form-label" path="name">Nombre:</form:label>
				<div class="col-10">
					<form:input class="form-control" type="text" path="name"/> 
				</div>
			</div>
			<div class="row">
				<form:label class="col-2 col-form-label" path="last_name">Apellido:</form:label>
				<div class="col-10">
					<form:input class="form-control" type="text" path="last_name"/> 
				</div>
			</div>
			<div class="row">
				<form:label class="col-2 col-form-label" path="limite">Limite:</form:label>
				<div class="col-10">
					<form:input class="form-control" type="text" path="limite"/> 
				</div>
			</div>
			<div class="row">
				<form:label class="col-2 col-form-label" path="cp">Codigo Postal:</form:label>
				<div class="col-10">
					<form:input class="form-control" type="text" path="cp"/>
				</div>
			</div>
			<div class="d-flex justify-content-center">
				<input class="btn btn-danger m-2" type="button" value="Limpiar">
				<input class="btn btn-primary m-2" type="submit" value="Insertar"> 
			</div>
		</form:form>
		
		<!-- <form method="POST" action="/usuario/login">
			<label for="name">Nombre:</label>
			<input type="text" id="name" name="name"> <br>
			<label for="last-name">Apellido:</label>
			<input type="text" id="last-name" name="last-name"> <br>
			<label for="limit">Limite:</label>
			<input type="text" id="limit" name="limit"> <br>
			<label for="cp">Codigo Postal:</label>
			<input type="text" id="cp" name="cp"> <br>
			<input type="button" value="Limpiar">
			<input type="submit" value="Insertar">
		</form> -->
	</div>
	
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</html>