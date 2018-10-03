package com.dojo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
		String userFirstName = request.getParameter("firstName");
		String userLastName = request.getParameter("lastName");
		String favLanguage = request.getParameter("favoriteLanguage");
		String homeTown = request.getParameter("homeTown");
		if(userFirstName == null) {
			userFirstName = "Unknown";
		}
		if(userLastName == null) {
			userLastName = "Unknown";
		}
		if(favLanguage == null) {
			favLanguage = "Unknown";
		}
		if(homeTown == null) {
			homeTown = "Unknown";
		}
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.write("<h1 style='color:green;'>Welcome, <span style='color:blue;'>"+ userFirstName+" "+userLastName+"</span></h1>");
		out.write("<br>");
		out.write("<h2>Your favorite language is: <span style='color:royalblue;'>"+favLanguage+"</span></h2>");
		out.write("<h2>Your hometown is: <span style='color:royalblue;'>"+homeTown+"</span></h2>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
