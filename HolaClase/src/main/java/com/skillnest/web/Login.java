package com.skillnest.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//captura de datos enviados desde el jsp
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		if (nombre == null || nombre.isEmpty()) {
		    request.setAttribute("error", "El nombre es obligatorio");
		    request.getRequestDispatcher("/login.jsp").forward(request, response);
		    return;
		}

		if (email == null || !email.contains("@")) {
		    request.setAttribute("error", "El correo electrónico es inválido");
		    request.getRequestDispatcher("/login.jsp").forward(request, response);
		    return;
		}
		//pendiente validar password
		
        // Guardar en sesión
        HttpSession session = request.getSession();
        session.setAttribute("usuario", nombre);
        session.setAttribute("email", email);

        // Crear cookie
        Cookie cookie = new Cookie("usuario", nombre);
        cookie.setMaxAge(60 * 60); // 1 hora
        response.addCookie(cookie);

        // Redireccionar a bienvenida
        response.sendRedirect("bienvenida");
	}

}
