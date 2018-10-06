package com.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.models.Player;
import com.web.models.Team;

/**
 * Servlet implementation class Players
 */
@WebServlet("/player")
public class Players extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Players() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("teamId") != null) {
			Team selectedTeam = Team.getTeam(Integer.parseInt(request.getParameter("teamId")));
			request.setAttribute("selectedTeam", selectedTeam);
			RequestDispatcher view = request.getRequestDispatcher("views/addPlayer.jsp");
			view.forward(request, response);
		}else {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Add new player
		if(request.getParameter("firstName") == null || request.getParameter("lastName") == null || request.getParameter("age") == null) {
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			int age = Integer.parseInt(request.getParameter("age"));
			Player newPlayer = new Player(firstName, lastName, age);
			int teamId = Integer.parseInt(request.getParameter("team"));
			Team selectedTeam = Team.getTeam(teamId);
			System.out.println("who's newPlayer "+ newPlayer);
			selectedTeam.addToPlayerList(newPlayer, teamId);
			response.sendRedirect("/TeamRoster/teams?detailTeamId="+teamId);
		}
	}

}
