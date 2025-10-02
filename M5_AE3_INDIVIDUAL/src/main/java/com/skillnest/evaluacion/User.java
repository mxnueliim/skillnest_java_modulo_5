package com.skillnest.evaluacion;

public class User {
    private final String nombre;
    private final String email;
    private final String password;

    public User(String nombre, String email, String password) {
        this.nombre = nombre;
        this.email = email.toLowerCase();
        this.password = password;
    }
    public String getNombre() { return nombre; }
    public String getEmail()  { return email; }
    public String getPassword(){ return password; }
}
