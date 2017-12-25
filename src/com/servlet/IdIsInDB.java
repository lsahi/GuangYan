package com.servlet;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.http.HttpServlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dao.CustomerDAOImpl;
import com.po.Customer;
import com.util.C3P0;

//function composing
public class IdIsInDB extends HttpServlet{
	
	IdIsInDB(String ID, String name)throws Exception{
		
		Customer c = new Customer();
		CustomerDAOImpl cus=new CustomerDAOImpl();
		
		PreparedStatement stmt;
		
		String sql = "select * from user where Sno = ?";//select from user where Admin = (adminName)
		Connection conn = C3P0.getConnection();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1,ID);
		ResultSet rs = stmt.executeQuery();
		
		//show if sno is in the database
		if(rs.next()){
			rs.previous();
			
			//timeused
			c=cus.getSigner(ID);
			String myTime=c.getTimesLeft();
			//get timesLeft
			int time = Integer.valueOf(myTime).intValue();
			c.setTimesLeft(time+1);
		}else{
			
			//new user
			c.setSno(ID);
			c.setSname(name);
			c.setPhone(" ");
			c.setInformation("ÎÞ±¸×¢");
			c.setTimesLeft(0);
			
			//update new user => ID and name got from ID certification 
			//                => Phone number and information set as null and timesleft set as 0
			cus.save(c);
		}
	}
}
