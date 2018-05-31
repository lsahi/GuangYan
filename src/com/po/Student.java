package com.po;

public class Student {

	String sno;
	String sname;
	String password;
	String smail;
	String phone;
	
	int gender;
	int type1;
	int type2;
	int type3;
	int type4;

	public String getSno() {
		return sno;
	}
	//
	public void setSno(String sno) {
		this.sno = sno;
	}
/*
	@Override
	public String toString() {
		return "Customer [sno=" + sno + ", sname=" + sname + ", phone=" + phone + ", timesLeft" + timesLeft + ", information" + information
				+ "]";//
	}
*/
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	//public void timesUsed()
	
	public String getMail() {
		return smail;
	}
	public void setMail(String smail) {
		this.smail=smail;
	}
	
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender=gender;
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
	
}
