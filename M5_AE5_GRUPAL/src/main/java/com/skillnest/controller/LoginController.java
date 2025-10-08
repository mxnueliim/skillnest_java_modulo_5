package com.skillnest.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.skillnest.model.Usuario;
import com.skillnest.model.UsuarioDAO;

@WebServlet(name = "loginController", urlPatterns = { "/loginController" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String correo = request.getParameter("correo");
	    String password = request.getParameter("password");
	    
	    if (correo == null || correo.isBlank() || password == null || password.isBlank()) {
            request.setAttribute("error", "Debes completar correo y contraseña.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }
	    
	    Usuario usuario = usuarioDAO.autenticar(correo, password);
	    
	    if (usuario != null) {
            // éxito → guardar en sesión y redirigir a la vista protegida
            HttpSession session = request.getSession(true);
            session.setAttribute("usuario", usuario);
            session.setMaxInactiveInterval(30 * 60); 
            response.sendRedirect(request.getContextPath() + "/productos");
        } else {
            // fallo → volver al login con mensaje
            request.setAttribute("error", "Credenciales inválidas.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
	}

}
