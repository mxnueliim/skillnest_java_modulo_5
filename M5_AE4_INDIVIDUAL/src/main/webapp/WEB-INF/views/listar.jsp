<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Listado de productos</title>
  <%@ include file="/WEB-INF/includes/head.jspf" %>
</head>
<body class="min-h-screen bg-slate-100 text-slate-800 flex flex-col">
  <c:set var="pageTitle" value="Listado de productos" />
  <%@ include file="/WEB-INF/includes/nav.jspf" %>

  <main class="flex-1">
    <div class="container mx-auto px-4 py-8">
      <div class="mb-6 flex items-center justify-between">
        <h1 class="text-2xl font-semibold">Productos</h1>
        <a href="${pageContext.request.contextPath}/registrar"
           class="inline-flex items-center rounded-lg bg-cyan-600 px-4 py-2 text-white hover:bg-cyan-700">
          Nuevo producto
        </a>
      </div>

      <c:if test="${param.ok == '1'}">
        <div class="mb-4 rounded-lg border border-green-200 bg-green-50 p-3 text-green-700">
          Producto creado correctamente.
        </div>
      </c:if>

      <div class="overflow-x-auto rounded-xl border border-slate-200 bg-white shadow">
        <table class="min-w-full divide-y divide-slate-200">
          <thead class="bg-slate-50">
            <tr>
              <th class="px-4 py-3 text-left text-xs font-medium uppercase tracking-wider text-slate-600">ID</th>
              <th class="px-4 py-3 text-left text-xs font-medium uppercase tracking-wider text-slate-600">Nombre</th>
              <th class="px-4 py-3 text-left text-xs font-medium uppercase tracking-wider text-slate-600">Precio</th>
              <th class="px-4 py-3 text-left text-xs font-medium uppercase tracking-wider text-slate-600">Descripción</th>
              <th class="px-4 py-3"></th>
            </tr>
          </thead>
          <tbody class="divide-y divide-slate-200">
            <c:forEach var="p" items="${productos}">
              <tr class="hover:bg-slate-50">
                <td class="px-4 py-3 text-sm text-slate-700">${p.id}</td>
                <td class="px-4 py-3 text-sm text-slate-700">${p.nombre}</td>
                <td class="px-4 py-3 text-sm text-slate-700">$ ${p.precio}</td>
                <td class="px-4 py-3 text-sm text-slate-700">${p.descripcion}</td>
                <td class="px-4 py-3 text-right">
                  <form action="${pageContext.request.contextPath}/eliminar" method="post"
                        onsubmit="return confirm('¿Eliminar el producto #${p.id}?');">
                    <input type="hidden" name="id" value="${p.id}">
                    <button type="submit"
                            class="rounded-lg border border-red-300 bg-red-50 px-3 py-1 text-sm text-red-700 hover:bg-red-100">
                      Eliminar
                    </button>
                  </form>
                </td>
              </tr>
            </c:forEach>

            <c:if test="${empty productos}">
              <tr>
                <td colspan="5" class="px-4 py-6 text-center text-slate-500">No hay productos registrados.</td>
              </tr>
            </c:if>
          </tbody>
        </table>
      </div>
    </div>
  </main>

  <%@ include file="/WEB-INF/includes/foot.jspf" %>
</body>
</html>
