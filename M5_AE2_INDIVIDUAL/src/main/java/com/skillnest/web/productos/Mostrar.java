package com.skillnest.web.productos;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Servlet implementation class Mostrar
 */
@WebServlet(name = "mostrar", urlPatterns = { "/mostrar" })
public class Mostrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Mostrar() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String, Object>> productos = new ArrayList<>();

	    Map<String, Object> p1 = new HashMap<>();
	    p1.put("nombre", "Lápices");
	    p1.put("categoria", "hogar");     // solo texto
	    p1.put("precio", 1200.0);         // número
	    p1.put("oferta", true);           // boolean

	    Map<String, Object> p2 = new HashMap<>();
	    p2.put("nombre", "Polera");
	    p2.put("categoria", "vestuario");
	    p2.put("precio", 8990.0);
	    p2.put("oferta", false);

	    productos.add(p1);
	    productos.add(p2);
	    
	    Object nombreReq = request.getAttribute("nombre");
	    if (nombreReq != null) {
	        Map<String, Object> nuevo = new HashMap<>();
	        nuevo.put("nombre", nombreReq);
	        nuevo.put("categoria", request.getAttribute("categoria"));
	        nuevo.put("precio", request.getAttribute("precio")); // puede ser null si falló parseo
	        Object ofertaReq = request.getAttribute("oferta");
	        nuevo.put("oferta", ofertaReq != null ? (Boolean) ofertaReq : false);
	        productos.add(nuevo);
	    }

	    request.setAttribute("productos", productos);
	    request.getRequestDispatcher("/productos/mostrar.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
