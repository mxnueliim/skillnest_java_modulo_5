// src/main/java/com/skillnest/controller/ProductoController.java
package com.skillnest.controller;

import com.skillnest.model.Producto;
import com.skillnest.model.ProductoDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.util.List;

@WebServlet("/productos")
public class ProductoController extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final ProductoDAO dao = new ProductoDAO();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {

	    // 1) Si viene ?editId=XX → cargar y mostrar el formulario de edición
	    String editId = req.getParameter("editId");
	    if (editId != null && !editId.isBlank()) {
	        try {
	            int id = Integer.parseInt(editId);
	            Producto p = dao.obtenerPorId(id);
	            if (p != null) {
	                req.setAttribute("producto", p);
	                req.getRequestDispatcher("/WEB-INF/productos/edit.jsp").forward(req, resp);
	                return;
	            }
	        } catch (NumberFormatException ignored) {
	            // si no es número, cae al listado
	        }
	        // si no existe el producto o el id es inválido → volver al listado
	        resp.sendRedirect(req.getContextPath() + "/productos");
	        return;
	    }

	    // 2) Sin editId → listar en el dashboard (como ya lo tenías)
	    List<Producto> productos = dao.obtenerTodos();
	    req.setAttribute("productos", productos);
	    req.getRequestDispatcher("/dashboard.jsp").forward(req, resp);
	}

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action"); // create | update | delete

        if ("create".equals(action)) {
            dao.crear(new Producto(
                0,
                req.getParameter("nombre").trim(),
                Integer.parseInt(req.getParameter("precio")),
                (req.getParameter("descripcion") == null ? "" : req.getParameter("descripcion").trim())
            ));
        } else if ("update".equals(action)) {
            dao.actualizar(new Producto(
                Integer.parseInt(req.getParameter("id")),
                req.getParameter("nombre").trim(),
                Integer.parseInt(req.getParameter("precio")),
                (req.getParameter("descripcion") == null ? "" : req.getParameter("descripcion").trim())
            ));
        } else if ("delete".equals(action)) {
            dao.eliminar(Integer.parseInt(req.getParameter("id")));
        }

        resp.sendRedirect(req.getContextPath() + "/productos");
    }
}
