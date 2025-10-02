<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head><meta charset="UTF-8"><title>Registro</title></head>
<body>
  <h1>Registro</h1>

  <%
    java.util.List<String> errores = (java.util.List<String>) request.getAttribute("errores");
    if (errores != null && !errores.isEmpty()) {
  %>
    <div style="color:red;">
      <ul>
        <% for (String e : errores) { %><li><%= e %></li><% } %>
      </ul>
    </div>
  <%
    }
    String valNombre = (String) request.getAttribute("valNombre");
    String valEmail  = (String) request.getAttribute("valEmail");
  %>

  <form method="post" action="<%=request.getContextPath()%>/registro">
    <label>Nombre:</label><br>
    <input type="text" name="nombre" value="<%= valNombre!=null?valNombre:"" %>"><br><br>

    <label>Correo electrónico:</label><br>
    <input type="email" name="email" value="<%= valEmail!=null?valEmail:"" %>"><br><br>

    <label>Contraseña (mín. 6):</label><br>
    <input type="password" name="password"><br><br>

    <button type="submit">Registrar</button>
  </form>

  <p><a href="<%=request.getContextPath()%>/login">Ir a login</a></p>
</body>
</html>
