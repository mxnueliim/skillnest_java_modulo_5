<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="jakarta.servlet.http.Cookie" %>
<!DOCTYPE html>
<html lang="es">
<head><meta charset="UTF-8"><title>Bienvenida</title></head>
<body>
<%
  String nombre = (String) request.getAttribute("nombre"); // desde servlet
  if (nombre == null || nombre.isBlank()) {
      Object s = session.getAttribute("usuario");          // Sesión
      if (s != null) nombre = s.toString();
  }
  if (nombre == null || nombre.isBlank()) {
      Cookie[] cookies = request.getCookies();
      if (cookies != null) {
          for (Cookie ck : cookies) {
              if ("usuario".equals(ck.getName())) {
                  nombre = java.net.URLDecoder.decode(ck.getValue(), java.nio.charset.StandardCharsets.UTF_8);
                  break;
              }
          }
      }
  }
  if (nombre == null || nombre.isBlank()) {
      String qn = request.getParameter("nombre");
      if (qn != null && !qn.isBlank()) nombre = qn;
  }
%>

  <h1>¡Bienvenido <%= (nombre != null && !nombre.isBlank()) ? nombre : "Visitante" %>!</h1>
  <p><a href="<%=request.getContextPath()%>/login">Login</a> | <a href="<%=request.getContextPath()%>/registro">Registro</a></p>
</body>
</html>
