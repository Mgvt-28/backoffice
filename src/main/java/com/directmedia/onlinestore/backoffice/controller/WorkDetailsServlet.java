package com.directmedia.onlinestore.backoffice.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.Work;

/**
 * Servlet implementation class WorkDetailsServlet
 */
@WebServlet("/work-details2")
public class WorkDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset = UTF-8");

		String id = request.getParameter("id");

		//Work oeuvre = Catalogue.listOfWorks.stream().filter(w -> w.getId() == Long.parseLong(id)).findFirst().get();
		// = à
		Work oeuvre = null;
		
		 for (Work w : Catalogue.listOfWorks) { if (w.getId() == Long.parseLong(id)) {
		 oeuvre = w; } break; }
		 

		oeuvre.setId(Long.parseLong(id));
		PrintWriter out = response.getWriter();
		out.println("<html><body><h1>Détails de l'oeuvre : </h1><br/>");
		out.println("<p>Titre : </p>" + oeuvre.getTitle());
		out.println("<br/><p>ID : </p>" + oeuvre.getId());
		out.println("<br/><p>Acteur principal : </p>" + oeuvre.getMainArtist().getName());
		out.println("<br/><p>Année de parution : </p>" + oeuvre.getRelease());
		out.println("<br/><p>Genre : </p>" + oeuvre.getGenre());
		out.println("<br/><p>Résumé : </p>" + oeuvre.getSummary());

		out.println("<br/><br/><a href=\"WEB-INF/catalogue.jsp\">Retour au catalogue</a>");
		out.println("</body></html>");

	}

}
