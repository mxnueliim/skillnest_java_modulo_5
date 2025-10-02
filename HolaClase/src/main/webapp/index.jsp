<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hola Clase</title>
</head>
<body>
	<div>
		<h1>Hola Clase</h1>
		<p> hoy veremos jsp y jstl</p>
		<a href="/HolaClase/cliente"> Desplegar servlet de Cliente</a>
		<br>
		<a href="cliente"> Desplegar servlet de Cliente</a>
		<br>
		<a href="productos">Ver productos</a>
		<br>
		<a href="agregar">Agregar productos</a>
		<hr>
		
		<%!
			//bloque de definicion
			String nombre= "Israel";
		
		%>
		<ul>
		<%//bloque de ejecucion
			for(int i = 0; i<5;i++){%>
			
				<li><%= i %> <%= nombre %></li>
		
		<%	} %>
		</ul>
		
		<h2><%= new Date() %></h2>
		
		<!--    JSTL  -->
		<h3><c:out value="${nombre}" /></h3>
		
		<c:if test="${numero > 0}">
			<p>El número es positivo</p>
		</c:if>
		
		<c:choose>
			<c:when test="${opcion == 'A'}">
				<p>Seleccionaste la opción A</p>
			</c:when>
			<c:when test="${opcion == 'B'}">
			    <p>Seleccionaste la opción B</p>
			</c:when>
			<c:otherwise>
				<p>No seleccionaste ninguna opción</p>
			</c:otherwise>
		</c:choose>
		
</body>
</html>