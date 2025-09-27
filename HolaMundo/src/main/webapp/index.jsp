<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hola Mundo</title>
</head>
<body>
	<div><h1>Hola Mundo</h1></div>
	<p> Hoy veremos jsp y jstl</p>
	<a href="/HolaMundo/cliente">Desplegar servlet de Cliente</a>
	<br>
	<a href="cliente">Ver cliente</a>
	<br>
	<a href="productos">Ver productos</a>
	<br>
	<a href="agregarproducto">Agregar productos</a>
	
	<%!
	//signo de ! se ocupa para definir
	//aqui permite trabajar codigo java dentro
	
	String nombre = "Manuel";
	%>
	
	
	<ul>
	<%
	//for es de ejecucion, por eso <%! no lleva ! 
	for (int i = 0; i < 5; i++) { %>
	  <li> <%=i+1%> <%= nombre %></li>
	<% } %>
	</ul>
	
	<h2> <%=new Date() %></h2>
	<!-- JSTL -->
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
	
	<c:forEach var="item" items="${lista}">
	   <li>${item}</li>
	</c:forEach>
</body>
</html>