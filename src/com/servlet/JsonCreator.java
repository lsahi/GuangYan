package com.servlet;

import java.util.List;

import com.google.gson.Gson;
import com.po.Activity;


public class JsonCreator<T> {
	
	public String JsonCreator(List<T> t){
		
		Gson gson=new Gson();
		String myJson=gson.toJson(t);
		return myJson;
		
	}
	
	//useless
	/*
	public List<Message> messageJsonCreator(){
		
	}
	*/
}
