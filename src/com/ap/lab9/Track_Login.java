/*
 * Harish Fulara(2014143)
 * Himaneesh Chhabra(2014044)
 * 
 */

package com.ap.lab9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Track_Login")
public class Track_Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "PizzaServletFiles";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String orderID = request.getParameter("orderID");
		
		if(orderID != null && orderID.compareTo("") != 0)
		{
			String savePath = System.getProperty("user.home") + File.separator + SAVE_DIR;
		
			FileInputStream fis = new FileInputStream(savePath + File.separator + "user.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String tmp;
			int flag = 0;
		
			while((tmp=br.readLine())!=null)
			{
				if(request.getParameter("orderID").compareTo(tmp)==0)
				{
					flag = 1;
					break;
				}
			}
		
			br.close();
			
			if(flag == 1)
			{
				request.getRequestDispatcher("/Track_Order_Home").forward(request, response);
			}
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println(
				"<!DOCTYPE html>"+

				"<html>"+
				"<head>"+
				"<link rel=\"stylesheet\" href=\"bootstrap.css\">"+
				"<link rel=\"stylesheet\" href=\"main.css\">"+
				"<title>Pizza - Track</title>"+
				"</head>"+
				"<body>"+
				"<div class=\"nav\">"+
				"<div class=\"container\">"+
				"<ul>"+
				"<li><img class=\"pull-left\" src=\"https://tangent2000.files.wordpress.com/2013/06/pizza-time-logoal.jpg\" /></li>"+
				"</ul>"+
				"<ul class=\"pull-right\">"+
				"<li><a href=\"/APLab9/MyHomePage\">Home</a></li>"+
				"</ul>"+
				"</div>"+
				"</div>"+
				"<div class=\"form_design\">"+
				"<h2>Track Your Order</h2>"+
				"<form class=\"form-horizontal\" role=\"form\" action=\"Track_Login\" method=\"GET\">"+
				"<div class=\"form-group\">"+
				"<label class=\"control-label col-sm-2\">Order ID:</label>"+
				"<div class=\"col-sm-4\">"+
				"<input type=\"text\" class=\"form-control\" name=\"orderID\" placeholder=\"Enter your Order ID\">"+
				"</div>"+
				"</div>"+
				"<div class=\"form-group\">"+ 
				"<div class=\"col-sm-offset-2 col-sm-10\">"+
				"<button type=\"submit\" class=\"btn btn-default\">Submit</button>"+
				"</div>"+
				"</div>"+
				"</form>"+
				"</div>"+
				"</body>"+
				"</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
