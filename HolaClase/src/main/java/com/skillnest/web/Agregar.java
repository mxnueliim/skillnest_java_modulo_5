package com.skillnest.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/agregar")
public class Agregar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Agregar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/agregarProducto.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//capturar los datos(parametros)
		String nombre =request.getParameter("nombre");
		String cantidad = request.getParameter("cantidad");
		
		//System.out.println(nombre);
		//System.out.println(cantidad);
		//Obtener la sesión actual o crear una nueva
		HttpSession session = request.getSession();
		//guardar atributo en session; usuario="Juan Perez"
		session.setAttribute("usuario", nombre);
		
		//agregar cookie
		Cookie cookie = new Cookie("nombre_usuario", nombre);
		cookie.setMaxAge(60*60); // La cookie expirará en 1 hora
		response.addCookie(cookie);
		
		//almacenar los datos
		
		//traspasar datos capturados a otro jsp
		request.setAttribute("nombre", nombre);
		request.setAttribute("cantidad", cantidad);
		
		//request.getRequestDispatcher("/mostrarProducto.jsp").forward(request, response);
		request.getRequestDispatcher("/home").forward(request, response);
	}

}
