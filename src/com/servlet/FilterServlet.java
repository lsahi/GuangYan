package com.servlet;

import java.io.IOException;
 
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FilterServlet implements Filter {

	  
	/**   
	* ��Ҫ�ų���ҳ��   
	*/    
	  
	private String excludedPages;       
	private String[] excludedPageArray;     
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        // ��������������Ҫ�õ�request,response,session����
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();

        // ����û������URI
        String path = servletRequest.getRequestURI();
        //System.out.println(path);
        
        // ��session��ȡԱ��������Ϣ
        String empId = (String) session.getAttribute("empId");

        /*������Constants.java������д����������˵�ҳ��
        for (int i = 0; i < Constants.NoFilter_Pages.length; i++) {

            if (path.indexOf(Constants.NoFilter_Pages[i]) > -1) {
                chain.doFilter(servletRequest, servletResponse);
                return;
            }
        }*/
        
        // ��½ҳ���������
        if(path.indexOf("/loginTest.jsp") > -1) {
            chain.doFilter(servletRequest, servletResponse);
            return;
        }else if(path.indexOf("/index.jsp")>-1) {
            chain.doFilter(servletRequest, servletResponse);
            return;
        }else if(path.indexOf("/pwCertificate.do")>-1) {
            chain.doFilter(servletRequest, servletResponse);
            return;
        }else {
        	;
        }

        // �ж����û��ȡ��Ա����Ϣ,����ת����½ҳ��
        if (empId == null || "".equals(empId)) {
            // ��ת����½ҳ��
            servletResponse.sendRedirect("/GuangyanAdmin/loginTest.jsp");
        } else {
            // �Ѿ���½,�����˴�����
            chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

}