package com.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.po.Admin;
import com.po.Student;
import com.util.C3P0;

public class AdminDAOImpl implements AdminDAO{
	
	PreparedStatement stmt;
	ResultSet rs;
	
	public boolean certificate(Admin admin) throws Exception{		
		
		Admin a = new Admin();
		
		String sql = "select * from user where Admin = ?";//select from user where Admin = (adminName)
		Connection conn = C3P0.getConnection();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1,admin.getUser());
		ResultSet rs = stmt.executeQuery();
		//show if admin.getPassword() is in the database
		if(rs.next()){
			rs.previous();
		}else{
			return false;
		}
		
		while (rs.next()) {
			a.setUser(rs.getString("Admin"));//Sno will be changed into IDCard in the future
			a.setPassword(rs.getString("Password"));
		}
		
		if((a.getPassword()).equals(admin.getPassword())) {
			conn.close();
			return true;
		}else {
			conn.close();
			return false;
		}
	}
}
