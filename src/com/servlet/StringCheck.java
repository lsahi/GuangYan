package com.servlet;

public class StringCheck<T> {
	public int checkString(T t){
		
		if(t instanceof String) {
			return 1;
		}else {
			return 0;
		}
		
	}
}
