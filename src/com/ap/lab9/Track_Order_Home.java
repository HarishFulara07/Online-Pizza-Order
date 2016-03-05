/*
 * Harish Fulara(2014143)
 * Himaneesh Chhabra(2014044)
 * 
 */

package com.ap.lab9;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Track_Order_Home")
public class Track_Order_Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "PizzaServletFiles";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String savePath = System.getProperty("user.home") + File.separator + SAVE_DIR;
		String tmp;
		System.out.println(request.getParameter("orderID"));
		BufferedReader reader = new BufferedReader(new FileReader(savePath + File.separator + request.getParameter("orderID") + ".txt"));
		
		String progress_value = null, stage = null;
		while((tmp=reader.readLine()) != null)
		{
			if(tmp.equals("1"))
			{
				progress_value = "10";
				stage = "Order Placed";
				break;
			}
			else if(tmp.equals("2"))
			{
				progress_value = "25";
				stage = "Preparation";
				break;
			}
			else if(tmp.equals("3"))
			{
				progress_value = "50";
				stage = "Bake";
				break;
			}
			else if(tmp.equals("4"))
			{
				progress_value = "70";
				stage = "Quality Check";
				break;
			}
			else if(tmp.equals("5"))
			{
				progress_value = "90";
				stage = "Out for Delievery";
				break;
			}
			else if(tmp.equals("6"))
			{
				progress_value = "100";
				stage = "Delievered";
				break;
			}
		}
			
		reader.close();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>" + 
		"<link rel=\"stylesheet\" href=\"bootstrap.css\">" +
	 	"<link rel=\"stylesheet\" href=\"main.css\">" + 
		"<title>Pizza - Track</title>" + 
		"</head>"
		+
		"<body>" +
		"<div class=\"nav\">" +
	    "<div class=\"container\">" +
	    "<ul>" +
	    "<li><img class=\"pull-left\" src=\"https://tangent2000.files.wordpress.com/2013/06/pizza-time-logoal.jpg\" /></li>" +
	    "</ul>" +
	    "<ul class=\"pull-right\">" +
	    "<li><p>Your Order ID: " + request.getParameter("orderID") + "</p></li>" +
	    "<li><a href=\"/APLab9/MyHomePage\">Home</a></li>" +
	    "</ul>" +
	    "</div>" +
	   	"</div>"
		+
		"<div class=\"track\">" +
   		"<h2>Track Your Order </h2>" +
   		"<ol>" +
   		"<li>Order Placed</li>" +
   		"<li>Preparation</li>" +
   		"<li>Bake</li>" +
   		"<li>Quality Check</li>" +
   		"<li>Out for Delievery</li>" +
   		"<li>Delievered</li>" +
   		"</ol>" +
   		"</div>"
   		+				
		"<div class=\"trackbar\">" +
        "<div class=\"progress\">" +
        "<div class=\"progress-bar\" role=\"progressbar\" aria-valuenow=\"70\"" +
        "aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width:"  + progress_value + "%\">" +
        stage +
        "</div>" +
        "</div>" +
        "</div>"
		+
		"</body" + "</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
