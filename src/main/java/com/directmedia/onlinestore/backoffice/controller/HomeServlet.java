package com.directmedia.onlinestore.backoffice.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet(name = "HomeServlet", urlPatterns = { "/home" })
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		out.println("<html><body><h1>Onlinestore, votre boutique mulltimédia en ligne</h1>");
		out.println("Bonjour " + session.getAttribute("pseudo") + "<a href =\"logout\"> (Déconnexion)</a><br/><br/>");
		out.println("<a href=\"catalogue\">Accéder au catalogue</a><br/>");
		out.println("<a href=\"add-work-form2.html\">Ajouter une oeuvre au catalogue</a><br/>");
		out.println("</body></html>");
	}
}
