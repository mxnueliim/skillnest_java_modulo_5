package com.skillnest.web.DAO;

import java.util.List;

import com.skillnest.web.DTO.Usuario;

public interface UsuarioDAO {
	Usuario obtenerPorId(int id);
	//public void agregarUsuario(String nombre, String correo);
	void crear(Usuario usuario);
	//public void listarUsuarios();
	List<Usuario> obtenerTodos();
	void eliminar(int id);
	//public void actualizarCorreo(int id, String nuevoCorreo);
	void actualizar(Usuario usuario);
	
	

}
