package com.po;	

import java.util.Date;
import java.text.SimpleDateFormat;

public class FixTime {
	String TimeName;
	String UserID;
	String UserName;
	String Operation;
	String TimesLeft;
	String CurrentTime;
	
	public String getTimeName(){
		return TimeName;
	}
	
	//Time+Name=TimeName
	//get time here and import admin name	
	public void setTimeName(String TimeName) {

		/*
		 * new Date to get current time
		 * df.format to output as a standard format
		 */
		this.TimeName=TimeName;
		//SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd-HH:mm:ss");
		//df.format(new Date())+"-"+Admin;
	}
	
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String UserID) {
		this.UserID=UserID;
	}
	
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String UserName) {
		this.UserName=UserName;
	}
	
	public String getOperation() {
		return Operation;
	}
	public void setOperation(String Operation) {
		this.Operation=Operation;
	}
	
	public String getTimesLeft() {
		return TimesLeft;
	}
	public void setTimesLeft(String TimesLeft) {
		this.TimesLeft=TimesLeft;
	}
	
	public String getCurrentTime() {
		return CurrentTime;
	}
	//automatically time-setting
	public void setCurrentTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd-HH:mm:ss");
		df.format(new Date());
		this.CurrentTime=df.format(new Date());
	}
	//get the object from database
	public void setCurrentTime(String CurrentTime) {
		this.CurrentTime=CurrentTime;
	}
	public FixTime(){
		setCurrentTime();
	}

}
