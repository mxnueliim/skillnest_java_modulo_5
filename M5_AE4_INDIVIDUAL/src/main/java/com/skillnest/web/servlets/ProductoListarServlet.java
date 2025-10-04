package com.skillnest.web.servlets;

import java.io.IOException;
import java.util.List;

import com.skillnest.web.DAO.ProductoDAO;
import com.skillnest.web.DAO.ProductoDAOImpl;
import com.skillnest.web.DTO.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductoListarServlet", urlPatterns = {"/productos"})
public class ProductoListarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ProductoDAO productoDAO;

    @Override
    public void init() throws ServletException {
        productoDAO = new ProductoDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Producto> productos = productoDAO.obtenerTodos();
        request.setAttribute("productos", productos);
        request.getRequestDispatcher("/WEB-INF/views/listar.jsp").forward(request, response);
    }
}
