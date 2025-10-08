<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.skillnest.model.Producto" %>
<%
  List<Producto> productos = (List<Producto>) request.getAttribute("productos");
%>

<table border="1" cellpadding="6" cellspacing="0">
  <thead>
    <tr>
      <th>ID</th><th>Nombre</th><th>Precio</th><th>Descripción</th><th>Acción</th>
    </tr>
  </thead>
  <tbody>
  <%
    if (productos != null) {
      for (Producto p : productos) {
  %>
    <tr>
      <td><%= p.getId() %></td>
      <td><%= p.getNombre() %></td>
      <td><%= p.getPrecio() %></td>
      <td><%= p.getDescripcion() %></td>
      <td>
        <a href="<%= request.getContextPath() %>/productos?editId=<%= p.getId() %>">Editar</a>
        |
        <form action="<%= request.getContextPath() %>/productos" method="post" style="display:inline" onsubmit="return confirm('¿Eliminar?');">
          <input type="hidden" name="action" value="delete">
          <input type="hidden" name="id" value="<%= p.getId() %>">
          <button type="submit">Eliminar</button>
        </form>
      </td>
    </tr>
  <%
      }
    }
  %>
  </tbody>
</table>
