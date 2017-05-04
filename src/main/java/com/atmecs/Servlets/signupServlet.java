package com.atmecs.Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atmecs.daos.EmployeeDaoImpl;
import com.atmecs.pojo.Employee;

public class signupServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doGet(req, resp);
		doTag(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doPost(req, resp);
		doTag(req,resp);
	}
	public void doTag(HttpServletRequest req,HttpServletResponse resp) throws IOException{
	   Employee employee = new Employee();
	   employee.setEmail(req.getParameter("email"));
	   employee.setName(req.getParameter("name"));
	   employee.setPassword(req.getParameter("pass"));
	   EmployeeDaoImpl empDao = new EmployeeDaoImpl();
	   try {
		empDao.insertEmp(employee);
	    resp.sendRedirect("techTalk.jsp");
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
		
	}

}
