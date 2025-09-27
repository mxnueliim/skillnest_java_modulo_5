<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Producto</title>
</head>
<body>
	<div>
		<h1>Formulario para agregar producto</h1>
		<form action="agregarproducto" method="post">
			<label for="nombre">Ingresa el nombre del producto</label>
			<input type="text" id="nombre" name="nombre" required/><br>
			
			<label for="cantidad">Ingresa la cantidad</label>
			<input type="number" id="cantidad" name="cantidad" required/><br>
			
			<br><input type="submit" value="enviar">
		</form>
	</div>
</body>
</html>