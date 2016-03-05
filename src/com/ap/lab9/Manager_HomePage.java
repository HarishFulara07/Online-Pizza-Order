/*
 * Harish Fulara(2014143)
 * Himaneesh Chhabra(2014044)
 * 
 */

package com.ap.lab9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Manager_HomePage")
public class Manager_HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "PizzaServletFiles";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
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
      	"</div>" +
      	"</div>" +
      	"<div class=\"mytable\">" +
	   	"<table class=\"table\">" +
	   	"<thead>" +
	   	"<tr id=\"maintitle\">" +
	   	"<th colspan=\"3\">" +
	   	"Current Pending Orders</th>" +
	   	"</tr>" +
	   	"<tr id=\"coltitle\">" +
	   	"<th>Order ID</th>" +
	   	"<th>Order State</th>" +
	   	"<th>Update Order</th>" +
	   	"</tr>" +
	   	"</thead>");
	
		String savePath = System.getProperty("user.home") + File.separator + SAVE_DIR;
		String tmp, stage = null, ord;
		
		BufferedReader reader= new BufferedReader(new FileReader(savePath + File.separator + "user.txt"));
		
		while((tmp = reader.readLine()) != null)
		{
			if(tmp.compareTo("*") != 0 && tmp.compareTo("") != 0)
			{
				BufferedReader ordreader = new BufferedReader(new FileReader(savePath + File.separator + tmp +".txt"));
				
				while((ord = ordreader.readLine()) != null)
				{
					if(ord.equals("1"))
					{
						stage = "Order Placed";
						break;
					}
					else if(ord.equals("2"))
					{
						stage = "Preparation";
						break;
					}	
					else if(ord.equals("3"))
					{
						stage = "Bake";
						break;
					}	
					else if(ord.equals("4"))
					{
						stage = "Quality Check";
						break;
					}
					else if(ord.equals("5"))
					{
						stage = "Out for Delievery";
						break;
					}
					else if(ord.equals("6"))
					{
						stage = "Delievered";
						break;
					}
				}
				ordreader.close();
			
				//System.out.println(stage);
				out.print(
				"<tr>" +
				"<td>" + tmp + "</td>" +
				"<td>" + stage + "</td>" +
				"<td>" +
				"<form action=\"Manager_Order_Update\">" +
				"<input type=\"hidden\" name=\"ID\" value=\"" + tmp + "\">" +
				"<input type=\"submit\" value=\"Update\">" +
				"</form>" +
				"</td>" +
				"</tr>");
			}
		}	
		
		out.print(
		"</table>" +
		"</div>" +
		"</body>" +
		"</html>");
		
		reader.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
