<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Vista: registro.jsp -->
<html>
<head>
    <title>Registro de Usuario</title>
</head>
<body>
    <form action="RegistroController" method="post">
        <label for="nombre">Nombre:</label>
        <input type="text" name="nombre" id="nombre" required><br>
        
        <label for="correo">Correo:</label>
        <input type="email" name="correo" id="correo" required><br>
        
        <label for="pass">Password:</label>
        <input type="password" name="pass" id="pass" required><br>
        
        <input type="submit" value="Registrar">
    </form>
</body>
</html>