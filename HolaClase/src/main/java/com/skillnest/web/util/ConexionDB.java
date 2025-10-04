package com.skillnest.web.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB {
    private static ConexionDB instancia;
    private Connection conexion;
    private final String URL = "jdbc:mysql://localhost:3306/gestion_usuarios";
    private final String USUARIO = "root";
    private final String CONTRASENA = "Admin1234.";

    private ConexionDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ConexionDB getInstancia() {
        if (instancia == null) {
            instancia = new ConexionDB();
        }
        return instancia;
    }

    public Connection getConexion() {
        return conexion;
    }
}
