<%@ page import="com.po.Customer"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page session="true" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>校园召集 注册界面</title>
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
          <a class="navbar-brand" href="add.jsp">用户注册</a>
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
		<h2 class="form-signin-heading">添加用户</h2>
		<table>
			
			
			<tr>
				<td>昵称Sname:</td>
				<td><input type = "text" name = "sname" class = "form-control" value = "<%=request.getParameter("sno") == null ? "" : request.getParameter("sname")%>"></td>
			</tr>
			
			<tr>
				<td>邮箱Smail:</td>
				<td><input type = "text" name = "sno" class = "form-control" value = "<%=request.getParameter("sno") == null ? "" : request.getParameter("smail")%>"></td>
			</tr>
			
			<tr>
				<td>密码Spw:</td>
				<td><input type = "text" name = "sno" class = "form-control" value = "<%=request.getParameter("sno") == null ? "" : request.getParameter("sno")%>"></td>
			</tr>
			
			<tr>
				<td>手机Phone:</td>
				<td><input type = "text" name = "phone" class = "form-control" value = "<%=request.getParameter("sno") == null ? "" : request.getParameter("phone")%>"></td>
			</tr>
			
			<tr>
				<td>备注信息information:</td>
				<td><input type = "text" name = "information" class = "form-control" value = "无备注"></td>
			</tr>
			
			
			<!-- addCustomerServlet.do -->
			
		</table>
		<tr>
			兴趣爱好:</br>
			    <input type="checkbox" id="Checkbox1" value="1">大创       	 	 <input type="checkbox" id="Checkbox1" value="2">建模</br>
			    <input type="checkbox" id="Checkbox1" value="3">专利       		 <input type="checkbox" id="Checkbox1" value="4">自习</br></br>
		</tr>
		<tr>
			性别:</br>
				<input type="radio" name="optionsRadios" id="Radio1" value="option1" checked> 男
				<input type="radio" name="optionsRadios" id="Radio1" value="option2" checked> 女
		</tr>
		<tr>	
				<td><input type = "submit" value = "添加" class="btn btn-primary btn-block"></td>
				<td class = "btn btn-link"><a href = "queryCustomerServlet.do">返回</a></td>
		</tr>
	</form>
	</div>
	<br><br>

  </body>
  
</html>
