package com.skillnest.web.productos;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Servlet implementation class Registrar
 */
@WebServlet(name = "registrar", urlPatterns = { "/registrar" })
public class Registrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Registrar() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/productos/registrar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre =request.getParameter("nombre");
		String categoria = request.getParameter("categoria");
		Double precio = null;
	        try {
	            String precioStr = request.getParameter("precio");
	            if (precioStr != null && !precioStr.isBlank()) {
	                precio = Double.valueOf(precioStr);
	            }
	        } catch (NumberFormatException e) {
	            request.setAttribute("errorPrecio", "Precio inválido");
	        }
	
	        // Checkbox: viene null si no está marcado
	        boolean oferta = request.getParameter("oferta") != null;

		request.setAttribute("nombre", nombre);
        request.setAttribute("categoria", categoria);
        request.setAttribute("precio", precio);
        request.setAttribute("oferta", oferta);

        request.getRequestDispatcher("/mostrar").forward(request, response);
	}

}
