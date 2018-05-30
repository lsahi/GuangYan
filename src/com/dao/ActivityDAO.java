package com.dao;

import java.util.List;

import com.po.*;

public interface ActivityDAO {

	//public List<Activity> getAllInformation() throws Exception;
	
	public List<Activity> selectAllActivity()throws Exception;
	
	public List<Activity> select(String keyword)throws Exception;
	
	public String activityToJson(List<Activity> myActivity);
	
	public void addActivity()throws Exception;
	
}
