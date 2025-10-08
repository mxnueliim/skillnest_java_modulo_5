<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
    <h2>Detalles del usuario</h2>
    <p>Nombre: ${usuario.nombre}</p>
    <p>Correo: ${usuario.correo}</p>

    <hr>

    <h2>Productos</h2>

    <jsp:include page="/WEB-INF/productos/form.jsp" />
    <br/>
    <jsp:include page="/WEB-INF/productos/tabla.jsp" />
</body>
</html>
