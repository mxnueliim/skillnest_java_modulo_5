<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Registrar producto</title>
  <%@ include file="/WEB-INF/includes/head.jspf" %>
</head>
<body class="min-h-screen bg-slate-100 text-slate-800 flex flex-col">
  <c:set var="pageTitle" value="Registro de producto" />
  <%@ include file="/WEB-INF/includes/nav.jspf" %>

  <main class="flex-1">
    <div class="container mx-auto px-4 py-8 max-w-xl">
      <h1 class="text-2xl font-semibold mb-6">Registrar producto</h1>

      <c:if test="${not empty error}">
        <div class="mb-4 rounded-lg border border-red-200 bg-red-50 p-3 text-red-700">
          ${error}
        </div>
      </c:if>

      <form action="${pageContext.request.contextPath}/registrar" method="post" class="space-y-4 bg-white p-6 rounded-xl shadow">
        <div>
          <label class="block text-sm font-medium text-slate-700 mb-1">Nombre</label>
          <input type="text" name="nombre" required
                 class="w-full rounded-lg border border-slate-300 px-3 py-2 focus:outline-none focus:ring-2 focus:ring-cyan-500">
        </div>

        <div>
          <label class="block text-sm font-medium text-slate-700 mb-1">Precio</label>
          <input type="number" name="precio" min="0" required
                 class="w-full rounded-lg border border-slate-300 px-3 py-2 focus:outline-none focus:ring-2 focus:ring-cyan-500">
        </div>

        <div>
          <label class="block text-sm font-medium text-slate-700 mb-1">Descripción</label>
          <textarea name="descripcion" rows="3" required
                    class="w-full rounded-lg border border-slate-300 px-3 py-2 focus:outline-none focus:ring-2 focus:ring-cyan-500"></textarea>
        </div>

        <div class="flex items-center gap-3">
          <button type="submit"
                  class="inline-flex items-center rounded-lg bg-cyan-600 px-4 py-2 text-white hover:bg-cyan-700">
            Guardar
          </button>
          <a href="${pageContext.request.contextPath}/productos"
             class="text-slate-600 hover:text-cyan-700">Ver listado</a>
        </div>
      </form>
    </div>
  </main>

  <%@ include file="/WEB-INF/includes/foot.jspf" %>
</body>
</html>
