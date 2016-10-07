package com.seed;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//	TODO:1 Make DisplayCartDetailsServlet as a HttpServlet
@WebServlet("/displayDetails")
public class DisplayCartDetailsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		String arr[]=request.getParameterValues("bookName");
		
		PrintWriter pw = response.getWriter();
		 pw.println("<html><body>");
		 pw.println("<table border='1'>");
		 for(int i=0;i<arr.length;i++){
			
				
				pw.println("<tr>");
				pw.println("<td>"+arr[i] +"</td>");
				pw.println("</tr>");
				
			//pw.println(arr[i]);
		}pw.println("</table>");
		pw.println("</body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(req, resp);
	}

//	TODO:2 	Provide call-back method (called by web container) for HTTP request made using HTTP GET method
//	TODO:3	This method should read products selected by web-client from bookCatelogue.html and 
//					display them in tabular format as html response to the web client.	




}









