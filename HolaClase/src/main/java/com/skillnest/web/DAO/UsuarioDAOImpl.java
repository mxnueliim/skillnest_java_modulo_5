package com.skillnest.web.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skillnest.web.DTO.Usuario;
import com.skillnest.web.util.ConexionDB;

public class UsuarioDAOImpl implements UsuarioDAO{
	
	private Connection conn;

    public UsuarioDAOImpl() {
        conn = ConexionDB.getInstancia().getConexion();
    }

	@Override
	//public void agregarUsuario(String nombre, String correo) {
		public void crear(Usuario usuario){
	        String sql = "INSERT INTO usuarios (nombre, correo) VALUES (?, ?)";
	        try {
	            //Connection conn = ConexionDB.getInstancia().getConexion();
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, usuario.getNombre());
	            ps.setString(2, usuario.getCorreo());
	            ps.executeUpdate();
	            ps.close();
	            System.out.println("Usuario agregado exitosamente.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	@Override
	public List<Usuario> obtenerTodos() {
	    List<Usuario> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM usuarios";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("correo")
                );
                lista.add(usuario);
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
		
	}

	@Override
	public void actualizar(Usuario usuario) {
		try {
            String sql = "UPDATE usuarios SET nombre = ?, correo = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreo());
            ps.setInt(3, usuario.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

	public void eliminar(int id) {
        try {
            String sql = "DELETE FROM usuarios WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@Override
	public Usuario obtenerPorId(int id) {
		Usuario usuario = null;
        try {
            String sql = "SELECT * FROM usuarios WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new Usuario(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("correo")
                );
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
		
	}
}

