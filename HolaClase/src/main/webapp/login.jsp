<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h2>Ingreso al sistema web</h2>
		 <c:if test="${not empty error}">
			<div class="alert alert-danger" role="alert">
			  	<c:out value="${error}"></c:out> 
			</div>
		</c:if>
		<form action="login" method="post">
		  <div class="mb-3">
		    <label for="email" class="form-label">Email address</label>
		    <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp">
		    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
		    
		  </div>
		  <div class="mb-3">
		    <label for="nombre" class="form-label">Name</label>
		    <input type="text" class="form-control" id="nombre" name="nombre">
		  </div>
		  <div class="mb-3">
		    <label for="password" class="form-label">Password</label>
		    <input type="password" class="form-control" id="password" name="password">
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form>
		
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>