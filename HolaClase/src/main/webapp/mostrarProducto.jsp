<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Producto Almacenado</title>
</head>
<body>
	<div>
		<h2>Producto almacenado</h2>
		<p>Nombre producto: ${nombre}</p>
		<p>Cantidad: <c:out value="${cantidad}"></c:out> </p>
		<br>
		<h3>mostrar nombre desde session: ${sessionScope.usuario}</h3>
	</div>
</body>
</html>