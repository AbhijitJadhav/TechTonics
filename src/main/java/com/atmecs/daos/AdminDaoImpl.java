package com.atmecs.daos;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;

public class AdminDaoImpl implements AutoCloseable{


		private Connection connection;
		PreparedStatement statment;
		
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
	}

