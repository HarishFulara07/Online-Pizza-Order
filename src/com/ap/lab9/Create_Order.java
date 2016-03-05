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

@WebServlet("/Create_Order")
public class Create_Order extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "PizzaServletFiles";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String customerID = session.getId();
		String f = customerID.substring(0, 3);
		String l = f + customerID.substring(customerID.length() - 3);
		
		out.println("<!DOCTYPE html>" + "<html>"+
				"<head>"+
				"<link rel=\"stylesheet\" href=\"bootstrap.css\">"+
				"<link rel=\"stylesheet\" href=\"main.css\">"+
				"<title>Pizza - Order</title>"+
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
				"</ul>"+
				"</div>"+
				"</div>"+
				    
				"<div class=\"menu\">"+
				"<div class=\"container\">"+
			    "<h1>Aah!!! Delicious</h1>"+
				"<p>Select From our wide variety of delicious PIZZAS!!!</p>"+
				"<div class=\"row\">"+
				"<div class=\"col-md-4\">"+
				"<div class=\"thumbnail\">"+
				"<img src=\"chicken_supreme.jpg\" />"+
				"</div>"+
				"<div class=\"thumbnail\">"+
				"<img src=\"corn_chicken.png\" />"+
				"</div>"+
				"</div>"+
			    "<div class=\"col-md-4\">"+
				"<div class=\"thumbnail\">"+
				"<img src=\"veg_supreme.jpg\" />"+
				"</div>"+
				"<div class=\"thumbnail\">"+
				"<img src=\"crispy_panner.jpg\" />"+
				"</div>"+
				"</div>"+
				"<div class=\"col-md-4\">"+
				"<div class=\"order\">"+
				"<form class=\"form-horizontal\" role=\"form\" action=\"Create_Order\" method=\"POST\">"+
				"<p> Corn Chicken </p>"+
				"<div class=\"checkbox\">"+
				"<label><input type=\"checkbox\" name=\"order1\">Order</label>"+
				"</div>"+
				"<div class=\"radio\">"+
				"<label><input type=\"radio\" name=\"type1\" value=\"small\">Small</label>"+
				"</div>"+
				"<div class=\"radio\">"+
				"<label><input type=\"radio\" name=\"type1\" value=\"medium\">Medium</label>"+
				"</div>"+
				"<div class=\"radio\">"+
				"<label><input type=\"radio\" name=\"type1\" value=\"large\">Large</label>"+
				"</div>"+
				"<label>Quantity: <input type=\"text\" style = \"width: 70px\" name=\"quantity1\" placeholder=\"1\"></label>"+
				"<p> Veg Supreme </p>"+
				"<div class=\"checkbox\">"+
				"<label><input type=\"checkbox\" name=\"order2\">Order</label>"+
				"</div>"+
				"<div class=\"radio\">"+
				"<label><input type=\"radio\" name=\"type2\" value=\"small\">Small</label>"+
				"</div>"+
				"<div class=\"radio\">"+
				"<label><input type=\"radio\" name=\"type2\" value=\"medium\">Medium</label>"+
				"</div>"+
				"<div class=\"radio\">"+
				"<label><input type=\"radio\" name=\"type2\" value=\"large\">Large</label>"+
				"</div>"+
				"<label>Quantity: <input type=\"text\" style = \"width: 70px\" name=\"quantity2\" placeholder=\"1\"></label>"+
				"<p> Chicken Supreme </p>"+
				"<div class=\"checkbox\">"+
				"<label><input type=\"checkbox\" name=\"order3\">Order</label>"+
				"</div>"+
				"<div class=\"radio\">"+
				"<label><input type=\"radio\" name=\"type3\" value=\"small\">Small</label>"+
				"</div>"+
				"<div class=\"radio\">"+
				"<label><input type=\"radio\" name=\"type3\" value=\"medium\">Medium</label>"+
				"</div>"+
				"<div class=\"radio\">"+
				"<label><input type=\"radio\" name=\"type3\" value=\"large\">Large</label>"+
				"</div>"+
				"<label>Quantity: <input type=\"text\" style = \"width: 70px\" name=\"quantity3\" placeholder=\"1\"></label>"+
				"<p> Crispy Panner </p>"+
				"<div class=\"checkbox\">"+
				"<label><input type=\"checkbox\" name=\"order4\">Order</label>"+
				"</div>"+
				"<div class=\"radio\">"+
				"<label><input type=\"radio\" name=\"type4\" value=\"small\">Small</label>"+
				"</div>"+
				"<div class=\"radio\">"+
				"<label><input type=\"radio\" name=\"type4\" value=\"medium\">Medium</label>"+
				"</div>"+
				"<div class=\"radio\">"+
				"<label><input type=\"radio\" name=\"type4\" value=\"large\">Large</label>"+
				"</div>"+
				"<label>Quantity: <input type=\"text\" style = \"width: 70px\" name=\"quantity4\" placeholder=\"1\"></label>"+
				"<div class=\"button\">"+
				"<label><input type=\"submit\" name = \"btn\" value=\"Add Order\" id=\"submit2\"></label>"+
				"<label><input type=\"submit\" name = \"btn\" value=\"Continue Order\" id=\"submit1\"></label>"+
				"</div>"+
				"</form>"+
				"</div>"+
				"</div>"+          
				"</div>"+               	
			   	"</div>"+
				"</div>"+
				"</body>"+
				"</html>"
	);
    	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("btn");
		int flag = 0;
		
		HttpSession session = request.getSession();
		String customerID = session.getId();
		String f = customerID.substring(0, 3);
		String l = f + customerID.substring(customerID.length() - 3);
		
		String savePath = System.getProperty("user.home") + File.separator + SAVE_DIR;
		
		File fileSaveDir = new File(savePath);
        
        if (!fileSaveDir.exists()) 
        {
            fileSaveDir.mkdir();
        }
        
        File file = new File(savePath + File.separator + l + ".txt");
        if(file.exists() == false)
        {
        	flag = 1;
        }
        
        BufferedWriter fos= new BufferedWriter(new FileWriter(savePath + File.separator + l + ".txt",true));
        
        if(flag == 1)
        {
        	fos.write(l + "\n");
        }
        
		if("Continue Order".compareTo(action) == 0)
		{
			String cb1 = request.getParameter("order1");
		
			//System.out.println(request.getParameter("quantity1"));
			if(cb1!=null)
			{
				String nm="Corn Chicken";
				fos.write(nm);
			
				String type = request.getParameter("type1");
				if(type.equals("small"))
				{
					fos.write(";small");
				}
				else if(type.equals("medium"))
				{
					fos.write(";medium");
				}
				else if(type.equals("large"))
				{
					fos.write(";large");
				}	
			
				String quantity = request.getParameter("quantity1");
			
				if(quantity.compareTo("") == 0)
				{
					fos.write(";" + 1 + "\n");
				}
				else
				{
					fos.write(";" + quantity + "\n");
				}
			}
			else
			{
				fos.write("null" + "\n");
			}	
		
			String cb2 = request.getParameter("order2");
			//System.out.println(cb2);
		
			if(cb2!=null)
			{
				String nm="Veg Supreme";
				fos.write(nm);
				String type = request.getParameter("type2");
				if(type.equals("small"))
				{
					fos.write(";small");
				}
				else if(type.equals("medium"))
				{
					fos.write(";medium");
				}
				else if(type.equals("large"))
				{
					fos.write(";large");
				}
				String quantity = request.getParameter("quantity2");
			
				if(quantity.compareTo("") == 0)
				{
					fos.write(";" + 1 + "\n");
				}	
				else
				{
					fos.write(";" + quantity + "\n");
				}
			}
			else
			{
				fos.write("null" + "\n");
			}
		
			String cb3 = request.getParameter("order3");
			//System.out.println(cb3);
		
			if(cb3!=null)
			{
				String nm="Chicken Supreme";
				fos.write(nm);
				String type = request.getParameter("type3");
				if(type.equals("small"))
				{
					fos.write(";small");
				}
				else if(type.equals("medium"))
				{
					fos.write(";medium");
				}
				else if(type.equals("large"))
				{
					fos.write(";large");
				}
				String quantity = request.getParameter("quantity3");
			
				if(quantity.compareTo("") == 0)
				{
					fos.write(";" + 1 + "\n");
				}	
				else
				{
					fos.write(";" + quantity + "\n");
				}
			}
			else
			{
				fos.write("null" + "\n");
			}	
		
			String cb4 = request.getParameter("order4");
			//System.out.println(cb4);
		
			if(cb4!=null)
			{
				String nm="Crispy Panner";
				fos.write(nm);
				String type = request.getParameter("type4");
				if(type.equals("small"))
				{
					fos.write(";small");
				}
				else if(type.equals("medium"))
				{
					fos.write(";medium");
				}	
				else if(type.equals("large"))
				{
					fos.write(";large");
				}
				String quantity = request.getParameter("quantity4");
				
				if(quantity.compareTo("") == 0)
				{
					fos.write(";" + 1 + "\n");
				}	
				else
				{
					fos.write(";" + quantity + "\n");
				}	
			}
			else
			{
				fos.write("null" + "\n");
			}	
		
			fos.close();
		
			response.sendRedirect("/APLab9/Order_Details");
		}
		else
		{
			String cb1 = request.getParameter("order1");
		
			//System.out.println(request.getParameter("quantity1"));
			if(cb1!=null)
			{
				String nm="Corn Chicken";
				fos.write(nm);
			
				String type = request.getParameter("type1");
				if(type.equals("small"))
				{
					fos.write(";small");
				}
				else if(type.equals("medium"))
				{
					fos.write(";medium");
				}
				else if(type.equals("large"))
				{
					fos.write(";large");
				}	
			
				String quantity = request.getParameter("quantity1");
			
				if(quantity.compareTo("") == 0)
				{
					fos.write(";" + 1 + "\n");
				}
				else
				{
					fos.write(";" + quantity + "\n");
				}
			}
			else
			{
				fos.write("null" + "\n");
			}	
		
			String cb2 = request.getParameter("order2");
			//System.out.println(cb2);
		
			if(cb2!=null)
			{
				String nm="Veg Supreme";
				fos.write(nm);
				String type = request.getParameter("type2");
				if(type.equals("small"))
				{
					fos.write(";small");
				}
				else if(type.equals("medium"))
				{
					fos.write(";medium");
				}
				else if(type.equals("large"))
				{
					fos.write(";large");
				}
				String quantity = request.getParameter("quantity2");
			
				if(quantity.compareTo("") == 0)
				{
					fos.write(";" + 1 + "\n");
				}	
				else
				{
					fos.write(";" + quantity + "\n");
				}
			}
			else
			{
				fos.write("null" + "\n");
			}
		
			String cb3 = request.getParameter("order3");
			//System.out.println(cb3);
		
			if(cb3!=null)
			{
				String nm="Chicken Supreme";
				fos.write(nm);
				String type = request.getParameter("type3");
				if(type.equals("small"))
				{
					fos.write(";small");
				}
				else if(type.equals("medium"))
				{
					fos.write(";medium");
				}
				else if(type.equals("large"))
				{
					fos.write(";large");
				}
				String quantity = request.getParameter("quantity3");
			
				if(quantity.compareTo("") == 0)
				{
					fos.write(";" + 1 + "\n");
				}	
				else
				{
					fos.write(";" + quantity + "\n");
				}
			}
			else
			{
				fos.write("null" + "\n");
			}	
		
			String cb4 = request.getParameter("order4");
			//System.out.println(cb4);
		
			if(cb4!=null)
			{
				String nm="Crispy Panner";
				fos.write(nm);
				String type = request.getParameter("type4");
				if(type.equals("small"))
				{
					fos.write(";small");
				}
				else if(type.equals("medium"))
				{
					fos.write(";medium");
				}	
				else if(type.equals("large"))
				{
					fos.write(";large");
				}
				String quantity = request.getParameter("quantity4");
				
				if(quantity.compareTo("") == 0)
				{
					fos.write(";" + 1 + "\n");
				}	
				else
				{
					fos.write(";" + quantity + "\n");
				}	
			}
			else
			{
				fos.write("null" + "\n");
			}	
		
			fos.close();
			
			response.sendRedirect("/APLab9/Create_Order");
		}
	}
}
