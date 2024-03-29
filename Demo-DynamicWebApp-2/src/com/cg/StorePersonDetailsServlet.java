package com.cg;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class StorePersonDetailsServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String user = request.getParameter("name");
			String age = request.getParameter("age");
	
			Person p1 = new Person(user, Integer.parseInt(age));
			
			request.setAttribute("pd", p1);
			
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("displayDetails");	
	
			dispatcher.forward(request, response);
			
	}

	
	
}
