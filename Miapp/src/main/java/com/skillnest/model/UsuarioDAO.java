package com.skillnest.model;

import java.sql.*;

import com.skillnest.util.ConexionDB;

public class UsuarioDAO {
	private Connection conn;

    public UsuarioDAO() {
        conn = ConexionDB.getInstancia().getConexion();
    }

    public void guardar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, correo,password) VALUES (?, ?, ?)";

        try {
           
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getPassword());
            ps.executeUpdate();
            ps.close();
            System.out.println("Usuario agregado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Usuario obtenerUsuarioPorId(int id) {
        Usuario usuario = null;
        String sql = "SELECT nombre, correo FROM usuarios WHERE id = ?";
        
        try {
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setNombre(rs.getString("nombre"));
                usuario.setCorreo(rs.getString("correo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
}
