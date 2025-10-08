package com.skillnest.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.skillnest.model.Usuario;
import com.skillnest.model.UsuarioDAO;

//Controlador: RegistroController.java
@WebServlet("/RegistroController")
public class RegistroController extends HttpServlet {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();

 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String nombre = request.getParameter("nombre");
     String correo = request.getParameter("correo");
     String password = request.getParameter("pass");

     // Crear un objeto de usuario y establecer valores
     Usuario usuario = new Usuario();
     usuario.setNombre(nombre);
     usuario.setCorreo(correo);
     usuario.setPassword(password);

     usuarioDAO.guardar(usuario);
     // Guardar el usuario en la base de datos
     // Aquí iría el código para guardar en la base de datos
     // Por ejemplo, un DAO que interactúa con la base de datos.

     // Redirigir a una página de confirmación
     response.sendRedirect("confirmacion.jsp");
 }
}
