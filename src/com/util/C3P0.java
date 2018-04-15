package com.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.dao.CustomerDAOImpl;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0 {
	//

	private static final String URL = "jdbc:mysql://localhost/androidserver?characterEncoding=utf8&useSSL=false";
	private static final String USER = "root";
	private static final String PASSWORD = "123456";
	private static final String DRIVERCLASS = "com.mysql.jdbc.Driver";
	private static final String sql="select * from student";
	static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	static {
		dataSource.setUser(USER);
		dataSource.setPassword(PASSWORD);
		dataSource.setJdbcUrl(URL);
		try {
			dataSource.setDriverClass(DRIVERCLASS);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
	public static void main(String[] args) throws Exception {
		
		Connection conn = C3P0.getConnection();
		if (conn != null) {
			System.out.println("OK,Database Connected");
		} else {
			System.out.println("Connection Error");
		}
		
		//test accepted
		/*
		CustomerDAOImpl myCustomer=new CustomerDAOImpl();
		myCustomer.getAllInformation();
		List<Customer> students = myCustomer.getAllInformation();

		for (Customer c1 : students) {
			System.out.println(c1.getSno() + "  " + c1.getSname() + "  " + c1.getPhone() +" "+ c1.getTimesLeft() +" "+ c1.getInformation());
		}
		*/
		
	}
}
