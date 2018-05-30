package com.po;

public class Activity {

	String id;
	String host;
	String name;
	String details;
	int type1;
	int type2;
	int type3;
	int type4;
	int enabled;
	
	public void setId(String id) {
		this.id= id;
	}
	public String getId() {
		return id;
	}
	
	public void setHost(String host) {
		this.host=host;
	}
	public String getHost() {
		return host;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setDetails(String details) {
		this.details=details;
	}
	public String getDetails() {
		return details;
	}
	
	public void setType(int t1,int t2, int t3, int t4) {
		this.type1=t1;
		this.type2=t2;
		this.type3=t3;
		this.type4=t4;
	}
	public int getType1() {
		return type1;
	}
	public int getType2() {
		return type2;
	}
	public int getType3() {
		return type3;
	}
	public int getType4() {
		return type4;
	}
	
	public void setEnabled(int enabled) {
		this.enabled=enabled;
	}
	public int getEnabled() {
		return enabled;
	}
}
