<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head><meta charset="UTF-8"><title>Login</title></head>
<body>
  <h1>Iniciar sesión</h1>

  <%
    String error = request.getParameter("error");
    if ("1".equals(error)) {
  %>
    <div style="color:red;">Credenciales inválidas.</div>
  <%
    }
  %>

  <form method="post" action="<%=request.getContextPath()%>/login">
    <label>Nombre de usuario:</label><br>
    <input type="text" name="nombre"><br><br>

    <label>Contraseña:</label><br>
    <input type="password" name="password"><br><br>

    <button type="submit">Entrar</button>
  </form>

  <p><a href="<%=request.getContextPath()%>/registro">Ir a registro</a></p>
</body>
</html>
