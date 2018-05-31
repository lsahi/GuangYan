package com.dao;

import java.util.List;

import com.po.Student;

public interface StudentDAO {
	
	//
	public void addStudent(Student student) throws Exception;
	
	//get student from name
	public Student getSigner(String sname) throws Exception;
	
	public List<Student> getForCustomer(Student c) throws Exception;
	
	public void updateStudent(Student c) throws Exception;
	
	public String loginCheck(String sname, String password);
	
	public Student getSignerByName(String sname) throws Exception;
	
	public Student getSignerById(String sno) throws Exception;
}







