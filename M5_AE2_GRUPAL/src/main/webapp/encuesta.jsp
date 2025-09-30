<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Encuesta</title>
</head>
<body>
	<h1>Encuesta</h1>

	<form action="${pageContext.request.contextPath}/resultados" method="post">

          <!-- Nombre -->
          <div>
            <label for="nombre" >Nombre</label>
            <input
              type="text" id="nombre" name="nombre" required/>
          </div>
          
          <!-- Edad -->
          <div>
            <label for="edad" >Edad</label>
            <input
              type="number" id="edad" name="edad" required/>
          </div>

          <!-- Recomendacion -->
          <div>
            <label for="recomendacion" >¿Recomendarías este sitio a otros?</label>
            <input type="radio" id="si" name="recomienda" value="si" required>
        	<label for="si">Sí</label><br>
        	<input type="radio" id="no" name="recomienda" value="no">
        	<label for="no">No</label><br>
          </div>
          
          <!-- Calificación -->
          <div>
            <label for="calificacion">Calificación</label>
            <select id="calificacion" name="calificacion" required>
                <option value="" disabled selected>Selecciona…</option>
                <c:forEach var="n" begin="1" end="5">
                    <option value="${n}">${n}</option>
                </c:forEach>
            </select>
        </div>

          <!-- Comentario adicional -->
          <div>
            <label for="comentario">Comentario adicional</label><br>
            <textarea id="comentario" name="comentario" rows="3" cols="40" required></textarea>
        </div>


          <!-- Botón -->
          <div>
            <button type="submit">
              Enviar
            </button>
          </div>
        </form>
</body>
</html>