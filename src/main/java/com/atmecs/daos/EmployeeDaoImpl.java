package com.atmecs.daos;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.atmecs.pojo.Employee;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;

public class EmployeeDaoImpl implements AutoCloseable{

	
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
			//System.out.println(connection);
		}
		public void close(){
			try{
				if(connection!=null)
					connection.close();
			}catch(Exception e){
			}
		}
		public void insertEmp(Employee employee) throws SQLException{
			String sql = "insert into employee(Email, Name, Password) values (?,?,?)";
			try {
				this.open();
				statment =  (PreparedStatement) connection.prepareStatement(sql);
				statment.setString(1, employee.getEmail());
				statment.setString(2, employee.getName());
				statment.setString(3, employee.getPassword());
				statment.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				if(statment!=null){
					statment.close();
				}
			}
			
		}
		}

