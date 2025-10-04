<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<script src="https://cdn.tailwindcss.com"></script>
<head>
<meta charset="UTF-8">
<title>Evaluacion 4 - Modulo 5</title>
</head>
<%@ include file="/WEB-INF/includes/head.jspf" %>
<body class="min-h-screen bg-slate-100 text-slate-800 flex flex-col">
  <c:set var="pageTitle" value="Inicio" />
  <%@ include file="/WEB-INF/includes/nav.jspf" %>

  <main class="flex-1">
    <div class="container mx-auto px-4 py-8">
      
      <div class="grid grid-cols-1 sm:grid-cols-2 gap-6">
        <a href="${pageContext.request.contextPath}/registrar"
           class="group block rounded-xl border border-slate-200 bg-white p-6 shadow-sm hover:shadow-md transition">
          <h2 class="text-lg font-medium text-slate-900 group-hover:text-cyan-700">Registro de productos</h2>
          <p class="mt-2 text-sm text-slate-500">Agrega un nuevo producto.</p>
        </a>

        <a href="${pageContext.request.contextPath}/productos"
           class="group block rounded-xl border border-slate-200 bg-white p-6 shadow-sm hover:shadow-md transition">
          <h2 class="text-lg font-medium text-slate-900 group-hover:text-cyan-700">Listado de productos</h2>
          <p class="mt-2 text-sm text-slate-500">Revisa la tabla disponible.</p>
        </a>
      </div>
    </div>
  </main>

  <%@ include file="/WEB-INF/includes/foot.jspf" %>
</body>

</html>