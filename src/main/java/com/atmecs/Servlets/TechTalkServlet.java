package com.atmecs.Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atmecs.daos.TechTalkdaoImpl;
import com.atmecs.pojo.Talks;

@WebServlet
public class TechTalkServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doGet(req, resp);
		processRequest(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doPost(req, resp);
		processRequest(req,resp);
	}
	public void processRequest(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		TechTalkdaoImpl techTalkDao = new TechTalkdaoImpl();
		 try {
			List<Talks> techTalks = techTalkDao.getTechTalks();
			System.out.println(techTalks);
			req.setAttribute("techTalks", techTalks);
			System.out.println(techTalks);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/techTalk.jsp");
			requestDispatcher.forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	}

