<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro de Nuevo Empleado</title>
</head>
<body>
	<form:form commandName="empleado" method="post"
action="${pageContext.request.contextPath}/empleado/guardar-actualizar">
		<c:if test="${empleado.id > 0}">
			<form:input path="id" type="hidden" />
			<form:input path="fechaCreacion" type="hidden" />
			<form:input path="estado" type="hidden" />
		</c:if>
		<table>
			<tr>
				<td>Nombre :</td>
				<td><form:input path="nombre" type="text" required="true" maxlength="30"/></td>
			</tr>
			<tr>
				<td>Apellido Paterno :</td>
				<td><form:input path="apellidoPaterno" type="text" required="true" maxlength="30"/></td>
			</tr>
			<tr>
				<td>Apellido Materno :</td>
				<td><form:input path="apellidoMaterno" type="text" required="true" maxlength="30"/></td>
			</tr>
			<tr>
				<td>Edad :</td>
				<td><form:input path="edad" type="int" required="true" min="0" max="99"/></td>
			</tr>
			<tr>
				<td>Sexo :</td>
				<td><form:input path="sexo" type="text" required="true" maxlength="15"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Guardar Datos" /></td>
			</tr>
		</table>
	</form:form>
	
	<table>
		<tr>
			<td>NOMBRE COMPLETO</td>
			<td>EDAD</td>
			<td>SEXO</td>
			<td>Fecha de Creaci�n</td>
			<td>Acciones</td>
		</tr>
		<c:forEach items="${empleados}" var="emp">
			<tr>
				<td><c:out value="${emp.nombre} ${emp.apellidoPaterno} ${emp.apellidoMaterno}" /></td>
				<td><c:out value="${emp.edad}" /></td>
				<td><c:out value="${emp.sexo}" /></td>
				<td><c:out value="${emp.fechaCreacion}" /></td>
				<td><a href='<c:url value="/empleado/${emp.id}/actualizar"/>'>Actualizar</a></td>
				<td><a class="confirm"
					href='<c:url value="/empleado/${emp.id}/eliminar"/>'>Eliminar</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>