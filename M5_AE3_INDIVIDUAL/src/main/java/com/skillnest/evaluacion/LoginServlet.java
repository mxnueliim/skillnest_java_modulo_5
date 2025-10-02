package com.skillnest.evaluacion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.skillnest.evaluacion.User;

@WebServlet(name="LoginServlet", urlPatterns={"/login"})
public class LoginServlet extends HttpServlet {

    @SuppressWarnings("unchecked")
    private Map<String, User> getUserStore(HttpServletRequest req) {
        var ctx = req.getServletContext();
        Object obj = ctx.getAttribute("USERS");
        if (obj == null) {
            Map<String, User> store = new ConcurrentHashMap<>();
            ctx.setAttribute("USERS", store);
            return store;
        }
        return (Map<String, User>) obj;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String nombre = (req.getParameter("nombre") == null) ? "" : req.getParameter("nombre").trim();
        String pass   = (req.getParameter("password") == null) ? "" : req.getParameter("password").trim();

        if (nombre.isEmpty() || pass.isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/login?error=1");
            return;
        }

        Map<String, User> users = getUserStore(req);

        // Buscar por NOMBRE (no por email)
        User u = null;
        for (User cand : users.values()) {
            if (cand.getNombre().equalsIgnoreCase(nombre)) {
                u = cand;
                break;
            }
        }

        if (u != null && u.getPassword().equals(pass)) {
            // Sesión con el nombre
            HttpSession session = req.getSession(true);
            session.setAttribute("usuario", u.getNombre());

            // Cookie 7 días con el nombre
            String cookieValue = URLEncoder.encode(u.getNombre(), StandardCharsets.UTF_8);
            Cookie c = new Cookie("usuario", cookieValue);
            c.setMaxAge(7 * 24 * 60 * 60);
            c.setPath(req.getContextPath().isEmpty() ? "/" : req.getContextPath());
            resp.addCookie(c);

            // Paso de atributo a la JSP
            req.setAttribute("nombre", u.getNombre());
            req.getRequestDispatcher("/bienvenida.jsp").forward(req, resp);
        } else {
            // Credenciales inválidas
            resp.sendRedirect(req.getContextPath() + "/login?error=1");
        }
    }
}
