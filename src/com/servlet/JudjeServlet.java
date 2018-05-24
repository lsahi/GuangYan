package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDAOImpl;
import com.dao.CustomerDAOImpl;
import com.dao.FixTimeDAOImpl;
import com.po.Admin;
import com.po.Customer;
import com.po.FixTime;

public class JudjeServlet extends HttpServlet {
	
	public String thisAdmin;
	
	private static final long serialVersionUID = 1L;
	
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
		/*
        HttpSession session=request.getSession(false); 
        if(session==null)  
        {  
            response.sendRedirect("loginTest.jsp");  
            return ;  
        }  
        */
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session=null;
		request.setCharacterEncoding("utf-8");// setCharset
		String servletPath = request.getServletPath();
		String methodName = servletPath.substring(1,servletPath.length()-3);
		try {
			if ("pwCertificate".equals(methodName)){
			 	pwCertifacate(request, response);
			}
		}catch (Exception e) {
				// TODO: handle exception
				response.sendRedirect("loginTest.jsp");
		}

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
			}
			/*
			else if ("add".equals(methodName)) {
				charge(request, response);
			} 
*/
			//add here -pw certification
		} catch (Exception e) {
			// TODO: handle exception
			response.sendRedirect("loginTest.jsp");
		}
	}
	
	private void queryChangeInfo(HttpServletRequest request, HttpServletResponse response) throws Exception{
        
		FixTime f= new FixTime();
		f.setUserID(request.getParameter("UserID"));
		List<FixTime> listFixTime=fixTimeDAOImpl.getForFixTime(f);
		request.setAttribute("listFixTime", listFixTime);
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
		int charged =Integer.parseInt(timesLeft);//��������
		//test accepted 

		Customer c = new Customer();
		CustomerDAOImpl temp=new CustomerDAOImpl();
		int left;
		//left=Integer.parseInt(c.getTimesLeft()); //�������ݿ���ԭ��
		c.setSno(sno);
		Customer stu=temp.getSigner(sno);

		left=charged+Integer.parseInt(stu.getTimesLeft());
		c.setSname(sname);
		c.setPhone(phone);
		c.setTimesLeft(left);					//ʵ��ʣ��
		c.setInformation(information);
		

		FixTime fix=new FixTime();
		/**
		 * 
		 */
		String admin=thisAdmin;
		String timeName=fix.getCurrentTime()+" - "+admin;
		String currentOperation=null;
		if(charged>0) {
			currentOperation= "��ֵ" +charged+"��";
		}
		else {
			currentOperation="�޸ĸ�����Ϣ";
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
			request.setAttribute("msg", "错误" + request.getParameter("sno") + "用户为空");
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
				c.setInformation(request.getParameter("information")+"�ޱ�ע");
				System.out.println(c.getInformation());
			}else {
				//c.setInformation(request.getParameter("information"));
			}*/
			
			//System.out.println(c.getInformation()+"111");
			
			/*
			 * ��ӵ���¼ 
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
			fix.setOperation("ע��");
			fix.setTimesLeft("0");
			fix.setCurrentTime();
			
			fixTimeDAOImpl.save(fix);
			customerDAOImpl.save(c);
			
			request.setAttribute("msg", "��ϲ�㣬�����֤" + request.getParameter("sno") + "ע��ɹ����뷵�ز鿴��������");
			
			request.getRequestDispatcher("add.jsp").forward(request, response);
		}
	}
	
	//
	private void pwCertifacate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Admin a=new Admin();
		AdminDAOImpl ad=new AdminDAOImpl();
		a.setUser(request.getParameter("user"));
		a.setPassword(request.getParameter("password"));
		//get username this time
		thisAdmin=request.getParameter("user");
		if(!ad.certificate(a)) {
			request.setAttribute("msg", "�˺�������"+"��ƥ�䣬����������");
			

		}else {
			/*
			
			HttpSession session = request.getSession();
			session.setAttribute("login-user", user);
			*/
						//new session here
			request.getRequestDispatcher("index.jsp").forward(request, response);
			request.getSession().setAttribute("user", a);  
		}
		
	}
	
}
