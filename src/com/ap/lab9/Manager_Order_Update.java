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

@WebServlet("/Manager_Order_Update")
public class Manager_Order_Update extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "PizzaServletFiles";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String savePath = System.getProperty("user.home") + File.separator + SAVE_DIR;
		String filename = request.getParameter("ID");
		
		FileInputStream fis = new FileInputStream(savePath + File.separator + filename + ".txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String line, upd;
		int flag = 0;
		StringBuilder filecontent = new StringBuilder();
		
		while((line=br.readLine())!=null)
		{
			if(line.equals("1") || line.equals("2") || line.equals("3") || line.equals("4") || line.equals("5"))
			{
				upd=line;
				if(upd.compareTo("1")==0)
				{
					filecontent.append("2");
				}
				else if(upd.compareTo("2")==0)
				{
					filecontent.append("3");
				}
				else if(upd.compareTo("3")==0)
				{
					filecontent.append("4");
				}
				else if(upd.compareTo("4")==0)
				{
					filecontent.append("5");
				}
				else if(upd.compareTo("5")==0)
				{
					filecontent.append("6");
					flag = 1;
				}
				
				filecontent.append("\n");
			}
			else
			{
				filecontent.append(line);
				filecontent.append("\n");
			}
		}

		br.close();
		String str=filecontent.toString();
		String content = str.replaceAll("(?!\\r)\\n", "\r\n");
		FileOutputStream fos = new FileOutputStream(savePath + File.separator + filename + ".txt");
		PrintStream ps = new PrintStream(fos);
		ps.println(content);
		ps.close();
		
		if(flag == 1)
		{
			File file = new File(savePath + File.separator + filename + ".txt");
			file.delete();
			
			fis = new FileInputStream(savePath + File.separator + "user.txt");
			br = new BufferedReader(new InputStreamReader(fis));
			filecontent = new StringBuilder();
			
			while((line=br.readLine())!=null)
			{
				if(line.compareTo(filename) == 0)
				{
					filecontent.append("*\n");
				}
				else
				{
					filecontent.append(line + "\n");
				}
			}
			
			br.close();
			str=filecontent.toString();
			content = str.replaceAll("(?!\\r)\\n", "\r\n");
			fos = new FileOutputStream(savePath + File.separator + "user" + ".txt");
			ps = new PrintStream(fos);
			ps.println(content);
			ps.close();
		}

		response.sendRedirect("/APLab9/Manager_HomePage");
	}
}