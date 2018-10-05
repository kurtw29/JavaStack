package com.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class home
 */
@WebServlet("/home")
public class home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("status") == null) {
			int number = (int) (Math.random()*100+1);
			session.setAttribute("number", number);
			RequestDispatcher view = request.getRequestDispatcher("views/startGuess.jsp");
			view.forward(request,  response);				
		}else if(session.getAttribute("status").equals("correct")){
			session.setAttribute("status", null);
			int number = (int) (Math.random()*100+1);
			session.setAttribute("number", number);
			RequestDispatcher view = request.getRequestDispatcher("views/startGuess.jsp");
			view.forward(request,  response);
		}else {
			RequestDispatcher view = request.getRequestDispatcher("views/startGuess.jsp");
			view.forward(request,  response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//if user click submit w/o entering a number - redirect to home
		if(request.getParameter("guessNumber") == "") {
			RequestDispatcher view = request.getRequestDispatcher("views/startGuess.jsp");
			view.forward(request,  response);
		}else {
			
			HttpSession session = request.getSession();
			//declare & assign guessNumber variable from POST
			int guessNumber = Integer.parseInt(request.getParameter("guessNumber"));
			int number = (int) session.getAttribute("number");
			
			//if guess too high, update session(status):high, and redirect;
			if(guessNumber > number) {
				session.setAttribute("status", "high");
			}
			//if guess too low, update session(status):low, and redirect;
			else if(guessNumber < number) {
				session.setAttribute("status", "low");
			}
			//if guess correct, update session(status):correct, and redirect;
			else if(guessNumber == number) {
				session.setAttribute("status", "correct");
			}
			RequestDispatcher view = request.getRequestDispatcher("views/startGuess.jsp");
			view.forward(request,  response);
			
		}
		//		doGet(request, response);
	}

}
