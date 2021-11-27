<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
rel="stylesheet"
integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
crossorigin="anonymous">
<title>EDITAR CLIENTE</title>
</head>
<body>
<h1>EDITAR CLIENTE</h1>
<div class="container">
	<form:form class="form-group" method="POST" action="/cliente/actualizar" modelAttribute="cliente">
		<input type="hidden" name="_method" value="put">
		<form:input type="hidden" path="id" />
		
		<div class="row">
			<form:label class="col-2 col-form-label" path="name">Nombre:</form:label>
			<div class="col-10">
				<form:input class="form-control" type="text" path="name" />
			</div>
			
			<form:label class="col-2 col-form-label" path="rut">Rut:</form:label>
			<div class="col-10">
				<form:input class="form-control" type="text" path="rut" />
			</div>
			
			<form:label class="col-2 col-form-label" path="age">Edad:</form:label>
			<div class="col-10">
				<form:input class="form-control" type="text" path="age" />
			</div>
			
			<form:label class="col-2 col-form-label" path="sex">Sexo:</form:label>
			<div class="col-10">
				<form:input class="form-control" type="text" path="sex" />
			</div>
		
			<form:label class="col-2 col-form-label" path="phone">Celular:</form:label>
			<div class="col-10">
				<form:input class="form-control" type="text" path="phone" />
			</div>
			
			<form:label path="plan">Plan: </form:label>
			<form:select path="plan">
				<form:option value="true">Si</form:option>
				<form:option value="false">No</form:option>
			</form:select>
			
			<form:label class="form-label" path="lista_proveedores">Proveedores asignados:</form:label>
			<form:select class="form-select" path="lista_proveedores" multiple="true"
			aria-label="multiple select example">
				<option selected disabled>Seleccione Proveedor</option>
				<c:forEach items="${listaProveedores}" var="proveedor">
				<c:if test="${proveedor.getId() == cliente.getLista_proveedores().getId()}">
					<form:option value="${proveedor.getId()}" selected="true">
					${proveedor.getName()} ${proveedor.getLast_name()}
					</form:option>
				</c:if>
					<form:option value="${proveedor.getId()}">
					${proveedor.getName()}
					</form:option>
				</c:forEach>
			</form:select>
			</div>
			<div class="d-flex justify-content-center">
			<input class="btn btn-primary m-2" type="submit" value="Editar">
		</div>
	</form:form>
</div>


</body>
<script
src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
crossorigin="anonymous"></script>
</html>