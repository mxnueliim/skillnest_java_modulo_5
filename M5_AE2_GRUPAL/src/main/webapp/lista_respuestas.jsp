<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de respuestas</title>
</head>
<body>
    <h1>Respuestas simuladas</h1>

    <c:if test="${empty respuestas}">
        <p>No hay respuestas.</p>
    </c:if>

    <c:forEach var="r" items="${respuestas}">
        <div style="margin-bottom:10px; padding:8px; border:1px solid #ccc;
             <c:if test='${r.calificacion < 3}'>background-color:#ffe6e6;</c:if>">
            <p><strong>Nombre:</strong> <c:out value="${r.nombre}"/></p>
            <p><strong>Edad:</strong> <c:out value="${r.edad}"/></p>
            <p><strong>Calificación:</strong> <c:out value="${r.calificacion}"/></p>
            <p><strong>Comentario:</strong> <c:out value="${r.comentario}"/></p>

            <c:if test="${r.calificacion < 3}">
                <p style="color:red;"><strong>Calificación baja — revisar feedback.</strong></p>
            </c:if>
        </div>
    </c:forEach>

    <p><a href="${pageContext.request.contextPath}/encuesta">Volver a la encuesta</a></p>
</body>
</html>
