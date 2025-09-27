<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ include file="/WEB-INF/includes/head.jspf" %>

<body class="min-h-screen bg-slate-100 text-slate-800 flex flex-col">
  <c:set var="pageTitle" value="Registro de productos" />
  <%@ include file="/WEB-INF/includes/nav.jspf" %>

  <main class="flex-1">
    <div class="container mx-auto px-4 py-8">
      <div class="max-w-xl mx-auto bg-white rounded-xl border border-slate-200 shadow-sm p-6">
        <h2 class="text-lg font-semibold text-slate-900 mb-4">Nuevo producto</h2>

        <form action="${pageContext.request.contextPath}/registrar" method="post" class="space-y-5">
          <!-- Nombre -->
          <div>
            <label for="nombre" class="block text-sm font-medium text-slate-700">Nombre del producto</label>
            <input
              type="text" id="nombre" name="nombre" required
              class="mt-1 block w-full rounded-lg border border-slate-300 bg-white px-3 py-2 text-sm
                     placeholder-slate-400 focus:outline-none focus:ring-2 focus:ring-cyan-500 focus:border-cyan-500" />
          </div>

          <!-- Categoría -->
          <div>
            <label for="categoria" class="block text-sm font-medium text-slate-700">Categoría</label>
            <select
              id="categoria" name="categoria" required
              class="mt-1 block w-full rounded-lg border border-slate-300 bg-white px-3 py-2 text-sm
                     focus:outline-none focus:ring-2 focus:ring-cyan-500 focus:border-cyan-500">
              <option value="" disabled selected>Seleccione…</option>
              <option value="electronica">Electrónica</option>
              <option value="hogar">Hogar</option>
              <option value="moda">Moda</option>
            </select>
          </div>

          <!-- Precio -->
          <div>
            <label for="precio" class="block text-sm font-medium text-slate-700">Precio</label>
            <input
              type="number" id="precio" name="precio" step="0.01" min="0" required
              class="mt-1 block w-full rounded-lg border border-slate-300 bg-white px-3 py-2 text-sm
                     placeholder-slate-400 focus:outline-none focus:ring-2 focus:ring-cyan-500 focus:border-cyan-500" />
          </div>

          <!-- Oferta -->
          <div class="flex items-center gap-2">
            <input
              id="oferta" type="checkbox" name="oferta" value="si"
              class="h-4 w-4 rounded border-slate-300 text-cyan-600 focus:ring-cyan-500" />
            <label for="oferta" class="text-sm text-slate-700">¿Está en oferta?</label>
          </div>

          <!-- Botón -->
          <div class="pt-2">
            <button type="submit"
              class="inline-flex items-center rounded-lg bg-cyan-600 px-4 py-2 text-sm font-medium text-white
                     hover:bg-cyan-700 focus:outline-none focus:ring-2 focus:ring-cyan-500 focus:ring-offset-2">
              Enviar
            </button>
          </div>
        </form>
      </div>
    </div>
  </main>

  <%@ include file="/WEB-INF/includes/foot.jspf" %>
</body>
</html>
