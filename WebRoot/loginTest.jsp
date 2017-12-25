<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>光盐管理系统</title>
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
    <img src="bootstrap/1.jpg" class = "bg"> 

    <!-- 最上面的导航栏 -->
  	<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">

          <a class="navbar-brand" href="loginTest.jsp">光盐管理系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
        </div>
      </div>
    </nav>
    
    <!-- 登陆  -->
	<div class="center-block" style="width:400px;">
	<form name="loginTest" action="pwCertificate.do" method = "post">
		<h2 class="form-signin-heading">Please Input</h2>
		<table>
			<tr>
				<td>账号:</td>
				<td><input type = "text" name = "user" class = "form-control" value = "<%=request.getParameter("user") == null ? "" : request.getParameter("user")%>"></td>
			</tr>
			
			<tr>
				<td>密码:</td>
				<td><input type = "text" name = "password" class = "form-control" value = "<%=request.getParameter("password") == null ? "" : request.getParameter("password")%>"></td>
			</tr>
			
			<!-- addCustomerServlet.do -->
			<tr>	
				<td><input type = "submit" value = "登陆" class="btn btn-primary"></td>
				<!-- <td class = "btn btn-link"><a href = "queryCustomerServlet.do">return</a></td> -->
			</tr>
		</table>
	</form>
	</div>
	<%
    	out.print("<br><br><br><br>");
		Object msg = request.getAttribute("msg");
		if (msg != null) { 
			out.print("<div class=\"alert alert-info\" role=\"alert\"><h4>");
			out.println(msg);
			out.print("</h4></div>");
		} 
	%>
    <br><br><br><br>
  </body>
</html>
