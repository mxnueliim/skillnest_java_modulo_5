package com.skillnest.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/sesion")
public class Sesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Sesion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Obtener la sesión actual o crear una nueva
		HttpSession session = request.getSession();
		
		// Recuperar la sesión y el atributo
		//HttpSession session = request.getSession(false);
		String usuario = (String) session.getAttribute("usuario");
		System.out.println(usuario);
		

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
		    for (Cookie cookie : cookies) {
		        if ("nombre_usuario".equals(cookie.getName())) {
		            String nombre_usuario = cookie.getValue();
		            System.out.println(nombre_usuario);
		        }
		    }
		}
		
		//session.invalidate();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
