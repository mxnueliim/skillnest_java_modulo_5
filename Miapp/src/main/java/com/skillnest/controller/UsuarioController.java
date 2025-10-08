package com.skillnest.controller;

import java.io.IOException;

import com.skillnest.model.Usuario;
import com.skillnest.model.UsuarioDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        // Obtener el usuario desde el modelo
        Usuario usuario = usuarioDAO.obtenerUsuarioPorId(id);
        
        // Pasar el usuario a la vista
        request.setAttribute("usuario", usuario);
        RequestDispatcher dispatcher = request.getRequestDispatcher("usuario.jsp");
        dispatcher.forward(request, response);
    }
}
