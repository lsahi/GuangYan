package com.po;

public class Customer {

	String sno;
	String sname;
	String phone;
	int timesLeft;	   //�����Ǵ�������
	String information;//�����Ǳ�ע

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	@Override
	public String toString() {
		return "Customer [sno=" + sno + ", sname=" + sname + ", phone=" + phone + ", timesLeft" + timesLeft + ", information" + information
				+ "]";//
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getTimesLeft() {
		return timesLeft+"";
	}
	
	/**
	 * @param timesLeft
	 */
	public void setTimesLeft(int timesLeft) {
		this.timesLeft = timesLeft;		
	}
	
	//public void timesUsed()
	
	public String getInformation() {
		return information;
	}
	
	public void setInformation(String information) {
		this.information=information;
	}
	
}
