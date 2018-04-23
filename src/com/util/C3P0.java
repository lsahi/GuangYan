package com.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.dao.CustomerDAOImpl;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0 {
	//
	/**数据库连接池
	 * URL=数据库位置
	 * USER=
	 * PASSWORD=
	 * DRIVERCLASS=
	 * sql=默认语句->查询整个表
	*/
	private static final String URL = "jdbc:mysql://localhost/app?useSSL=false";
	private static final String USER = "root";
	private static final String PASSWORD = "123456";
	private static final String DRIVERCLASS = "com.mysql.jdbc.Driver";
	private static final String sql="select * from student";
	static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	/*
	用于连接本机上的默认实例名  
  
  String URL ="jdbc:sqlserver://localhost;integratedSecurity=true;DatabaseName=JspDB";  
  
  //用于连接本机上的指定实例名(如果有两个实例,这时的端口号默认为是:1434)  
  
  //要先开启SQL Server服务/SQL Server Browser这项服务  
  
  String url = "jdbc:sqlserver://localhost;instanceName=MYSQL2008;integratedSecurity=true;DatabaseName=jdbcDB";    
	 * */
	
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
