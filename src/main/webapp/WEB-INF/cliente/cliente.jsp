<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Clientes</title>
</head>
<body>

	<div class="container">
		<form:form class="form-group" method="POST" action="cliente/crear" modelAttribute="cliente">
			<div class="row">
				<form:label class="col-2 col-form-label" path="name">Nombre:</form:label>
				<div class="col-10">
					<form:input class="form-control" type="text" path="name"/>
				</div>
	
				<form:label class="col-2 col-form-label" path="rut">Rut:</form:label>
				<div class="col-10">
					<form:input class="form-control" type="text" path="rut"/>
				</div>
	
				<form:label class="col-2 col-form-label" path="age">Edad:</form:label>
				<div class="col-10">
					<form:input class="form-control" type="text" path="age"/>
				</div>
	
				<form:label class="col-2 col-form-label" path="sex">Sexo:</form:label>
				<div class="col-10">
					<form:input class="form-control" type="text" path="sex"/>
				</div>
	
				<form:label class="col-2 col-form-label" path="phone">Celular:</form:label>
				<div class="col-10">
					<form:input class="form-control" type="text" path="phone"/>
				</div>
	
				<form:label path="plan">Plan: </form:label>
				<form:select path="plan">
					<form:option value="true">Si</form:option>
					<form:option value="false">No</form:option>
				</form:select>
				
				<form:select class="form-select" path="proveedor" multiple="true" aria-label="multiple select example">
					<option selected disabled>Seleccione Proveedor</option>
					<c:forEach items="${listaProveedores}" var="proveedor">
						<form:option value="${proveedor.getId()}">
							${proveedor.getName()}
						</form:option>
					</c:forEach>
				</form:select>

				<div class="d-flex justify-content-center">
					<input class="btn btn-danger m-2" type="reset" value="Limpiar">
					<input class="btn btn-primary m-2" type="submit" value="Insertar">
				</div>
			</div>
		</form:form>

<br>
<hr>

<table class="table">
	<thead>
		<tr>
			<th scope="col">#</th>
			<th scope="col">Rut</th>
			<th scope="col">Nombre</th>
			<th scope="col">Edad</th>
			<th scope="col">Sexo</th>
			<th scope="col">Plan</th>
			<th scope="col">Celular</th>
		</tr>
	</thead>
<tbody>
	<c:forEach items="${listaClientes}" var="cliente">
	<tr>
		<th scope="row">${cliente.getId()}</th>
		<td>${cliente.getRut()}</td>
		<td>${cliente.getAge()}</td>
		<td>${cliente.getSex()}</td>
		<td>${cliente.getPlan()}</td>
		<td>${cliente.getPhone()}</td>
		<td class="d-flex justify-content-center">
			<form method="post" action="/proyecto/eliminar">
				<input type="hidden" name="id" value="${proyecto.getId()}">
				<input class="btn btn-danger btn-sm" type="submit" value="Eliminar">
			</form>
			<form method="post" action="/proyecto/editar">
				<input type="hidden" name="id" value="${proyecto.getId()}">
				<input class="btn btn-primary btn-sm" type="submit" value="Editar">
			</form>
		</td>
	</tr>
	</c:forEach>
</tbody>
</table>

</div>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</html>