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
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class AuthentificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String pseudo = request.getParameter("pseudo");
		String mdp = request.getParameter("mdp");
		String admin1 = "michel";
		String mdpAdmin1 = "123456";
		String admin2 = "caroline";
		String mdpAdmin2 = "abcdef";
		if(admin1.equals(pseudo) && mdpAdmin1.equals(mdp) || admin2.equals(pseudo) && mdpAdmin2.equals(mdp)) {
			out.println("<a href=\"home.jsp\">Accés à la page d'accueil</a>");
			session.setAttribute("pseudo", pseudo);
		}else {
			System.out.println(pseudo + mdp);
			out.println("login/mdp erroné <br/>");
			out.println("<a href=\"login.html\">Retour à la page de connexion</a>");
		}
	}


}
