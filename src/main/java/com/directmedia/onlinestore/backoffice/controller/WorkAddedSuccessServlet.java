package com.directmedia.onlinestore.backoffice.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WorkAddedSuccessServlet
 */
@WebServlet("/work-added-success")
public class WorkAddedSuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<html><body>L'oeuvre avec l'identifiant " + request.getAttribute("identifiantOeuvre") + " a bien été ajoutée !<br/>");
		
		out.println("<a href=\"home.jsp\">Retour à la page d'accueil</a></body></html>");
	}

}
