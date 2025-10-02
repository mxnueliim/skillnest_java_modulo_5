package com.skillnest.evaluacion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

@WebServlet(name="RegistroServlet", urlPatterns={"/registro"})
public class RegistroServlet extends HttpServlet {

    @SuppressWarnings("unchecked")
    private Map<String, User> getUserStore() {
        var ctx = getServletContext();
        Object obj = ctx.getAttribute("USERS");
        if (obj == null) {
            Map<String, User> store = new ConcurrentHashMap<>();
            ctx.setAttribute("USERS", store);
            return store;
        }
        return (Map<String, User>) obj;
    }

    private static boolean emailValido(String email) {
        if (email == null) return false;
        String regex = "^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$";
        return Pattern.compile(regex).matcher(email).matches();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/registro.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String nombre = Optional.ofNullable(req.getParameter("nombre")).orElse("").trim();
        String email  = Optional.ofNullable(req.getParameter("email")).orElse("").trim().toLowerCase();
        String pass   = Optional.ofNullable(req.getParameter("password")).orElse("").trim();

        List<String> errores = new ArrayList<>();
        if (nombre.isEmpty()) errores.add("El nombre es obligatorio.");
        if (email.isEmpty() || !emailValido(email)) errores.add("Correo electrónico inválido.");
        if (pass.length() < 6) errores.add("La contraseña debe tener al menos 6 caracteres.");

        if (!errores.isEmpty()) {
            req.setAttribute("errores", errores);
            req.setAttribute("valNombre", nombre);
            req.setAttribute("valEmail", email);
            req.getRequestDispatcher("/registro.jsp").forward(req, resp);
            return;
        }

        // Guardar “registro” en memoria de aplicación
        Map<String, User> users = getUserStore();
        users.put(email, new User(nombre, email, pass));

        // Sesión
        HttpSession session = req.getSession(true);
        session.setAttribute("usuario", nombre);

        // Paso de parámetro a la JSP mediante atributo
        req.setAttribute("nombre", nombre);
        req.getRequestDispatcher("/bienvenida.jsp").forward(req, resp);
    }
}
