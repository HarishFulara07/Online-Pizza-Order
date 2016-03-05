/*
 * Harish Fulara(2014143)
 * Himaneesh Chhabra(2014044)
 * 
 */

package com.ap.lab9;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Order_Details")
public class Order_Details extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "PizzaServletFiles";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		String customerID = session.getId();
		String f = customerID.substring(0, 3);
		String l = f + customerID.substring(customerID.length() - 3);
		
		String savePath = System.getProperty("user.home") + File.separator + SAVE_DIR;
		
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		
		if(name != null && name.compareTo("") != 0 && address.compareTo("") != 0 && phone.compareTo("") != 0)
		{
			BufferedWriter fos = new BufferedWriter(new FileWriter(savePath + File.separator + l + ".txt",true));
			fos.write(name + "\n");
			fos.write(address + "\n");
			fos.write(phone + "\n");
			fos.write(1 + "\n");
			fos.write(0 + "\n");
			fos.close();
	
			fos = new BufferedWriter(new FileWriter(savePath + File.separator + "user.txt",true));
			fos.write(l + "\n");
			fos.close();
			
			 response.sendRedirect("/APLab9/Track_Order");
		}
		
		out.println("<!DOCTYPE html>"+
		"<html>"+
		"<head>"+
		"<link rel=\"stylesheet\" href=\"bootstrap.css\">"+
		"<link rel=\"stylesheet\" href=\"main.css\">"+
		"<title>Pizza - Details</title>"+
		"</head>"+
		"<body>"+
		"<div class=\"nav\">"+
		"<div class=\"container\">"+
		"<ul>"+
		"<li><img class=\"pull-left\" src=\"https://tangent2000.files.wordpress.com/2013/06/pizza-time-logoal.jpg\" /></li>"+
		"</ul>"+
		"<ul class=\"pull-right\">"+
		"<li><p>Your Order ID: " + l + "</p></li>" +
		"<li><a href=\"/APLab9/MyHomePage\">Home</a></li>"+
		"<li><a href=\"/APLab9/Create_Order\">Menu-Page</a></li>"+
		"</ul>"+
		"</div>"+
		"</div>"+
		"<div class=\"form_design\">"+
		"<h2>Pizza Delievery Details</h2>"+
		"<p>Note: All fields are mandatory</p>"+
		"<form class=\"form-horizontal\" role=\"form\" action=\"Order_Details\" method=\"GET\">"+
		"<div class=\"form-group\">"+
		"<label class=\"control-label col-sm-2\">Name:</label>"+
		"<div class=\"col-sm-4\">"+
		"<input type=\"text\" class=\"form-control\" name=\"name\" placeholder=\"Enter your name\">"+
		"</div>"+
		"</div>"+
		"<div class=\"form-group\">"+
		"<label class=\"control-label col-sm-2\">Phone Number:</label>"+
		"<div class=\"col-sm-4\">"+ 
		"<input type=\"text\" class=\"form-control\" name=\"phone\" placeholder=\"Enter your phone number\">"+
		"</div>"+
		"</div>"+
		"<div class=\"form-group\">"+
		"<label class=\"control-label col-sm-2\">Delievery Address:</label>"+
		"<div class=\"col-sm-4\">"+
		"<textarea class=\"form-control\" rows=\"5\" name=\"address\" placeholder=\"Enter pizza delievery address\"></textarea>"+
		"</div>"+
		"</div>"+
		"<div class=\"form-group\">"+ 
		"<div class=\"col-sm-offset-2 col-sm-10\">"+
		"<button type=\"submit\" class=\"btn btn-default\">Place Order</button>"+
		"</div>"+
		"</div>"+
		"</form>"+
		"</div>"+
		"</body>"+
		"</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
