package com.skillnest.web.servlets;

import java.io.IOException;

import com.skillnest.web.DAO.ProductoDAO;
import com.skillnest.web.DAO.ProductoDAOImpl;
import com.skillnest.web.DTO.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductoCrearServlet", urlPatterns = {"/registrar"})
public class ProductoCrearServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ProductoDAO productoDAO;

    @Override
    public void init() throws ServletException {
        productoDAO = new ProductoDAOImpl();
    }

    // GET -> muestra el formulario
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/registrar.jsp").forward(request, response);
    }

    // POST -> valida, guarda y redirige al listado
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String precioStr = request.getParameter("precio");
        String descripcion = request.getParameter("descripcion");

        // Validación sencilla
        if (nombre == null || nombre.isBlank() ||
            precioStr == null || precioStr.isBlank() ||
            descripcion == null || descripcion.isBlank()) {
            request.setAttribute("error", "Todos los campos son obligatorios.");
            request.getRequestDispatcher("/WEB-INF/views/registrar.jsp").forward(request, response);
            return;
        }

        int precio;
        try {
            precio = Integer.parseInt(precioStr);
            if (precio < 0) throw new NumberFormatException("precio negativo");
        } catch (NumberFormatException ex) {
            request.setAttribute("error", "El precio debe ser un número entero válido (>= 0).");
            request.getRequestDispatcher("/WEB-INF/views/registrar.jsp").forward(request, response);
            return;
        }

        Producto p = new Producto(nombre, precio, descripcion);
        productoDAO.crear(p);

        // PRG: Post/Redirect/Get
        response.sendRedirect(request.getContextPath() + "/productos?ok=1");
    }
}
