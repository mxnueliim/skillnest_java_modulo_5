package com.skillnest.web.DTO;

public class Producto {
	private int id;
    private String nombre;
    private int precio;
    private String descripcion;
    
    
	public Producto(String nombre, int precio, String descripcion) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
	}

	public Producto(int id, String nombre, int precio, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
    
    
}
