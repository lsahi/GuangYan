package com.servlet;

import java.io.IOException;
import java.util.List;

/* 
 * Can see when the action done
 * Charge / add account/ time used/ will be shown in another table in mysql
 * Only show and query can be done on the browser
 * 
 */
 	

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDAOImpl;
import com.dao.StudentDAOImpl;
import com.dao.FixTimeDAOImpl;
import com.po.Admin;
import com.po.Student;
import com.po.FixTime;

public class FixTimeServlet extends HttpServlet{
	
	StudentDAOImpl studentDAOImpl = new StudentDAOImpl();
	FixTimeDAOImpl fixTimeDAOImpl = new FixTimeDAOImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FixTimeServlet() {
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
		/*
		try {
			if ("addCustomerServlet".equals(methodName)) {
				add(request, response);
			} else if ("queryCustomerServlet".equals(methodName)) {
				query(request, response);
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
		*/
	}
	
	
	//��ѯ�����ݶ�Ϊ����ͨ������ID��ʵ��
	//��ѯ������һ��������ģ��
	
	private void query(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		FixTime t=new FixTime();
		t.setUserID(request.getParameter("UserID"));
		List<FixTime> listFixTime = fixTimeDAOImpl.getForFixTime(t);
		request.setAttribute("listCustomer" ,listFixTime);
		request.getRequestDispatcher("userinfo.jsp").forward(request, response);
	}

}
