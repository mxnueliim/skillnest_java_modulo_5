// package com.tu.paquete;  // <- ajusta si usas paquetes

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "EncuestaServlet", urlPatterns = { "/encuesta", "/resultados", "/lista_respuestas" })
public class Encuesta extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getServletPath();

        switch (path) {
            case "/encuesta":
                request.getRequestDispatcher("/encuesta.jsp").forward(request, response);
                return;

            case "/lista_respuestas":
                // Lista simulada (>=5)
                List<Map<String, Object>> respuestas = new ArrayList<>();
                respuestas.add(map("Ana",   22, 5, "Excelente servicio."));
                respuestas.add(map("Luis",  17, 2, "Podría mejorar."));
                respuestas.add(map("María", 35, 4, "Todo bien, gracias."));
                respuestas.add(map("Pedro", 28, 1, "No me funcionó."));
                respuestas.add(map("Sofía", 19, 3, "Normal, nada especial."));

                request.setAttribute("respuestas", respuestas);
                request.getRequestDispatcher("/lista_respuestas.jsp").forward(request, response);
                return;

            default:
                // vuelve al index si la ruta no coincide
                response.sendRedirect(request.getContextPath() + "/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getServletPath();

        if ("/resultados".equals(path)) {
            // Tomar parámetros del form
            String nombre      = request.getParameter("nombre");
            int    edad        = safeInt(request.getParameter("edad"));
            String recomienda  = request.getParameter("recomienda"); // "si" | "no"
            int    calificacion= safeInt(request.getParameter("calificacion"));
            String comentario  = request.getParameter("comentario");

            // Pasar a la vista
            request.setAttribute("nombre", nombre);
            request.setAttribute("edad", edad);
            request.setAttribute("recomienda", recomienda);
            request.setAttribute("calificacion", calificacion);
            request.setAttribute("comentario", comentario);

            request.getRequestDispatcher("/resultados.jsp").forward(request, response);
            return;
        }

        // Cualquier otro POST vuelve al inicio
        response.sendRedirect(request.getContextPath() + "/");
    }

    // Helpers
    private static Map<String, Object> map(String nombre, int edad, int calificacion, String comentario) {
        Map<String, Object> m = new HashMap<>();
        m.put("nombre", nombre);
        m.put("edad", edad);
        m.put("calificacion", calificacion);
        m.put("comentario", comentario);
        return m;
    }

    private static int safeInt(String s) {
        try { return Integer.parseInt(s); } catch (Exception e) { return 0; }
    }
}
