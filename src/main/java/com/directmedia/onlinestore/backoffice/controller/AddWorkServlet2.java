package com.directmedia.onlinestore.backoffice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.directmedia.onlinestore.core.entity.Artist;
import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.Work;

/**
 * Servlet implementation class AddWorkServlet
 */
@WebServlet("/add-work2")
public class AddWorkServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean success = true;

		Work newOeuvre = new Work();

		newOeuvre.setTitle(request.getParameter("title"));
		newOeuvre.setMainArtist(new Artist(request.getParameter("mainArtist")));
		try {
		newOeuvre.setRelease(Integer.parseInt(request.getParameter("release")));
		} catch(NumberFormatException nfe) {
			success = false;
		}

		newOeuvre.setGenre(request.getParameter("genre"));
		newOeuvre.setSummary(request.getParameter("summary"));

		for (Work work : Catalogue.listOfWorks) {
			if (work.getTitle().equals(newOeuvre.getTitle()) && work.getRelease() == newOeuvre.getRelease()
					&& work.getMainArtist().getName().equals(newOeuvre.getMainArtist().getName())) {
				success = false;
			}
		}
		
		RequestDispatcher disp = null;
		
		if (success) {
			Catalogue.listOfWorks.add(newOeuvre);
			request.setAttribute("identifiantOeuvre", newOeuvre.getId());
			disp = request.getRequestDispatcher("/work-added-success");
		}else {
			disp = request.getRequestDispatcher("/work-added-failure");
		}
		
		disp.forward(request, response);

	}

}
