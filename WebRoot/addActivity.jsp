<%@ page import="com.po.Student"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page session="true" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>学生召集注册系统</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="bootstrap/js/jquery/2.0.0/jquery.min.js"></script>
	<link href="bootstrap/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
	<script src="bootstrap/js/bootstrap/3.3.6/bootstrap.min.js"></script>
	<script src="bootstrap/js/myjs.js"></script>
	<link href="bootstrap/css/mycss.css" rel="stylesheet">
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  </head>
  
  <body>
    <!-- 最上面的导航栏 -->
  	<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
          </button>
          <a class="navbar-brand">发起一个召集活动</a>
        </div>
      </div>
    </nav>
    
    
    <%
    	out.print("<br><br><br><br>");
		Object msg = request.getAttribute("msg");
		if (msg != null) { 
			out.print("<div class=\"alert alert-info\" role=\"alert\"><h4>");
			out.println(msg);
			out.print("</h4></div>");
		} 
	%>
    
	<div class="center-block" style="width:400px;">
	<form action="addCustomerServlet.do" method = "post">
		<h3 class="form-signin-heading">新建召集活动</h2>
		<table>
			
			<tr>
				<td>召集活动名:</td>
				<td><input type = "text" name = "sname" class = "form-control" value = "<%= request.getParameter("sno") == null ? "" : request.getParameter("sname")%>"></td>
			</tr>
			<br>
			<tr>
				<td>详细描述:</td>
				<td><textarea class="form-control" name=detailed rows="4"></textarea></td>
				<!-- <td><input type = "text" name = "password" class = "form-control" value = "<%= request.getParameter("sno") == null ? "" : request.getParameter("sno")%>"></td>
			 -->
			</tr>
			
			<!-- addCustomerServlet.do -->
			<tr>	
				<td><input type = "submit" value = "添加" class="btn btn-primary btn-block"></td>	
				<!-- <td class = "btn btn-link"><a href = "queryCustomerServlet.do">返回</a></td> -->
			</tr>
		</table>
	</form>
	</div>
	<br><br>

  </body>
  
</html>