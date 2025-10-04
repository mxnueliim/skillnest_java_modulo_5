package com.skillnest.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.skillnest.web.DAO.UsuarioDAOImpl;
import com.skillnest.web.DTO.Usuario;


@WebServlet(name = "agregarusuario", urlPatterns = { "/agregarusuario" })
public class AgregarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	//inyeccion del DAO
	private final UsuarioDAOImpl userDao = new UsuarioDAOImpl();
	
    public AgregarUsuario() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Obtener parámetros del formulario
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");

        // Crear el DTO
        /*Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setCorreo(correo);*/

        Usuario usuario = new Usuario(nombre, correo);
        
        // Llamar al DAO
        //UsuarioDAO dao = new UsuarioDAOImpl();
        //dao.crear(usuario);
        userDao.crear(usuario);

        List<Usuario> lista = userDao.obtenerTodos();

        // Pasamos la lista como atributo a la JSP
        request.setAttribute("usuarios", lista);
        request.getRequestDispatcher("usuarios.jsp").forward(request, response);
	}

}
