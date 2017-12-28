package com.dao;

import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.util.C3P0;

import com.po.FixTime;
import com.po.Admin;
import com.po.Customer;
import com.dao.FixTimeDAO;

public class FixTimeDAOImpl implements FixTimeDAO{
	
	PreparedStatement stmt;
	ResultSet rs;
	
	@Override
	public List<FixTime>  getAllInformation()throws Exception{
		
		List<FixTime> list = new ArrayList<FixTime>();
		Connection conn = C3P0.getConnection();
		String sql = "select * from timefix";
		
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
		while(rs.next()) {
			FixTime myTime=new FixTime();
			myTime.setTimeName(rs.getString("TimeName"));
			myTime.setUserID(rs.getString("UserID"));
			myTime.setUserName(rs.getString("UserName"));
			myTime.setOperation(rs.getString("Operation"));
			myTime.setTimesLeft(rs.getString("TimesLeft"));
			
			list.add(myTime);
			
		}
		conn.close();
		return list;
	}

	@Override
	public void save(FixTime fixTime) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<FixTime> getSigner(String UserID) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from timefix where UserID = ?";
		
		Connection conn = C3P0.getConnection();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, UserID);
		ResultSet rs = stmt.executeQuery();
		
		List<FixTime> list = new ArrayList<FixTime>();
		if (rs.next()) {
			FixTime myTime=new FixTime();
			myTime.setTimeName(rs.getString("TimeName"));
			myTime.setUserID(UserID);// static here
			myTime.setUserName(rs.getString("UserName"));
			myTime.setOperation(rs.getString("Operation"));
			myTime.setTimesLeft(rs.getString("TimesLeft"));
			
			list.add(myTime);
		}
		conn.close();
		return list;
	}
	
	public List<FixTime> getForFixTime(FixTime t) throws Exception{
		// TODO Auto-generated method stub
		
		List<FixTime> list = new ArrayList<FixTime>();
		Connection conn = C3P0.getConnection();
		String sql = "select * from fixtime where UserID like ?";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, t.getUserID() == null ? "%%" : "%" + t.getUserID() + "%");
		rs = stmt.executeQuery();
		while (rs.next()) {
			FixTime fix=new FixTime();
			fix.setSno(rs.getString("Sno"));
			fix.setSname(rs.getString("Sname"));
			fix.setPhone(rs.getString("Phone"));
			fix.setTimesLeft(rs.getInt(4));//colomn4 is timesLeft
			fix.setInformation(rs.getString("information"));
			list.add(fix);
		}
		conn.close();
		return list;
	}
}
