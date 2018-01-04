<%@page import="com.po.Customer"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page session="true" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>光盐用户管理系统</title>
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
          <a class="navbar-brand" href="index.jsp">光盐用户管理系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="queryCustomerServlet.do">查询</a></li>
            <li><a href="add.jsp">添加</a></li>
          </ul> 
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
		
	 <%
    	Customer c = (Customer) request.getAttribute("customer");
     %>
    
	<div class="center-block" style="width:400px;">
	<form action="update.do" method = "post">
		<input type = "hidden" name = "oldSno" value = "<%=c.getSno() %>"></input>
		<h2 class="form-signin-heading">Please Update</h2>
		<table>
			<tr>
				<td>编号:</td>
				<td><input type = "text" name = "sno" class = "form-control" value = "<%=c.getSno() %>" readonly="true"></td>
				<!-- <td><%=c.getSno() %></td> -->
				<!-- readonly 只读属性 姓名栏中可以考虑添加 -->
			</tr>
			
			<tr>
				<td>姓名:</td>
				<td><input type = "text" name = "sname" class = "form-control" value = "<%=c.getSname() %>"></td>
			</tr>
			
			<tr>
				<td>电话:</td>
				<td><input type = "text" name = "phone" class = "form-control" value = "<%=c.getPhone() %>"></td>
			</tr>
			
			<tr>
				<td>本次充值次数:</td>
				<td><input type = "text" name = "timesLeft" class = "form-control" value= "0" ></td>
			</tr>
			
			<tr>
				<td>修改备注:</td>
				<td><input type = "text" name = "information" class = "form-control" value= "<%=c.getInformation() %>" ></td>
			</tr>
			


			<!-- value = "<%=c.getTimesLeft() %>" -->
			
			<!-- addCustomerServlet.do -->
			<tr>	
				<td><input type = "submit" value = "确定本次修改" class="btn btn-primary"></td>
				<td class = "btn btn-link"><a href = "queryCustomerServlet.do">放弃本次操作</a></td>
			</tr>
		</table>
	</form>
	</div>
	<br><br>

  </body>
  
</html>
