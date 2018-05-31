package com.servlet;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateToString {
	
	public String dateToString() {
		Date date=new Date();
		SimpleDateFormat myDate=  new SimpleDateFormat("yyyyMMddHHmmss");  
	    String d = myDate.format(date);  
	    return d;
	}
}