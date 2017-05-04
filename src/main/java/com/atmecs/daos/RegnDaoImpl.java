package com.atmecs.daos;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.atmecs.pojo.TechTalkRegistration;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;
public class RegnDaoImpl implements AutoCloseable{
	
	
	private Connection connection;
	private PreparedStatement statment;
	
	static {
		//System.out.println("inside static block");
		try {
			//System.out.println("test:"+DBUtil.DB_DRIVER);
			Class cls = Class.forName(DBUtil.DB_DRIVER);
			Driver driver = (Driver) cls.newInstance();
			DriverManager.registerDriver(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void open() throws SQLException{
		connection = (Connection) DriverManager.getConnection(DBUtil.DB_URL, DBUtil.DB_USER, DBUtil.DB_PASS);
	}
	public void close(){
		try{
			if(connection!=null)
				connection.close();
		}catch(Exception e){
		}
	}
   public List<TechTalkRegistration> getRegnList() throws SQLException{
			String sql = "SELECT EMAIL,TECHTALK,DATE FROM TECHTALKREGN";
			ResultSet resultSet = null;
			List<TechTalkRegistration> list = new ArrayList();
			try {
				statment = (PreparedStatement) connection.prepareStatement(sql);
				resultSet = statment.executeQuery();
				while (resultSet.next()) {
					TechTalkRegistration registration = new TechTalkRegistration();
					registration.setEmail(resultSet.getString("Email"));
					registration.setTechTalk(resultSet.getString("TechTalk"));
					registration.setDate(resultSet.getDate("Date"));
					list.add(registration);

				}
			} finally {
				if(resultSet!=null)
					resultSet.close();
				if(statment!=null)
					statment.close();
			}
			return list;
		}

	}

