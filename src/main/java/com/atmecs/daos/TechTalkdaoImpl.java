package com.atmecs.daos;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.atmecs.pojo.Talks;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;

public class TechTalkdaoImpl implements AutoCloseable {

	private Connection connection;
	private PreparedStatement statment;
	
	static {
		try {
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
	public  List<Talks> getTechTalks() throws SQLException{
		List<Talks> talkList = new ArrayList();
		String sql = "select * from talks";
		this.open();
		statment = (PreparedStatement) connection.prepareStatement(sql);
		ResultSet resultset = statment.executeQuery();
		
		while(resultset.next()){
			Talks talk = new Talks();
			talk.setDate(resultset.getDate("Date"));
			talk.setTechTalk(resultset.getString("TechTalk"));
			talk.setPresentator(resultset.getString("Presentator"));
        	talkList.add(talk);
			}
		return talkList;
		}
	
	public void addTechTalk(Talks talk){
		String sql = "insert into talks`(`Date`, `TechTalk`, `Presentator`) values (?,?,?)";
		try {
			this.open();
			statment =  (PreparedStatement) connection.prepareStatement(sql);
			statment.setDate(1, talk.getDate());
			statment.setString(2, talk.getTechTalk());
			statment.setString(3, talk.getPresentator());
			statment.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			if(statment!=null){
				try {
					statment.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
