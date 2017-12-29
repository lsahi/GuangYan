package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDAOImpl;
import com.dao.CustomerDAOImpl;
import com.dao.FixTimeDAOImpl;
import com.po.Admin;
import com.po.Customer;
import com.po.FixTime;

public class JudjeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	String thisAdmin;
	CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
	FixTimeDAOImpl fixTimeDAOImpl=new FixTimeDAOImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JudjeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");// setCharset
		String servletPath = request.getServletPath();
		String methodName = servletPath.substring(1,servletPath.length()-3);
		try {
			if ("addCustomerServlet".equals(methodName)) {
				add(request, response);
			} else if ("queryCustomerServlet".equals(methodName)) {
				query(request, response);
			} else if ("queryChangeInfo".equals(methodName)) { //ChangeInfo
				queryChangeInfo(request, response);
			} else if ("delete".equals(methodName)) {
				delete(request, response);
			} else if ("edit".equals(methodName)) {
				edit(request, response);
			} else if ("update".equals(methodName)) {
				update(request, response);
			} else if ("pwCertificate".equals(methodName)){
			 	pwCertifacate(request, response);
			}

			//add here -pw certification
		} catch (Exception e) {
			// TODO: handle exception
			response.sendRedirect("index.jsp");
		}
	}
	
	private void queryChangeInfo(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		FixTime f= new FixTime();
		f.setUserID(request.getParameter("UserID"));
		List<FixTime> listFixTime=fixTimeDAOImpl.getForFixTime(f);
		request.setAttribute("listFixTime", listFixTime);
		System.out.println("give out list");
		request.getRequestDispatcher("changeinfo.jsp").forward(request, response);
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String sno = request.getParameter("sno");
		customerDAOImpl.delete(sno);
		response.sendRedirect("queryCustomerServlet.do");
	}
	
	//done
	private void update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//request.setCharacterEncoding("utf-8");// setCharset
		
		//
		//String oldSno = request.getParameter("sno");
		String sno = request.getParameter("sno");
		String sname = request.getParameter("sname");
		String phone = request.getParameter("phone");
		String timesLeft = request.getParameter("timesLeft");
		String information = request.getParameter("information");
		int charged =Integer.parseInt(timesLeft);//本次新增
		//test accepted 

		Customer c = new Customer();
		CustomerDAOImpl temp=new CustomerDAOImpl();
		int left;
		//left=Integer.parseInt(c.getTimesLeft()); //加上数据库中原有
		c.setSno(sno);
		Customer stu=temp.getSigner(sno);

		left=charged+Integer.parseInt(stu.getTimesLeft());
		c.setSname(sname);
		c.setPhone(phone);
		c.setTimesLeft(left);					//实际剩余
		c.setInformation(information);
		
		//
		
		/*if (oldSno.equals(sno)) {
			customerDAOImpl.update(c);
			response.sendRedirect("queryCustomerServlet.do");
		} else {
			request.setAttribute("msg", "不能修改身份证号，请重新输入");
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}*/
		
		//应用修改
		FixTime fix=new FixTime();
		/**
		 * 
		 */
		String admin=thisAdmin;
		String timeName=fix.getCurrentTime()+" - "+admin;
		String currentOperation=null;
		if(charged>0) {
			currentOperation= "充值" +charged+"次";
		}
		else {
			currentOperation="修改个人信息";
		}
		
		fix.setTimeName(timeName);
		fix.setUserID(c.getSno());
		fix.setUserName(c.getSname());
		fix.setOperation(currentOperation);
		fix.setTimesLeft(left+"");
		fix.setCurrentTime();
		
		fixTimeDAOImpl.save(fix);
		customerDAOImpl.update(c);
		response.sendRedirect("queryCustomerServlet.do");
	}

	//while update, edit first
	private void edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");// setCharset
		String sno = request.getParameter("sno");
		Customer customer = customerDAOImpl.getSigner(sno);
		request.setAttribute("customer", customer);
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}

	private void query(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Customer c = new Customer();
		c.setSno(request.getParameter("sno"));
		c.setSname(request.getParameter("sname"));
		c.setPhone(request.getParameter("phone"));
		
		List<Customer> listCustomer = customerDAOImpl.getForCustomer(c);
		request.setAttribute("listCustomer" ,listCustomer);
		request.getRequestDispatcher("query.jsp").forward(request, response);
	}

	//done
	private void add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");// setCharset
		boolean flag = customerDAOImpl.getCountWithName(request.getParameter("sno"));
		if (flag || request.getParameter("sno") == null || request.getParameter("sno") == "") {
			request.setAttribute("msg", "该身份证号" + request.getParameter("sno") + "已经被注册，请换其他学号");
			request.getRequestDispatcher("add.jsp").forward(request, response);
		} else {
			Customer c = new Customer();
			c.setSno(request.getParameter("sno"));
			c.setSname(request.getParameter("sname"));
			c.setPhone(request.getParameter("phone"));
			c.setInformation(request.getParameter("information"));
			//System.out.println(request.getParameter("information")+1);
			/*
			if((request.getParameter("information"))==" ") {
				c.setInformation(request.getParameter("information")+"无备注");
				System.out.println(c.getInformation());
			}else {
				//c.setInformation(request.getParameter("information"));
			}*/
			
			//System.out.println(c.getInformation()+"111");
			
			/*
			 * 添加到记录 
			 */
			FixTime fix=new FixTime();
			/**
			 * 
			 */
			String admin=thisAdmin;
			String timeName=fix.getCurrentTime()+" - "+admin;
			
			fix.setTimeName(timeName);
			fix.setUserID(c.getSno());
			fix.setUserName(c.getSname());
			fix.setOperation("注册");
			fix.setTimesLeft("0");
			fix.setCurrentTime();
			
			fixTimeDAOImpl.save(fix);
			customerDAOImpl.save(c);
			
			request.setAttribute("msg", "恭喜你，该身份证" + request.getParameter("sno") + "注册成功，请返回查看或继续添加");
			
			request.getRequestDispatcher("add.jsp").forward(request, response);
		}
	}
	private void pwCertifacate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Admin a=new Admin();
		AdminDAOImpl ad=new AdminDAOImpl();
		a.setUser(request.getParameter("user"));
		a.setPassword(request.getParameter("password"));
		//get username this time
		thisAdmin=request.getParameter("user");
		if(!ad.certificate(a)) {
			request.setAttribute("msg", "账号与密码"+"不匹配，请重新输入");
			request.getRequestDispatcher("loginTest.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}
}

