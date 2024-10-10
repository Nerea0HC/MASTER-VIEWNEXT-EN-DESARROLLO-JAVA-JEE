package com.curso.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");

		//Creamos sesion para guardar el nombre
		HttpSession session = request.getSession();
		session.setAttribute("nombre", nombre);

		//HTML
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Persona registrada</title>");
		out.println("</head>");
		out.println("<body>");

		out.println("<h3>Nombre de la persona registrada: " + nombre + "</h3>");
		out.println("<h3>Se puede matricular en nuestros cursos accediendo al siguiente enlace enlace: </h3>");
		out.println("<a href='matriculacionCurso.html'>Formulario del curso</a>");

		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
