/*
 * Harish Fulara(2014143)
 * Himaneesh Chhabra(2014044)
 * 
 */

package com.ap.lab9;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MyHomePage")
public class MyHomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		@SuppressWarnings("unused")
		HttpSession session = request.getSession(true);
		
		out.print("<!DOCTYPE html>" +

		"<html>" +
		"<head>" +
		"<link rel=\"stylesheet\" href=\"bootstrap.css\">" +
		"<link rel=\"stylesheet\" href=\"main.css\">" +
		"<title>Pizza - Home</title>" +
		"</head>" +
		"<body>" +
		"<div class=\"nav\">" +
      	"<div class=\"container\">" +
      	"<ul>" +
      	"<li><img class=\"pull-left\" src=\"https://tangent2000.files.wordpress.com/2013/06/pizza-time-logoal.jpg\" /></li>" +
      	"</ul>" +
        "<ul class=\"pull-right\">" +
        "<li><a href=\"/APLab9/Create_Order\">Create New Order</a></li>" +
        "<li><a href=\"/APLab9/Track_Login\">Track My Order</a></li>" +
        "</ul>" +
      	"</div>" +
      	"</div>" +

    	"<div class=\"jumbotron\"></div>" + 
    	"<div class=\"credit\">" +
    	"<h2>Designed by: Harish Fulara and Himaneesh Chhabra</h2>" +
    	"</div>" +
    	"</body>" +
		"</html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}