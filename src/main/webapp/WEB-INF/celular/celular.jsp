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
		<form:form class="form-group" method="POST" action="/celular/crear" modelAttribute="celular">
			<div class="row">
				<form:label class="col-2 col-form-label" path="phone">Celular:</form:label>
				<div class="col-10">
					<form:input class="form-control" type="text" path="phone"/> 
				</div>
				<form:label class="col-2 col-form-label" path="brand">Marca:</form:label>
				<div class="col-10">
					<form:input class="form-control" type="text" path="brand"/> 
				</div>
			</div>
			<form:select class="form-select" path="usuario" aria-label="Default select example">
				<option selected>Seleccione Usuario</option>
				<c:forEach items="${listaUsuarios}" var="usuario">
					<form:option value="${usuario.getId()}">
						${usuario.getName()} ${usuario.getLast_name()}
					</form:option>
				</c:forEach>
			</form:select>
			<div class="d-flex justify-content-center">
				<input class="btn btn-danger m-2" type="reset" value="Limpiar">
				<input class="btn btn-primary m-2" type="submit" value="Crear"> 
			</div>
		</form:form>
	</div>
	
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</html>