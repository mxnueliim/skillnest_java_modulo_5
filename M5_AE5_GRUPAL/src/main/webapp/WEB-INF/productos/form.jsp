<%@ page contentType="text/html; charset=UTF-8" %>
<h3>Nuevo producto</h3>
<form action="${pageContext.request.contextPath}/productos" method="post">
    <input type="hidden" name="action" value="create">

    <label>Nombre</label><br>
    <input type="text" name="nombre" required><br><br>

    <label>Precio</label><br>
    <input type="number" name="precio" required><br><br>

    <label>Descripción</label><br>
    <textarea name="descripcion" rows="3"></textarea><br><br>

    <button type="submit">Agregar</button>
</form>
