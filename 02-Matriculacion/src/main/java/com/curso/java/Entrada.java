package com.curso.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Entrada
 */
public class Entrada extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Creamos sesion para guardar el curso
        HttpSession session = request.getSession();
        String curso = request.getParameter("curso");

        //Obtenemos la lista, si no existe se crea
        List<String> cursos = (List<String>) session.getAttribute("cursos");
        if (cursos == null) {
            cursos = new ArrayList<>();
        }
        cursos.add(curso);

        //Guardamos la lista de cursos en la sesión (clave-valor)
        session.setAttribute("cursos", cursos);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>" + session.getAttribute("nombre") + ", estas matriculado en los cursos siguientes: </h2>");
        out.println("<ul>");
        //Mostramos la lista con los parametros
        for (String c : cursos) {
            out.println("-" + c + "<br>");
        }
        out.println("<br><a href='matriculacionCurso.html'>Matricularse en otro curso</a>");
        out.println("</body></html>");
	}

}
