package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.util.C3P0;

import com.po.Student;
import com.servlet.DateToString;
import com.servlet.JsonCreator;
import com.po.Activity;
import com.po.FixTime;

public class StudentDAOImpl implements StudentDAO{

	PreparedStatement stmt;
	ResultSet rs;
	
	@Override
	public void addStudent(Student student) throws Exception{
		
		//?
		
		String sql = "insert into student (sname,password,smail,phone,gender,type1,type2,type3,type4) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn=C3P0.getConnection();
		
		stmt=conn.prepareStatement(sql);
		
		//stmt.setInt(1, 1);
		stmt.setString(1, student.getSname());
		stmt.setString(2, student.getPassword());
		stmt.setString(3, student.getMail());
		stmt.setString(4, student.getPhone());
		stmt.setInt(5, student.getGender());
		stmt.setInt(6, student.getType1());
		stmt.setInt(7, student.getType2());
		stmt.setInt(8, student.getType3());
		stmt.setInt(9, student.getType4());
		
		stmt.executeUpdate();

		conn.close();
	}
	
	@Override
	public void updateStudent(Student student) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update student set Sname = ?, type1 = ?, type2 = ?, type3 = ?, type4 = ? where Sname = ?";
		Connection conn = C3P0.getConnection();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, student.getSname());
		stmt.setInt(2, student.getType1());
		stmt.setInt(3, student.getType2());
		stmt.setInt(4, student.getType3());
		stmt.setInt(5, student.getType4());
		stmt.setString(6, student.getSname());
		stmt.executeUpdate();
		
		//
		//System.out.println(customer.getInformation());
		
		conn.close();
	}

	//done
	@Override
	public Student getSignerByName(String sname) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from student where Sname = ?";
		Connection conn = C3P0.getConnection();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, sname);
		ResultSet rs = stmt.executeQuery();
		Student stu = null;
		if (rs.next()) {
			
			stu = new Student();
			stu.setSno(rs.getString("Sno"));
			stu.setSname(rs.getString("Sname"));
			stu.setPassword(rs.getString("password"));
			stu.setMail(rs.getString("smail"));
			stu.setPhone(rs.getString("Phone"));
			stu.setGender(rs.getInt("gender"));
			stu.setType(rs.getInt("type1"), rs.getInt("type2"), rs.getInt("type3"), rs.getInt("type4"));
		}
		conn.close();
		return stu;
	}
	
	public boolean inDatabase(String sname)throws Exception{
		
		boolean flag=true;
		
		String sql = "select * from student where Sname = ?";
		Connection conn = C3P0.getConnection();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, sname);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			return flag;
		}else {
			flag=false;
			return flag;
		}
	}
	
	public Student getSignerById(String sno) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from student where Sno = ?";
		Connection conn = C3P0.getConnection();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, sno);
		ResultSet rs = stmt.executeQuery();
		Student stu = null;
		if (rs.next()) {
			
			stu = new Student();
			stu.setSno(rs.getString("Sno"));
			stu.setSname(rs.getString("Sname"));
			stu.setPassword(rs.getString("password"));
			stu.setMail(rs.getString("smail"));
			stu.setPhone(rs.getString("Phone"));
			
			stu.setGender(rs.getInt("gender"));
			stu.setType(rs.getInt("type1"), rs.getInt("type2"), rs.getInt("type3"), rs.getInt("type4"));
		}
		conn.close();
		return stu;
	}

	public String studentToJson(List<Student> s) {
		JsonCreator creator=new JsonCreator();
		String showAllJson=creator.JsonCreator(s);
		return showAllJson;
	}

	@Override
	public boolean loginCheck(String sname, String password) {
		
		Student s=new Student();
		try {
			if(!inDatabase(sname)) {
				return false;
			} else {
				s=this.getSignerByName(sname);
				if(password.equals(s.getPassword())) {
					return true;
				}else {
					return false;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	
	}
	


}







