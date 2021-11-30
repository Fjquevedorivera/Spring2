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
		<form:form class="" method="POST" action="/usuario/registrar" modelAttribute="usuario">
			<div class="form-group row">
				<form:label class="col-sm-2 col-form-label" path="name">Nombre:</form:label>
				<div class="col-sm-10">
					<form:input class="form-control" type="text" path="name"/> 
				</div>
			</div>
			<div class="form-group row">
				<form:label class="col-sm-2 col-form-label" path="last_name">Apellido:</form:label>
				<div class="col-sm-10">
					<form:input class="form-control" type="text" path="last_name"/> 
				</div>
			</div>
			<div class="form-group row">
				<form:label class="col-sm-2 col-form-label" path="limite">Limite:</form:label>
				<div class="col-sm-10">
					<form:input class="form-control" type="text" path="limite"/> 
				</div>
			</div>
			<div class="form-group row">
				<form:label class="col-sm-2 col-form-label" path="cp">Codigo Postal:</form:label>
				<div class="col-sm-10">
					<form:input class="form-control" type="text" path="cp"/>
				</div>
			</div>
			<div class="form-group row">	
				<form:label class="co-sml-2 col-form-label" path="rut">Rut:</form:label>
				<div class="col-sm-10">
					<form:input class="form-control" type="text" path="rut"/> 
				</div>
			</div>
			<div class="form-group row">
				<form:label class="col-sm-2 col-form-label" path="email">Email:</form:label>
				<div class="col-sm-10">
					<form:input class="form-control" type="text" path="email"/> 
				</div>
			</div>
			<div class="form-group row">
				<form:label class="col-sm-2 col-form-label" path="password">Contraseña:</form:label>
				<div class="col-sm-10">
					<form:input class="form-control" type="text" path="password"/>
				</div>
			</div>
			<div class="form-group row">
				<form:label class="col-sm-2 col-form-label" path="passwordConfirmation">Confirmar Contraseña:</form:label>
				<div class="col-sm-10">
					<form:input class="form-control" type="text" path="passwordConfirmation"/>
				</div>
			</div>
			<div class="d-flex justify-content-center pt-4">
				<input class="btn btn-danger m-2" type="reset" value="Limpiar">
				<input class="btn btn-primary m-2" type="submit" value="Registrar"> 
			</div>
		</form:form>
		
	</div>
	
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</html>