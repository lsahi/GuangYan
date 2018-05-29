package com.dao;

import java.util.List;

import com.po.Student;

public interface StudentDAO {
	
	/*
	 * ��ȡ������Ϣ
	 * */
	public List<Student> getAllInformation() throws Exception;
	
	/*
	 * �����Ϣ�������Ϊ����save,����add
	 * */
	public void save(Student customer) throws Exception;
	 
	/*
	 * ��ȡ������Ϣ
	 * */
	public Student getSigner(String Sno) throws Exception;
	
	/*
	 * ɾ����Ϣ
	 * */
	public void delete(String Sno) throws Exception;
	
	/*
	 * ���������ͬ����Ϣ
	 * */
	public boolean getCountWithName(String Sname) throws Exception;
	
	/*
	 * ģ����ѯ����
	 * */
	public List<Student> getForCustomer(Student c) throws Exception;
	
	public void update(Student c) throws Exception;
	
}







