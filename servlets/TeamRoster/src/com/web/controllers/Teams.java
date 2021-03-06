package com.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.models.Team;

/**
 * Servlet implementation class Teams
 */
@WebServlet("/teams")
public class Teams extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teams() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("detailTeamId") != null) {
			Team selectedTeam = Team.getTeam(Integer.parseInt(request.getParameter("detailTeamId")));
			request.setAttribute("selectedTeam", selectedTeam);
			RequestDispatcher view = request.getRequestDispatcher("views/team.jsp");
			view.forward(request, response);
		}else {
			RequestDispatcher view = request.getRequestDispatcher("views/addTeam.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Add new Team
		if(request.getParameter("teamName") == "" || request.getParameter("teamName") == null) {
			RequestDispatcher view = request.getRequestDispatcher("views/addTeam.jsp");
			view.forward(request, response);
		}else {
		Team newTeam = new Team(request.getParameter("teamName"));
		System.out.println("What's newTeam? : "+newTeam);
		Team.addToList(newTeam);
		//redirect after post logic:
		response.sendRedirect("/TeamRoster");
		}
		
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.write("<h1>doPost addTeaming</h1>");
		
	}

}
