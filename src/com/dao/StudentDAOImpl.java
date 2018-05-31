package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.util.C3P0;

import com.po.Student;
import com.servlet.DateToString;
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
		String sql = "update student set Sname = ?, type1 = ?, type2 = ?, type3 = ?, type4 = ?, where sno = ?";
		Connection conn = C3P0.getConnection();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, student.getSname());
		stmt.setInt(2, student.getType1());
		stmt.setInt(3, student.getType2());
		stmt.setInt(4, student.getType3());
		stmt.setInt(5, student.getType4());
		stmt.setString(6, student.getSno());
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
	

	@Override
	public List<Student> getForCustomer(Student c) throws Exception {

		List<Student> list = new ArrayList<Student>();
		Connection conn = C3P0.getConnection();
		String sql = "select * from student where sno like ? and sname like ? and phone like ?";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, c.getSno() == null ? "%%" : "%" + c.getSno() + "%");
		stmt.setString(2, c.getSname() == null ? "%%" : "%" + c.getSname() + "%");
		stmt.setString(3, c.getPhone() == null ? "%%" : "%" + c.getPhone() + "%");
		rs = stmt.executeQuery();
		while (rs.next()) {
			Student stu = new Student();
			stu.setSno(rs.getString("Sno"));
			stu.setSname(rs.getString("Sname"));
			stu.setPhone(rs.getString("Phone"));
			stu.setTimesLeft(rs.getInt(4));//colomn4 is timesLeft
			stu.setInformation(rs.getString("information"));
			list.add(stu);
		}
		conn.close();
		return list;
	}

}







