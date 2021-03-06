package com.servlet;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.http.HttpServlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.servlet.JudjeServlet;
import com.dao.CustomerDAOImpl;
import com.dao.FixTimeDAOImpl;
import com.po.Customer;
import com.po.FixTime;
import com.util.C3P0;

import java.io.*;

//function composing
public class IdIsInDB extends HttpServlet{
	
	public static void idInDB(String ID, String name)throws Exception{
		
		Customer c = new Customer();
		CustomerDAOImpl cus=new CustomerDAOImpl();
		FixTime fix=new FixTime();
		FixTimeDAOImpl f=new FixTimeDAOImpl();
		
		PreparedStatement stmt;
		
		String sql = "select * from student where Sno = ?";//select from user where Admin = (adminName)
		Connection conn = C3P0.getConnection();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1,ID);
		ResultSet rs = stmt.executeQuery();
		
		//show if sno is in the database
		if(rs.next()){//IN 
			rs.previous();
			
			fix.setTimeName(fix.getCurrentTime()+" - SystemAuto");
			fix.setUserID(ID);
			fix.setUserName(name);

			//timeused
			c=cus.getSigner(ID);
			String myTime=c.getTimesLeft();
			int time = Integer.valueOf(myTime).intValue();
			//get timesLeft
			if(time>0) {
				if(time==1) {
					;//System.out.println(); 用户仅剩1次，提醒充值
				}
				c.setTimesLeft(time-1);
				fix.setOperation("消费");
				fix.setTimesLeft((time-1)+"");
				fix.setCurrentTime();
				cus.update(c);
				f.save(fix);
				
				
			}else {
				c.setTimesLeft(time);
				cus.update(c);
				fix.setOperation("余额不足，消费失败");
				fix.setTimesLeft(time+"");
				fix.setCurrentTime();
				f.save(fix);
			}
			
			
		}else{//NOT IN
			
			//new user
			c.setSno(ID);
			c.setSname(name);
			c.setPhone(" ");
			c.setInformation("无备注");
			c.setTimesLeft(0);
			
			//use SystemAuto here for test
			//while the operation made by SystemAuto, it IS done not by anyone but the function( which get id from client)
			//will make a session in the future and save the user in server session
			//the user in session will be the name 
			fix.setTimeName(fix.getCurrentTime()+" - SystemAuto");
			fix.setUserID(ID);
			fix.setUserName(name);
			fix.setOperation("注册");
			fix.setTimesLeft("0");
			fix.setCurrentTime();
			
			//update new user => ID and name got from ID certification 
			//                => Phone number and information set as null and timesleft set as 0
			cus.save(c);
			f.save(fix);

			
			
			//BrowserOpenServlet open=new BrowserOpenServlet(ID);
		}
	}
}
