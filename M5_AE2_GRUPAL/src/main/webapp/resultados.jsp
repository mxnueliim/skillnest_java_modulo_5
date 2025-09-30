<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultados</title>
</head>
<body>
    <h1>Resultados de la encuesta</h1>

    <p><strong>Nombre:</strong> <c:out value="${nombre}"/></p>
    <p><strong>Edad:</strong> <c:out value="${edad}"/></p>
    <p><strong>¿Recomendaría?:</strong> <c:out value="${recomienda}"/></p>
    <p><strong>Calificación:</strong> <c:out value="${calificacion}"/></p>
    <p><strong>Comentario:</strong> <c:out value="${comentario}"/></p>
    <p><em>Largo del comentario:</em> <c:out value="${fn:length(comentario)}"/> caracteres</p>

    <!-- Agradecimiento especial si calificación >= 4 -->
    <c:if test="${calificacion >= 4}">
        <p style="color:green;"><strong>¡Gracias por tu alta calificación!</strong></p>
    </c:if>

    <!-- Advertencia si edad < 18 -->
    <c:if test="${edad < 18}">
        <p style="color:orange;"><strong>Advertencia:</strong> Usuario menor de 18 años.</p>
    </c:if>

    <!-- Mensaje según recomendación -->
    <c:choose>
        <c:when test="${recomienda == 'si'}">
            <p>¡Nos alegra que nos recomiendes!</p>
        </c:when>
        <c:otherwise>
            <p>Gracias por tu sinceridad, mejoraremos.</p>
        </c:otherwise>
    </c:choose>

    <p><a href="${pageContext.request.contextPath}/lista_respuestas">Ver lista simulada de respuestas</a></p>
    <p><a href="${pageContext.request.contextPath}/encuesta">Volver a la encuesta</a></p>
</body>
</html>
