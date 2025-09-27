package com.skillnest.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*; // o se puede especificar por lo necesario

/**
 * Servlet implementation class Productos
 */
@WebServlet(name = "productos", urlPatterns = { "/productos" })
public class Productos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Productos() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//estructura con varios datos
		List<String> productos = Arrays.asList("Lapices","Cuadernos","Carpetas","Regla");
		//agregar atributo al request
		request.setAttribute("productos", productos);
		request.setAttribute("Titulo", "Lista de todos los productos");
		//envio al jsp
		request.getRequestDispatcher("/producto.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
