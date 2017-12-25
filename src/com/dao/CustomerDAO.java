package com.dao;

import java.util.List;

import com.po.Customer;

public interface CustomerDAO {
	
	/*
	 * 获取所有信息
	 * */
	public List<Customer> getAllInformation() throws Exception;
	
	/*
	 * 添加信息，不清楚为何用save,不用add
	 * */
	public void save(Customer customer) throws Exception;
	 
	/*
	 * 获取个人信息
	 * */
	public Customer getSigner(String Sno) throws Exception;
	
	/*
	 * 删除信息
	 * */
	public void delete(String Sno) throws Exception;
	
	/*
	 * 不能添加相同的信息
	 * */
	public boolean getCountWithName(String Sname) throws Exception;
	
	/*
	 * 模糊查询条件
	 * */
	public List<Customer> getForCustomer(Customer c) throws Exception;
	
	public void update(Customer c) throws Exception;
	
}







