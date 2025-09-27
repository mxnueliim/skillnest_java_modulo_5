<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ include file="/WEB-INF/includes/head.jspf" %>

<body class="min-h-screen bg-slate-100 text-slate-800 flex flex-col">
  <c:set var="pageTitle" value="Mostrar productos" />
  <%@ include file="/WEB-INF/includes/nav.jspf" %>

  <main class="flex-1">
    <div class="container mx-auto px-4 py-8">

      <div class="bg-white rounded-xl border border-slate-200 shadow-sm p-6">
        <h2 class="text-lg font-semibold text-slate-900 mb-4">Listado de productos</h2>

        <div class="overflow-x-auto">
          <table class="min-w-full border border-slate-200 rounded-lg overflow-hidden">
            <thead class="bg-slate-50">
              <tr class="text-left text-slate-700">
                <th class="px-4 py-3 text-sm font-medium">Nombre</th>
                <th class="px-4 py-3 text-sm font-medium">Categoría</th>
                <th class="px-4 py-3 text-sm font-medium">Precio</th>
                <th class="px-4 py-3 text-sm font-medium">Oferta</th>
              </tr>
            </thead>
            <tbody class="divide-y divide-slate-200">
              <c:forEach var="p" items="${productos}">
                <tr class="hover:bg-slate-50">
                  <!-- Nombre + longitud -->
                  <td class="px-4 py-3 align-top">
                    <div class="text-slate-900"><c:out value="${p.nombre}"/></div>
                    <div class="text-xs text-slate-500">longitud: ${fn:length(p.nombre)} caracteres</div>
                  </td>

                  <!-- Categoría con choose -->
                  <td class="px-4 py-3 align-top">
                    <c:choose>
                      <c:when test="${p.categoria == 'electronica'}">Electrónica</c:when>
                      <c:when test="${p.categoria == 'hogar'}">Hogar</c:when>
                      <c:when test="${p.categoria == 'moda' || p.categoria == 'vestuario'}">Vestuario / Moda</c:when>
                      <c:otherwise><c:out value="${p.categoria}"/></c:otherwise>
                    </c:choose>
                  </td>

                  <!-- Precio validado -->
                  <td class="px-4 py-3 align-top">
                    <c:choose>
                      <c:when test="${p.precio != null and p.precio >= 0}">
                        <span class="font-medium text-slate-900">$ <c:out value="${p.precio}"/></span>
                      </c:when>
                      <c:otherwise>
                        <span class="text-red-600 font-medium">Precio inválido</span>
                      </c:otherwise>
                    </c:choose>
                  </td>

                  <!-- Oferta + badge -->
                  <td class="px-4 py-3 align-top">
                    <c:out value="${p.oferta ? 'Sí' : 'No'}"/>
                    <c:if test="${p.oferta}">
                      <span class="ml-2 inline-flex items-center rounded-full bg-green-100 px-2 py-0.5 text-xs font-medium text-green-700">
                        ¡En oferta!
                      </span>
                    </c:if>
                  </td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
      </div>

    </div>
  </main>

  <%@ include file="/WEB-INF/includes/foot.jspf" %>
</body>
</html>
