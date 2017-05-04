package com.atmecs.Servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class LoginServlet extends HttpServlet {
	@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		System.out.println("Step1");
		if(request.getParameter("user").equals("abhijit.jadhav@atmecs.com") && request.getParameter("pass").equals("Abhi@123"))
		{
		HttpSession	session = request.getSession();
		session.setAttribute("username", request.getParameter("user"));
			response.sendRedirect("techTalk.jsp");
		}
		else
		{
			response.getWriter().println("Wrong username or password");
		}
	}

}
