package com.skillnest.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "agregarproducto", urlPatterns = { "/agregarproducto" })
public class AgregarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AgregarProducto() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/agregarproducto.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//capturar los datos(parametros)
		String nombre =request.getParameter("nombre");
		String cantidad = request.getParameter("cantidad");
		
		System.out.println(nombre);
		System.out.println(cantidad);
		//almacenar los datos
		
		//traspasar datos capturados a otro jsp
		
		doGet(request, response);
	}

}
