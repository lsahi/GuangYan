package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.*;

import com.po.Activity;
import com.po.Student;
import com.servlet.JsonCreator;
import com.util.C3P0;

public class ActivityDAOImpl implements ActivityDAO{

	PreparedStatement stmt;
	ResultSet rs;
	
	
	//done
	public List<Activity> selectAllActivity() throws Exception{
		// TODO Auto-generated method stub
			List<Activity> list = new ArrayList<Activity>();
			Connection conn = C3P0.getConnection();
			String sql = "select * from activity";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Activity myActivity=new Activity();
				/*
				stu.setSno(rs.getString("Sno"));//Sno will be changed into IDCard in the future
				stu.setSname(rs.getString("Sname"));
				stu.setPhone(rs.getString("Phone"));
				stu.setTimesLeft(rs.getInt(4));//colomn4 is timesLeft
				stu.setInformation(rs.getString("information"));
				*/
				myActivity.setId(rs.getString("idactivity"));
				myActivity.setHost(rs.getString("activityhost"));
				myActivity.setName(rs.getString("activityname"));
				myActivity.setDetails(rs.getString("activityinfo"));
				myActivity.setType(rs.getInt("type1"), rs.getInt("type2"), rs.getInt("type3"), rs.getInt("type4"));
				myActivity.setEnabled(rs.getInt("activityenabled"));
				list.add(myActivity);
			}
			conn.close();
			return list;
	}
	
	//done
	public List<Activity> select(String keyword)throws Exception{
		List<Activity> list = new ArrayList<Activity>();
		Connection conn = C3P0.getConnection();
		//
		String sql = "select * from activity where activityname like ? or activityname like ? or activityinfo like ?";

		//String sql = "select * from activity where activityname = ?";
		//or activityname like %?% or activityinfo like %?%
		stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, "%"+keyword+"%");
		stmt.setString(2, "%"+keyword+"%");
		stmt.setString(3, "%"+keyword+"%");
		rs = stmt.executeQuery();
		
		while (rs.next()) {
			Activity myActivity=new Activity();
			
			myActivity.setId(rs.getString("idactivity"));
			myActivity.setHost(rs.getString("activityhost"));
			myActivity.setName(rs.getString("activityname"));
			myActivity.setDetails(rs.getString("activityinfo"));
			myActivity.setType(rs.getInt("type1"), rs.getInt("type2"), rs.getInt("type3"), rs.getInt("type4"));
			myActivity.setEnabled(rs.getInt("activityenabled"));
			
			list.add(myActivity);
		}
		conn.close();
		return list;
	}
	
	public String activityToJson(List<Activity> myActivity) {
		JsonCreator creator=new JsonCreator();
		String showAllJson=creator.JsonCreator(myActivity);
		return showAllJson;
	}

}
