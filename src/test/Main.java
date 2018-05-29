package test;

import java.util.List;
import com.dao.AdminDAO;
import com.dao.AdminDAOImpl;

import com.dao.StudentDAO;
import com.dao.StudentDAOImpl;

import com.po.Student;
import com.po.Admin;

public class Main {
	public static void main(String[] args) throws Exception {
		
//		CustomerDAO c = new CustomerDAOImpl();
//		
//		
//		Customer c2 = new Customer();
//		c2.setSno("15251102180");
//		c2.setSname("lisi");
//		c2.setPhone("13125457854");
//		c.save(c2);
//		List<Customer> students = c.getAllInformation();
//		for (Customer c1 : students) {
//			System.out.println(c1.getSno() + "  " + c1.getSname() + "  " + c1.getPhone());
//		}
//		System.out.println("-------------");
//		c.delete("15251102180");
//		students = c.getAllInformation();
		AdminDAO a= new AdminDAOImpl();
		/*
		for (Customer c1 : students) {
			System.out.println(c1.getSno() + "  " + c1.getSname() + "  " + c1.getPhone() +" "+ c1.getTimesLeft() +" "+ c1.getInformation());
		}*/
		Admin admin = new Admin();
		admin.setUser("admin");
		admin.setPassword("000000");
		if(a.certificate(admin)) {
			System.out.println("T");
		}else {
			System.out.println("f");
		}
		
	}
}
