<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Productos</title>
</head>
<body>
	<div>
		<h1><c:out value="${Titulo}"></c:out></h1>
		
		<ul>
			<c:forEach var="producto" items="${productos}">
			   <li>${producto} - <c:out value="${producto}" /></li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>