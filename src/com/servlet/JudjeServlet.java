package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ActivityDAOImpl;
import com.dao.AdminDAOImpl;
import com.dao.StudentDAOImpl;
import com.dao.FixTimeDAOImpl;
import com.po.Activity;
import com.po.Admin;
import com.po.Student;
import com.po.FixTime;

public class JudjeServlet extends HttpServlet {
	
	public String thisAdmin;
	
	private StringCheck check;
	
	private static final long serialVersionUID = 1L;
	
	StudentDAOImpl studentDAOImpl = new StudentDAOImpl();
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
	/**
	 * method select list
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
			} else if ("queryChangeInfo".equals(methodName)) { //ChangeInfo
				queryChangeInfo(request, response);
			} else if ("delete".equals(methodName)) {
				delete(request, response);
			} else if ("edit".equals(methodName)) {
				edit(request, response);
			} else if ("update".equals(methodName)) {
				update(request, response);
			} else if ("showAllActivities".equals(methodName)) {
				showAllActivities(request,response);
			} else if ("addStudent".equals(methodName)) {
				addStudent(request,response);
			} else if ("updateStudent".equals(methodName)) {
				updateStudent(request,response);
			} else if ("addActivity".equals(methodName)) {
				addActivity(request,response);
			} else if ("studentLogin".equals(methodName)) {
				studentLogin(request,response);
			}
			/*
			 * else if ("queryCustomerServlet".equals(methodName)) {
				query(request, response);
			} 
			else if ("add".equals(methodName)) {
				charge(request, response);
			} 
*/
			//add here -pw certification
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.sendRedirect("failed.jsp");
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
		studentDAOImpl.delete(sno);
		response.sendRedirect("queryCustomerServlet.do");
	}
	
	//done
	private void update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//request.setCharacterEncoding("utf-8");// setCharset
		
		//
		//String oldSno = request.getParameter("sno");
		
		//
		String sno = request.getParameter("sno");
		String sname = request.getParameter("sname");
		String phone = request.getParameter("phone");
		String smail = request.getParameter("email");
		String password = request.getParameter("passwrod");
		//test accepted 

		Student c = new Student();
		StudentDAOImpl temp=new StudentDAOImpl();
		int left;

		//get UID
		c.setSno(sno);
		
		Student stu=temp.getSigner(sno);
		c.setSname(sname);
		c.setPhone(phone);
		c.setPassword(password);
		c.setMail(smail);
		

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
		studentDAOImpl.update(c);
		response.sendRedirect("queryCustomerServlet.do");
	}

	//while update, edit first
	private void edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
        
		request.setCharacterEncoding("utf-8");// setCharset
		String sno = request.getParameter("sno");
		Student customer = studentDAOImpl.getSigner(sno);
		request.setAttribute("customer", customer);
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}

	
	
	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");// setCharset
		
		Student s=new Student();
		StudentDAOImpl sd=new StudentDAOImpl();
		
		DateToString d=new DateToString();
		s.setSno(d.dateToString());
		s.setSname(request.getParameter("sname"));
		s.setPassword(request.getParameter("password"));
		s.setMail(request.getParameter("smail"));
		s.setPhone(request.getParameter("phone"));
		s.setSname(request.getParameter("sname"));
		s.setGender(stringToInt(request.getParameter("gender")));
		
		int type1=1,type2=1,type3=1,type4=1;
		if((request.getParameter("type1") instanceof String)!=true) {
			type1=0;
		}
		if((request.getParameter("type2") instanceof String)!=true) {
			type2=0;
		}
		if((request.getParameter("type3") instanceof String)!=true) {
			type3=0;
		}
		if((request.getParameter("type4") instanceof String)!=true) {
			type4=0;
		}
		s.setType(type1,type2,type3,type4);
		
		sd.addStudent(s);

		request.getRequestDispatcher("registerSuccess.jsp").forward(request, response);
		
	}
	
	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");// setCharset
		
		Student s=new Student();
		StudentDAOImpl sd=new StudentDAOImpl();
		
		DateToString d=new DateToString();
		s.setSno(request.getParameter("sno"));
		s.setSname(request.getParameter("sname"));
		s.setPassword(request.getParameter("password"));
		s.setMail(request.getParameter("smail"));
		s.setPhone(request.getParameter("phone"));
		s.setSname(request.getParameter("sname"));
		
		int type1=1,type2=1,type3=1,type4=1;
		if((request.getParameter("type1") instanceof String)!=true) {
			type1=0;
		}
		if((request.getParameter("type2") instanceof String)!=true) {
			type2=0;
		}
		if((request.getParameter("type3") instanceof String)!=true) {
			type3=0;
		}
		if((request.getParameter("type4") instanceof String)!=true) {
			type4=0;
		}
		s.setType(type1,type2,type3,type4);
		
		sd.updateStudent(s);

		request.getRequestDispatcher("registerSuccess.jsp").forward(request, response);
		
	}
	
	private void addActivity(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");// setCharset
		
		Activity a=new Activity();
		ActivityDAOImpl ad=new ActivityDAOImpl();

		DateToString d=new DateToString();
		
		a.setId(d.dateToString());
		//a.setHost("hostname");
		a.setHost(request.getParameter("host"));
		a.setName(request.getParameter("name"));
		a.setDetails(request.getParameter("details"));
		int type1=1,type2=1,type3=1,type4=1;
		if((request.getParameter("type1") instanceof String)!=true) {
			type1=0;
		}
		if((request.getParameter("type2") instanceof String)!=true) {
			type2=0;
		}
		if((request.getParameter("type3") instanceof String)!=true) {
			type3=0;
		}
		if((request.getParameter("type4") instanceof String)!=true) {
			type4=0;
		}

		a.setType(type1,type2,type3,type4);

		ad.addActivity(a);
		
		request.getRequestDispatcher("activitySuccess.jsp").forward(request, response);
	}
	
	//done
	private void add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
        
		request.setCharacterEncoding("utf-8");// setCharset
		
		boolean flag = studentDAOImpl.getCountWithName(request.getParameter("sno"));
		//
		if (flag || request.getParameter("sname") == null || request.getParameter("sname") == "") {
			request.setAttribute("msg", "错误,用户昵称为空");
			request.getRequestDispatcher("addStudent.jsp").forward(request, response);
		} else if(flag || request.getParameter("password") == null || request.getParameter("password") == ""){
			request.setAttribute("msg", "错误,用户密码为空");
			request.getRequestDispatcher("addStudent.jsp").forward(request, response);
		}else {
			Student c = new Student();
			//c.setSno(request.getParameter("sno"));
			c.setSname(request.getParameter("sname"));
			c.setPhone(request.getParameter("phone"));
			c.setMail(request.getParameter("smail"));
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
		
			studentDAOImpl.save(c);
			
			//注册成功
			request.setAttribute("msg", "注册成功֤" + request.getParameter("sno") + "ע��ɹ����뷵�ز鿴��������");
			
			request.getRequestDispatcher("add.jsp").forward(request, response);
		}
	}
	
	
	
	//TODO
	//MAIN PAGE  -- SHOW ALL --
	private void showAllActivities(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		response.setContentType("text/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		JsonCreator creator=new JsonCreator();
		ActivityDAOImpl myActivity=new ActivityDAOImpl();
		List<Activity> activities=myActivity.selectAllActivity();
		String showAll=myActivity.activityToJson(activities);
		
		//print to console
		System.out.println(showAll);
		
		out.println(showAll);
		out = response.getWriter();
		
	}
	

	
	//TODO
	private void studentLogin(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		response.setContentType("text/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Student s=new Student();
		StudentDAOImpl sd=new StudentDAOImpl();
		
		String user;
		String password;
		user=request.getParameter("user");
		password=request.getParameter("password");
		boolean flag=true;
		System.out.println("userget:"+user);
		System.out.println("pw:"+password);
		flag=sd.loginCheck(request.getParameter("user"), request.getParameter("password"));
		if(!flag) {
			//not you
			out.println("bad login");
			out = response.getWriter();
			System.out.println("check not passed");
		} else {
			//return json
			JsonCreator creator=new JsonCreator();
			s=sd.getSignerByName(user);
			List<Student> sList=new ArrayList<Student>();
			sList.add(s);
			String showStudent=sd.studentToJson(sList);
			out.println(showStudent);

			System.out.println(showStudent);
			out = response.getWriter();
		}
	}
	
	private int stringToInt(String s) {
		int b = Integer.valueOf(s).intValue();
		return b;
	}
	
	
	
	//
	//
	private void pwCertifacate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Student s=new Student();
		StudentDAOImpl sd=new StudentDAOImpl();
		//
		s.setSname(request.getParameter("user"));
		s.setPassword(request.getParameter("password"));
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
			request.getSession().setAttribute("user", s);  
		}
		
	}
}
