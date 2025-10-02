package com.skillnest.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/bienvenida")
public class BienvenidaServlet extends HttpServlet {

	private static final long serialVersionUID = -6887529451179387982L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        String nombreSesion = (session != null) ? (String) session.getAttribute("usuario") : null;

        String nombreCookie = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("usuario".equals(cookie.getName())) {
                    nombreCookie = cookie.getValue();
                }
            }
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<h2>Bienvenido</h2>");
        if (nombreSesion != null) {
            out.println("<p>Desde sesión: " + nombreSesion + "</p>");
        }
        if (nombreCookie != null) {
            out.println("<p>Desde cookie: " + nombreCookie + "</p>");
        }
    }
}
