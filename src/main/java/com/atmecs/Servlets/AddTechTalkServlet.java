package com.atmecs.Servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atmecs.daos.TechTalkdaoImpl;
import com.atmecs.pojo.Talks;

public class AddTechTalkServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	public void  processRequest(HttpServletRequest req,HttpServletResponse resp){
		
		try {
			Talks talk = new Talks();
			String startDateStr = req.getParameter("date");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println(sdf.toString());
			java.sql.Date startDate =(java.sql.Date ) sdf.parse(startDateStr);
			
			System.out.println(sdf);
			talk.setDate(startDate);
			talk.setTechTalk(req.getParameter("tt"));
			talk.setPresentator(req.getParameter("presentator"));
			TechTalkdaoImpl techTalkDao = new TechTalkdaoImpl();
			techTalkDao.addTechTalk(talk);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
}
