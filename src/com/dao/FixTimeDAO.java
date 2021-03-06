package com.dao;

import java.util.List;

import com.po.FixTime;
import com.po.Admin;//

public interface FixTimeDAO {
	
	/*
	 * Get all information in the database
	 */
	public List<FixTime>  getAllInformation()throws Exception;
	
	/*
	 * save
	 * while new user added or odd user changed, save (add)
	 */
	public void save(FixTime fixTime)throws Exception;
	
	/*
	 * Show all operation done by the certain user
	 */
	public List<FixTime> getSigner(String UserID)throws Exception;
	
	/*
	 * 
	 */
	public List<FixTime> getForFixTime(FixTime t)throws Exception;
	
	
}
