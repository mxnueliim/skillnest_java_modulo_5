package com.skillnest.web.DAO;

import java.util.List;

import com.skillnest.web.DTO.Producto;

public interface ProductoDAO {
	void crear(Producto producto);
	List<Producto> obtenerTodos();
	void eliminar(int id);
	void actualizar(Producto producto);

}
