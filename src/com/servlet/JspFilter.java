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
    public void init(FilterConfig config) throws ServletException{} //初始化过滤器  
    public void destroy(){}//过滤器的生命周期结束  
  
  
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter)  
        throws IOException, ServletException{  
        request.getRequestDispatcher("/loginTest.jsp").forward(request, response);  
    }  
}  