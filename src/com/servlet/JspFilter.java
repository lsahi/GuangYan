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

public class JspFilter implements Filter{  
    public void init(FilterConfig config) throws ServletException{} //��ʼ��������  
    public void destroy(){}//���������������ڽ���  
  
  
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter)  
        throws IOException, ServletException{  
        request.getRequestDispatcher("/loginTest.jsp").forward(request, response);  
    }  
}  