package com.skillnest.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skillnest.util.ConexionDB;

public class ProductoDAO {

	private Connection conn;

    public ProductoDAO() {
        conn = ConexionDB.getInstancia().getConexion();
    }

	public void crear(Producto producto) {
		String sql = "INSERT INTO productos (nombre, precio, descripcion) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setInt(2, producto.getPrecio());
            ps.setString(3, producto.getDescripcion());
            ps.executeUpdate();
            ps.close();
            System.out.println("Producto agregado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}
	
	public List<Producto> obtenerTodos() {
		List<Producto> lista = new ArrayList<>();
        try {
            String sql = "SELECT id, nombre, precio, descripcion FROM productos";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto(
                	rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("precio"),
                    rs.getString("descripcion")
                );
                lista.add(producto);
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
	}

	public Producto obtenerPorId(int id) {
	    String sql = "SELECT id, nombre, precio, descripcion FROM productos WHERE id = ?";
	    try (PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setInt(1, id);
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                return new Producto(
	                    rs.getInt("id"),
	                    rs.getString("nombre"),
	                    rs.getInt("precio"),
	                    rs.getString("descripcion")
	                );
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	public void eliminar(int id) {
		try {
            String sql = "DELETE FROM productos WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

	public void actualizar(Producto producto) {
		try {
            String sql = "UPDATE productos SET nombre = ?, precio = ?, descripcion = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setInt(2, producto.getPrecio());
            ps.setString(3, producto.getDescripcion());
            ps.setInt(4, producto.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
}
