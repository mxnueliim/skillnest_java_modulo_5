package com.skillnest.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet(name = "sesion", urlPatterns = { "/sesion" })
public class Sesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Sesion() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Obtener la sesión actual o crear una nueva
		HttpSession session = request.getSession(true);
		// Guardar atributo en sesion
		session.setAttribute("usuario", "Juan Perez");
		// Recuperar la sesión y el atributo
		//HttpSession session = request.getSession(false);
		String usuario = (String) session.getAttribute("usuario");
		
		Cookie cookie = new Cookie("nombre_usuario", "Juan Perez");
		cookie.setMaxAge(60*60); // La cookie expirará en 1 hora
		response.addCookie(cookie);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
