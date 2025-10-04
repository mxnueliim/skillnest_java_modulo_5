package com.skillnest.web.servlets;

import java.io.IOException;

import com.skillnest.web.DAO.ProductoDAO;
import com.skillnest.web.DAO.ProductoDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductoEliminarServlet", urlPatterns = {"/eliminar"})
public class ProductoEliminarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ProductoDAO productoDAO;

    @Override
    public void init() throws ServletException {
        productoDAO = new ProductoDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if (idStr != null && !idStr.isBlank()) {
            try {
                int id = Integer.parseInt(idStr);
                productoDAO.eliminar(id);
            } catch (NumberFormatException ignored) {}
        }
        response.sendRedirect(request.getContextPath() + "/productos");
    }
}
