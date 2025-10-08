<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.skillnest.model.Producto" %>
<%
  Producto p = (Producto) request.getAttribute("producto");
  if (p == null) {
      response.sendRedirect(request.getContextPath() + "/productos");
      return;
  }
%>
<!DOCTYPE html>
<html>
<body>
  <h3>Editar producto</h3>
  <form action="<%= request.getContextPath() %>/productos" method="post">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="<%= p.getId() %>">

    <label>Nombre</label><br>
    <input type="text" name="nombre" required value="<%= p.getNombre() %>"><br><br>

    <label>Precio</label><br>
    <input type="number" name="precio" required value="<%= p.getPrecio() %>"><br><br>

    <label>Descripción</label><br>
    <textarea name="descripcion" rows="3"><%= p.getDescripcion() %></textarea><br><br>

    <button type="submit">Actualizar</button>
    <a href="<%= request.getContextPath() %>/productos">Volver</a>
  </form>
</body>
</html>
